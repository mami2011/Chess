package com.kryptonite.rest.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import com.kryptonite.constants.NPLabels;
import com.kryptonite.constants.NPRelationships;
import com.kryptonite.rest.model.CategoryModel;
import com.kryptonite.utils.DAO;

@Path("categories")
public class Category {

	@Inject
	GraphDatabaseService db;

	@Inject
	DAO dao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategory(CategoryModel category) {

		String id = null;

		if(StringUtils.isEmpty(category.getName())) {
			throw new IllegalArgumentException("Category name is required");
		}

		validateCategoryModel(category);

		try ( Transaction tx = db.beginTx(); )
		{
			//create new category
			Node categoryNode = db.createNode();
			id = "cat" + Math.abs(UUID.randomUUID().getLeastSignificantBits());
			categoryNode.setProperty("id", id);
			categoryNode.setProperty("creationdate", (new Date()).toString());
			populateCategoryNode(categoryNode,category);
			dao.addLabel(id, NPLabels.CATEGORY.name());
			tx.success();

			
		}
		catch(Exception e) {
			return Response.status(500).entity("Unable to create Category: " + e).build();
		}

		//Set the new category as child category to parent category .
		if(category.getParentId() != null) {
		Node parentCategoryNode = dao.getCategoryById(category.getParentId());
		CategoryModel parentCategoryModel = new CategoryModel();
		parentCategoryModel.setId((String)parentCategoryNode.getProperty("id"));
		List<String> childCategories = new ArrayList();
		//childCategories.addAll((List<String>) parentCategoryNode.getProperty("childIds"));
		childCategories.add(id);
		parentCategoryModel.setChildIds(childCategories);
		
		updateCategory(category.getParentId(),parentCategoryModel);
		}
	
		return Response.status(200).entity("Created category " + id).build();
	}

	@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(@PathParam("id") String categoryId, 
			CategoryModel category) {

		String id = categoryId;
		validateCategoryModel(category);

		Node categoryNode = dao.getCategoryById(id);
		if(categoryNode != null) {

			try ( Transaction tx = db.beginTx(); )
			{
				populateCategoryNode(categoryNode,category);
				tx.success();
			}
			catch(Exception e) {
				return Response.status(500).entity("Unable to update category: " + e).build();
			}
		}
		else {
			return Response.status(400).entity("Category does not exist: " + categoryId).build();
		}

		return Response.status(200).entity("Updated category " + id).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryModel getCategory(@PathParam("id") String id) {

		CategoryModel retVal = null;

		try {
			Node categoryNode = dao.getCategoryById(id);

			if(categoryNode != null) {
				retVal = getCategoryModel(categoryNode);
			}
			else {
				throw new WebApplicationException(Response.status(404).entity("Category not found: " + id).build());
			}
		}
		catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get Category: " + id).build());
		}

		return retVal;
	}

	@GET
	@Path("/search/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoryModel> getCategoryByNameOrTag(@PathParam("name") String searchString) {

		List<CategoryModel> retVal = new ArrayList<>();

		try {
			List<Node> categoryNodes = dao.getCategoriesBySearchString(searchString);

			for(Node categoryNode:categoryNodes) {
				retVal.add(getCategoryModel(categoryNode));
			}
		}
		catch(Exception e) {
			throw new WebApplicationException(Response.status(500).entity("Unable to get Category for search string: " + searchString).build());
		}

		return retVal;
	}

	private CategoryModel getCategoryModel(Node categoryNode) {

		CategoryModel thisCatModel = new CategoryModel();
		thisCatModel.setId((String)categoryNode.getProperty("id"));

		Relationship parentRel = categoryNode.getSingleRelationship(NPRelationships.SUPERCATEGORY, Direction.OUTGOING);
		if(parentRel != null) {
			thisCatModel.setParentId((String)parentRel.getEndNode().getProperty("id"));
		}

		thisCatModel.setName((String)categoryNode.getProperty("name"));
		thisCatModel.setIsActive((boolean)categoryNode.getProperty("isActive"));
		thisCatModel.setTags(Arrays.asList((String[])categoryNode.getProperty("tags")));

		List<String> childIds = new ArrayList<>();
		for(Relationship childRel:categoryNode.getRelationships(NPRelationships.SUBCATEGORY,Direction.OUTGOING)) {
			childIds.add((String)childRel.getOtherNode(categoryNode).getProperty("id"));
		}
		thisCatModel.setChildIds(childIds);

		return thisCatModel;
	}

	private void validateCategoryModel(CategoryModel category) {

		if(!StringUtils.isEmpty(category.getParentId()) ){
			Node superCategoryNode = dao.getCategoryById(category.getParentId());
			if(superCategoryNode == null) {
				throw new IllegalArgumentException("Parent category id " + category.getParentId() + " does not exist");
			}
			category.setParentNode(superCategoryNode);
		}

		if(category.getChildIds() != null){
			List<Node> childCategoryNodes = new ArrayList<>();
			for(String childId:category.getChildIds()) {
				Node childCategoryNode = dao.getCategoryById(childId);
				if(childCategoryNode == null) {
					throw new IllegalArgumentException("child category id " + childId + " does not exist");
				}
				childCategoryNodes.add(childCategoryNode);
			}
			category.setChildNodes(childCategoryNodes);
		}
	}

	private void populateCategoryNode(Node categoryNode , CategoryModel category) {

		if(!StringUtils.isEmpty(category.getName())) {
			categoryNode.setProperty( "name", category.getName() );	
		}
		categoryNode.setProperty( "isActive", category.getIsActive() );

		if(category.getParentNode() != null) {
			//set parent relationship
			categoryNode.createRelationshipTo(category.getParentNode(), NPRelationships.SUPERCATEGORY);
		}

		if(category.getChildNodes() != null) {
			for(Node childNode:category.getChildNodes()) {
				categoryNode.createRelationshipTo(childNode, NPRelationships.SUBCATEGORY);
			}
		}

		//set tags
		if(category.getTags() != null) {
			String[] existingTags = (String[])categoryNode.getProperty("tags",null);

			if(existingTags != null) {
				category.getTags().addAll(Arrays.asList(existingTags));
			}
			String[] tags = new String[category.getTags().size()];
			categoryNode.setProperty("tags", category.getTags().toArray(tags));
		}
	}

}

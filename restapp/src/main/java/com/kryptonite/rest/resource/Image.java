package com.kryptonite.rest.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.shell.util.json.JSONException;
import org.neo4j.shell.util.json.JSONObject;

import com.kryptonite.aws.AWSHelper;
import com.kryptonite.utils.DAO;
//import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("images")
public class Image {
	@Inject
	GraphDatabaseService db;

	@Inject
	DAO dao;

	@SuppressWarnings("null")
	@POST
	//@Consumes( MediaType.MULTIPART_FORM_DATA )
	@Consumes("multipart/form-data")
	public String uploadImage(MultipartFormDataInput      images) throws IOException {
		String key = null;
		String url = null;
		List<String> imageLinks = new ArrayList<String>();;
		key = AWSHelper.getInstance().uploadImage2AWS(images,450,key);
		if (key != null) {
			url="https://s3.amazonaws.com/nutped2/"+key;
			imageLinks.add(url);
		}
		key = AWSHelper.getInstance().uploadImage2AWS(images,125,"thumb"+key);
		if (key != null) {
			url="https://s3.amazonaws.com/nutped2/"+key;
			imageLinks.add(url);
		}
		String result = constructJSON(imageLinks);
		return result;

	}

	@Path("/videos")
	@POST
	//@Consumes( MediaType.MULTIPART_FORM_DATA )
	@Consumes("video/mp4")
	public String uploadVideo(MultipartFormDataInput      images) throws IOException {
		String key = null;
		String url = null;
		List<String> imageLinks = new ArrayList<String>();;
		key = AWSHelper.getInstance().uploadImage2AWS(images,450,key);
		if (key != null) {
			url="https://s3.amazonaws.com/nutped2/"+key;
			imageLinks.add(url);
		}
		key = AWSHelper.getInstance().uploadImage2AWS(images,125,"thumb"+key);
		if (key != null) {
			url="https://s3.amazonaws.com/nutped2/"+key;
			imageLinks.add(url);
		}
		String result = constructJSON(imageLinks);
		return result;

	}
	
	public static String constructJSON(List<String> links) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("imageurl", links.get(0));
			obj.put("thumbnailurl", links.get(1));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}

	@GET
	@Path("{id}")
	@Consumes( MediaType.MULTIPART_FORM_DATA )
	public InputStream downloadImage(@PathParam("id") String id) {
		String key = id;
		return AWSHelper.getInstance().downloadFileFromwAWS(key);

	}

	@GET
	@Path("{id}")
	@Consumes( MediaType.MULTIPART_FORM_DATA )
	public boolean deleteImage(@PathParam("id") String id) {
		String key = id;
		return AWSHelper.getInstance().deleteFile(key);

	}


}

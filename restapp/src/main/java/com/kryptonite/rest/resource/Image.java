package com.kryptonite.rest.resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.neo4j.graphdb.GraphDatabaseService;

import com.kryptonite.aws.AWSHelper;
import com.kryptonite.utils.DAO;

@Path("images")
public class Image {
	@Inject
	GraphDatabaseService db;

	@Inject
	DAO dao;

	@POST
	@Consumes( MediaType.MULTIPART_FORM_DATA )
	public String uploadImage(@MultipartForm  InputStream    images) throws IOException {
		 String key = AWSHelper.getInstance().uploadImage2AWS(images);
		 return key;
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

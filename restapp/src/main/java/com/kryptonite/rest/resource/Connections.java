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

@Path("users")
public class Connections {
	@Inject
	GraphDatabaseService db;

	@Inject
	DAO dao;


	@GET
	@Path("{id}")
	@Consumes( MediaType.MULTIPART_FORM_DATA )
	public InputStream downloadImage(@PathParam("id") String id) {
		String key = id;
		return AWSHelper.getInstance().downloadFileFromwAWS(key);

	}

}

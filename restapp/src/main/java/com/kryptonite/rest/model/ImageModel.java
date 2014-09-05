package com.kryptonite.rest.model;

import java.io.InputStream;

import javax.ws.rs.FormParam;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import com.kryptonite.constants.NotificationType;

public class ImageModel {
	@FormParam("image")
	@PartType("image/png")
	private InputStream file;

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}
	
	
}

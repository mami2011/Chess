package com.vendertool.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.ProduceMime;

public class BaseVenderToolServiceImpl implements IVenderToolService {

	public static final String VERSION_RESOURCE = "../parent/VenderToolVersion.properties";
	
	@GET
	@ProduceMime({ "application/xml", "application/json" })
	public String getVersion() {
		String path = "../parent/VenderToolVersion.properties";
		InputStream stream = getClass().getResourceAsStream(path);
		if (stream == null) {
			return "UNKNOWN";
		}
		
	    Properties props = new Properties();
	    try {
	    	props.load(stream);
	 	    stream.close();
	 	    return (String)props.get("vendertool.version");
	     } catch (IOException e) {
	 	    return "UNKNOWN";
	 	 }
	}
}

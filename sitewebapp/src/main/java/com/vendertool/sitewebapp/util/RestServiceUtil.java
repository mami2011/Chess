package com.vendertool.sitewebapp.util;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.core.HttpMethodEnum;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sitewebapp.common.RestServiceClientHelper;
import com.vendertool.sitewebapp.common.URLConstants;

public class RestServiceUtil {

	private static final Logger logger = Logger.getLogger(RestServiceUtil.class);
	
	public static Response post(BaseRequest baseRequest, String servicePath, HttpServletRequest httpRequest) {
		
		String hostName = RestServiceClientHelper.getServerURL(httpRequest);
		String url = hostName + URLConstants.WEB_SERVICE_PATH + servicePath;
		
		Response response = RestServiceClientHelper
			.invokeRestService(
				url, 
				baseRequest, 
				null, 
				MediaType.APPLICATION_JSON_TYPE,
				HttpMethodEnum.POST
			);
		
		
		int responseCode = response.getStatus();
		String className = baseRequest.getClass().getName();
		
		logger.log(Level.INFO,
			"Vendertool Web service status code for URL '" + url + "' from '" + 
			className + 
			" is '" + responseCode + "'."
		);
		
		//HTTP error code 200
		if(responseCode != Response.Status.OK.getStatusCode()) {
			throw new VTRuntimeException(className + " POST ERROR: " + responseCode);
		}

		return response;		
	}
}

package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponse extends BaseResponse {
	
	public ErrorResponse() {
	}
	
	public ErrorResponse(BaseResponse baseResponse) {
		if(baseResponse != null) {
			this.addErrors(baseResponse.getErrors());
		}
	}
}

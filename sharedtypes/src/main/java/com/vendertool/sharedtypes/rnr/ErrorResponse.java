package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponse extends BaseResponse {
	
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(BaseResponse baseResponse) {
		if(baseResponse != null) {
			this.addFieldBindingErrors(baseResponse.getFieldBindingErrors());
		}
	}
}

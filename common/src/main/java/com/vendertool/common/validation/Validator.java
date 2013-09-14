package com.vendertool.common.validation;

import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;


public interface Validator {
	public void validate(BaseRequest request, BaseResponse response);
}

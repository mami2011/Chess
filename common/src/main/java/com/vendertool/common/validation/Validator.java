package com.vendertool.common.validation;

import java.util.List;

import com.vendertool.sharedtypes.error.VTError;
import com.vendertool.sharedtypes.rnr.Request;

public interface Validator {
	public List<VTError> validate(Request request);
}

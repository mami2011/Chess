package com.vendertool.sitewebapp.common;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.validation.BindingResult;

import com.vendertool.sharedtypes.error.VTError;
import com.vendertool.sharedtypes.error.VTErrorFieldBindingMap;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public class VTErrorUtil {
	
	public static void convertToSpringErrors(
			BindingResult springBindingResult, Object bean, String bindingName,
			BaseResponse response) {
		if((response == null) || (!response.hasErrors()) || (springBindingResult == null)) {
			return;
		}
		
		if((bean == null) || (bindingName == null) || (bindingName.trim().isEmpty())) {
			return;
		}
		
//		BeanPropertyBindingResult springBindingResult = new BeanPropertyBindingResult(bean, bindingName);
		
		List<VTErrorFieldBindingMap> vterrors = response.getFieldBindingErrors();
		for(VTErrorFieldBindingMap vtbinderr : vterrors) {
			VTError vterr = vtbinderr.getError();
			if(!vtbinderr.hasFieldSpecificErrors()) {
				springBindingResult.reject(vterr.getErrorCode().getErrorCode(),
						vterr.getArguments(), vterr.getMessage());
			}
			
			Map<String, Set<String>> fieldMap = vtbinderr.getBindingFieldMap();
			Collection<Set<String>> fieldNameCollection = fieldMap.values();
			
			for(Set<String> fieldNames : fieldNameCollection) {
				if(fieldNames != null) {
					for(String fieldName : fieldNames) {
						springBindingResult.rejectValue(
								fieldName, 
								vterr
								.getErrorCode().getErrorCode(), vterr
								.getArguments(), vterr.getMessage());
					}
				}
			}
			
		}
		
//		return springBindingResult;
	}
	
	public static void updateErrorsWithLocalizedMessages(List<VTError> errors, Locale locale) {
		if(errors == null) {
			return;
		}
		
		MsgSource msgSrc = new MsgSource();
		
		for(VTError error : errors) {
			String errorCode = error.getDomainCodeKey();
			String localizedMsg = msgSrc.getMessage(errorCode, error.getArguments(), locale);
			error.setMessage(localizedMsg);
		}
	}
}

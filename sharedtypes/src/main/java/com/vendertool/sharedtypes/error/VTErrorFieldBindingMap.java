package com.vendertool.sharedtypes.error;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.vendertool.sharedtypes.exception.VTRuntimeException;

@XmlAccessorType(XmlAccessType.FIELD)
public class VTErrorFieldBindingMap {
	@JsonIgnore
	private static final Logger logger = Logger.getLogger(VTError.class);
	
	private VTError error;
	private Map<String, Set<String>> bindingFieldMap;
	
	/**
	 * Don't use this, this is only used during marshalling & un-marshalling by JSON, JAXB, etc.
	 */
	public VTErrorFieldBindingMap(){}
	
	
	public VTErrorFieldBindingMap(VTError error) {
		if(error == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"Trying to set null to error");
			logger.debug("VTError object cannot be null", ex);
			throw ex;
		}
		this.error = error;
	}
	
	public VTErrorFieldBindingMap(VTError error, String fullRootClassName,
			String... fieldNames) {
		this(error);
		bindFields(fullRootClassName, fieldNames);
	}
	
	public VTError getError() {
		return error;
	}

	public void setError(VTError error) {
		this.error = error;
	}

	public Map<String, Set<String>> getBindingFieldMap() {
		return bindingFieldMap;
	}

	public void setBindingFieldMap(Map<String, Set<String>> bindingFieldMap) {
		this.bindingFieldMap = bindingFieldMap;
	}
	
	public boolean hasFieldSpecificErrors() {
		Map<String, Set<String>> fieldBindings = getBindingFieldMap();
		return ((fieldBindings != null) && (!fieldBindings.isEmpty()));
	}

	public void bindFields(String fullRootClassName, String ...fieldNames) {
		if((fullRootClassName == null) || (fieldNames == null)) {
			logger.debug("VTErrorFieldBindingMap: binding did not happen, null arguments passed");
			return;
		}
		
		//clean fieldNames, cheeck for nulls & duplicates (Set takes care of this)
		Set<String> finalInputFieldNames = new HashSet<String>();
		for(String fn : fieldNames) {
			if((fn != null) && (!fn.trim().isEmpty())) {
				finalInputFieldNames.add(fn);
			}
		}
		
		if(finalInputFieldNames.isEmpty()) {
			return;
		}
		
		if(getBindingFieldMap() == null) {
			setBindingFieldMap(new HashMap<String, Set<String>>());
		}
		Map<String, Set<String>> bindingFM = getBindingFieldMap();
		
		Set<String> fns = bindingFM.get(fullRootClassName);
		if(fns == null) {
			bindingFM.put(fullRootClassName, finalInputFieldNames);
			return;
		}

		Set<String> newFieldSet = new HashSet<String>();
		newFieldSet.addAll(fns);
		newFieldSet.addAll(finalInputFieldNames);
		
		bindingFM.put(fullRootClassName, newFieldSet);
		
		return;
	}
	
	public boolean hasFieldError(String rootClassName, String fieldName) {
		if ((rootClassName == null) || (rootClassName.trim().isEmpty())
				|| (fieldName == null) || (fieldName.trim().isEmpty())) {
			return false;
		}
		
		if((bindingFieldMap == null) || bindingFieldMap.isEmpty()) {
			return false;
		}
		
		Set<String> fieldNames = bindingFieldMap.get(rootClassName);
		return (fieldNames != null) ? fieldNames.contains(fieldName) : false;
	}
}

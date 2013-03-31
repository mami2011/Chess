package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "errorCode", "errorMessage", "severity", "domain" })
public class VTError {
	private VTErrorCode errorCode;
	private String errorMessage;
	private VTErrorSeverity severity;
	private VTErrorDomain domain;

	public VTError(VTErrorCode errorCode, String errorMessage, VTErrorDomain domain){
		this(errorCode, errorMessage, VTErrorSeverity.ERROR, domain);
	}
	
	public VTError(VTErrorCode errorCode, String errorMessage,
			VTErrorSeverity severity, VTErrorDomain domain) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.domain = domain;
		this.severity = severity;
	}

	public VTErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(VTErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public VTErrorSeverity getSeverity() {
		return severity;
	}

	public void setSeverity(VTErrorSeverity severity) {
		this.severity = severity;
	}

	public VTErrorDomain getDomain() {
		return domain;
	}

	public void setDomain(VTErrorDomain domain) {
		this.domain = domain;
	}
	
	
}

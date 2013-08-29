package com.vendertool.sharedtypes.error;

public class FPSErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.FTS;
	
	private static class FPSErrorsHolder {
		private static final FPSErrors INSTANCE = new FPSErrors();
	}
	
	public static FPSErrors getInstance(){
		return FPSErrorsHolder.INSTANCE;
	}
	
	private FPSErrors(){}
	
	//Define errors here
	public VTError INVALID_FILE_FORMAT = new VTError(
			FPSErrorCode.INVALID_FILE_FORMAT, 
			"File format is not supported", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError FILE_TOO_BIG = new VTError(
			FPSErrorCode.FILE_TOO_BIG, 
			"File is too big", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError FILE_CORRUPTED = new VTError(
			FPSErrorCode.FILE_CORRUPTED, 
			"Unable to read file contents, may be corrupted", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError EMPTY_FILE = new VTError(
			FPSErrorCode.EMPTY_FILE, 
			"File contents are empty", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_FILE_STRUCTURE = new VTError(
			FPSErrorCode.INVALID_FILE_STRUCTURE, 
			"The file content structure is not as expected", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError UNAUTHORIZED_FILE_ACCESS = new VTError(
			FPSErrorCode.UNAUTHORIZED_FILE_ACCESS, 
			"File you are trying to access is not authrorized", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
}

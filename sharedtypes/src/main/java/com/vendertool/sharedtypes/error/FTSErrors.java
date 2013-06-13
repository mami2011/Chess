package com.vendertool.sharedtypes.error;

public class FTSErrors {
	private static final VTErrorDomainEnum DOMAIN = VTErrorDomainEnum.FTS;
	private static FTSErrors INSTANCE = null;
	
	public static synchronized FTSErrors getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new FTSErrors();
		}
		return INSTANCE;
	}
	
	private FTSErrors(){}
	
	//Define errors here
	public VTError INVALID_FILE_FORMAT = new VTError(
			FTSErrorCode.INVALID_FILE_FORMAT, 
			"File format is not supported", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError FILE_TOO_BIG = new VTError(
			FTSErrorCode.FILE_TOO_BIG, 
			"File is too big", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError FILE_CORRUPTED = new VTError(
			FTSErrorCode.FILE_CORRUPTED, 
			"Unable to read file contents, may be corrupted", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError EMPTY_FILE = new VTError(
			FTSErrorCode.EMPTY_FILE, 
			"File contents are empty", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError INVALID_FILE_STRUCTURE = new VTError(
			FTSErrorCode.INVALID_FILE_STRUCTURE, 
			"The file content structure is not as expected", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
	
	public VTError UNAUTHORIZED_FILE_ACCESS = new VTError(
			FTSErrorCode.UNAUTHORIZED_FILE_ACCESS, 
			"File you are trying to access is not authrorized", 
			VTErrorSeverityEnum.ERROR, 
			DOMAIN);
}

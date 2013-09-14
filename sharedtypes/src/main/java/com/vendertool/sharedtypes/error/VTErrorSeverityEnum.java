package com.vendertool.sharedtypes.error;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum VTErrorSeverityEnum {
	INFO,
	WARNING,	
	ERROR,
	FATAL;
}

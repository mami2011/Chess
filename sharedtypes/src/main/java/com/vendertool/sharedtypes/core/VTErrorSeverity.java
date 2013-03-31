package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum VTErrorSeverity {
	
	INFO(1, "INFO"),
	WARNING(2, "WARNING"),	
	ERROR(3, "ERROR"),
	FATAL(4, "FATAL");
	
	private int id;
	private String name;
	
	VTErrorSeverity(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
}

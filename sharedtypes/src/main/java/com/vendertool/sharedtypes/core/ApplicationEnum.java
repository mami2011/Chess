package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ApplicationEnum {
	WEB(1, "WEB"),
	BATCH(2, "BATCH"),
	MANUAL(3, "MANUAL"),
	OTHER(3, "OTHER");
	
	private int id;
	private String name;
	
	ApplicationEnum(){
		this(-1, "UNKNOWN");
	}
	
	ApplicationEnum(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}

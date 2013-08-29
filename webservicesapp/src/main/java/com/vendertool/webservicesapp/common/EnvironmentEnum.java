package com.vendertool.webservicesapp.common;

public enum EnvironmentEnum {
	DEVELOPMENT(1, "DEVELOPMENT"),
	QA(2, "QA"),
	SANDBOX(3, "SANDBOX"),
	PRODUTION(4, "PRODUTION");
	
	private int id;
	private String name;
	
	EnvironmentEnum(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public static EnvironmentEnum get(String env) {
		if(env == null) {
			return null;
		}
		
		String environment = env.toUpperCase();
		return EnvironmentEnum.valueOf(environment);
	}
}

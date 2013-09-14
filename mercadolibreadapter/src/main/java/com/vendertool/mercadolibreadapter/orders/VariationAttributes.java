package com.vendertool.mercadolibreadapter.orders;

public class VariationAttributes {
	private long id;
	private String name;
	private long value_id;
	private String value_name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getValue_id() {
		return value_id;
	}

	public void setValue_id(long value_id) {
		this.value_id = value_id;
	}

	public String getValue_name() {
		return value_name;
	}

	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}
}
package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShippingPolicy {
	
	@XmlEnum
	public enum ShippingTypeEnum {
		UNKNOWN(-1), CUSTOM(1), FIXED(2), CALCULATED(3);
		private int id;

		private ShippingTypeEnum(int id) {
			this.id = id; 
		}

		public int getId() {
			return id;
		}

		public ShippingTypeEnum get(int id) {
			ShippingTypeEnum[] shippingTypeValues = ShippingTypeEnum.values();
			for (ShippingTypeEnum typeEnum : shippingTypeValues) {
				if (typeEnum.getId() == id) {
					return typeEnum;
				}
			}
			return UNKNOWN;
		}
	}
	
	private int id;
	private String name;
	private ShippingTypeEnum shippingType;
	private FixedShippingDetails fixedShippingDetails;
	private CustomShippingDetails customShippingDetails;
	
	public ShippingPolicy(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShippingTypeEnum getShippingType() {
		return shippingType;
	}

	public void setShippingType(ShippingTypeEnum shippingType) {
		this.shippingType = shippingType;
	}

	public FixedShippingDetails getFixedShippingDetails() {
		return fixedShippingDetails;
	}

	public void setFixedShippingDetails(FixedShippingDetails fixedShippingDetails) {
		this.fixedShippingDetails = fixedShippingDetails;
	}

	public CustomShippingDetails getCustomShippingDetails() {
		return customShippingDetails;
	}

	public void setCustomShippingDetails(CustomShippingDetails customShippingDetails) {
		this.customShippingDetails = customShippingDetails;
	}
}

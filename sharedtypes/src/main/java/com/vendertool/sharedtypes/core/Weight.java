package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Weight {
	
	@XmlEnum
	public enum WeightUnitEnum {
		UNKNOWN(-1), GRAMS(1),KGS(2),OUNCES(3),LBS(4);
		
		private int id;

		private WeightUnitEnum(int id) {
			this.id = id; 
		}

		public int getId() {
			return id;
		}

		public static WeightUnitEnum get(int id) {
			WeightUnitEnum[] values = WeightUnitEnum.values();
			for (WeightUnitEnum typeEnum : values) {
				if (typeEnum.getId() == id) {
					return typeEnum;
				}
			}
			return UNKNOWN;
		}
	}
	
	private double value;
	private WeightUnitEnum weightUnit;
	
	public Weight() {
		this(0);
	}
	
	public Weight(double value) {
		setValue(value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public WeightUnitEnum getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(WeightUnitEnum weightUnit) {
		this.weightUnit = weightUnit;
	}
	
}

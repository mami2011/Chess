package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dimension {
	
	@XmlEnum
	public enum DimensionUnitEnum {
		UNKNOWN(-1),MM(1),CMS(2),INCHES(3),FEET(4);
		
		private int id;

		private DimensionUnitEnum(int id) {
			this.id = id; 
		}

		public int getId() {
			return id;
		}

		public DimensionUnitEnum get(int id) {
			DimensionUnitEnum[] values = DimensionUnitEnum.values();
			for (DimensionUnitEnum typeEnum : values) {
				if (typeEnum.getId() == id) {
					return typeEnum;
				}
			}
			return UNKNOWN;
		}
	}
	
	private int length;
	private int width;
	private int height;
	private DimensionUnitEnum dimensionUnit;
	
	public Dimension() {
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public DimensionUnitEnum getDimensionUnit() {
		return dimensionUnit;
	}
	public void setDimensionUnit(DimensionUnitEnum dimensionUnit) {
		this.dimensionUnit = dimensionUnit;
	}
}

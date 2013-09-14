package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

import com.vendertool.sharedtypes.core.Dimension.DimensionUnitEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class Image {
	
	@XmlEnum
	public enum ImageFormatEnum {
		UNKNOWN(-1), JPEG(1),GIF(2),BMP(3),PNG(4),TIFF(5),EXIF(6);
		
		private int id;

		private ImageFormatEnum(int id) {
			this.id = id; 
		}

		public int getId() {
			return id;
		}

		public static ImageFormatEnum get(int id) {
			ImageFormatEnum[] values = ImageFormatEnum.values();
			for (ImageFormatEnum typeEnum : values) {
				if (typeEnum.getId() == id) {
					return typeEnum;
				}
			}
			return UNKNOWN;
		}
	}
	
	private int imageId;
	private byte[] bytes;
	private String size;
	private ImageFormatEnum format;
	private String name;
	private String imgurl;
	
	public Image(){
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public ImageFormatEnum getFormat() {
		return format;
	}

	public void setFormat(ImageFormatEnum format) {
		this.format = format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}

package com.vendertool.sharedtypes.error;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum VTErrorDomainEnum {
	UNKNOWN,
	SYSTEM,
	SIGNIN,
	REGISTRATION,
	ROLE_MANAGEMENT,
	INVENTORY,
	LISTING,
	RETURNS_TEMPLATE,
	SHIPPING_TEMPLATE,
	ORDER_MANAGEMENT,
	MERCHANT_REPORTS,
	SHIPPING,
	TRACKING,
	METADATA,
	FTS,
	COMMON;
}

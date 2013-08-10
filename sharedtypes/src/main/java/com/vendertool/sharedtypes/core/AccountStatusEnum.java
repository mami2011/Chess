package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum AccountStatusEnum {
	NOT_VERIFIED,
	VERIFIED,
	CLOSED,
	SUSPENDED,
	DELINQUENT, 
	PASSWORD_EXPIRED;
}

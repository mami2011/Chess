package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum AccountStatusEnum {
	CREATED,
	ACTIVE,
	INACTIVE,
	CLOSED,
	SUSPENDED,
	DELINQUENT;
}

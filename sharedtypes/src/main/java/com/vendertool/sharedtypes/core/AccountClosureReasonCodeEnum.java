package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum AccountClosureReasonCodeEnum {
	TOO_EXPENSIVE,
	INSUFFICIENT_FEATURES,
	DOESNT_SCALE_TO_MY_BUSINESS,
	FOUND_A_BETTER_TOOL,
	TOO_BUGGY,
	GOING_OUT_OF_BUSINESS,
	OTHER;
}

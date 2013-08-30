package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethod {
	
	@XmlEnum
	public enum PaymentTypeEnum {
		UNKNOWN(-1),MERCADO_PAGO(1), CREDIT_CARD_VISA(2), CREDIT_CARD_MASTER(3), PAYPAL(4);
		private int id;

		private PaymentTypeEnum(int id) {
			this.id = id; 
		}

		public int getId() {
			return id;
		}

		public static PaymentTypeEnum get(int id) {
			PaymentTypeEnum[] values = PaymentTypeEnum.values();
			for (PaymentTypeEnum typeEnum : values) {
				if (typeEnum.getId() == id) {
					return typeEnum;
				}
			}
			return UNKNOWN;
		}
	}
	
	
	private PaymentTypeEnum method;
	private String paymentId;
	
	public PaymentMethod(){}
	
	public PaymentTypeEnum getMethod() {
		return method;
	}

	public void setMethod(PaymentTypeEnum method) {
		this.method = method;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
}

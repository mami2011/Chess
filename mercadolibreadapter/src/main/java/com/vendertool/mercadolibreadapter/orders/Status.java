package com.vendertool.mercadolibreadapter.orders;

public class Status {
	private String confirmed;
	private String payment_required;
	private String payment_in_process;
	private String paid;
	private String cancelled;

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getPayment_required() {
		return payment_required;
	}

	public void setPayment_required(String payment_required) {
		this.payment_required = payment_required;
	}

	public String getPayment_in_process() {
		return payment_in_process;
	}

	public void setPayment_in_process(String payment_in_process) {
		this.payment_in_process = payment_in_process;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getCancelled() {
		return cancelled;
	}

	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}

}
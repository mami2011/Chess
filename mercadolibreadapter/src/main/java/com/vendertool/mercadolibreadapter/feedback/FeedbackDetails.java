package com.vendertool.mercadolibreadapter.feedback;

public class FeedbackDetails {
	private String rating;
	private String fulfilled;
	private String reason;
	private String message;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(String fulfilled) {
		this.fulfilled = fulfilled;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
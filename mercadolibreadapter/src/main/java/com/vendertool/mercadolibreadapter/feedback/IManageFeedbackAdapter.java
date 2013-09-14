package com.vendertool.mercadolibreadapter.feedback;

public interface IManageFeedbackAdapter {

	public void postFeedback(FeedbackDetails feedbackDetails);
	
	public void respondToFeedback(FeedbackDetails feedbackDetails);
	
	public void changeFeedback(FeedbackDetails feedbackDetails);
}
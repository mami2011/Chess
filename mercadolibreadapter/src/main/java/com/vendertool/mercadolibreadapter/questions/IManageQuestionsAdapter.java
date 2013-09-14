package com.vendertool.mercadolibreadapter.questions;


public interface IManageQuestionsAdapter {

	public void answerQuestion();

	public void deleteQuestion(String questionId);

	public void blockUserAskingQ(QuestionedUser user);

	public void getBlockedUsersFromAskingQ();

	public void removeUserFromBlocklistQ(QuestionedUser user);
}
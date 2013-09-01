package com.vendertool.mercadolibreadapter.questions;

import org.apache.log4j.Logger;


public class ManageQuestionsAdapterImpl implements IManageQuestionsAdapter{
	private static final Logger logger = Logger
			.getLogger(ManageQuestionsAdapterImpl.class);

	private static class ManageQuestionsAdapterImplHolder {
		private static final ManageQuestionsAdapterImpl INSTANCE = new ManageQuestionsAdapterImpl();
	}

	private ManageQuestionsAdapterImpl() {

	}

	public static ManageQuestionsAdapterImpl getInstance() {
		return ManageQuestionsAdapterImplHolder.INSTANCE;
	}

	public void answerQuestion() {
		
	}

	public void deleteQuestion(String questionId) {
		
	}

	public void blockUserAskingQ(QuestionedUser user) {
		
	}

	public void getBlockedUsersFromAskingQ() {
		
	}

	public void removeUserFromBlocklistQ(QuestionedUser user) {
		
	}
}
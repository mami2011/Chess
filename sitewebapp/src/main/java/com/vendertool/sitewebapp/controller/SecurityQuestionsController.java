package com.vendertool.sitewebapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.ErrorResponse;

@Controller
public class SecurityQuestionsController {
	private static final Logger logger = Logger.getLogger(SecurityQuestionsController.class);
	
	@RequestMapping(value="questions", method=RequestMethod.GET)
	public String getSecurityQuestionsView(ModelMap modelMap, HttpServletRequest request){
		logger.info("getSecurityQuestionsView GET controller invoked");
		
		Locale locale = RequestContextUtils.getLocale(request);

		// Add mock data
		SecurityQuestion q1 = new SecurityQuestion();
		q1.setId(1);
		q1.setText("What is the name of your favorite pet?");
		SecurityQuestion q2 = new SecurityQuestion();
		q2.setId(2);
		q2.setText("What is the name of your high school?");
		SecurityQuestion q3 = new SecurityQuestion();
		q3.setId(3);
		q3.setText("What is your favorite color");
		SecurityQuestion q4 = new SecurityQuestion();
		q4.setId(4);
		q4.setText("What street did you grow up on");
		List<SecurityQuestion> questions = new ArrayList<SecurityQuestion>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		modelMap.addAttribute("questionList", questions);

		// Add JSON for Angular
		try {
			ObjectMapper mapper = new ObjectMapper();
			String modelMapJson= mapper.writeValueAsString(modelMap);
			modelMap.put("modelMapJson", modelMapJson);
		}
		catch (Exception e) {
			logger.log(Level.ERROR, e.getMessage(), e);
			e.printStackTrace();
			throw new VTRuntimeException("Cannot convert modelMap to json");
		}
		
		return "securityQuestions/securityQuestions";
	}
	
	@RequestMapping(value="questions/save", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveQuestionAnswers(@RequestBody SecurityQuestionsResponse res) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		if (res != null && !res.getQuestionAnswers().isEmpty()) {
			int count = 1;
			for (SecurityQuestionAnswer qa : res.getQuestionAnswers()) {
				
				if (qa.getQuestionId() == null) {
					errorResponse.addFieldBindingError(
							Errors.REGISTRATION.MISSING_SECURITY_QUESTION, 
							SecurityQuestionAnswer.class.getName(),
							"question" + count);
				}
				
				if (qa.getAnswer() == null) {
					errorResponse.addFieldBindingError(
							Errors.REGISTRATION.MISSING_SECURITY_ANSWER,
							SecurityQuestionAnswer.class.getName(),
							"answer" + count);
				} 
				
				count++;
				System.err.println("id:" + qa.getQuestionId() + " " + qa.getAnswer());
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("errorResponse", errorResponse);
		
		return map;
	}

	
	/******************************************
	 * 
	 * Get partial pages for Angular
	 * 
	 ******************************************/
	@RequestMapping(value = "questions/partial/questions", method = RequestMethod.GET)
	public String getQuestionsPartial() {
		logger.info("getQuestionsPartial controller invoked");
		return "securityQuestions/partial/questions";
	}
	
	@RequestMapping(value = "questions/partial/success", method = RequestMethod.GET)
	public String getSuccessPartial() {
		logger.info("getSuccessPartial controller invoked");
		return "securityQuestions/partial/success";
	}

	

}

/** Mock classes. Replace later **/
class SecurityQuestion {
	private int id;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}

class SecurityQuestionAnswer {
	
	private Integer questionId;
	private String answer;
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}

class SecurityQuestionsResponse {
	
	private List<SecurityQuestionAnswer> questionAnswers;

	public List<SecurityQuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(List<SecurityQuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}
}


















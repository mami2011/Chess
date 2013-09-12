<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t1" tagdir="/WEB-INF/tags/page" %>

<spring:message code="form.securityquestions.title" var="title"/>
<spring:message code='form.submit' var="submit"/>

<t1:page title="VendorTool" angularAppName="securityQuestionsApp" currentPage="questions" email="${email}" >

	<jsp:attribute name="css">
		<link href="<c:url value='/wro/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/wro/securityQuestions.js' />" type="text/javascript"></script>
	</jsp:attribute>
	
	<jsp:attribute name="inlineJs">
		securityQuestionsApp.factory('Data', function() {
			return ${modelMapJson};
		});
		
		// IE placeholder text
		$('input').placeholder();
	</jsp:attribute>
	
	<jsp:body>
		<div id="pgBg"><img src="resources/img/cafe2.jpg" alt=""></div>
		
	    <div class="reg main input-group" ng-controller="SecurityQuestionsCtrl">
	    	
	        <h3 class="ttl">${title}</h3>
			
			<c:if test="${errorResponse.hasErrors()}">
				<div class="pg-msg">
					<div class="alert alert-danger">
						<c:forEach items="${errorResponse.getVTErrors()}" var="vterror">
							${vterror.getMessage()}<br/>
						</c:forEach>
					</div>
				</div>
			</c:if>

			<form>

				<select ng-model="question1" ng-options="q.id as q.text for q in question1Options">
					<option value="">- Select a question -</option>
		        </select>
	            <div>
	                <input class="form-control" ng-model="answer1" placeholder="Your answer to question" autocomplete="off"/>
	            </div>
				
				<select ng-model="question2" ng-options="q.id as q.text for q in question2Options">
					<option value="">- Select a second question -</option>
		        </select>
	            <div>
	                <input class="form-control" ng-model="answer2" placeholder="Your answer to second question" autocomplete="off"/>
	            </div>
				
	            <div class="submit">
	            	<button ng-click="save()" type="button" class="btn btn-primary grn">Submit</button>
	            </div>

	        </form>
	    </div>
	</jsp:body>
</t1:page>

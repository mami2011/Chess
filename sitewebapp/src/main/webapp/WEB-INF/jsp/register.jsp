<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:page title="VendorTool registration">

	<jsp:attribute name="header">
		<t:header email="${email}" currentPage="register"/>
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/resources/js/lang-menu.js' />"></script>
		<script src="<c:url value='/resources/js/register.js' />"></script>
	</jsp:attribute>
	
	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
		<c:set var="email" value="${account.emailId}"/>
		<div class="reg main input-group bx-rnd-shdw">
			<h3 class="ttl"><spring:message code="form.registration.signup"/></h3>
			<spring:message code='form.registration.firstname' var="firstname"/>
			<spring:message code='form.registration.lastname' var="lastname"/>
			<spring:message code='form.registration.email' var="emailId"/>
			<spring:message code='form.registration.password' var="password"/>
			<spring:message code='form.registration.confirmpassword' var="confirmpassword"/>
			<spring:message code='form.registration.submit' var="submit"/>
			
			<spring:message code='form.registration.email.info' var="emailInfo"/>
			<spring:message code='form.registration.password.info' var="pwdInfo"/>
			<spring:message code='form.registration.confirmpassword.info' var="confPwdInfo"/>
	
			<form:form method="post" commandName="account">
				<div>
					<form:input class="form-control" placeholder="${firstname}"  path="contactDetails.firstName"/>
				</div>
				<div>
					<form:input class="form-control" placeholder="${lastname}"  path="contactDetails.lastName"/>
				</div>
				<div>
					<form:input id="emailId" class="form-control info-msg-available" placeholder="${emailId}"  path="emailId"/>
					<span id="email-info">${emailInfo}</span>
				</div>
				<div>
					<form:password id="password" class="form-control info-msg-available" placeholder="${password}"  path="password"/>
					<span id="pwd-info">${pwdInfo}</span>
				</div>
				<div>
					<form:password id="confirmpassword" class="form-control info-msg-available" placeholder="${confirmpassword}" path="confirmPassword"/>
					<span id="conf-pwd-info">${confPwdInfo}</span>
				</div>
				<div class="submit">
					<input type="submit"class="btn lg" value="${submit}" />
				</div>
			</form:form>
		</div>
	</jsp:body>
	
</t:page>

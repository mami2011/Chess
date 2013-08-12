<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:page stylesheet="register.css">
	<c:set var="email" value="${account.emailId}"/>
	<div class="reg main input-group bx-rnd-shdw">
		<h3 class="ttl"><spring:message code="form.registration.signup"/></h3>
		<spring:message code='form.registration.email' var="emailId"/>
		<spring:message code='form.registration.password' var="password"/>
		<spring:message code='form.registration.confirmpassword' var="confirmpassword"/>
		<spring:message code='form.registration.submit' var="submit"/>

		<form:form method="post" commandName="account">
			<div>
				<form:input class="form-control" placeholder="${emailId}"  path="emailId"/>
			</div>
			<div>
				<form:password class="form-control" placeholder="${password}"  path="password"/>
			</div>
			<div>
				<form:password class="form-control" placeholder="${confirmpassword}" path="confirmPassword"/>
			</div>
			<div class="submit">
				<input type="submit"class="btn lg" value="${submit}" />
			</div>
		</form:form>
	</div>
</t:page>
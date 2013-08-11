<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<t:page stylesheet="register.css">
	
	<c:set var="email" value="${account.emailId}"/>
	<%-- 
	<c:set var="password" value="${fields['password']}"/>
	<c:set var="passwordConf" value="${fields['passwordConf']}"/>
	--%>
	<div class="reg main input-group bx-rnd-shdw">
		<h3 class="ttl"><spring:message code="form.registration.signup"/></h3>
		
		<%--
		<c:if test="${email.hasError || password.hasError || passwordConf.hasError}">
			<div class="alert alert-danger">
				There were problems signing you up.
			</div>
		</c:if>
		--%>
		<!-- <form method="post" action="register"> -->
		
		
		<form:form method="post" commandName="account">
		<spring:message code='form.registration.email' var="emailId"/>
		<spring:message code='form.registration.password' var="password"/>
		<spring:message code='form.registration.confirmpassword' var="confirmpassword"/>
		<spring:message code='form.registration.submit' var="submit"/>
			<%-- 
			<div class="${email.hasError ? 'err' : ''}">--%>
			<div>
				<%-- <input class="form-control" placeholder="Email" name="email" type="email" value="${email.value}"/> --%>
				<form:input class="form-control" placeholder="${emailId}"  name="email" type="email" path="emailId"/>
				<%-- 
				<div class="err-msg">
					<c:forEach var="item" items="${email.errorMessages}">
						${item}<br/>
					</c:forEach>
				</div>--%>
			</div>
			<%-- 
			<div class="${password.hasError ? 'err' : ''}">--%>
			<div>
				<!-- <input class="form-control" placeholder="Password" type="password" name="password"/> -->
				<form:input class="form-control" placeholder="${password}" type="password" name="password" path="password"/>
				<%-- 
				<div class="err-msg">
					<c:forEach var="item" items="${password.errorMessages}">
						${item}<br/>
					</c:forEach>
				</div>--%>
			</div>
			<%-- 
			<div class="${passwordConf.hasError ? 'err' : ''}">--%>
			<div>
				<form:input class="form-control" placeholder="${confirmpassword}"  type="password" name="password" path="confirmPassword"/>
				<%-- 
				<div class="err-msg">
					<c:forEach var="item" items="${passwordConf.errorMessages}">
						${item}<br/>
					</c:forEach>
				</div>--%>
			</div>
			<div class="submit">
				<input type="submit"class="btn lg" value="${submit}" />
			</div>
		</form:form>
	</div>

</t:page>
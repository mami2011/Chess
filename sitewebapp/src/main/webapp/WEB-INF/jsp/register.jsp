<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:page title="${title}">
	
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
		<spring:message code="form.registration.title" var="title"/>
		<c:set var="email" value="${account.emailId}"/>
		<div class="reg main input-group bx-rnd-shdw">
			<h3 class="ttl"><spring:message code="form.registration.signup"/></h3>
			<spring:message code='form.registration.firstname' var="firstname"/>
			<spring:message code='form.registration.lastname' var="lastname"/>
			<spring:message code='form.registration.email' var="emailId"/>
			<spring:message code='form.registration.password' var="password"/>
			<spring:message code='form.registration.confirmpassword' var="confirmpassword"/>
			<spring:message code='form.submit' var="submit"/>
			
			<spring:message code='form.registration.email.info' var="emailInfo"/>
			<spring:message code='form.registration.password.info' var="pwdInfo"/>
			<spring:message code='form.registration.confirmpassword.info' var="confPwdInfo"/>
	
			<form:form method="post" commandName="account">
				<c:if test="${errorResponse.hasErrors()}">
					<div class="errorblock">
						<c:forEach items="${errorResponse.getVTErrors()}" var="vterror">
							<span class="errorfont">
								<c:out value="${vterror.getMessage()}" />
							</span>
							<br />
						</c:forEach>
					</div>
				</c:if>
				
				<div>
					<c:set var="firstname_rootpath" value="contactDetails.firstName" />
					<c:set var="firstnamepath" value="firstName" />
					<form:input class="form-control" placeholder="${firstname}"  path="${firstname_rootpath}"/>
					<c:if test="${errorResponse.hasFieldError(account.getContactDetails().getClass().getName(), firstnamepath)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(account.getContactDetails().getClass().getName(), firstnamepath)}"
								var="vterror">
								<span class="errorfont">
									<c:out value="${vterror.getMessage()}" />
								</span>
								<br />
							</c:forEach>
						</div>
					</c:if>
				</div>
				<div>
					<c:set var="lastname_rootpath" value="contactDetails.lastName" />
					<c:set var="lastnamepath" value="lastName" />
					<form:input class="form-control" placeholder="${lastname}"  path="${lastname_rootpath}"/>
					<c:if test="${errorResponse.hasFieldError(account.getContactDetails().getClass().getName(), lastnamepath)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(account.getContactDetails().getClass().getName(), lastnamepath)}"
								var="vterror">
								<span class="errorfont">
									<c:out value="${vterror.getMessage()}" />
								</span>
								<br />
							</c:forEach>
						</div>
					</c:if>
				</div>
				<div>
					<c:set var="emailIdpath" value="emailId" />
					<form:input id="emailId" class="form-control info-msg-available" placeholder="${emailId}"  path="${emailIdpath}"/>
					<c:if test="${errorResponse.hasFieldError(account.getClass().getName(), emailIdpath)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(account.getClass().getName(), emailIdpath)}"
								var="vterror">
								<span class="errorfont">
									<c:out value="${vterror.getMessage()}" />
								</span>
								<br />
							</c:forEach>
						</div>
					</c:if>
					<span id="email-info">${emailInfo}</span>
				</div>
				<div>
					<c:set var="passwordpath" value="password" />
					<form:password id="password" class="form-control info-msg-available" placeholder="${password}"  path="${passwordpath}"/>
					<c:if test="${errorResponse.hasFieldError(account.getClass().getName(), passwordpath)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(account.getClass().getName(), passwordpath)}"
								var="vterror">
								<span class="errorfont">
									<c:out value="${vterror.getMessage()}" />
								</span>
								<br />
							</c:forEach>
						</div>
					</c:if>
					<span id="pwd-info">${pwdInfo}</span>
				</div>
				<div>
					<c:set var="confirmPasswordPath" value="confirmPassword" />
					<form:password id="confirmpassword" class="form-control info-msg-available" placeholder="${confirmpassword}" path="${confirmPasswordPath}"/>
					<c:if test="${errorResponse.hasFieldError(account.getClass().getName(), confirmPasswordPath)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(account.getClass().getName(), confirmPasswordPath)}"
								var="vterror">
								<span class="errorfont">
									<c:out value="${vterror.getMessage()}" />
								</span>
								<br />
							</c:forEach>
						</div>
					</c:if>
					<span id="conf-pwd-info">${confPwdInfo}</span>
				</div>

				<div class="submit">
					<input type="submit" class="btn lg grn" value="${submit}" />
				</div>
				
				<c:if test="${errorResponse.hasErrors()}">
					<div>
						<div>
							<label for="jsonAccountOutput">JSON Account Output: </label>	
							<textarea id="jsonAccountOutput" readonly rows="8" cols="55"><c:out value="${json_account_output}" /></textarea>
						</div>
						<div>
							<label for="jsonErrorResponseOutput">JSON Error Response Output: </label>	
							<textarea id="jsonErrorResponseOutput" readonly rows="8" cols="55"><c:out value="${json_err_res_output}"/></textarea>
						</div>
					</div>
				</c:if>
			</form:form>
		</div>
	</jsp:body>
	
</t:page>

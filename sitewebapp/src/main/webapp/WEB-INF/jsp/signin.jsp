<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:page title="${signintitle}">
	
	<jsp:attribute name="header">
		<t:header email="${email}" currentPage="signin"/>
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/resources/js/lang-menu.js' />"></script>
	</jsp:attribute>
	
	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
	    <div class="reg main input-group bx-rnd-shdw">
	    	<spring:message code="form.signin.signin" var="signintitle"/>
	    	<spring:message code='form.submit' var="submit"/>
	    	
	        <h3 class="ttl"><c:out value="${signintitle}" /></h3>

	        <form:form method="post" commandName="signin">
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
	            	<spring:message code='form.signin.username' var="emaillabel"/>
	            	<c:set var="username_path" value="username" />
	                <form:input class="form-control" placeholder="${emaillabel}"  path="${username_path}"/>
					<c:if test="${errorResponse.hasFieldError(signin.getClass().getName(), username_path)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(signin.getClass().getName(), username_path)}"
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
	            	<spring:message code='form.signin.password' var="passwordlabel"/>
	            	<c:set var="password_path" value="password" />
	                <form:password class="form-control" placeholder="${passwordlabel}" path="${password_path}"/>
					<c:if test="${errorResponse.hasFieldError(signin.getClass().getName(), password_path)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(signin.getClass().getName(), password_path)}"
								var="vterror">
								<span class="errorfont">
									<c:out value="${vterror.getMessage()}" />
								</span>
								<br />
							</c:forEach>
						</div>
					</c:if>	                
	            </div>
	            <div class="submit">
	                <input type="submit" class="btn lg" value="${submit}"/>
	            </div>
	        </form:form>
	    </div>
	</jsp:body>
</t:page>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t1" tagdir="/WEB-INF/tags/page" %>

<t1:page title="${signintitle}" currentPage="signin" email="${email}">

	<jsp:attribute name="css">
		<link href="<c:url value='/wro/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
	    <div class="reg main input-group bx-rnd-shdw">
	    	<spring:message code="form.signin.signin" var="signintitle"/>
	    	<spring:message code='form.submit' var="submit"/>
	    	
	        <h3 class="ttl"><c:out value="${signintitle}" /></h3>
	        <c:if test="${param.justConfAccount}" >
	        	<spring:message code="form.registration.welcome"/>
	        </c:if>

			<c:if test="${!empty SPRING_SECURITY_LAST_EXCEPTION.message}">
			    <div class="pg-msg">
					<div class="alert alert-danger">
						${SPRING_SECURITY_LAST_EXCEPTION.message}
						<c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
					</div>
				</div>
			</c:if>
			
			<c:if test="${errorResponse.hasErrors()}">
				<div class="pg-msg">
					<div class="alert alert-danger">
						<c:forEach items="${errorResponse.getVTErrors()}" var="vterror">
							${vterror.getMessage()}<br/>
						</c:forEach>
					</div>
				</div>
			</c:if>
			
			<form action="<c:url value="/j_spring_security_check" />" method="POST">
	            <div>
	            	<spring:message code='form.signin.username' var="emaillabel"/>
	            	<c:set var="username_path" value="username" />
	                <input id="username" class="form-control" name="j_username" type="text" placeholder="${emaillabel}"/>
	            </div>
	            <div>
	            	<spring:message code='form.signin.password' var="passwordlabel"/>
	            	<c:set var="password_path" value="password" />
	                <!-- For spring login page we have to use the below -->
	                <input id="password" class="form-control" name="j_password" type="password" placeholder="${passwordlabel}"/>
	            </div>
	            <div class="submit">
	            	<input type="submit" class="btn btn-primary grn" value="${submit}" />
	            </div>
	        </form>
	    </div>
	</jsp:body>
</t1:page>

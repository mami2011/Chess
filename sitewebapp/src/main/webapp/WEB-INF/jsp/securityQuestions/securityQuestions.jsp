<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t1" tagdir="/WEB-INF/tags/page" %>

<t1:page title="${title}" currentPage="questions" email="${email}">

	<jsp:attribute name="css">
		<link href="<c:url value='/wro/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/wro/register.js' />" type="text/javascript"></script>
	</jsp:attribute>
	
	<jsp:attribute name="inlineJs">
		$('input').placeholder();
	</jsp:attribute>
	
	<jsp:body>
		<div id="pgBg"><img src="resources/img/cafe2.jpg" alt=""></div>
		
	    <div class="reg main input-group">
	    	<spring:message code="form.securityquestions.title" var="title"/>
	    	<spring:message code='form.submit' var="submit"/>
	    	
	        <h3 class="ttl">${title}</h3>
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
			
			<form action="<c:url value="" />" method="POST">
				<div class="dropdown">
					<a data-toggle="dropdown" href="#">Select question 1 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
					</ul>
				</div>
	            <div>
	                <input class="form-control" name="answer1" placeholder="Your answer to question 1" autocomplete="off"/>
	            </div>
	            <div class="dropdown">
					<a data-toggle="dropdown" href="#">Select question 2 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
					</ul>
				</div>
	            <div>
	                <input class="form-control" name="answer1" placeholder="Your answer to question 2" autocomplete="off"/>
	            </div>
	            <div class="submit">
	            	<input type="submit" class="btn btn-primary grn" value="${submit}" />
	            </div>
				
				
	        </form>
	    </div>
	</jsp:body>
</t1:page>

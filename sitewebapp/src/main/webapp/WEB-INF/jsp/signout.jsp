<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:page title="${signouttitle}" >
	
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
	    	<spring:message code="form.signin.signout" var="signouttitle"/>

	    	<h3 class="ttl"><c:out value="${signouttitle}" /></h3>
	    	<h5 class="ttl"><spring:message code="form.signout.signoutmsg"/></h5>
	    	<span><a href="/signin"><spring:message code="form.signin.signin"/></a></span>
	    	
		</div>	    	
	</jsp:body>
</t:page>	
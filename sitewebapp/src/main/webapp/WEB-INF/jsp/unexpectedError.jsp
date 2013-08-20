<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>



<t:page title="Unexpected error">
	<jsp:attribute name="header">
		<t:header email="${email}" currentPage="unexpectedError"/>
	</jsp:attribute>
	
	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
		<div class="reg main input-group bx-rnd-shdw">
	        <h3 class="ttl">Unexpected Exception</h3>
	        <div class="msg">
	            Sorry, an error has occurred, please report the problem.
	        </div>
	    </div>
	</jsp:body>
</t:page>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:page title="Session timeout">
	<jsp:attribute name="header">
		<t:header email="${email}" currentPage="sessiontimeout"/>
	</jsp:attribute>
	
	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
		<div class="reg main input-group bx-rnd-shdw">
	        <h3 class="ttl">Session timeout</h3>
	        <div class="msg">
	            Sorry, your session has timeout.
	            <p>
	                <a href="signin">Please click here to sign-in again.</a>
	            </p>
	        </div>
	    </div>
	</jsp:body>
</t:page>

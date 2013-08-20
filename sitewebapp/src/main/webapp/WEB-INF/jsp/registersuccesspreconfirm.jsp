<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:page title="VendorTool registration">
	<jsp:attribute name="header">
		<t:header email="${email}" currentPage="registersuccesspreconfirm"/>
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/resources/js/lang-menu.js' />"></script>
	</jsp:attribute>
	
	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/register.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
		<div class="reg main input-group bx-rnd-shdw">
	        <h3 class="ttl">Almost done!</h3>
	        <div class="msg">
	            Please check your email for our confirmation message.
	            In it you'll find a link to click to complete the sign-up process.
	        </div>
	    </div>
	</jsp:body>
</t:page>
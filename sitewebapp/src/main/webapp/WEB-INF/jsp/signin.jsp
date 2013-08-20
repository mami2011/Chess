<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page title="VendorTool Sign-in">
	
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
	        <h3 class="ttl">Sign-in</h3>
	
	        <form method="post" action="">
	            <div>
	                <input class="form-control" placeholder="Email" name="email" type="email" value=""/>
	            </div>
	            <div>
	                <input class="form-control" placeholder="Password" type="password" name="password"/>
	            </div>
	            <div class="submit">
	                <input type="submit"class="btn lg" value="Submit"/>
	            </div>
	        </form>
	    </div>
	</jsp:body>
</t:page>

<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--============
Page fragments
================--%>
<%@ attribute name="header"		fragment="true"%>
<%@ attribute name="scripts"	fragment="true"%>
<%@ attribute name="css"		fragment="true"%>

<%--============
Attributes
================--%>
<%@ attribute name="title" required="false"%>

<%--============
Variables
================--%>
<c:set var="htmlTitle" value="${empty htmlTitle ? 'Vendor Tool' : htmlTitle}"/>


<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>${title}</title>
		<link href='<c:url value="/resources/css/main.css" />' rel="stylesheet" type="text/css"/>
		<link href='<c:url value="/resources/css/lib/bootstrap.min.css" />' rel="stylesheet" type="text/css"/>
		
		<%-- Page specific CSS tags --%>
		<jsp:invoke fragment="css"/>
		
	</head>
	<body>
		<div id="wrap">
			
			<%-- Page specific header section --%>
			<jsp:invoke fragment="header"/>
			
			<div id="body">
				
				<%-- Main contents --%>
				<jsp:doBody/>
			
				<div class="clr"></div>
			</div>
			
			<div id="footer">
				<div class="ftr">
					<a href="#"><spring:message code="form.header.aboutus"/></a>
					<a href="#"><spring:message code="form.header.contact"/></a>
					<a href="#"><spring:message code="form.header.faq"/></a>
					<a href="#"><spring:message code="form.header.privacy"/></a>
				</div>
			</div>
		</div>

		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src='<c:url value="/resources/js/lib/bootstrap.min.js" />'></script>
		
		<%-- Page specific javascript tags --%>
		<jsp:invoke fragment="scripts"/>
	</body>
</html>


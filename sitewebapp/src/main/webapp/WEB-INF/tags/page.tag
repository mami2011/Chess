<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="stylesheet" required="false"%>

<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/bootstrap.min.css"/>"/>
		<c:if test="${!empty stylesheet}">
			<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/"/>${stylesheet}"/>
		</c:if>
	</head>
	<body>
		<div id="wrap">
			<div id="header">
				<div class="hdr">
					<div class="topnav inline">
						<a href="#"><spring:message code="form.header.logo"/></a>
						<a href="#"><spring:message code="form.header.platform"/></a>
						<a href="#"><spring:message code="form.header.tools"/></a>
						<a href="#"><spring:message code="form.header.pricing"/></a>
					</div>
					<div class="ctls">
						<div class="sign-in inline">
							<a href="#"><spring:message code="form.registration.signin"/></a>
						</div>
						<form class="lang inline">
							<span>
							<spring:message code="form.registration.lang"/>
							</span>
							<select>
								<option>English</option>
								<option>português</option>
								<option>español</option>
							</select>
						</form>
					</div>
				</div>
			</div>
			<div id="body">
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

		<script src="<c:url value="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"/>"></script>
		<script src="<c:url value="/resources/js/lib/bootstrap.min.js"/>"></script>
	</body>
</html>


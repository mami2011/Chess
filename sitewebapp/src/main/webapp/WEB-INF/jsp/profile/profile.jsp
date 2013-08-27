<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<t:page title="VendorTool" angularAppName="profileApp">

	<jsp:attribute name="header">
		<t:header email="${account.emailId}" currentPage="profile"/>
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/resources/js/shared/errorUtil.js' />" type="text/javascript"></script>
		<script src="<c:url value='/resources/js/profile/app.js' />" type="text/javascript"></script>
		<script src="<c:url value='/resources/js/profile/controllers.js' />" type="text/javascript"></script>
		<script src="<c:url value='/resources/js/shared/errorResponse.module.js' />" type="text/javascript"></script>
	</jsp:attribute>
	
	<jsp:attribute name="inlineJs">
		<script type="text/javascript">
			profileApp.factory('Data', function() {
				return ${modelMapJson};
			});
		</script>
	</jsp:attribute>

	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/profile.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
	
		<t:layoutTable ngController="ProfileCtrl">
			<jsp:attribute name="leftNav">
				<h3 class="ttl">Profile</h3>
				<div class="list-group">
					<a href="profile" 		ng-class="getClass('/profile')" 	class="list-group-item">Change info</a>
					<a href="#/email"		ng-class="getClass('/email')" 		class="list-group-item">Change email</a>
					<a href="#/password"	ng-class="getClass('/password')"	class="list-group-item">Change password</a>
				</div>
			</jsp:attribute>
			<jsp:attribute name="content">
				<div class="pg-msg">
					<div class="alert alert-success" style="display:none;">Profile information updated.</div>
					<div class="alert alert-danger"  style="display:none;">Sorry, there's been an error.</div>
				</div>
				
				<div ng-view></div>
			</jsp:attribute>
		</t:layoutTable>
		
	</jsp:body>

</t:page>




<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t1" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="t2" tagdir="/WEB-INF/tags/layoutTable" %>
<%@ taglib prefix="t3" tagdir="/WEB-INF/tags/navbarSection" %>


<t1:page title="Uploads" angularAppName="uploadsApp" currentPage="accounthub" email="${email}">

	<jsp:attribute name="css">
		<link href="<c:url value='/wro/uploads.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/wro/uploads.js' />" type="text/javascript"></script>
	</jsp:attribute>

	<jsp:body>
		<t2:layoutTable ngController="UploadsCtrl">
			<jsp:attribute name="leftNav">
				<h3 class="ttl">Uploads</h3>
				<div class="list-group">
					<a href="#/files" 		ng-class="getClass('/accounthub')" 	class="list-group-item">Files</a>
					<a href="#/uploader"	ng-class="getClass('/uploader')" 	class="list-group-item">Upload</a>
					<a href="#/selling"		ng-class="getClass('/selling')" 	class="list-group-item">Orders</a>
					<a href="#/selling"		ng-class="getClass('/selling')" 	class="list-group-item">Selling</a>
					<a href="#/inventory"	ng-class="getClass('/inventory')"	class="list-group-item">Inventory</a>
				</div>
			</jsp:attribute>
			<jsp:attribute name="content">
				<t3:navbarSection current="uploads"/>
				
				<div class="msg">
					<div class="alert alert-success" style="display:none;">Profile information updated.</div>
					<div class="alert alert-danger"  style="display:none;">Sorry, there's been an error.</div>
				</div>
				
				<div ng-view></div>
			</jsp:attribute>
		</t2:layoutTable>
	
	</jsp:body>
</t1:page>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>




<t:page title="Account hub">
	
	<jsp:attribute name="header">
		<t:header email="${email}" currentPage="accounthub"/>
	</jsp:attribute>
	
	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/accounthub.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
	
		<t:layoutTable ngController="AcctHubCtrl">
			<jsp:attribute name="leftNav">
				<h3 class="ttl">Summary</h3>
				<div class="list-group">
					<a href="${accountHubUrl}" 	ng-class="getClass('/accounthub')" 	class="list-group-item">Overview</a>
					<a href="#/selling"		ng-class="getClass('/selling')" 	class="list-group-item">Selling</a>
					<a href="#/selling"		ng-class="getClass('/selling')" 	class="list-group-item">Orders</a>
					<a href="#/selling"		ng-class="getClass('/selling')" 	class="list-group-item">Selling</a>
					<a href="#/inventory"	ng-class="getClass('/inventory')"	class="list-group-item">Inventory</a>
				</div>
			</jsp:attribute>
			<jsp:attribute name="content">
				<t:navbarSection current="summary"/>
				
				<div class="msg">
					<div class="alert alert-success" style="display:none;">Profile information updated.</div>
					<div class="alert alert-danger"  style="display:none;">Sorry, there's been an error.</div>
				</div>
				
				<div ng-view></div>
			</jsp:attribute>
		</t:layoutTable>
	
	</jsp:body>
</t:page>

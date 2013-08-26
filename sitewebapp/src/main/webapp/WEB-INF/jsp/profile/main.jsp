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
		<table ng-controller="ProfileCtrl" class="main acct contact input-group bx-rnd-shdw" cellpadding="0" cellspacing="0">
			<tr>
				<td class="c1">
					<h3 class="ttl">Profile</h3>
					<div class="list-group">
						<a href="profile" 			ng-class="getClass('/profile')" 		class="list-group-item">Change info</a>
						<a href="#/email/:edit"		ng-class="getClass('/email/:edit')" 	class="list-group-item">Change email</a>
						<a href="#/password/:edit"	ng-class="getClass('/password/:edit')"	class="list-group-item">Change password</a>
					</div>
				</td>
				<td class="c2">
					 
					<div class="msg">
						<div class="alert alert-success" style="display:none;">Profile information updated.</div>
						<div class="alert alert-danger"  style="display:none;">Sorry, there's been an error.</div>
					</div>
					
					<div ng-view class="info-wrp">
				
	
			
				
				<%-- 
				<!--===================================
				Edit profile
				======================================= -->
				<form method="post" id="profile-form">
					<table border="0" id="edit-info" class="info edit input-group" cellspacing="0" cellpadding="0">
						<c:forEach var="entry" items="${labels}">
							<tr>
								<td class="ng-class:{'err': field.hasError}; col2">
									<label>${entry.value}:</label>
								</td>
								<td class="col2">
									<input ng-model="fieldMap['${entry.key}'].value" name="${entry.key}" class="form-control" />
									<div class="err-msg">
										<span ng-repeat="msg in fieldMap['${entry.key}'].errorMessages">
											{{msg}}<br/>
										</span>
									</div>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td>
							</td>
							<td class="col2">
								<input ng-click="saveProfile()" type="submit" class="btn lg" value="Submit"/>
							</td>
						</tr>
					</table>
				</form>
				
				<!--===================================
				Edit email
				======================================= -->
				<table border="0" id="edit-email" class="info edit input-group" cellspacing="0" cellpadding="0">
					<tr>
						<td class="col1">
							<label>${profile.email.label}:</label>
						</td>
						<td class="col2">
							<input class="form-control" name="${profile.email.name}" value=""/>
						</td>
					</tr>
					<tr>
						<td class="col1">
							<label>Re-enter ${profile.email.label}:</label>
						</td>
						<td class="col2">
							<input class="form-control" name="${profile.email.name}" value=""/>
						</td>
					</tr>
					<tr>
						<td class="col1">
							<label>${profile.password.label}:</label>
						</td>
						<td class="col2">
							<input class="form-control" name="${profile.password.name}" value=""/>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td class="col2">
							<input type="submit" class="btn lg" value="Submit"/>
						</td>
					</tr>
				</table>
				
				
				--%>
				</div><!-- end of class="info-wrp" -->
			  </td>
			</tr>
		</table><!-- end of ng-controller="ProfileCtrl" -->
		

	</jsp:body>

</t:page>




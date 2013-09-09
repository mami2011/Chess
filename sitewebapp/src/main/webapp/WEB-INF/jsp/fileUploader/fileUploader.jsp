<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>



<t:popup title="File uploader" angularAppName="fileUploaderApp">
	
	<jsp:attribute name="css">
		<link href="<c:url value='/wro/fileUploader.css' />" rel="stylesheet" type="text/css" />
		
		<%--
		<link href="<c:url value='/resources/css/sharedNgModules/fileUploaderModule.css' />" rel="stylesheet" type="text/css" />
		 --%>
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/wro/fileUploader.js' />" type="text/javascript"></script>
		
		<%--
		<script src="<c:url value='/resources/js/sharedNgModules/fileUploaderModule.js' />" type="text/javascript"></script>  
		--%>
	</jsp:attribute>

	<jsp:body>
		<div ngController="FileUploaderCtrl">
			
			<div file-uploader upload-url="uploadFile" all-done-url="x"></div>
		</div>
	</jsp:body>
</t:popup>

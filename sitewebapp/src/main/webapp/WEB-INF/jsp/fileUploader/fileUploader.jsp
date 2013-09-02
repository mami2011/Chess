<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>



<t:popup title="File uploader" angularAppName="fileUploaderApp">
	
	<jsp:attribute name="scripts">
		<script src="<c:url value='/resources/js/fileUploader/app.js' />" type="text/javascript"></script>
		<script src="<c:url value='/resources/js/fileUploader/controllers.js' />" type="text/javascript"></script>
		
		<script src="<c:url value='/resources/js/ngModules/fileUploaderModule.js' />" type="text/javascript"></script>  
	</jsp:attribute>

	<jsp:attribute name="css">
		<link href="<c:url value='/resources/css/ngModules/fileUploaderModule.css' />" rel="stylesheet" type="text/css" />
	</jsp:attribute>
	
	<jsp:body>
		<div ngController="FileUploaderCtrl">
			
			<div file-uploader upload-url="/comps/upload" all-done-url="x"></div>
		</div>
	</jsp:body>
</t:popup>

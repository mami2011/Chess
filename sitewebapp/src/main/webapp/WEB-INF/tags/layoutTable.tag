<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--============
Page fragments
================--%>
<%@ attribute name="leftNav"	fragment="true"%>
<%@ attribute name="content"	fragment="true"%>

<%--============
Attributes
================ --%>
<%@ attribute name="ngController" required="false"%>


<table class="main input-group" ng-controller="${ngController}" cellpadding="0" cellspacing="0">
	<tr>
		<td class="c1">
			<jsp:invoke fragment="leftNav"/>
		</td>
		<td class="c2"> 
			<jsp:invoke fragment="content"/>
			
			<div class="cell-pad">oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo</div>
	  </td>
	</tr>
</table><!-- end of ng-controller="ProfileCtrl" -->
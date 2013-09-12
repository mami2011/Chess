<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--============
Page fragments
================--%>
<%@ attribute name="leftNav"	fragment="true"%>
<%@ attribute name="content"	fragment="true"%>

<%--============
Attributes
================ --%>
<%@ attribute name="angularController" required="false"%>


<table class="layout input-group" ng-controller="${angularController}" cellpadding="0" cellspacing="0">
	<tr>
		<td class="c1">
			<jsp:invoke fragment="leftNav"/>
		</td>
		<td class="c2"> 
			<jsp:invoke fragment="content"/>
			
			<div class="cell-pad">
				<!-- Dummy content to push out table. Not seen by user. -->
				oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo oooooooo
			</div>
	  </td>
	</tr>
</table>
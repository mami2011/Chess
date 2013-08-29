<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--============
Attributes
================--%>
<%@ attribute name="current" required="true"%>

<c:set var="curr1" value="${current == 'summary' ? 'active' : ''}"/>
<c:set var="curr2" value="${current == 'uploads' ? 'active' : ''}"/>
<c:set var="curr3" value="${current == 'orders' ? 'active' : ''}"/>
<c:set var="curr4" value="${current == 'reports' ? 'active' : ''}"/>
<c:set var="curr5" value="${current == 'faq' ? 'active' : ''}"/>
<c:set var="curr6" value="${current == 'subscription' ? 'active' : ''}"/>
<c:set var="curr7" value="${current == 'role' ? 'active' : ''}"/>

<div class="sec navbar navbar-default" role="navigation">
	<ul class="nav navbar-nav">
		<li class="${curr1}"><a href="summary">Summary</a></li>
		<li class="${curr2}"><a href="uploads">Uploads</a></li>
		<li class="${curr3}"><a href="orders">Orders</a></li>
		<li class="${curr4}"><a href="reports">Reports</a></li>
		<li class="${curr5}"><a href="faq">FAQ</a></li>
		<li class="${curr6}"><a href="subscription">Subscription</a></li>
		<li class="${curr7}"><a href="roles">Role Management</a></li>
	</ul>
</div>

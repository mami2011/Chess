<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--============
Attributes
================--%>
<%@ attribute name="email"			required="false"%>
<%@ attribute name="currentPage"	required="false"%>

<div id="header">
	<div class="hdr">

		<div class="topnav inline">
			<a href="home"><spring:message code="form.header.logo"/></a>
			<a href="accounthub" class="curr">Account Hub</a>
			<a href="#">Inventory</a>
			<a href="#">Selling</a>
			<%-- 
			<a href="#"><spring:message code="form.header.platform"/></a>
			<a href="#"><spring:message code="form.header.tools"/></a>
			<a href="#"><spring:message code="form.header.pricing"/></a>--%>
		</div>
		<div class="ctls">
			
			<c:choose>
				<c:when test="${empty email}">
					<div class="sign-in inline">
					
						<%--=================
						Sign In 
						=====================--%>
						<c:choose>
							<c:when test="${currentPage == 'signin'}">
								<spring:message code="form.signin.signin"/>
							</c:when>
							<c:otherwise>
								<a href="signin"><spring:message code="form.signin.signin"/></a>
							</c:otherwise>
						</c:choose>
						|
						
						<%--=================
						Sign Up
						=====================--%>
						<c:choose>
							<c:when test="${currentPage == 'register'}">
								<spring:message code="form.registration.signup"/>
							</c:when>
							<c:otherwise>
								<a href="register"><spring:message code="form.registration.signup"/></a>
							</c:otherwise>
						</c:choose>
					</div>
				</c:when>
				<c:otherwise>
					<%--=================
					User Menu
					=====================--%>
					<div class="user inline">
						<a id="profileBtn" href="javascript:;">${email} <b class="arw"></b></a>
						
						<ul id="profileMenu" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
						  <li><a tabindex="-1" href="profile">Profile</a></li>
						  <li class="divider"></li>
						  <li><a tabindex="-1" href="<c:url value="j_spring_security_logout" />">Sign-out</a></li>
						</ul>
					</div>
					<%--=================
					Search Box
					=====================--%>
					<form class="srch inline">
						<input/>
						<button title="Search"></button>
					</form>
				</c:otherwise>
			</c:choose>
			
			<%--=================
			Language Menu
			=====================--%>
			<c:if test="${empty email && !empty langOptions}">
				<div class="lang inline">
					<c:forEach var="entry" items="${langOptions}">
						<c:if test="${entry.val == selectedLang}"><c:set var="selectedLangText" value="${entry.txt}"/></c:if>
					</c:forEach>
					<a id="langBtn" href="javascript:;"><span class="lbl"><spring:message code="form.registration.lang"/>:</span> ${selectedLangText} <b class="arw"></b></a>
					
					<ul id="languageMenu" name="lang" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
						<c:forEach var="entry" items="${langOptions}">
							<c:set var="selected" value="${entry.val == selectedLang ? 'selected' : ''}"/>
							<li><a tabindex="-1" href="?lang=${entry.val}">${entry.txt}</a></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			
		</div>
	</div>
</div>


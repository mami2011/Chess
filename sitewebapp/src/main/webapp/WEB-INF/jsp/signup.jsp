<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page stylesheet="signup.css">
	
	<c:set var="email" value="${fields['email']}"/>
	<c:set var="password" value="${fields['password']}"/>
	<c:set var="passwordConf" value="${fields['passwordConf']}"/>
			
	<div class="su main input-group bx-rnd-shdw">
		<h3 class="ttl">Sign up</h3>
		
		<c:if test="${email.hasError || password.hasError || passwordConf.hasError}">
			<div class="alert alert-danger">
				There were problems signing you up.
			</div>
		</c:if>

		<form method="post" action="/listing-tool/signup/save">

			<div class="${email.hasError ? 'err' : ''}">
				<input class="form-control" placeholder="Email" name="email" type="email" value="${email.value}"/>
				<div class="err-msg">
					<c:forEach var="item" items="${email.errorMessages}">
						${item}<br/>
					</c:forEach>
				</div>
			</div>
			<div class="${password.hasError ? 'err' : ''}">
				<input class="form-control" placeholder="Password" type="password" name="password"/>
				<div class="err-msg">
					<c:forEach var="item" items="${password.errorMessages}">
						${item}<br/>
					</c:forEach>
				</div>
			</div>
			<div class="${passwordConf.hasError ? 'err' : ''}">
				<input class="form-control" placeholder="Confirm password" type="password" name="passwordConf"/>
				<div class="err-msg">
					<c:forEach var="item" items="${passwordConf.errorMessages}">
						${item}<br/>
					</c:forEach>
				</div>
			</div>
			<div class="submit">
				<input type="submit"class="btn lg" value="Submit"/>
			</div>
		</form>
	</div>

</t:page>
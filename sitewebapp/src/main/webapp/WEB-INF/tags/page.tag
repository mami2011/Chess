<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="stylesheet" required="false"%>

<!doctype html>
<html>
	<head>

		<link rel="stylesheet" type="text/css" href="/resources/css/main.css"/>
		<link rel="stylesheet" type="text/css" href="/resources/css/lib/bootstrap.min.css"/>
		<c:if test="${!empty stylesheet}">
			<link rel="stylesheet" type="text/css" href="/resources/css/${stylesheet}"/>
		</c:if>
	</head>
	<body>
		<div id="wrap">
			<div id="header">
				<div class="hdr">
					<div class="topnav inline">
						<a href="#">Logo</a>
						<a href="#">Platform</a>
						<a href="#">Tools</a>
						<a href="#">Pricing</a>
					</div>
					<div class="ctls">
						<div class="sign-in inline">
							<a href="#">Sign In</a>
						</div>
						<form class="lang inline">
							<span>
								Language
							</span>
							<select>
								<option>English</option>
								<option>Portuguese</option>
								<option>Spanish</option>
							</select>
						</form>
					</div>
				</div>
			</div>
			<div id="body">
				<jsp:doBody/>
				<div class="clr"></div>
			</div>
			<div id="footer">
				<div class="ftr">
					<a href="#">About us</a>
					<a href="#">Contact</a>
					<a href="#">FAQ</a>
					<a href="#">Privacy</a>
				</div>
			</div>
		</div>
		<script src="/resources/js/lib/jquery-1.10.2.min.js"></script>
		<script src="/resources/js/lib/bootstrap.min.js"></script>
	</body>
</html>


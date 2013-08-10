<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->

<c:url value="favicon.ico" var="favurl" />
<c:url value="apple-touch-icon.png" var="appletouchurl" />
<c:url value="/resources/css/register.css" var="registercssurl" />
<c:url value="/resources/css/bootstrap.css" var="bootstrapcssurl" />
<c:url value="/resources/css/theme.css" var="themecssurl" />
<c:url value="/resources/img/logo.png" var="logoimgurl" />
<c:url value="/resources/js/bootstrap.min.js" var="bootstrapminjsurl" />
<c:url value="/resources/js/bootstrap.js" var="bootstrapjsurl" />
<c:url value="/resources/js/theme.js" var="themejsurl" />
<c:url value="/signin" var="signinurl" />
<c:url value="/register" var="registerurl" />
<c:url value="/home" var="homeurl" />

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Registration</title>
    <meta name="description" content="Welcome to vendertool registration">
    <meta name="viewport" content="width=device-width">

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="icon" type="image/png" href="${favurl}">
    <link rel="apple-touch-icon" href="${appletouchurl}" />

	<link rel="stylesheet" type='text/css' href="${bootstrapcssurl}" >
    <link rel="stylesheet" type="text/css" href="${themecssurl}">
    <link rel="stylesheet" type="text/css" href="${registercssurl}">
    <link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic'>
</head>
<body>

	<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
    		<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
          	</a>
          	<a class="brand" href="${homeurl}">
                <img src="${logoimgurl}" alt="logo" />
            </a>
		  	<div class="nav-collapse collapse">
		  	<!--
                <ul class="nav pull-right">
                    <li>
                        <a class="btn-header" href="${registerurl}">Sign up</a>
                    </li>
                    <li><a class="btn-header" href="${signinurl}">Sign in</a></li>
                </ul>
                -->
            </div>
        </div>
      </div>
    </div>

    <div id="box_sign">
        <div class="container">
            <div class="span12 box_wrapper">
                <div class="span12 box">
                    <div>
                        <div class="head">
                            <h4><b>Register</b></h4>
                            <h5>It&#39;s free and always will be.</h5>
                        </div>
                        <div class="form">
                           <!--  <form:form commandName="account" method="POST" action="/register"> --> 
                            	<!-- <label for="firstName">First Name: </label> -->
                            	<!-- <form:input path="firstName" id="firstName" placeholder="First Name"/> -->
                                <input type="text" placeholder="First Name" required pattern="[a-zA-Z]{2,}" />
                                <input type="text" placeholder="Last Name" required pattern="[a-zA-Z]{2,}"/>
                                <input type="text" placeholder="Email" required pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
                                <input type="password" placeholder="Password" required pattern="[a-zA-Z][a-zA-Z0-9]{5,}"/>
                                <input type="password" placeholder="Confirm Password" required pattern="[a-zA-Z][a-zA-Z0-9]{5,}"/>
                                <input type="submit" class="btn" value="Sign up"/>&nbsp;&nbsp;&nbsp;
                                <input type="submit" class="btn" value="Cancel"/>
                            <!-- </form:form> --> 
                        </div>
                    </div>
                </div>
                <p class="already">Already have an account? 
                    <a href="${signinurl}">Sign in</a></p>
            </div>
        </div>
    </div>

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${bootstrapminjsurl}"></script>
    <script src="${themejsurl}"></script>
    
</body>
</html>
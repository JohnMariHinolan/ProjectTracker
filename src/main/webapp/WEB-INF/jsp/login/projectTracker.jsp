<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/resources/static/css/login.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
<body>
<script src="/javascript/login.js"></script>
<div class="login-page">
  <div class="form">
   	<h2>Please Login: ${loginMessage}</h2>
   
    <form class="login-form" action="userLogin" method = "POST">
      <input type="text" name="username" placeholder="username"/>
      <input type="password" name="password" placeholder="password"/>
      <input type="submit" value = "Login"/>
      
       </form>
   <!--  
   
    <form class="register-form">
      <input type="text" placeholder="name"/>
      <input type="password" placeholder="password"/>
      <input type="text" placeholder="email address"/>
      <input type="submit" value ="register">Rgister</input>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form> 
      <p class="message">Not registered? <a href="#">Create an account</a></p>
      -->
   
  </div>
</div>
</body>
</html>
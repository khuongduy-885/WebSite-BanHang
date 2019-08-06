<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="common/taglibheader.jsp"/>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
	<fmt:setBundle basename="ApplicationResources" var="lang"/> 
	<c:url var="formlogin" value="/login" />
</head>
<body id="body-login">
	<div id="body-flex-login">
		<dir id="container-login">
			<dir id="container-login-left">
				<dir class="header-login">
					<span style="font-size: 48px"> Welecome</span><br/>
				</dir>
					
				<dir id="food-login">
				</dir>
			</dir >
			
			<dir id="container-login-right">
				<dir id="header-login-right">
					<span class="actived"> <fmt:message key="label.login" bundle="${lang}"/> /</span><a href='<c:url value="/signin"/>'><span><fmt:message key="label.signin" bundle="${lang}"/> </span></a>
					</dir>
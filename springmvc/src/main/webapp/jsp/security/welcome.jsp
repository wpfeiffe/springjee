<!DOCTYPE html>
<%--
  welcome security page using Spring Security
  User: wpfeiffe
  Date: 11/17/12

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="bpcs" uri="http://test.bpcs.com/bpcs-taglib" %>

<html lang="en">
<head>
    <base href="<c:url value="/"/>" target="_self"/>
    <title>Login</title>
    <link href="css/bootstrap.css" rel="stylesheet">

    <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
    <h3>${msg}</h3>
    <h3>Username : ${user}</h3>
    <a href="<c:url value="/j_spring_security_logout" />" > Logoff</a>
</body>

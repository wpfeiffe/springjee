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
    <title>Welcome</title>
</head>
<body class="container" style="margin-top: 10px">
    <h3>${msg}</h3>
    <h3>Username : ${user}</h3>
    <a href="<c:url value="/j_spring_security_logout" />" > Logoff</a>
</body>

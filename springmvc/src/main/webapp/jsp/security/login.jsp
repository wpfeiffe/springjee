<!DOCTYPE html>
<%--
  Login page using Spring Security
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
    <h1>Log In</h1>
    <c:if test="${not empty error}">
        <div class="alert alert-error">
            Error logging in: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>

    <%--<form class="form-horizontal" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>--%>
    <form class="form-horizontal" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
        <div class="control-group">
            <label class="control-label" for="j_username">Username</label>

            <div class="controls">
                <input type="text" name="j_username" id="j_username" placeholder="Username">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="j_password">Password</label>

            <div class="controls">
                <input type="password" name="j_password" id="j_password" placeholder="Password">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" name="Login" class="btn">Log In</button>
            </div>
        </div>

    </form>
</body>
</html>
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
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
      }

      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }

      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
</head>
<body>
    <div class="container">

    <%--<form class="form-horizontal" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>--%>
    <form class="form-signin" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
        <h2 class="form-signin-heading">Log In</h2>
        <c:if test="${not empty error}">
            <div class="alert alert-error">
                Error logging in: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <input type="text" class="input-block-level" name="j_username" id="j_username" placeholder="Username">
        <input type="password" class="input-block-level" name="j_password" id="j_password" placeholder="Password">
        <button type="submit" name="Login" class="btn btn-large btn-primary">Log In</button>
    </form>
    </div>
</body>
</html>
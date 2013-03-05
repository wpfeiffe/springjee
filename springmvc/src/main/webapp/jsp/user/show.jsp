<!DOCTYPE html>
<%--
  Show the user data
  User: wpfeiffe
  Date: 2/6/13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Show User: ${user.login}</title>
</head>
<body>
<h2>Show User: ${user.login}</h2>
<div class="well">
  <form id="user_form">
    <label>User Id</label>
    <input type="text" value="${user.id}" class="input-xlarge">
    <label>Login</label>
    <input type="text" value="${user.login}" class="input-xlarge">
    <label>Roles</label>
    <input type="text" value="${user.roles}" class="input-xlarge">
    <label>Locked?</label>
    <input type="text" value="${user.acctLocked}" class="input-xlarge">
    <label>Enabled?</label>
    <input type="text" value="${user.acctEnabled}" class="input-xlarge">
    <label>Exp Date</label>
    <input type="text" value="<fmt:formatDate type="date" value="${user.acctExpireDate}" />" class="input-xlarge">
    <label>PW Exp Date</label>
    <input type="text" value="<fmt:formatDate type="date" value="${user.credExpireDate}" />" class="input-xlarge">
    <div>
      <button class="btn btn-primary">Update</button>
    </div>
  </form>
</div>
</body>
</html>
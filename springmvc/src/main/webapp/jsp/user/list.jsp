<!DOCTYPE html>

<%--
  Page will show user list in a datatable
  User: wpfeiffe
  Date: 9/8/12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="bpcs" uri="http://test.bpcs.com/bpcs-taglib" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
  <title>Users</title>

  <link href="css/DT_Bootstrap.css" rel="stylesheet">

  <script type="text/javascript" src="js/jquery.dataTables.js"></script>
  <script type="text/javascript" src="js/DT_Bootstrap.js"></script>
</head>
<body>
<div class="container" style="margin-top: 10px">
<h2>List Users</h2>
  <!-- Table of users -->
  <%--<table class="table table-striped table-bordered table-condensed">--%>
<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="userlist">
    <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Roles</th>
            <th>Locked?</th>
            <th>Enabled?</th>
            <th>Expire Date</th>
            <th>PW Expire Date</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.roles}</td>
                <td>${user.acctLocked}</td>
                <td>${user.acctEnabled}</td>
                <td><fmt:formatDate type="date" value="${user.acctExpireDate}" /></td>
                <td><fmt:formatDate type="date" value="${user.credExpireDate}" /></td>
                <td>
                  <a href="show.htm?userId=${user.id}"><i class="icon-pencil"></i></a>
                  <a href=""><i class="icon-remove"></i></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<div class="alert alert-info">${users.size()} user records found</div>
</body>
</html>
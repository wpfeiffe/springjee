<!DOCTYPE html>

<%--
  Page will show employee list in a datatable
  User: wpfeiffe
  Date: 9/8/12
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="bpcs" uri="http://test.bpcs.com/bpcs-taglib" %>

<html lang="en">
<head>
  <title>Show Employee List</title>

  <link href="css/DT_Bootstrap.css" rel="stylesheet">

  <script type="text/javascript" src="js/jquery.dataTables.js"></script>
  <script type="text/javascript" src="js/DT_Bootstrap.js"></script>
</head>
<body>
<div class="container" style="margin-top: 10px">

  <!-- Table of employees -->
  <%--<table class="table table-striped table-bordered table-condensed">--%>
<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
    <thead>
        <tr>
            <th>First</th>
            <th>Last</th>
            <th>SSN</th>
            <th>Title</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <th>${emp.firstName}</th>
                <th>${emp.lastName}</th>
                <th>${emp.ssn}</th>
                <th>${emp.title}</th>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<div class="alert alert-success"><bpcs:testel testAttribute="${message}"/></div>
</body>
</html>
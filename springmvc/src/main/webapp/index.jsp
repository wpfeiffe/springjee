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
    <title>Spring JEE Jboss 7</title>

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/DT_Bootstrap.css" rel="stylesheet">

    <script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.js"></script>
    <%--<script type="text/javascript" src="js/bootstrap.js"></script>--%>
    <script type="text/javascript" src="js/DT_Bootstrap.js"></script>
    <style>
        body {
            padding-top: 60px; /* When using the navbar-top-fixed */
        }
    </style>
</head>
<body >
<div class="container" style="margin-top: 10px">
    <!-- Navbar -->
    <div id="mainnav" class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <div class="nav-collapse">
                    <ul class="nav nav-pills">
                        <li class="active"><a href="./listemp.htm">Home</a></li>
                        <li class=""><a href="./addemp.htm">Add Emp</a></li>
                        <li class=""><a href="./listemp.htm">List</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


</div>
</body>
</html>
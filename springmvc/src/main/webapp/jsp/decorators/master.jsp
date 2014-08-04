<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>SpringJeeHelloWorld - <decorator:title /></title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <style>
      body {
        padding-top: 60px; /* When using the navbar-top-fixed */
      }
    </style>
    <decorator:head/>
  </head>
  <body class="container" style="margin-top: 10px">
  <div id="mainnav" class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
        <div class="nav-collapse">
          <ul class="nav nav-pills">
            <li id="li_home" class="active"><a href="/">Home</a></li>
            <li id="li_add" class=""><a href="./addemp.htm">Add Emp</a></li>
            <li id="li_list" class=""><a href="./listemp.htm">List</a></li>
            <li id="li_bcrypt" class=""><a href="./bcrypt.htm">BCrypt</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <decorator:body />
  </body>
</html>





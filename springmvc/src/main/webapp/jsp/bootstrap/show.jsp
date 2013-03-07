<!DOCTYPE html>
<%--
  Bootstrap "show" page used to experiment with bootstrap
  User: wpfeiffe
  Date: 2/4/13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <title>Bootstrap Show</title>
  <base href="<c:url value="/"/>" target="_self"/>
  <script type="text/javascript">
    jQuery(function($)
    {

    });
  </script>
</head>
<body>
Show = ${hello}
</body>
</html>
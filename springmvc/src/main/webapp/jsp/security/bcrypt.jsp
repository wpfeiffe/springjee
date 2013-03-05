<!DOCTYPE html>
<%--
  page shows bcrypt values for given text
  User: wpfeiffe
  Date: 01/31/13

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="bpcs" uri="http://test.bpcs.com/bpcs-taglib" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
  <base href="<c:url value="/"/>" target="_self"/>
  <title>Bcrypt</title>
</head>
<body>
    <h1>Bcrypt</h1>
    <c:if test="${not empty encoded_text}">
        <div class="alert alert-info">
            The encoded text is: <b>${encoded_text}</b>
        </div>
    </c:if>

    <%--<form class="form-horizontal" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>--%>
    <form class="form-horizontal" name="enc_form" method="POST" action="">
        <div class="control-group">
            <label class="control-label" for="encode_text">Text</label>

            <div class="controls">
                <input type="text" name="encode_text" id="encode_text" placeholder="Text to encode">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" name="encode_btn" class="btn">Encode the text</button>
            </div>
        </div>

    </form>
</body>
</html>
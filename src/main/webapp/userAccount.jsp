<%--
  Created by IntelliJ IDEA.
  User: prasad
  Date: 2022-06-06
  Time: 07.29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User-Account</title>
</head>
<body>
<c:forEach var="customer" items="${customerDetails}">
    ID: ${customer.id} <br>
    Name:${customer.name} <br>
    Email:${customer.email}<br>
    Phone:${customer.phone}<br>
    UserName:${customer.userName}<br>
    Password:${customer.password}<br>
</c:forEach>
</body>
</html>
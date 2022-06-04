<%--
  Created by IntelliJ IDEA.
  User: prasad
  Date: 2022-06-04
  Time: 17.29
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
    ${customer.id}
    ${customer.name}
    ${customer.email}
    ${customer.phone}
    ${customer.userName}
    ${customer.password}
</c:forEach>
</body>
</html>

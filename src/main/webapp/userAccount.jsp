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
<table>
    <c:forEach var="customer" items="${customerDetails}">

        <c:set var="id" value="${customer.id}"/>
        <c:set var="name" value="${customer.name}"/>
        <c:set var="email" value="${customer.email}"/>
        <c:set var="phone" value="${customer.phone}"/>
        <c:set var="username" value="${customer.userName}"/>
        <c:set var="password" value="${customer.password}"/>
        <tr>
            ID: ${customer.id} <br>
        </tr>
        <tr>
            Name:${customer.name} <br>
        </tr>
        <tr>
            Email:${customer.email}<br>
        </tr>
        <tr>
            Phone:${customer.phone}<br>
        </tr>
        <tr>
            UserName:${customer.userName}<br>
        </tr>
        <tr>
            Password:${customer.password}<br>
        </tr>
    </c:forEach>
</table>

<c:url value="updateUser.jsp" var="updateUser">
    <c:param name="id" value="${id}"/>
    <c:param name="name" value="${name}"/>
    <c:param name="email" value="${email}"/>
    <c:param name="phone" value="${phone}"/>
    <c:param name="username" value="${username}"/>
    <c:param name="password" value="${password}"/>
</c:url>

<a href="${updateUser}">
    <input type="button" name="update" value="Update My Data">
</a>
<br>
<c:url value="deleteUser.jsp" var="deleteUser">
    <c:param name="id" value="${id}"/>
    <c:param name="name" value="${name}"/>
    <c:param name="email" value="${email}"/>
    <c:param name="phone" value="${phone}"/>
    <c:param name="username" value="${username}"/>
    <c:param name="password" value="${password}"/>
</c:url>
<a href="${deleteUser}">
<input type="button" name="delete" value="Delete My Account">
</a>
</body>
</html>
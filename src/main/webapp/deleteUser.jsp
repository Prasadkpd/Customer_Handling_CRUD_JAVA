<%--
  Created by IntelliJ IDEA.
  User: prasad
  Date: 2022-06-19
  Time: 13.57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
%>
<h1>Delete User Account</h1>
<form action="delete" method="post">
    User ID <input type="text" name="uid" value="<%= id %>" readonly> <br>
    Name <input type="text" name="name" value="<%= name %>" readonly> <br>
    Email <input type="email" name="email" value="<%= email %>" readonly> <br>
    Phone Number <input type="text" name="phone" value="<%= phone %>" readonly> <br>
    User Name <input type="text" name="uname" value="<%= username %>" readonly> <br>
    Password <input type="text" name="pass" value="<%= password %>" readonly> <br><br>

    <input type="submit" name="submit" value="Delete User">
</form>

</body>
</html>

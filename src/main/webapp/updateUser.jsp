<%--
  Created by IntelliJ IDEA.
  User: prasad
  Date: 2022-06-06
  Time: 09.41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
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
<form action="update" method="post">
 User ID <input type="text" name="uid" value="<%= id %>" readonly> <br>
 Name <input type="text" name="name" value="<%= name %>"> <br>
 Email <input type="email" name="email" value="<%= email %>"> <br>
 Phone Number <input type="text" name="phone" value="<%= phone %>"> <br>
 User Name <input type="text" name="uname" value="<%= username %>"> <br>
 Password <input type="text" name="pass" value="<%= password %>"> <br><br>

 <input type="submit" name="submit" value="Update User">
</form>
</body>
</html>

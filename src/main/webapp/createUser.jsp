<%--
  Created by IntelliJ IDEA.
  User: prasad
  Date: 2022-06-06
  Time: 08.28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<form action="create" method="post">
    Name <input type="text" name="name"> <br>
    Email <input type="email" name="email"> <br>
    Phone Number <input type="text" name="phone"> <br>
    User Name <input type="text" name="uid"> <br>
    Password <input type="password" name="pass"> <br>

    <input type="submit" name="submit" value="Create User">
</form>

</body>
</html>

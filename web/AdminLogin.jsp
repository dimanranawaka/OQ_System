<%--
  Created by IntelliJ IDEA.
  User: MALIDHUWA KV
  Date: 8/5/2023
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
  <link href="bootstrap.min.css" rel="stylesheet" type="text/css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <meta charset="ISO-8859-1">
</head>
<style type="text/css">

  li{
    float: left;
  }
  ul{
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #1a1a1a;
  }
  li a
  {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }
  li a:HOVER {
    background-color: aqua;
  }

</style>
<body>
<font color="blue"><center><h1>Admin Login</h1></center></font>
<font color="red">
  <%
    if (request.getParameter("msg")!= null)
      out.println(request.getParameter("msg"));
  %>
</font>
<font color="green">
  <%
    if (request.getParameter("msg1")!=null)
      out.println(request.getParameter("msg1"));
  %>
</font>
<form action="adminValidator" method="post">
        <pre>
            User ID  : <input type="text" name="uName"> <br>
            Password : <input type="password" name="uPassword"> <br>
            <input onclick="location.href='index.html'" type="button" value="Exit" class="btn btn-outline-primary"> <input type="submit" value="Login" class="btn btn-outline-primary">
        </pre>
</form>
</body>
</html>

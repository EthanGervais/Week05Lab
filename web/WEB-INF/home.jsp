<%-- 
    Document   : home
    Created on : 11-Oct-2020, 7:45:49 PM
    Author     : ethan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome home!</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${username}</h3>
        <form action="logout" method="get">
            <a href="login?logout">Log out</a>
        </form>
    </body>
</html>

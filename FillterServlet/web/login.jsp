<%-- 
    Document   : login
    Created on : Nov 6, 2023, 2:29:51 AM
    Author     : THINKPAD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            User: <input type="text" name="user" value="" />
            Pass: <input type="password" name="pass" value="" />
            <input type="submit" value="Login" />
        </form>
    </body>
</html>

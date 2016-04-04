<%-- 
    Document   : Login
    Created on : Mar 20, 2012, 4:56:26 PM
    Author     : LS5002117
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form name="loginForm" action="LoginAction.action" method="post">
            <table>
                <tr>
                    <td> User Name:</td>
                    <td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td> Password </td>
                    <td> <input type="password" name="password"> </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="Login">
                        <input type="reset" name="Cancel">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

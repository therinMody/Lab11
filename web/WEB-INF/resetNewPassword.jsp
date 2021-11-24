<%-- 
    Document   : resetNewPassword
    Created on : Nov 23, 2021, 2:44:17 PM
    Author     : 821320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter a new password</title>
    </head>
    <body>
        <h1>Enter a new password</h1>

        <form method="POST" action="reset">
            <p><input type="password" name="newPassword" required></p>
            
            <button type="submit" value="Submit">Submit</button>
            <input type="hidden" value="new" name="action">
            <input type="hidden" value="${uuidHolder}" name="uuid">
        </form>
    </body>
</html>

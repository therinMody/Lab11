<%-- 
    Document   : reset
    Created on : Nov 23, 2021, 1:52:32 PM
    Author     : 821320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <br>
        <p>Please enter your email address to reset your password</p>
        <form method="POST" action="reset">
            <p>Email Address: <input type="text" name="confirmEmail" required></p>
            <button type="submit" value="Submit">Submit</button>
            <input type="hidden" value="email" name="action">
        </form>
        
    </body>
</html>

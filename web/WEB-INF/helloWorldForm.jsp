<%-- 
    Document   : helloWorldForm
    Created on : 6-Mar-2023, 11:22:17 AM
    Author     : lynnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <!--submit to the url action hello-->
        <form method="POST" action="hello">
        <!-- ADD value that what they have typed in -->
            First name: <input type="text" name="firstname" value="${firstname}"><br>
            Last name: <input type="text" name="lastname" value="${lastname}"><br>
            <input type ="submit" value="submit">
        </form>
    </body>
</html>

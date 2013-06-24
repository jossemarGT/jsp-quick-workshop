<%-- 
    Document   : index
    Created on : Jun 23, 2013, 9:26:57 PM
    Author     : jossemarGT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="author" content="jossemarGT">
        <title>Quick Workshop</title>
        <!-- This css is part of the "Twitter bootstrap" if you mind to use the
        same styles, it's a nice idea to check its own documentation at
        http://twitter.github.io/bootstrap/ -->
        
        <!-- Also you can download a custom theme of twitter bootstrap at 
        http://bootswatch.com/#gallery -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
    </head>
    <body>

        <div id="intro" class="app-section container active">
                <h1>Welecome</h1>
                <p>Sign in</p>
                <%
                  if ( request.getParameter("error") != null ){
                      out.println("<p style='background-color:orange;color:red;'>Usuario o contraseña erronea.</p>");
                  }      
                %>
                
                
                <!--
                action="LoginServlet" this attribute define where does the information
                will be submited.
                
                method="post" because we don't want to see the user and password in the url
                -->
                <form class="input-form" id="login" action="LoginServlet" method="post">
                    <fieldset>
                        <legend>Login</legend>
                        <label for="user-name">username</label>
                        <input type="text" id="user-name" name="user-name" placeholder="my.username" />

                        <label for="user-pass">password</label>
                        <input type="password" id="user-pass" name="user-pass" />
                        <input type="submit" value="Ingresar" id="user-submit" />
                    </fieldset>
                </form>
        </div>
    </body>
</html>
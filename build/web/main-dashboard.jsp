<%-- 
    Document   : main-dashboard
    Created on : Jun 23, 2013, 9:42:48 PM
    Author     : jossemarGT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="author" content="jossemarGT">
        <title>Quick Workshop </title>
        <!-- This css is part of the "Twitter bootstrap" if you mind to use the
        same styles, it's a nice idea to check its own documentation at
        http://twitter.github.io/bootstrap/ -->
        
        <!-- Also you can download a custom theme of twitter bootstrap at 
        http://bootswatch.com/#gallery -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>
    </head>
    <body >

        
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">

                    <a class="brand" href="#intro">Web Derivator</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <!-- You have to set the same value of the tab id into the 
                            href attribute after a # symbol.
                            
                            Ex.:
                            the link with the href="#tab1"
                            will show the tab with the id="tab1" after the link
                            is clicked.
                            
                            -->
                            <li><a href="#tab1">Admin tab</a></li>
                            <li><a href="#tab2">Normal user tab</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div id="intro" class="app-section container active">
            <section>
                <h1>Welcome</h1>
                <p>Choose the task that you'd like to perform</p>
            </section>
        </div>
        
        <%
            //Heads up!
            //The next code is to validate if the user can see the content (tab).
            //if the current user doesn't have the user-rol "admin" the tab below
            //wont be rendered in the browser
            if ( session.getAttribute("user-rol").toString().equalsIgnoreCase("admin")) { 
        %>
        
        <div id="tab1" class="app-section container">
            <section>
                <h2>Admin tab 1</h2>

                <!--
                action="UploadServlet" this attribute define where does the information
                will be submited.
                
                enctype="multipart/form-data" method="post" have to go every time 
                that you want to send a file to any server
                -->
                <form class="input-form" action="UploadServlet" enctype="multipart/form-data" method="post"> 
                    <fieldset>
                        <legend>Upload config file</legend>
                        <!-- 
                        The hidden field is to know which parser you have to choose
                        after the file has been uploaded.
                        -->
                        <input type="hidden" name="parser-action-type" value="admin-tab1" />
                        <label class="input-file-group" for="file-upload-basic" >Attach config file</label>
                        <input name="file-upload-basic" id="file-upload-basic" type="file" class="input-file-group">

                        <button type="submit" class="btn">Upload and parse</button>
                    </fieldset>
                </form>

            </section>
        </div>
        <% 
            } //Please DON'T FORGET TO CLOSE THE IF of the user-rol validation
            //Any content that any user can see goes bellow this line (like tab2).
        %>

        <div id="tab2" class="app-section container">
            <section>
                <h2>Tab 2</h2>
                
                <!--
                Check the explanation of every attribute of this form above.
                -->
                <form class="input-form" action="UploadServlet" enctype="multipart/form-data" method="post"> 
                    <fieldset>
                        <legend>Upload config file</legend>
                        <!-- 
                        Just remeber to CHANGE the value of the hidden field
                        -->
                        <input type="hidden" name="parser-action-type" value="user-tab2" />
                        <label class="input-file-group" for="file-upload-basic" >Attach config file</label>
                        <input name="file-upload-basic" id="file-upload-basic" type="file" class="input-file-group">

                        <button type="submit" class="btn">Upload and parse</button>
                    </fieldset>
                </form>
            </section>
        </div>


        <footer >

        </footer>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.js"></script>
        <!-- The script below has ajax call to my custom version of this code,  but 
        doesn't have any use for this example. So, go on if you like to explore -->
        <script src="assets/js/script.js"></script>
    </body>
</html>


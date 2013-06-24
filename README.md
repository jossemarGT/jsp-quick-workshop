#JSP Quick Workshop
A minimal webapp created at the "JSP workshop", a crash course that aims to explain:

- Use of session variables
- Use of request parameters
- Use of java server pages and java servlets (in a MVC pattern)
- Implement a redirect
- Implement a file upload
- Implement a raw way to display login errors
- Dynamically show/hide content to selected user rol

This webapp just have:

- A login page [index.jsp](https://github.com/jossemarGT/jsp-quick-workshop/blob/master/web/index.jsp) which only valid user/pass is test/test
- A representation of a dashboard [main-dashboard.jsp](https://github.com/jossemarGT/jsp-quick-workshop/blob/master/web/main-dashboard.jsp)
- A servlet to handle the login [LoginServlet.java](https://github.com/jossemarGT/jsp-quick-workshop/blob/master/src/java/servlets/LoginServlet.java)
- A servler to handle the file upload [UploadServlet.java](https://github.com/jossemarGT/jsp-quick-workshop/blob/master/src/java/servlets/UploadServlet.java)

Technology, dependencies and frameworks:
- JSP w/ glassfish
- File upload dependencies: [commons-fileupload-1.3.jar](http://commons.apache.org/proper/commons-fileupload/) & [commons-io-2.4.jar](http://commons.apache.org/proper/commons-io/)
- Styling framework: [Twitter Bootstrap](http://twitter.github.io/bootstrap/)
- IDE (if its matters): Netbeans 7.3

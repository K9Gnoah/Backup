<%-- 
    Document   : createRectangle
    Created on : Sep 18, 2023, 2:56:35 PM
    Author     : THINKPAD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <canvas id="myCanvas" width="500" height="500" style="border:1px solid grey"></canvas>

        <script>
        <%
        int num = Integer.parseInt(request.getAttribute("the_num").toString());
        PrintWriter webprint = response.getWriter();
        webprint.println(num);

        // Declare the variables outside of the loop
        int a, b, rectWidth, rectHeight;

        for (int i = 1; i <= num; i++) {
        %>
            do {
                // Generate random values for a and rectWidth such that a + rectWidth <= 500
                a = Math.floor(Math.random() * 501); // Random integer between 0 and 500
                rectWidth = Math.floor(Math.random() * (501 - a)); // Random integer between 0 and (500 - a)

                // Generate random values for b and rectHeight such that b + rectHeight <= 500
                b = Math.floor(Math.random() * 501); // Random integer between 0 and 500
                rectHeight = Math.floor(Math.random() * (501 - b)); // Random integer between 0 and (500 - b)
            } while (a + rectWidth > 500 || b + rectHeight > 500 || rectWidth <= 0 || rectHeight <= 0);



            const canvas = document.getElementById("myCanvas");
            const ctx = canvas.getContext("2d");

            ctx.beginPath();
            ctx.rect(a, b, rectWidth, rectHeight);
//            ctx.rect(20,20,200,200);
//            ctx.rect(20,20,200,200);
            ctx.stroke();
        <%
        }
        %>
        </script> 

    </body>
</html>

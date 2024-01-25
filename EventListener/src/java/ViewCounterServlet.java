/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author THINKPAD
 */
public class ViewCounterServlet extends HttpServlet {
   
    // Phương thức xử lý GET request.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Integer viewCount = (Integer) context.getAttribute("viewCount");
        if (viewCount == null) {
            viewCount = 1;
        } else {
            viewCount++;
        }
        context.setAttribute("viewCount", viewCount);
        
        // Hiển thị số lượt view trên trang web.
        resp.setContentType("text/html");
        resp.getWriter().write("<html><body><h1>Number of views: " + viewCount + "</h1></body></html>");
    }
}

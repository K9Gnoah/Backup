/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author THINKPAD
 */
public class NewServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    private ArrayList<Student> studentList = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("create.html").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter webprint = response.getWriter();
//        String get_classID= request.getParameter("classId");
//        String get_className= request.getParameter("className");
//        String get_startDate = request.getParameter("startDate");
//        boolean get_allowRetake = request.getParameter("gender")!= null;
//        String get_dpm = request.getParameter("department");
        
        // Loop through the submitted students and add them to the ArrayList
        int rowIndex = 1; // Start with the first student (row 1)
        while (true) {
            String id = request.getParameter("id" + rowIndex);
            if (id == null) {
                break; // No more students to process
            }
            String name = request.getParameter("name" + rowIndex);
            String gender = request.getParameter("gender" + rowIndex);
            String dob = request.getParameter("dob" + rowIndex);
            String department = request.getParameter("department" + rowIndex);

            // Create a Student object and add it to the ArrayList
            Student student = new Student(id, name, gender, dob, department);
            studentList.add(student);       
            webprint.println(studentList.get(rowIndex-1).getId());
            webprint.println(studentList.get(rowIndex-1).getName());
            webprint.println(studentList.get(rowIndex-1).getGender());
            webprint.println(studentList.get(rowIndex-1).getDate());
            webprint.println(studentList.get(rowIndex-1).getDeparment());
            webprint.println("---------------------------");
            // Increment the rowIndex to process the next student
            rowIndex++;
        }      
        
    
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

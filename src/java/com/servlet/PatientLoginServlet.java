
package com.servlet;

import com.business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josia
 */
@WebServlet(name = "PatientLoginServlet", urlPatterns = {"/PatientLoginServlet"})
public class PatientLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get the email from previous page
            String username = request.getParameter("username");
            
            // Get the password from the previous page
            String password = request.getParameter("password");
            
            // Create a new dentist object
            Patient p = new Patient();
            
            // Login the customer
            if(p.login(username, password)){
                request.getSession().setAttribute("patient", p);
                request.getRequestDispatcher("pat/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("pat/login-err.html").forward(request, response);
            }
        
        }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Patient Login Servlet";
    }// </editor-fold>

}

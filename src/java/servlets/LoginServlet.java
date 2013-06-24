/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jossemargt
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        /** Workshop code goes below this line **/
        HttpSession session = request.getSession(); //Getting current http session
        
        try {
              
            //A raw approach to user validation
            
            if( request.getParameter("user-name").equalsIgnoreCase("test") 
                    && request.getParameter("user-pass").equalsIgnoreCase("test") ){
                //store session variables
                session.setAttribute("user-name", "admin");
                session.setAttribute("user-rol", "admin");
                //redirect to the dashboard view
                response.sendRedirect("main-dashboard.jsp");
            } else {
                //redirect to login page with error code 401
                response.sendRedirect("index.jsp?error=401");
            }
            
            //You must use the parsing method as the functional request describes instead.
            //Like:
            
            // UserParser parser = new UserParser( users.txt );
            // HashMap<String, String> users = parser.parse();
            
            // String hashpass = users.get( request.getParameter("user-name")
            // if ( hashpass != null) { //user exists
            //      if( hashpass.equalsIgnoreCase( request.getParameter("user-pass")  ) )
            //          [store session variables and redirect]
            // } else { [redirect with error code] }
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
        return "Short description";
    }// </editor-fold>
}

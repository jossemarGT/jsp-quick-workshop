/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author jossemargt
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {

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
        
        //WARNING: To use this code you have to attach the libraries 
        // - commons-fileupload-1.3.jar 
        // - commons-io-2.4.jar
        // You can find them in the /lib dir.
        
        String flag_parser_type = null;
        InputStream filecontent = null;

        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {

                    //Remember the hidden field with the name "parser-action-type"
                    //We'll use it as flag to know which parser call.
                    if( item.getFieldName().equalsIgnoreCase("parser-action-type") ){
                        flag_parser_type = item.getString();
                    }

                } else {
                    String fieldname = item.getFieldName();
                    String filename = FilenameUtils.getName(item.getName());
                    filecontent = item.getInputStream();
                }
            }
        } catch (FileUploadException e) {
            throw new ServletException("File Upload Failed", e);
        }
        
        //After the file upload we just call our custom parser
        try {
            //This code just resend the content of the uploaded file, it doens't
            //have any use to you.
            StringWriter writer = new StringWriter();
            IOUtils.copy(filecontent, writer);
            out.println( writer.toString() );
            
            //So, instead of that code you will parse the file like this
            
            //if ( flag_parser_type != null ) {
            //  if( flag_parser_type.equalsIgnoreCase("admin-tab1") ){
            //      AdminTab1Parser parser = new parser(filecontent);
            //      Object result = parser.parse();
            //      [Do some magic]
            //  } else if( flag_parser_type.equalsIgnoreCase("user-tab2") ){
            //      UserTab2Parser parser2 = new parser(filecontent);
            //      Object result = parser.parse();
            //      [Do some magic]
            //  } else {
            //      [Something else]
            //  }
            //}
            
            // [print the response]
            
        } catch (Exception e){
            //Parser exception
            
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

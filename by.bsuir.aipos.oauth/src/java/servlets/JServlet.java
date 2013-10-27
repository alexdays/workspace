/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.Operation;
import org.xml.sax.SAXException;

/**
 *
 * @author Александр
 */
@WebServlet(name = "JServlet", urlPatterns = {"/JServlet"})
public class JServlet extends HttpServlet {
   private Operation operation;
   
   public JServlet() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
       operation = new Operation();
   }
      
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = (String)request.getParameter("erasingName");
        PrintWriter out = response.getWriter();
        out.println("name: "+name);
        try {
            operation.eraseConcept(name);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String conceptName = (String)request.getParameter("searchingName");
        String conceptContent = "wef";
        try {
            conceptContent = operation.getConceptContent(conceptName);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(JServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        request.setAttribute("name", conceptName);
        request.setAttribute("content", conceptContent);
        request.getRequestDispatcher("content.jsp").forward(request, response);
        
    }

      
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.Manual;
import client.Manual_Service;
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

import org.xml.sax.SAXException;

/**
 *
 * @author Александр
 */
@WebServlet(name = "CServlet", urlPatterns = {"/CServlet"})
public class CServlet extends HttpServlet {

    private Manual manual;
    
    public CServlet() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
         Manual_Service manual_service = new Manual_Service();
         manual = manual_service.getManualPort();
         manual.init();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = (String)request.getParameter("addingName");
        String content = (String)request.getParameter("addingContent");
        
            manual.addConcept(name, content);
            request.getRequestDispatcher("index.jsp").forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = (String)request.getParameter("changingName");
        String content = (String)request.getParameter("changingContent");
        
            manual.changeConcept(name, content);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

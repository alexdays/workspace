/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Александр
 */
@WebServlet(name = "OAuth", urlPatterns = {"/OAuth"})
public class OAuth extends HttpServlet {
    private static final String client_id = "708635192499906";
    private static final String redirect_uri="http://localhost:8084/by.bsuir.aipos.oauth/OAuth";
    private static final String client_secret="f5c9bb2753b09bdc48e2e91c341248be";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        if (code == null || code.equals("")) {
            // an error occurred, handle this
        }
        response.getWriter().println(code);
        String token = null;
        try {
            String g = "https://graph.facebook.com/oauth/access_token?"
                    + "client_id="+client_id
                    + "&redirect_uri="+URLEncoder.encode(redirect_uri)
                    + "&client_secret="+client_secret
                    + "&code="+code;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String temp = null;
            while((temp = reader.readLine())!=null){
                 token += temp;
            }   
            token = token.replace("null", "");
            
        } catch(Exception e){
        
        }
        String graph = null;
        try {
            String g = "https://graph.facebook.com/me?" + token;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuffer b = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine + "\n");            
            in.close();
            graph = b.toString();
        } catch (Exception e) {
                // an error occurred, handle this
        }

        String facebookId;
        String firstName = null;
        String middleNames;
        String lastName;
        String email = null;
        String gender;
        try {
            JSONObject json = new JSONObject(graph);
            facebookId = json.getString("id");
            firstName = json.getString("first_name");
            if (json.has("middle_name"))
               middleNames = json.getString("middle_name");
            else
                middleNames = null;
            if (middleNames != null && middleNames.equals(""))
                middleNames = null;
            lastName = json.getString("last_name");
            email = json.getString("email");
            if (json.has("gender")) {
                String g = json.getString("gender");
                if (g.equalsIgnoreCase("female"))
                    gender = "female";
                else if (g.equalsIgnoreCase("male"))
                    gender = "male";
                else
                    gender = "unknown";
            } else {
                gender = "unknown";
            }
        } catch (JSONException e) {
            // an error occurred, handle this
        }
        HttpSession session = request.getSession();
        session.setAttribute("user_name", firstName);
        session.setAttribute("user_email", email);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

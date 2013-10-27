/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class Operation {
    private List<Note> noteList;
    private Connection connection;
    private Statement stat;
    private ResultSet rs;
    
    public Operation() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        //Class.forName("com.mysql.jdbs.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","");
        stat = connection.createStatement();
    }
    
    public List<String> getAllConcepts() throws ParserConfigurationException, SAXException, IOException, TransformerException, ClassNotFoundException, SQLException{
        ResultSet res = stat.executeQuery("SELECT name FROM concepts");
        List<String> list = new ArrayList<String>();
        while(res.next()){
            list.add(res.getString("name"));
        }  
        return list;
    }
    public void addConcept(String name, String content) throws ParserConfigurationException, SAXException, IOException, TransformerException, ClassNotFoundException, SQLException{
         stat.execute("INSERT INTO concepts (name,content) VALUES('"+name+"','"+content+"')");
    }
    public String getConceptContent(String conceptName) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException{
        ResultSet res = stat.executeQuery("SELECT * FROM concepts WHERE name='"+conceptName+"'");
        return res.getString("content");
    }
    public void changeConcept(String conceptName, String content) throws ParserConfigurationException, SAXException, IOException, IOException, TransformerException, SQLException{
         stat.execute("UPDATE concepts SET name='"+conceptName+"', content='"+content+"' WHERE name='"+conceptName+"'");
    }
    public void eraseConcept(String conceptName) throws ParserConfigurationException, SAXException, IOException, TransformerException, SQLException{
         stat.execute("DELETE FROM concepts WHERE name='"+conceptName+"'");
    }   	
	
}

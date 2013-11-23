/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Note;

/**
 *
 * @author Александр
 */
@Stateless
public class OperationBean implements OperationBeanLocal {
    private List<Note> noteList;
    private Connection connection;
    private Statement stat;
    private ResultSet rs;    
      
    @Override
    public List<String> getAllConcepts() {
        List<String> list = new ArrayList<String>();
        try {
            ResultSet res = stat.executeQuery("SELECT name FROM concepts");
            
            while(res.next()){
                list.add(res.getString("name"));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(OperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void addConcept(String name, String content) {
        try {
            stat.execute("INSERT INTO concepts (name,content) VALUES('"+name+"','"+content+"')");
        } catch (SQLException ex) {
            Logger.getLogger(OperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void changeConcept(String name, String content) {
        try {
            stat.execute("UPDATE concepts SET name='"+name+"', content='"+content+"' WHERE name='"+name+"'");
        } catch (SQLException ex) {
            Logger.getLogger(OperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eraseConcept(String name) {
        try {
            stat.execute("DELETE FROM concepts WHERE name='"+name+"'");
        } catch (SQLException ex) {
            Logger.getLogger(OperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getConceptContent(String name) {
        try {
            ResultSet res = stat.executeQuery("SELECT * FROM concepts");
            while(res.next()){
                if(res.getString("name").equals(name)){
                    return res.getString("content");
                }
            }           
        } catch (SQLException ex) {
            Logger.getLogger(OperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void init() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","");
            stat = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(OperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
  

}

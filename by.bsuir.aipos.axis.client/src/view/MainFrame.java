/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class MainFrame extends JFrame{
    
    private JTextField searchField;
    private JTextPane contentPane;
    private JTextPane conceptListPane;
    private JButton searchBtn;
    private JButton eraseBtn;
    private JButton changeBtn;
    private JButton addBtn;
    private ChangeDialog changeDialog;
    private AddDialog addDialog;
    
    public static final String endpoint = "http://localhost:8080/axis/service.jws";
    private Service service;
    private Call call;
    
    public MainFrame() throws MalformedURLException, AxisFault, RemoteException, ServiceException{
        service = new Service();
        call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
        initCommonSettings();
        initWorkingArea();
        initEvents();
        String[] allConcepts = getAllConceptList();
        fillConceptPane(allConcepts);
    }
    public void initCommonSettings(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 240);
        setTitle("Web-service");
    }
    
    public void initWorkingArea(){
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel viewPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());
        
        searchField = new JTextField(20);
        searchBtn = new JButton("Search");
        JLabel searchLbl = new JLabel("Concept for search or erase: ");
        topPanel.add(searchLbl);
        topPanel.add(searchField);
        topPanel.add(searchBtn);
        
        conceptListPane = new JTextPane();
        conceptListPane.setPreferredSize(new Dimension(200,480));
        contentPane = new JTextPane();
        
        JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, conceptListPane, contentPane);
        
        addBtn = new JButton("Add...");
        changeBtn = new JButton("Change...");
        eraseBtn = new JButton("Erase");
        bottomPanel.add(addBtn);
        bottomPanel.add(changeBtn);
        bottomPanel.add(eraseBtn);
        
        add(topPanel, BorderLayout.NORTH);
        add(splitter, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);  
    }
    public String[] getAllConceptList() throws RemoteException{
        Object[] param = new Object[]{};
        String[] response = (String[])call.invoke("getAllConcepts", param);
        String[] conceptList = response;
        return conceptList;
    }
    public void fillConceptPane(String[] conceptList){
        String allConcepts = "";
        for(int i=0;i<conceptList.length;i++){
            allConcepts+=conceptList[i]+"\n";
        }
        conceptListPane.setText(allConcepts);
    }
    private void initEvents(){
        searchBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String requiredConceptName = searchField.getText();
                Object[] param = new Object[]{requiredConceptName};
                String result = "";
                try {
                    result = (String)call.invoke("getConceptContent", param);
                } catch (AxisFault ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                              
                contentPane.setText(result);
            }            
        });
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog = new AddDialog(MainFrame.this, call);
                addDialog.setVisible(true);
            }        
        });
        changeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDialog = new ChangeDialog(MainFrame.this,call);
                changeDialog.setVisible(true);
            }        
        });
        
        eraseBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 String erasedConceptName = searchField.getText();
                 Object[] param = new Object[]{erasedConceptName};
                try {
                    call.invoke("eraseConcept", param);
                } catch (AxisFault ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}

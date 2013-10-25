/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.ws.rs.core.MediaType;

public class MainFrame extends JFrame{
    
    public static final String endPoint = "http://localhost:8084/RestFul/webresources/base";
    
    private JTextField searchField;
    private JTextPane contentPane;
    private JTextPane conceptListPane;
    private JButton searchBtn;
    private JButton eraseBtn;
    private JButton changeBtn;
    private JButton addBtn;
    private ChangeDialog changeDialog;
    private AddDialog addDialog;
    private WebResource service;
        
    public MainFrame() throws MalformedURLException, RemoteException{
        initClientParams(); 
        initCommonSettings();
        initWorkingArea();
        initEvents();
        String response = service.path("concept").accept(MediaType.TEXT_PLAIN).get(String.class);                 
        //String[] allConcepts = getAllConceptList();
        fillConceptPane(response.split(";"));
    }
    
    private void initClientParams(){
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        service = client.resource(endPoint);
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
        ClientResponse response = service.path("concept").accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        String[] list;
        list = response.getEntity(String[].class);
        return list;
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
                String result = service.path("concept").path(requiredConceptName).accept(MediaType.TEXT_PLAIN).get(String.class);
                contentPane.setText(result);
            }            
        });
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog = new AddDialog(MainFrame.this, service);
                addDialog.setVisible(true);
            }        
        });
        changeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDialog = new ChangeDialog(MainFrame.this, service);
                changeDialog.setVisible(true);
            }        
        });
        
        eraseBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 String erasedConceptName = searchField.getText();
                 service.path("concept").path(erasedConceptName).type(MediaType.TEXT_PLAIN).delete(ClientResponse.class);
            }
        });
    }
    
}

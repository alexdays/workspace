/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.aipos.javamanual.view;

import by.bsuir.aipos.javamanual.client.Client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;

public class MainFrame extends JFrame{
    
    private JTextField searchField;
    private JTextPane contentPane;
    private JTextPane conceptListPane;
    private JButton searchBtn;
    private JButton eraseBtn;
    private JButton changeBtn;
    private Client client;
    private ChangeDialog changeDialog;
    
    public MainFrame() throws MalformedURLException, ServiceException{
        client = new Client();
        client.callStart();
        initCommonSettings();
        initWorkingArea();
        initEvents();
    }
    public void initCommonSettings(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setTitle("Web-service");
    }
    
    public void initWorkingArea(){
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel viewPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());
        
        searchField = new JTextField(20);
        searchBtn = new JButton("Search");
        topPanel.add(searchField);
        topPanel.add(searchBtn);
        
        conceptListPane = new JTextPane();
        conceptListPane.setPreferredSize(new Dimension(200,480));
        contentPane = new JTextPane();
//        viewPanel.add(conceptListPane,BorderLayout.WEST);
//        viewPanel.add(contentPane, BorderLayout.CENTER);
        
        JSplitPane splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, conceptListPane, contentPane);
        
        
        changeBtn = new JButton("Change...");
        eraseBtn = new JButton("Erase");
        bottomPanel.add(changeBtn);
        bottomPanel.add(eraseBtn);
        
        add(topPanel, BorderLayout.NORTH);
        add(splitter, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        
    }
    private void initEvents(){
        searchBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String requiredConceptName = searchField.getText();
                try {
                    String conceptContent = client.getConceptContent(requiredConceptName);
                    contentPane.setText(conceptContent);
                } catch (AxisFault ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        });
        changeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDialog = new ChangeDialog(MainFrame.this,client);
            }        
        });
        
        eraseBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 String erasedConceptName = searchField.getText();
                try {
                    client.eraseConcept(erasedConceptName);
                } catch (AxisFault ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}

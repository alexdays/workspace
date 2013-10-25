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
import org.apache.axis2.AxisFault;
import service.ServiceIOExceptionException;
import service.ServiceParserConfigurationExceptionException;
import service.ServiceSAXExceptionException;
import service.ServiceStub;
import service.ServiceTransformerExceptionException;

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
    
    private ServiceStub service;
    
    public MainFrame() throws MalformedURLException, AxisFault, RemoteException, ServiceIOExceptionException, ServiceSAXExceptionException, ServiceParserConfigurationExceptionException, ServiceTransformerExceptionException{
        service = new ServiceStub();
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
    public String[] getAllConceptList() throws RemoteException, ServiceIOExceptionException, ServiceSAXExceptionException, ServiceParserConfigurationExceptionException, ServiceTransformerExceptionException{
        ServiceStub.GetAllConcepts gac = new ServiceStub.GetAllConcepts();
        ServiceStub.GetAllConceptsResponse gacr = service.getAllConcepts(gac);
        String[] conceptList = gacr.get_return();
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
                ServiceStub.GetConceptContent gcc = new ServiceStub.GetConceptContent();
                gcc.setConceptName(requiredConceptName);
                ServiceStub.GetConceptContentResponse gccr;
                String result = "";
                try {
                    gccr = service.getConceptContent(gcc);
                    result = gccr.get_return();
                } catch (RemoteException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceIOExceptionException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceSAXExceptionException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceParserConfigurationExceptionException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                contentPane.setText(result);
            }            
        });
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog = new AddDialog(MainFrame.this,service);
                addDialog.setVisible(true);
            }        
        });
        changeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDialog = new ChangeDialog(MainFrame.this,service);
                changeDialog.setVisible(true);
            }        
        });
        
        eraseBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 String erasedConceptName = searchField.getText();
                 ServiceStub.EraseConcept ec = new ServiceStub.EraseConcept();
                 ec.setConceptName(erasedConceptName);
                try {
                    service.eraseConcept(ec);
                } catch (RemoteException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceIOExceptionException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceSAXExceptionException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceParserConfigurationExceptionException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceTransformerExceptionException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}

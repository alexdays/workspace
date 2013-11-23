package view;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;


public class AddDialog extends JFrame{
    private JTextField conceptNameField;
    private JTextPane conceptContentPane;
    private JButton addBtn;
    private JButton cancelBtn;
    private MainFrame mainFrame;
    private WebResource service;
    
    public AddDialog(MainFrame mainFrame, WebResource service){
        this.mainFrame = mainFrame;
        this.service = service;
        initCommonSettings();
        initComponents();
        initEvents();
    }
    private void initCommonSettings(){
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setTitle("Add Dialog");
       setSize(400,200);
       setLayout(new BorderLayout());
    }
    private void initComponents(){
        JPanel btnPanel = new JPanel(new FlowLayout());
        conceptNameField = new JTextField();
        conceptContentPane = new JTextPane();
        addBtn = new JButton("Add");
        cancelBtn = new JButton("Cancel");
        btnPanel.add(addBtn);
        btnPanel.add(cancelBtn);
        add(conceptNameField, BorderLayout.NORTH);
        add(conceptContentPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
    private void initEvents(){
        cancelBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
        addBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = conceptNameField.getText();
                String content = conceptContentPane.getText();
                MultivaluedMap<String, String> queryParam = new MultivaluedMapImpl();
                queryParam.add("name", name);
                queryParam.add("content", content);
                service.path("concept").queryParams(queryParam).type(MediaType.TEXT_PLAIN).put(ClientResponse.class);
            }
        });
    }
}
                
                

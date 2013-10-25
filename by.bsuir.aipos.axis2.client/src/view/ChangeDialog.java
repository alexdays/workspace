package view;

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
import service.ServiceIOExceptionException;
import service.ServiceParserConfigurationExceptionException;
import service.ServiceSAXExceptionException;
import service.ServiceStub;
import service.ServiceTransformerExceptionException;


public class ChangeDialog extends JFrame{
    private JTextField conceptNameField;
    private JTextPane conceptContentPane;
    private JButton changeBtn;
    private JButton cancelBtn;
    private MainFrame mainFrame;
    private ServiceStub service;
    
    public ChangeDialog(MainFrame mainFrame, ServiceStub service){
        this.service = service;
        this.mainFrame = mainFrame;
        initCommonSettings();
        initComponents();
        initEvents();
    }
    private void initCommonSettings(){
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setTitle("Change Dialog");
       setSize(400,200);
       setLayout(new BorderLayout());
    }
    private void initComponents(){
        JPanel btnPanel = new JPanel(new FlowLayout());
        conceptNameField = new JTextField();
        conceptContentPane = new JTextPane();
        changeBtn = new JButton("Change");
        cancelBtn = new JButton("Cancel");
        btnPanel.add(changeBtn);
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
        changeBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = conceptNameField.getText();
                String content = conceptContentPane.getText();
                ServiceStub.ChangeConcept cc = new ServiceStub.ChangeConcept();
                cc.setConceptName(name);
                cc.setContent(content);
                try {
                    service.changeConcept(cc);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChangeDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceIOExceptionException ex) {
                    Logger.getLogger(ChangeDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceSAXExceptionException ex) {
                    Logger.getLogger(ChangeDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceParserConfigurationExceptionException ex) {
                    Logger.getLogger(ChangeDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServiceTransformerExceptionException ex) {
                    Logger.getLogger(ChangeDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

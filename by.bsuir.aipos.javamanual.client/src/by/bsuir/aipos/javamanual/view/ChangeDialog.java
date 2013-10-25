package by.bsuir.aipos.javamanual.view;

import by.bsuir.aipos.javamanual.client.Client;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import org.apache.axis.AxisFault;


public class ChangeDialog extends JFrame{
    private JTextField conceptNameField;
    private JTextPane conceptContentPane;
    private JButton changeBtn;
    private JButton cancelBtn;
    private MainFrame mainFrame;
    private Client client;
    
    public ChangeDialog(MainFrame mainFrame, Client client){
        this.mainFrame = mainFrame;
        this.client = client;
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
                try {
                    client.changeConcept(name, content);
                } catch (AxisFault ex) {
                    Logger.getLogger(ChangeDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
    }
}

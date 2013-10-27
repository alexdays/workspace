package by.bsuir.aipos.smtp_server.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import by.bsuir.aipos.smtp_server.controller.*;
import by.bsuir.aipos.smtp_server.model.Account;
import by.bsuir.aipos.smtp_server.model.POP3Server;
import by.bsuir.aipos.smtp_server.model.Server;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private final static int DEFAULT_FRAME_WIDTH = 400;
	private final static int DEFAULT_FRAME_HEIGHT = 400;
	private JTextPane protocolView;
	private JButton startServerBtn;
	private JButton stopServerBtn;
	private JTextField emailField;
	private JTextField passwordField;
	private JButton createAccountBtn;
	private JTextField portValueField;
	private Server server;
	private POP3Server pop3server;
	private List<Account> accountList;
	
	public MainFrame() throws IOException{
		accountList = new Vector<Account>();
		initCommonSettings();
		initFrameContent();
		startServer();
		initListeners();
		
	}
	private void initCommonSettings(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT));
		setTitle("SMTP-server");
	}
	
	private void initFrameContent(){
		setLayout(new BorderLayout());
		protocolView = new JTextPane();
		JScrollPane scrollProtocolView = new JScrollPane(protocolView);
		JPanel controlPanel = new JPanel(new FlowLayout());
		JPanel regPanel = new JPanel(new BorderLayout());
		startServerBtn = new JButton("Start SMTP-server");
		stopServerBtn = new JButton("Stop SMTP-server");
		portValueField = new JTextField("1234");
		portValueField.setPreferredSize(new Dimension(60, 25));
		emailField = new JTextField();
		emailField.setPreferredSize(new Dimension(150, 25));
		passwordField = new JTextField();
		passwordField.setPreferredSize(new Dimension(150, 25));
		createAccountBtn = new JButton("Create account");
		controlPanel.add(portValueField);
		controlPanel.add(startServerBtn);
		controlPanel.add(stopServerBtn);
		regPanel.add(emailField,BorderLayout.NORTH);
		regPanel.add(passwordField,BorderLayout.CENTER);
		regPanel.add(createAccountBtn,BorderLayout.SOUTH);
		add(controlPanel, BorderLayout.NORTH);
		add(scrollProtocolView, BorderLayout.CENTER);
		add(regPanel,BorderLayout.SOUTH);
	}
	
	private void startServer() throws IOException{
		int port = Integer.valueOf(portValueField.getText());
		server = new Server(port, this);
		pop3server = new POP3Server(this);
		pop3server.start();
	}
	private void initListeners(){
		startServerBtn.addActionListener(new StartServerBntClick(server));
		stopServerBtn.addActionListener(new StopServerBntClick(server));
		createAccountBtn.addActionListener(new CreateAccountBtnClick(this));
	}
	public void appendLine(String line){
		String currentText = protocolView.getText();
		protocolView.setText(currentText+"\n"+line);
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void appendAccount(String email, String password){
		Account account = new Account(email, password);
		accountList.add(account);
	}
	public JTextField getEmailField() {
		return emailField;
	}
	public JTextField getPasswordField() {
		return passwordField;
	}
	public boolean isAccount(String email){
		for(int i=0;i<accountList.size();i++){
			if(accountList.get(i).getEmail().equals(email)){
				return true;
			}
		}
		return false;
	}
	public Account getAccount(String email){
		for(int i=0;i<accountList.size();i++){
			if(accountList.get(i).getEmail().equals(email)){
				return accountList.get(i);
			}
		}
		return null;
	}
}

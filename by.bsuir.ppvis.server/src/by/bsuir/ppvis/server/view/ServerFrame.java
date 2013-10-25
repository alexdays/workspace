package by.bsuir.ppvis.server.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import by.bsuir.ppvis.server.controller.Controller;
import by.bsuir.ppvis.server.controller.EngBtnEvent;
import by.bsuir.ppvis.server.controller.RusBtnEvent;
import by.bsuir.ppvis.server.model.Document;
import by.bsuir.ppvis.server.server.Server;
import by.bsuir.ppvis.server.utls.ChildMenus;
import by.bsuir.ppvis.server.utls.CreateMenu;
import by.bsuir.ppvis.server.utls.CreateTools;
import by.bsuir.ppvis.server.utls.MainMenuEnum;
import by.bsuir.ppvis.utls.Language;

public class ServerFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int DEFAULT_FRAME_WIDTH = 480;
	public final int DEFAULT_FRAME_HEIGHT = 320;
	public final int DEFAULT_SERVER_PORT = 4444;
	public final String DEFAULT_FRAME_TITLE = "Server";
	
	private Server server;
	private String lang = Language.RUS;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextPane textPane;
	private JToggleButton rusBtn;
	private JToggleButton engBtn;
	private Document doc;
	private Controller controller;
	private String currentFileName = "";
		
	public ServerFrame() throws IOException{
		doc = new Document(this);
		controller = new Controller(this);
		server = new Server(this);
		initCommonSettings();
		initMenuBar();
		initToolBar();
		initWorkingArea();
		addComponents();
		initListeners();
	}
	
	private void initCommonSettings(){
		setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(DEFAULT_FRAME_TITLE);
	}
	
	private void initMenuBar(){
		menuBar = new JMenuBar();
		createMenu();
	}
	
	public void createMenu(){
		menuBar.removeAll();
		for(MainMenuEnum i : MainMenuEnum.values()){
			menuBar.add(CreateMenu.createMenu(i, controller, lang));
		}
		
		setJMenuBar(menuBar);
	}
	
	private void initToolBar(){
		toolBar = new JToolBar();
		Insets margin = new Insets(7,2,7,2);
		engBtn = new JToggleButton("ENG");
		rusBtn = new JToggleButton("\u0420\u0423\u0421");
		engBtn.setMargin(margin);
		rusBtn.setMargin(margin);
		for(ChildMenus i : ChildMenus.values()){
			toolBar.add(CreateTools.createTools(i, controller));
		}
		toolBar.add(engBtn);
		toolBar.add(rusBtn);		
	}
	
	private void initWorkingArea(){
		textPane = new JTextPane();
		textPane.setFont(new Font("Times New Romans",Font.PLAIN,14));
		JScrollPane scroll = new JScrollPane(textPane);
		add(scroll, BorderLayout.CENTER);
	}
			
	private void initListeners(){
		rusBtn.addActionListener(new RusBtnEvent(this));
		engBtn.addActionListener(new EngBtnEvent(this));
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {	
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					server.stop();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
			}
		});
	}
	
	private void addComponents(){
		add(toolBar, BorderLayout.NORTH);
	}
	
	public Document getDocument(){
		return doc;
	}
		
	public void setCurrentFileName(String fileName){
		currentFileName = fileName;
	}
	public String getCurrentFileName(){
		return currentFileName;
	}
	public String getCurrentLanguage(){
		return lang;
	}
	public void setLanguage(String lang){
		this.lang = lang;
	}
	public void setSelectEngBtn(boolean b){
		engBtn.setSelected(b);
	}
	public void setSelectRusBtn(boolean b){
		rusBtn.setSelected(b);
	}
	public Server getServer(){
		return server;
	}
	public void appendAct(String act){
		String currentText = textPane.getText();
		String newLine = (currentText.isEmpty())?(""):("\n");
		textPane.setText(currentText+newLine+act);
	}
}

package by.bsuir.ppvis.client.view;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.controller.Controller;
import by.bsuir.ppvis.client.controller.MainPagingNextEvent;
import by.bsuir.ppvis.client.controller.MainPagingPrevEvent;
import by.bsuir.ppvis.client.model.Document;
import by.bsuir.ppvis.client.utls.ChildMenus;
import by.bsuir.ppvis.client.utls.CreateMenu;
import by.bsuir.ppvis.client.utls.CreateTools;
import by.bsuir.ppvis.client.utls.MainMenuEnum;
import by.bsuir.ppvis.general.model.Note;
import by.bsuir.ppvis.utls.Language;
import by.bsuir.ppvis.client.view.TablePage;

public class ClientFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int DEFAULT_FRAME_WIDTH = 800;
	public final int DEFAULT_FRAME_HEIGHT = 600;
	public final int DEFAULT_SERVER_PORT = 4444;
	
	private Client client;
	private String lang = Language.RUS;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private TablePage tablePage;
	private JToggleButton rusBtn;
	private JToggleButton engBtn;
	private Document doc;
	private Controller controller;
	private String currentFileName = null;
	private List<Note> foundedNotes;
	private List<Note> erasedNotes;
	private InputDialog inputDialog;
	private EraseDialog eraseDialog;
	private FindDialog findDialog;
		
	public ClientFrame() throws IOException{
		doc = new Document(this);
		controller = new Controller(this);
		client = new Client(this);
		initCommonSettings();
		initMenuBar();
		initToolBar();
		initWorkingArea();
		initDialogs();
		addComponents();
		initListeners();
	}
	
	private void initCommonSettings(){
		setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Client");
		
	}
	
	private void initMenuBar(){
		menuBar = new JMenuBar();
		createMenu();
	}
	
	private void initDialogs(){
		inputDialog = new InputDialog(this);
		findDialog = new FindDialog(this);
		eraseDialog = new EraseDialog(this);
	}
	
	private void createMenu(){
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
		tablePage = new TablePage(this, new MainPagingPrevEvent(this),
				new MainPagingNextEvent(this));
		tablePage.updateData(doc.getData());
		add(tablePage, BorderLayout.CENTER);
		tablePage.update();
	}
			
	private void initListeners(){
		rusBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				engBtn.setSelected(false);
				lang = Language.RUS;
				createMenu();
				tablePage.reconstruction();
			}
		});
		engBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rusBtn.setSelected(false);
				lang = Language.ENG;
				createMenu();
				tablePage.reconstruction();
			}
		});
		this.addWindowListener(new WindowListener() {
			
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
				try {
					client.destroyServerThread();
					client.stop();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
			}
		});
	}
	
	private void addComponents(){
		add(toolBar, BorderLayout.NORTH);
	}
	
	public void redrawTable(List<Note> notes){
		tablePage.updateData(notes);
		tablePage.update();
	}

    public void clearTable(){
       tablePage.clearTable();
    }

	public Document getDocument(){
		return doc;
	}
	
	public DefaultTableModel getTableModel(){
		return tablePage.getTableModel();
	}
	
	public JTable getTable(){
		return tablePage.getTable();
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
	public Client getClient(){
		return client;
	}
	public List<Note> getFoundedNotes() {
		return foundedNotes;
	}

	public void setFoundedNotes(List<Note> foundedNotes) {
		this.foundedNotes = foundedNotes;
	}

	public List<Note> getErasedNotes() {
		return erasedNotes;
	}

	public void setErasedNotes(List<Note> erasedNotes) {
		this.erasedNotes = erasedNotes;
	}

	public InputDialog getInputDialog() {
		return inputDialog;
	}

	public void setInputDialog(InputDialog inputDialog) {
		this.inputDialog = inputDialog;
	}

	public EraseDialog getEraseDialog() {
		return eraseDialog;
	}

	public void setEraseDialog(EraseDialog eraseDialog) {
		this.eraseDialog = eraseDialog;
	}

	public FindDialog getFindDialog() {
		return findDialog;
	}

	public void setFindDialog(FindDialog findDialog) {
		this.findDialog = findDialog;
	}

	public TablePage getTablePage() {
		return tablePage;
	}
}

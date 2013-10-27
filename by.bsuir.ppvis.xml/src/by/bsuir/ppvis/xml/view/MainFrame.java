package by.bsuir.ppvis.xml.view;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import by.bsuir.ppvis.utls.ChildMenus;
import by.bsuir.ppvis.utls.CreateMenu;
import by.bsuir.ppvis.utls.CreateTools;
import by.bsuir.ppvis.utls.Language;
import by.bsuir.ppvis.utls.MainMenuEnum;
import by.bsuir.ppvis.xml.controller.Controller;
import by.bsuir.ppvis.xml.model.Document;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int DEFAULT_FRAME_WIDTH = 800;
	public final int DEFAULT_FRAME_HEIGHT = 600;
	private String lang = Language.RUS;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private TablePage tablePage;
	private JToggleButton rusBtn;
	private JToggleButton engBtn;
	private Document doc;
	private Controller controller;
	private String currentFileName = "";
	
	public MainFrame(){
		doc = new Document(this);
		controller = new Controller(this);
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
		setTitle("Table DB");
	}
	
	private void initMenuBar(){
		menuBar = new JMenuBar();
		createMenu();
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
		tablePage = new TablePage(this);
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
	}
	
	private void addComponents(){
		add(toolBar, BorderLayout.NORTH);
	}
	
	public void redrawTable(){
		tablePage.updateData(doc.getData());
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
	
}

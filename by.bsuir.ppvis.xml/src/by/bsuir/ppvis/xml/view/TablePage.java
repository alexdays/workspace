package by.bsuir.ppvis.xml.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import by.bsuir.ppvis.xml.model.Document;

public class TablePage extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_ROW_HEIGHT = 23;
	public static final int DEFAULT_ROW_COUNT = 10;
	public static final int DEFAULT_COLUMN_COUNT = 10;
	public static final int DEFAULT_FONT_SIZE = 14;
	public static final int DEFAULT_PAGE_NUMBER = 1;
	
	private MainFrame mainFrame;
	private Document doc;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollTable;
	private JButton prevBtn;
	private JButton nextBtn;
	private JSpinner pageNumberEdit;
	private JSpinner cellsNumberEdit;
	private JPanel pagingPanel; 
	private int pageNumber;
	private int rowCount;
	private List<Document.Note> notes;
	private ResourceBundle bundle;
	public TablePage(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		doc = mainFrame.getDocument();
		bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage(), Locale.getDefault());
		pageNumber = DEFAULT_PAGE_NUMBER;
		rowCount = DEFAULT_ROW_COUNT;
		initCommonSettings();
		initTable();
		initPaging();
		initComponents();
		initListeners();
	}
	
	private void initCommonSettings(){
		setLayout(new BorderLayout());
	}
	
	private void initTable(){
		tableModel = new DefaultTableModel();
		tableModel.setRowCount(DEFAULT_ROW_COUNT);
		tableModel.setColumnCount(DEFAULT_COLUMN_COUNT);
		table = new JTable(tableModel);
		table.setRowHeight(DEFAULT_ROW_HEIGHT);
		table.setFont(new Font("Verdana",Font.PLAIN,DEFAULT_FONT_SIZE));
		scrollTable = new JScrollPane(table);
	}
	
	private void initPaging(){
		pagingPanel = new JPanel(new FlowLayout());
		prevBtn = new JButton(bundle.getString("prev"));
		nextBtn = new JButton(bundle.getString("next"));
		pageNumberEdit = new JSpinner();
		cellsNumberEdit = new JSpinner();
		pageNumberEdit.setFont(new Font("Verdana",Font.BOLD,DEFAULT_FONT_SIZE));
		pageNumberEdit.setValue(DEFAULT_PAGE_NUMBER);
		cellsNumberEdit.setValue(DEFAULT_ROW_COUNT);
		pageNumberEdit.setPreferredSize(new Dimension(50,28));
		cellsNumberEdit.setPreferredSize(new Dimension(50,28));
		pagingPanel.add(prevBtn);
		pagingPanel.add(pageNumberEdit);
		pagingPanel.add(cellsNumberEdit);
		pagingPanel.add(nextBtn);
	}
	
	private void initComponents(){
		add(scrollTable,BorderLayout.CENTER);
		add(pagingPanel,BorderLayout.SOUTH);
	}
	
	private String[][] fillPage(){
		String[][] currentPageData = new String[rowCount][doc.getColumnNames().length];
		String[] tempCell = null;
		int index;
		for(int i=1;i<=rowCount;i++){
			try{
				index = (pageNumber-1)*rowCount-1+i;
				tempCell = noteToStringArr(notes.get(index));
			}catch(Exception ex){
				tempCell = null;
			}
			currentPageData[i-1] =  tempCell; 
		}
		return currentPageData;
	}
	
	private String[] noteToStringArr(Document.Note note){
		String[] result = new String[]{
			note.getStudentFIO(),
			note.getParentsFIO(),
			note.getWorkingAddress(),
			note.getParentsPost(),
			String.valueOf(note.getParentsExperience())
		};
		return result;
	}
	
	private void initListeners(){
		prevBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(pageNumber>1){
					--pageNumber;
				}
				pageNumberEdit.setValue(pageNumber);
				update();
			}
		});
		nextBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(notes==null) return;
				if(pageNumber<notes.size()/rowCount+1){
					++pageNumber;
				}
				pageNumberEdit.setValue(pageNumber);
				update();
			}
		});
		pageNumberEdit.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int value = Integer.parseInt(String.valueOf(pageNumberEdit.getValue()));
				if(value>0&&value<=notes.size()/rowCount+1){
					pageNumber = value;
					update();
				} else {
					pageNumberEdit.setValue(pageNumber);
				}
			}
		});
		cellsNumberEdit.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int value = Integer.parseInt(String.valueOf(cellsNumberEdit.getValue()));
				if(value>0){
					tableModel.setRowCount(value);
					table.repaint();
					rowCount = value;
				} else {
					cellsNumberEdit.setValue(rowCount);
				}
			}
		});
	}
	
	public void update(){
		tableModel.setDataVector(fillPage(), doc.getColumnNames());
		table.setModel(tableModel);
		table.repaint();
	}
	
	public void updateData(List<Document.Note> data){
		this.notes = data;
	}
		
	public void clearTable(){
		tableModel.setDataVector(new Object[0][0], new Object[0]);
		table.setModel(tableModel);
		table.repaint();
	}
	
	public DefaultTableModel getTableModel(){
		return tableModel;
	}
	
	public JTable getTable(){
		return table;
	}
	
	public void setRowCount(int rowCount){
		this.rowCount = rowCount;
		cellsNumberEdit.setValue(rowCount);
		tableModel.setRowCount(rowCount);
		table.repaint();
	}
	
	public void reconstruction(){
		Document doc = mainFrame.getDocument();
		bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage(), Locale.getDefault());
		prevBtn.setText(bundle.getString("prev"));
		nextBtn.setText(bundle.getString("next"));
		updateData(doc.getData());
		update();
	}
}

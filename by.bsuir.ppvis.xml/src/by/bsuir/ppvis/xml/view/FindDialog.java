
package by.bsuir.ppvis.xml.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import by.bsuir.ppvis.xml.model.Document;

public class FindDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 700;
	public static final int DEFAULT_HEIGHT = 365;
	
	private MainFrame mainFrame;
	private JButton findBtn;
	private JButton cancelBtn;
	private JTextField inputFieldFirst;
	private JTextField inputFieldSecond;
	private JLabel inputLbl;
	private TablePage tablePage;
	private JRadioButton checkerStFio;
	private JRadioButton checkerParFioWorkAddr;
	private JRadioButton checkerParExper;
	private JRadioButton checkerStFioWorkAddr;
	private JPanel editPanel;
	private ResourceBundle bundle;
    public FindDialog(MainFrame mainFrame){
    	this.mainFrame = mainFrame;
        initCommonSettings();
        initComponents();
        addComponentsOnFrame();
        initListeners();
    }
    private void initCommonSettings(){
    	bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage(), Locale.getDefault());
    	setTitle(bundle.getString("finddialog"));
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
    }

    private void initComponents(){
    	editPanel = new JPanel(new BorderLayout());
    	tablePage = new TablePage(mainFrame);
    	tablePage.setRowCount(5);    	
    	inputFieldFirst = new JTextField();
    	inputFieldSecond = new JTextField();
    	inputLbl = new JLabel(bundle.getString("findfield"));
    	findBtn = new JButton(bundle.getString("find"));
    	cancelBtn = new JButton(bundle.getString("cancel"));
    	checkerStFio = new JRadioButton(bundle.getString("bystfio"));
    	checkerParFioWorkAddr = new JRadioButton(bundle.getString("byparfioworkaddr"));
    	checkerParExper = new JRadioButton(bundle.getString("byparexper"));
    	checkerStFioWorkAddr = new JRadioButton(bundle.getString("bystfioworkaddr"));
    }
    
    private void addComponentsOnFrame(){
    	ButtonGroup radioGroup = new ButtonGroup();
    	JPanel checkPanel = new JPanel(new GridLayout(4, 2));
    	editPanel.add(inputFieldFirst,BorderLayout.NORTH);
    	editPanel.add(inputFieldSecond, BorderLayout.CENTER);
    	radioGroup.add(checkerStFio);
    	radioGroup.add(checkerParFioWorkAddr);
    	radioGroup.add(checkerParExper);
    	radioGroup.add(checkerStFioWorkAddr);
    	radioGroup.add(findBtn);
    	radioGroup.add(cancelBtn);
    	checkPanel.add(checkerStFio);
    	checkPanel.add(checkerParFioWorkAddr);
    	checkPanel.add(checkerParExper);
    	checkPanel.add(checkerStFioWorkAddr);
    	checkPanel.add(inputLbl);
    	checkPanel.add(editPanel);
    	checkPanel.add(findBtn);
    	checkPanel.add(cancelBtn);
    	add(checkPanel,BorderLayout.NORTH);
    	add(tablePage, BorderLayout.CENTER);
    }
    
    private void initListeners(){
    	findBtn.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			String inputFirst = inputFieldFirst.getText();
    			String inputSecond = inputFieldSecond.getText();
    			Document doc = mainFrame.getDocument();
    			List<Document.Note> data;
    			if(checkerStFio.isSelected()){
    				data = doc.getDataByStFIO(inputFirst);
       			} else if(checkerParFioWorkAddr.isSelected()){
    				data = doc.getDataByParFIOWorkAddr(inputFirst, inputSecond);
    			} else if(checkerParExper.isSelected()){
    				data = doc.getDataByParExper(Integer.parseInt(inputFirst),Integer.parseInt(inputSecond));
     			} else if(checkerStFioWorkAddr.isSelected()){
     				data = doc.getDataByStFIOWorkAddr(inputFirst, inputSecond);
     			} else {
     				data = doc.getDataByStFIO(inputFirst);
     			}
    			updateTable(data);
    		}
    	});
    	cancelBtn.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			dispose();
    		}
    	});
    }
    
    private void updateTable(List<Document.Note> data){
    	tablePage.updateData(data);
    	tablePage.update();
    }
}

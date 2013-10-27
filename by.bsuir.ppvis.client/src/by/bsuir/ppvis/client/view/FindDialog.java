
package by.bsuir.ppvis.client.view;

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

import by.bsuir.ppvis.client.controller.FindBtnEvent;
import by.bsuir.ppvis.client.controller.FindPagingNextEvent;
import by.bsuir.ppvis.client.controller.FindPagingPrevEvent;
import by.bsuir.ppvis.general.model.Note;
import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.TablePage;

public class FindDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 700;
	public static final int DEFAULT_HEIGHT = 365;
	
	private ClientFrame mainFrame;
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
    public FindDialog(ClientFrame mainFrame){
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
    	tablePage = new TablePage(mainFrame, new FindPagingPrevEvent(mainFrame),
    			new FindPagingNextEvent(mainFrame));
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
    	findBtn.addActionListener(new FindBtnEvent(mainFrame));
    	cancelBtn.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			setVisible(false);
    		}
    	});
    }
    
    public void updateTable(List<Note> data){
    	tablePage.updateData(data);
    	tablePage.update();
    }
	public TablePage getTablePage() {
		return tablePage;
	}
	public JTextField getInputFieldFirst() {
		return inputFieldFirst;
	}
	public JTextField getInputFieldSecond() {
		return inputFieldSecond;
	}
	public JRadioButton getCheckerStFio() {
		return checkerStFio;
	}
	public JRadioButton getCheckerParFioWorkAddr() {
		return checkerParFioWorkAddr;
	}
	public JRadioButton getCheckerParExper() {
		return checkerParExper;
	}
	public JRadioButton getCheckerStFioWorkAddr() {
		return checkerStFioWorkAddr;
	}
}

package by.bsuir.ppvis.client.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.controller.EmptyFieldFocusEvent;
import by.bsuir.ppvis.general.model.Note;
import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.client.view.ClientFrame;

public class InputDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JTextField inputStudentFIO;
	private JTextField inputParentsFIO;
	private JTextField inputWorkingAddress;
	private JTextField inputParentsPost;
	private JSpinner inputParentsExperience;
	private JButton okBtn;
	private JButton cancelBtn;
	private ClientFrame mainFrame;
	private ResourceBundle bundle;
	
	public InputDialog(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
		initCommonSettings();
		initComponents();
		initListeners();
		initEmptyFields();
		initEmptyFieldActions();
	}
	private void initCommonSettings(){
		bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage(), Locale.getDefault());
		setTitle(bundle.getString("inputdialog"));
		setSize(400,200);
		setLocationRelativeTo(null);
		setResizable(false);		
	}
	private void initComponents(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		inputStudentFIO = new JTextField();
		inputParentsFIO = new JTextField();
		inputWorkingAddress = new JTextField();
		inputParentsPost = new JTextField();
		inputParentsExperience = new JSpinner();
		okBtn = new JButton(bundle.getString("ok"));
		cancelBtn = new JButton(bundle.getString("cancel"));
		addComponents();
		
	}
	private void addComponents(){
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(okBtn);
		btnPanel.add(cancelBtn);
		mainPanel.add(inputStudentFIO);
		mainPanel.add(inputParentsFIO);
		mainPanel.add(inputWorkingAddress);
		mainPanel.add(inputParentsPost);
		mainPanel.add(inputParentsExperience);
		mainPanel.add(btnPanel);
		add(mainPanel);
	}
	
	private void initListeners(){
		okBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String studentFIO = inputStudentFIO.getText();
				String parentsFIO = inputParentsFIO.getText();
				String workingAddress = inputWorkingAddress.getText();
				String parentsPost = inputParentsPost.getText();
				int parentsExperience = Integer.parseInt(String.valueOf(inputParentsExperience.getValue()));
				
				try {
					Note note = new Note(studentFIO, parentsFIO, 
							workingAddress, parentsPost, parentsExperience);
					Client client = mainFrame.getClient();       		
					ObjectOutputStream oos = client.getOut();
					oos.writeObject(ClientCmd.add);
					oos.writeObject(mainFrame.getCurrentFileName());
					oos.writeObject(note);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
	}
	
	private void initEmptyFields(){
		inputStudentFIO.setText(bundle.getString("studfiofield"));
		inputParentsFIO.setText(bundle.getString("parentfiofield"));
		inputWorkingAddress.setText(bundle.getString("workaddrfield"));
		inputParentsPost.setText(bundle.getString("parentpostfield"));
		inputParentsExperience.setValue(Integer.parseInt(bundle.getString("parentexperfield")));
	}
	
	private void initEmptyFieldActions(){
		inputStudentFIO.addFocusListener(new EmptyFieldFocusEvent(this));
		inputParentsFIO.addFocusListener(new EmptyFieldFocusEvent(this));
		inputWorkingAddress.addFocusListener(new EmptyFieldFocusEvent(this));
		inputParentsPost.addFocusListener(new EmptyFieldFocusEvent(this));
		inputParentsExperience.addFocusListener(new EmptyFieldFocusEvent(this));
		
	}	
	
}

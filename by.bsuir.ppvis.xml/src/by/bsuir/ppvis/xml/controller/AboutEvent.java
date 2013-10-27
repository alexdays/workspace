package by.bsuir.ppvis.xml.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import by.bsuir.ppvis.xml.view.MainFrame;

public class AboutEvent implements ActionListener{
	private MainFrame mainFrame;
	private ResourceBundle bundle;
	public AboutEvent(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage());
	}
	public void actionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(mainFrame,
				bundle.getString("aboutcontent"),
			    bundle.getString("aboutdialog"),
			    JOptionPane.INFORMATION_MESSAGE,
			    null);
	}

}

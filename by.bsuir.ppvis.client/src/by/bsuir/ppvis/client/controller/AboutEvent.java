package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import by.bsuir.ppvis.client.view.ClientFrame;

public class AboutEvent implements ActionListener{
	private ClientFrame mainFrame;
	private ResourceBundle bundle;
	public AboutEvent(ClientFrame mainFrame){
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

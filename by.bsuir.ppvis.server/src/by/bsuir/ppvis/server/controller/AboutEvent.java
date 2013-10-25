package by.bsuir.ppvis.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import by.bsuir.ppvis.server.view.ServerFrame;

public class AboutEvent implements ActionListener{
	private ServerFrame mainFrame;
	private ResourceBundle bundle;
	public AboutEvent(ServerFrame mainFrame){
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

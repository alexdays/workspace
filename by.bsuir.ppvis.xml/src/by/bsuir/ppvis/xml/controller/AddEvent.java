package by.bsuir.ppvis.xml.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.xml.view.InputDialog;
import by.bsuir.ppvis.xml.view.MainFrame;

public class AddEvent implements ActionListener{
	private MainFrame mainFrame;
	public AddEvent(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		InputDialog inputDialog = new InputDialog(mainFrame);
		inputDialog.setVisible(true);
	}
}

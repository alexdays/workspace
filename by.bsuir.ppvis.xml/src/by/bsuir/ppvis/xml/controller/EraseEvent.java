package by.bsuir.ppvis.xml.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.xml.view.EraseDialog;
import by.bsuir.ppvis.xml.view.MainFrame;

public class EraseEvent implements ActionListener{
	private MainFrame mainFrame;
	public EraseEvent(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		EraseDialog eraseDialog = new EraseDialog(mainFrame);
		eraseDialog.setVisible(true);
	}
}

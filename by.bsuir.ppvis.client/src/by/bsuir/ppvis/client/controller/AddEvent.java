package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.InputDialog;

public class AddEvent implements ActionListener{
	private ClientFrame mainFrame;
	public AddEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		InputDialog inputDialog = mainFrame.getInputDialog();
		inputDialog.setVisible(true);
	}
}

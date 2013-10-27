package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.EraseDialog;

public class EraseEvent implements ActionListener{
	private ClientFrame mainFrame;
	public EraseEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		EraseDialog eraseDialog = mainFrame.getEraseDialog();
		eraseDialog.setVisible(true);
	}
}

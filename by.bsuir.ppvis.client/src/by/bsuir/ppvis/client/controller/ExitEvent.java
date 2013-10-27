package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.client.view.ClientFrame;

public class ExitEvent implements ActionListener{
	private ClientFrame mainFrame;
	public ExitEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		mainFrame.dispose();
	}
}

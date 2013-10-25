package by.bsuir.ppvis.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.server.view.ServerFrame;

public class ExitEvent implements ActionListener{
	private ServerFrame mainFrame;
	public ExitEvent(ServerFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		mainFrame.dispose();
	}
}

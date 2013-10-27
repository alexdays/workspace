package by.bsuir.ppvis.xml.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.xml.view.MainFrame;

public class ExitEvent implements ActionListener{
	private MainFrame mainFrame;
	public ExitEvent(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		mainFrame.dispose();
	}
}

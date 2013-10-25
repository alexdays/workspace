package by.bsuir.ppvis.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import by.bsuir.ppvis.server.view.ServerFrame;
import by.bsuir.ppvis.utls.Language;

public class EngBtnEvent implements ActionListener{
	private ServerFrame mainFrame;
	public EngBtnEvent(ServerFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		mainFrame.setSelectRusBtn(false);
		mainFrame.setLanguage(Language.ENG);
		mainFrame.createMenu();
	}
}

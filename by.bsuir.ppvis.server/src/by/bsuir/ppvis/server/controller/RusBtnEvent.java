package by.bsuir.ppvis.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import by.bsuir.ppvis.server.view.ServerFrame;
import by.bsuir.ppvis.utls.Language;

public class RusBtnEvent implements ActionListener{
	private ServerFrame mainFrame;
	public RusBtnEvent(ServerFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		mainFrame.setSelectEngBtn(false);
		mainFrame.setLanguage(Language.RUS);
		mainFrame.createMenu();
	}
}
package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.FindDialog;
import by.bsuir.ppvis.client.view.TablePage;
import by.bsuir.ppvis.utls.ClientCmd;

public class NextFindBtnEvent implements ActionListener{
	private ClientFrame mainFrame;
	private FindDialog findDialog;
	public NextFindBtnEvent(ClientFrame mainFrame, FindDialog findDialog){
		this.mainFrame = mainFrame;
		this.findDialog = findDialog;
	}
	public void actionPerformed(ActionEvent e){
		String docName;
		docName = mainFrame.getCurrentFileName();
		Client client = mainFrame.getClient();
		TablePage tablePage = findDialog.getTablePage();
		ObjectOutputStream oos = client.getOut();
		try {
			oos.writeObject(ClientCmd.find);
			oos.writeObject(docName);
			oos.writeObject(String.valueOf(tablePage.getPageNumber()));
			oos.writeObject(String.valueOf(tablePage.getRowCount()));
			mainFrame.setCurrentFileName(docName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}

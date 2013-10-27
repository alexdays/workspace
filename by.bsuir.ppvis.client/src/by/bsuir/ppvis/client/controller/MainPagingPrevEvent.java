package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.TablePage;
import by.bsuir.ppvis.utls.ClientCmd;

public class MainPagingPrevEvent implements ActionListener{
	private ClientFrame mainFrame;
	
	public MainPagingPrevEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		String docName;
		docName = mainFrame.getCurrentFileName();
		Client client = mainFrame.getClient();
		TablePage tablePage = mainFrame.getTablePage();
		int nextPageNumber = (tablePage.getPageNumber()-1>1)?(tablePage.getPageNumber()-1):1;
		int rowCount = tablePage.getRowCount();
		int begIndex = (nextPageNumber-1)*rowCount;
		tablePage.setPageNumber(nextPageNumber);
		tablePage.setPageNumberEdit(nextPageNumber);			
		ObjectOutputStream oos = client.getOut();
		try {
			oos.writeObject(ClientCmd.open);
			oos.writeObject(docName);
			oos.writeObject(String.valueOf((begIndex<=0)?1:begIndex));
			oos.writeObject(String.valueOf(rowCount));
			mainFrame.setCurrentFileName(docName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}

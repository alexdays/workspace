package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.TablePage;

public class OpenEvent implements ActionListener{
	private ClientFrame mainFrame;
	public OpenEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		String docName;
		docName = JOptionPane.showInputDialog("Введите имя документа: ");
		
		Client client = mainFrame.getClient();
		TablePage tablePage = mainFrame.getTablePage();
		ObjectOutputStream oos = client.getOut();
		try {
			oos.writeObject(ClientCmd.open);
			oos.writeObject(docName);
			oos.writeObject(String.valueOf(tablePage.getPageNumber()));
			oos.writeObject(String.valueOf(tablePage.getRowCount()));
			mainFrame.setCurrentFileName(docName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}

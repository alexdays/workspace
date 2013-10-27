package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.FindDialog;
import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.utls.KeyIDs;

public class FindBtnEvent implements ActionListener{
	private ClientFrame mainFrame;
	public FindBtnEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		FindDialog findDialog = mainFrame.getFindDialog();
		String inputFirst = findDialog.getInputFieldFirst().getText();
		String inputSecond = findDialog.getInputFieldSecond().getText();
		Client server = mainFrame.getClient();
		ObjectOutputStream oos = server.getOut();
		try {
			oos.writeObject(ClientCmd.find);
			oos.writeObject(mainFrame.getCurrentFileName());
			if(findDialog.getCheckerStFio().isSelected()){
				oos.writeObject(KeyIDs.STUD_FIO);
				oos.writeObject(inputFirst);    				
				oos.flush();
			} else if(findDialog.getCheckerParFioWorkAddr().isSelected()){
				oos.writeObject(KeyIDs.PARENT_FIO_WORKADDR);
				oos.writeObject(inputFirst); 
				oos.writeObject(inputSecond); 
				oos.flush();
			} else if(findDialog.getCheckerParExper().isSelected()){
				oos.writeObject(KeyIDs.PARENT_EXPER);
				oos.writeObject(inputFirst); 
				oos.writeObject(inputSecond); 
				oos.flush();
			} else if(findDialog.getCheckerStFioWorkAddr().isSelected()){
				oos.writeObject(KeyIDs.PARENT_FIO_WORKADDR);
				oos.writeObject(inputFirst); 
				oos.writeObject(inputSecond); 
				oos.flush();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

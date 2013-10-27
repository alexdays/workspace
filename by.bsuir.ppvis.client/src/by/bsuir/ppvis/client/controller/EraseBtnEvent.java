package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.EraseDialog;
import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.utls.KeyIDs;

public class EraseBtnEvent implements ActionListener{
	private ClientFrame mainFrame;
	public EraseBtnEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		EraseDialog eraseDialog = mainFrame.getEraseDialog();
		String inputFirst = eraseDialog.getInputFieldFirst().getText();
		String inputSecond = eraseDialog.getInputFieldSecond().getText();
		Client server = mainFrame.getClient();
		ObjectOutputStream oos = server.getOut();
		try {
			oos.writeObject(ClientCmd.erase);
			oos.writeObject(mainFrame.getCurrentFileName());
			if(eraseDialog.getCheckerStFio().isSelected()){
				oos.writeObject(KeyIDs.STUD_FIO);
				oos.writeObject(inputFirst);    				
				oos.flush();
			} else if(eraseDialog.getCheckerParFioWorkAddr().isSelected()){
				oos.writeObject(KeyIDs.PARENT_FIO_WORKADDR);
				oos.writeObject(inputFirst); 
				oos.writeObject(inputSecond); 
				oos.flush();
			} else if(eraseDialog.getCheckerParExper().isSelected()){
				oos.writeObject(KeyIDs.PARENT_EXPER);
				oos.writeObject(inputFirst); 
				oos.writeObject(inputSecond); 
				oos.flush();
			} else if(eraseDialog.getCheckerStFioWorkAddr().isSelected()){
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
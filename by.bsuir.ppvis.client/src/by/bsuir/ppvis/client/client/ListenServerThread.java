package by.bsuir.ppvis.client.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import by.bsuir.ppvis.general.model.Note;
import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.EraseDialog;
import by.bsuir.ppvis.client.view.FindDialog;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListenServerThread extends Thread{

	private ObjectInputStream ois;
	private ClientFrame mainFrame;
	private Client client;
	
	public ListenServerThread(Client client, ClientFrame mainFrame){
		this.client = client;
		this.mainFrame = mainFrame;
		//this.doc = mainFrame.getDocument();
	}
	
	@Override
	public void run() {
		try {
			initStreams();
			listenServer();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	private void initStreams(){
		//oos = client.getOut();
		ois = client.getIn();
	}
	private void listenServer() throws IOException, ClassNotFoundException{
		String currentCommand;
		while(true){
			currentCommand = (String)ois.readObject();
			if(currentCommand.equals(ClientCmd.open)){
				@SuppressWarnings("unchecked")
				List<Note> notes = (List<Note>)ois.readObject();
				mainFrame.redrawTable(notes);
			} else if(currentCommand.equals(ClientCmd.find)){
				@SuppressWarnings("unchecked")
				List<Note> foundedNotes = (List<Note>)ois.readObject();
				FindDialog findDialog = mainFrame.getFindDialog();
				findDialog.updateTable(foundedNotes);
			} else if(currentCommand.equals(ClientCmd.erase)){
				@SuppressWarnings("unchecked")
				List<Note> erasedNotes = (List<Note>)ois.readObject();
				EraseDialog eraseDialog = mainFrame.getEraseDialog();
				eraseDialog.updateTable(erasedNotes);
			} else if(currentCommand.equals(ClientCmd.tabledata)){
				
				
			} 
		}
		
	}

}
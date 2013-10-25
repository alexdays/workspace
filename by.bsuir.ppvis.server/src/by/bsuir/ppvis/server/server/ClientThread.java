package by.bsuir.ppvis.server.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import by.bsuir.ppvis.general.model.Note;
import by.bsuir.ppvis.server.model.Document;
import by.bsuir.ppvis.server.view.ServerFrame;
import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.utls.KeyIDs;

public class ClientThread extends Thread{

	private ServerFrame mainFrame;
	private Socket client;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Document doc;
	
	public ClientThread(ServerFrame mainFrame, Socket client){
		this.mainFrame = mainFrame;
		this.client = client;
		this.doc = mainFrame.getDocument();
	}
	
	@Override
	public void run() {
		try {
			initStreams();
			listening();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} finally{
                    try {
                        client.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    interrupt();
                }
		
	}
		
	private void initStreams() throws IOException{
		InputStream inStream = client.getInputStream();
		OutputStream outStream = client.getOutputStream();
		oos = new ObjectOutputStream(outStream);
		ois = new ObjectInputStream(inStream);
	}
	private void listening() throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException, TransformerException{
		String currentCommand;
		String fileName;
		while(true){
			currentCommand = (String)ois.readObject();
			if(currentCommand.equals(ClientCmd.add)){
				fileName = (String)ois.readObject();
				add(fileName);
			} else if(currentCommand.equals(ClientCmd.find)){
				fileName = (String)ois.readObject();
				find(fileName);
			} else if(currentCommand.equals(ClientCmd.erase)){
				fileName = (String)ois.readObject();
				erase(fileName);
			} else if(currentCommand.equals(ClientCmd.save)){
				fileName = (String)ois.readObject();
				save(fileName);
			} else if(currentCommand.equals(ClientCmd.open)){
				fileName = (String)ois.readObject();
				open(fileName);
			} else if(currentCommand.equals(ClientCmd.disconnect)){
				disconnect();
			} else if(currentCommand.equals(ClientCmd.tabledata)){
				fileName = (String)ois.readObject();
				tabledata(fileName);
			}else {
				mainFrame.appendAct(currentCommand);
			}
		}
	}
	private void add(String fileName) throws ParserConfigurationException, SAXException, IOException, TransformerException, ClassNotFoundException{
		mainFrame.appendAct("> add note processing...");
		doc.setDocName(fileName);
		Note note = (Note)ois.readObject();
		doc.addNote(note);
		mainFrame.appendAct("> note is added");
	}
	private void find(String fileName) throws NumberFormatException, IOException, ClassNotFoundException, ParserConfigurationException, SAXException, TransformerException{
		mainFrame.appendAct("> find notes processing...");
		List<Note> foundedNotes = null;
		switch((KeyIDs)ois.readObject()){
		case STUD_FIO:{
			String studentFIO = (String)ois.readObject();
			foundedNotes = doc.getDataByStFIO(studentFIO);
			break;
		}
		case PARENT_FIO_WORKADDR:{
			String parentFIO = (String)ois.readObject();
			String workingAddress = (String)ois.readObject();
			foundedNotes = doc.getDataByParFIOWorkAddr(parentFIO, workingAddress);
			break;
		}
		case PARENT_EXPER:{
			int lowEdge =Integer.parseInt((String)ois.readObject());
			int highEdge = Integer.parseInt((String)ois.readObject());
			foundedNotes = doc.getDataByParExper(lowEdge, highEdge);
			break;
		}
		case STUD_FIO_WORKADDR:{
			String studentFIO = (String)ois.readObject();
			String workingAddress = (String)ois.readObject();
			foundedNotes = doc.getDataByStFIOWorkAddr(studentFIO, workingAddress);
		}
		}
		oos.writeObject(ClientCmd.find);
		oos.writeObject(foundedNotes);
		mainFrame.appendAct("> notes are found");
		}
	private void erase(String fileName) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException, TransformerException{
		mainFrame.appendAct("> erase notes processing...");
		doc.setDocName(fileName);
		List<Note> erasedNotes = null;
		switch((KeyIDs)ois.readObject()){
		case STUD_FIO:{
			String studentFIO = (String)ois.readObject();
			erasedNotes = doc.eraseDataByStFIO(studentFIO);
			break;
		}
		case PARENT_FIO_WORKADDR:{
			String parentFIO = (String)ois.readObject();
			String workingAddress = (String)ois.readObject();
			erasedNotes = doc.eraseDataByParFIOWorkAddr(parentFIO, workingAddress);
			break;
		}
		case PARENT_EXPER:{
			int lowEdge =Integer.parseInt((String)ois.readObject());
			int highEdge = Integer.parseInt((String)ois.readObject());
			erasedNotes = doc.eraseDataByParExper(lowEdge, highEdge);
			break;
		}
		case STUD_FIO_WORKADDR:{
			String studentFIO = (String)ois.readObject();
			String workingAddress = (String)ois.readObject();
			erasedNotes = doc.eraseDataByStFIOWorkAddr(studentFIO, workingAddress);
		}
		}
		oos.writeObject(ClientCmd.erase);
		oos.writeObject(erasedNotes);
		mainFrame.appendAct("> notes are erased");
	}
	private void save(String fileName) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException, TransformerException{
		mainFrame.appendAct("> save document processing...");
		doc.setDocName(fileName);
		@SuppressWarnings("unchecked")
		List<Note> notes = (List<Note>)ois.readObject();
		doc.setNotes(notes);
		doc.saveModel();
		mainFrame.appendAct("> document is saved by name "+fileName);
	}
	private void open(String fileName) throws IOException, ParserConfigurationException, SAXException, NumberFormatException, ClassNotFoundException{
		mainFrame.appendAct("> open document processing...");
		doc.setDocName(fileName);
		int begIndex = Integer.parseInt((String)ois.readObject());
		int pageCount = Integer.parseInt((String)ois.readObject());
		List<Note> notes = doc.getRangeItems(begIndex, pageCount);
		oos.writeObject(ClientCmd.open);
		oos.writeObject(notes);
		mainFrame.appendAct("> document by name "+doc.getDocName()+" is opened");
	}
	private void disconnect() throws IOException{
		client.close();
		mainFrame.appendAct("> client is gone");
		interrupt();
	}
	private void tabledata(String fileName) throws ParserConfigurationException, SAXException, IOException{
		mainFrame.appendAct("> get params of table...");
		doc.setDocName(fileName);
		int notesCount = doc.getNotesCount();
		oos.writeObject(ClientCmd.tabledata);
		oos.writeObject(String.valueOf(notesCount));
		mainFrame.appendAct("> params are transported");
	}
}

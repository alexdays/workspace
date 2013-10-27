package by.bsuir.ppvis.client.model;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.general.model.Note;
import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.client.view.ClientFrame;

public class Document implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle;
	private ClientFrame mainFrame;
	private List<Note> notes;
	private String columnNames[];
	public Document(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
		bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage(), Locale.getDefault());
		notes = new Vector<Note>();
    }
	
	public String[] getColumnNames(){
		bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage(), Locale.getDefault());
		columnNames = new String[]{
				bundle.getString("studfio"),
				bundle.getString("parentfio"),
				bundle.getString("workingaddress"),
				bundle.getString("parentpost"),
				bundle.getString("parentexper")
			};
		return columnNames;
	}
	
	public List<Note> getData(){
		return notes;
	}
	
	public void addNote(String studentFIO, String parentsFIO, String workingAddress,
			String parentsPost, int parentsExperience) throws IOException
	{
		
		Note note = new Note(studentFIO, parentsFIO, 
				workingAddress, parentsPost, parentsExperience);
		Client client = mainFrame.getClient();       		
		ObjectOutputStream oos = client.getOut();
		oos.writeObject(ClientCmd.add);
		//oos.writeObject(docName);
		oos.writeObject(note);
		oos.flush();
	}
	
	public void eraseNote(String studentFIO){
		for(int i=0;i<notes.size();i++){
			if(notes.get(i).getStudentFIO().equals(studentFIO)){
				notes.remove(i);
			}
		}
	}

        public boolean isEmpty(){
            return (notes.isEmpty())?true:false;
        }

        public void clearModel(){
            notes.clear();
        }

	public void saveModel(String fileName) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		Client client = mainFrame.getClient();       		
		ObjectOutputStream oos = client.getOut();
		String docName = JOptionPane.showInputDialog("Введите имя документа: ");
		oos.writeObject(ClientCmd.save);
		oos.writeObject(docName);
		oos.writeObject(notes);
		oos.flush();
	}
	
	public void openModel(File file) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = f.newDocumentBuilder();
		org.w3c.dom.Document d = builder.parse(file);
		NodeList studentList = d.getElementsByTagName("student");
                notes = new Vector<Note>();
		for(int i=0;i<studentList.getLength();i++){
                    NodeList studentFields = studentList.item(i).getChildNodes();
                    Note tempNote  = new Note(studentFields.item(0).getTextContent(),studentFields.item(1).getTextContent(),
                            studentFields.item(2).getTextContent(),studentFields.item(3).getTextContent(),Integer.parseInt((String)studentFields.item(4).getTextContent()));
                    notes.add(tempNote);
                }

	}
	
	private List<Note> getNotesByStFIO(String studentFIO){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			String fullName = notes.get(i).getStudentFIO();
			String currentStudentFIO = (fullName.length()==studentFIO.length())?
					(fullName):(fullName.substring(0,studentFIO.length()));
			if(currentStudentFIO.equals(studentFIO)){
				foundedNotes.add(notes.get(i));
			}
		}
		return foundedNotes;
	}
	public List<Note> getDataByStFIO(String studentFIO){
		List<Note> list = getNotesByStFIO(studentFIO);
		return list;
	}
	
	private List<Note> getNotesByParFIOWorkAddr(String parentFIO, String workingAddress){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			String fullParentFIO = notes.get(i).getParentsFIO();
			String fullWorkingAddress = notes.get(i).getWorkingAddress();
			String currentParentFIO = (fullParentFIO.length()==parentFIO.length())?(fullParentFIO):
				(fullParentFIO.substring(0,parentFIO.length()));
			String currentWorkingAddress = (fullWorkingAddress.length()==workingAddress.length())?
					(fullWorkingAddress):(fullWorkingAddress.substring(0,workingAddress.length()));
			if(currentParentFIO.equals(parentFIO)&&
					currentWorkingAddress.equals(workingAddress)){
				foundedNotes.add(notes.get(i));
			}
		}
		return foundedNotes;
	}
	public List<Note> getDataByParFIOWorkAddr(String parentFIO, String workingAddress){
		List<Note> list = getNotesByParFIOWorkAddr(parentFIO,workingAddress);
		return list;
	}
	
	private List<Note> getNotesByParExper(int parentExper1, int parentExper2){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			int currentParentExper = notes.get(i).getParentsExperience();
			if((currentParentExper>=parentExper1)&&(currentParentExper<=parentExper2)){
				foundedNotes.add(notes.get(i));
			}
		}
		return foundedNotes;
	}
	public List<Note> getDataByParExper(int parentExper1, int parentExper2){
		List<Note> list = getNotesByParExper(parentExper1, parentExper2);
		return list;
	}
	
	private List<Note> getNotesByStFIOWorkAddr(String studentFIO, String workingAddress){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			String fullStFIO = notes.get(i).getStudentFIO();
			String fullWorkingAddress = notes.get(i).getWorkingAddress();
			String currentStFio = (fullStFIO.length()==studentFIO.length())?
					(fullStFIO):(fullStFIO.substring(0,studentFIO.length()));
			String currentWorkingAddress = (fullWorkingAddress.length()==workingAddress.length())?
					(fullWorkingAddress):(fullWorkingAddress.substring(0,workingAddress.length()));
			if(currentStFio.equals(studentFIO)&&
					currentWorkingAddress.equals(workingAddress)){
				foundedNotes.add(notes.get(i));
			}
		}
		return foundedNotes;
	}
	public List<Note> getDataByStFIOWorkAddr(String studentFIO, String workingAddress){
		List<Note> list = getNotesByStFIOWorkAddr(studentFIO,workingAddress);
		return list;
	}
	
	public List<Note> eraseDataByStFIO(String studentFIO){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			String fullName = notes.get(i).getStudentFIO();
			String currentStudentFIO = (fullName.length()==studentFIO.length())?
					(fullName):(fullName.substring(0,studentFIO.length()));
			if(currentStudentFIO.equals(studentFIO)){
				foundedNotes.add(notes.get(i));
				notes.remove(i);
			}
		}
		return foundedNotes;
	}
	
	public List<Note> eraseDataByParFIOWorkAddr(String parentFIO, String workingAddress){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			String fullParentFIO = notes.get(i).getParentsFIO();
			String fullWorkingAddress = notes.get(i).getWorkingAddress();
			String currentParentFIO = (fullParentFIO.length()==parentFIO.length())?(fullParentFIO):
				(fullParentFIO.substring(0,parentFIO.length()));
			String currentWorkingAddress = (fullWorkingAddress.length()==workingAddress.length())?
					(fullWorkingAddress):(fullWorkingAddress.substring(0,workingAddress.length()));
			if(currentParentFIO.equals(parentFIO)&&
					currentWorkingAddress.equals(workingAddress)){
				foundedNotes.add(notes.get(i));
				notes.remove(i);
			}
		}
		return foundedNotes;
	}
	public List<Note> eraseDataByParExper(int parentExper1, int parentExper2){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			int currentParentExper = notes.get(i).getParentsExperience();
			if((currentParentExper>=parentExper1)&&(currentParentExper<=parentExper2)){
				foundedNotes.add(notes.get(i));
				notes.remove(i);
			}
		}
		return foundedNotes;
	}
	public List<Note> eraseDataByStFIOWorkAddr(String studentFIO, String workingAddress){
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			String fullStFIO = notes.get(i).getStudentFIO();
			String fullWorkingAddress = notes.get(i).getWorkingAddress();
			String currentStFio = (fullStFIO.length()==studentFIO.length())?
					(fullStFIO):(fullStFIO.substring(0,studentFIO.length()));
			String currentWorkingAddress = (fullWorkingAddress.length()==workingAddress.length())?
					(fullWorkingAddress):(fullWorkingAddress.substring(0,workingAddress.length()));
			if(currentStFio.equals(studentFIO)&&
					currentWorkingAddress.equals(workingAddress)){
				foundedNotes.add(notes.get(i));
				notes.remove(i);
			}
		}
		return foundedNotes;
	}
	
	public String[][] NotesToStringArr(List<Note> list){
		String result[][] = new String[list.size()][getColumnNames().length];
		for(int i=0;i<list.size();i++){
			result[i][0] = list.get(i).getStudentFIO();
			result[i][1] = list.get(i).getParentsFIO();
			result[i][2] = list.get(i).getWorkingAddress();
			result[i][3] = list.get(i).getParentsPost();
			result[i][4] = String.valueOf(list.get(i).getParentsExperience());
		}
		return result;
	}
	
	
}

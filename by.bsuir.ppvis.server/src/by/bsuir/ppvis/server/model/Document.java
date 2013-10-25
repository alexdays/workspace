package by.bsuir.ppvis.server.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import by.bsuir.ppvis.general.model.Note;
import by.bsuir.ppvis.server.view.ServerFrame;

public class Document implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ResourceBundle bundle;
	private ServerFrame mainFrame;
	private List<Note> notes;
	private String columnNames[];
	private String docName;
	public Document(ServerFrame mainFrame){
		this.mainFrame = mainFrame;
		bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage(), Locale.getDefault());
		notes = new Vector<Note>();
    }
	
	public void setNotes(List<Note> notes){
		this.notes = notes;
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
	
	public int getNotesCount() throws ParserConfigurationException, SAXException, IOException{
		openModel();
		return notes.size();
	}
	
	
	public void setDocName(String docName){
		this.docName = docName;		
	}
	
	public String getDocName(){
		return docName;
	}
	
	public void addNote(Note note) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		if(note!=null){
			openModel();
			notes.add(note);
			saveModel();
		}
	}
	
	public void eraseNote(String studentFIO) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
		for(int i=0;i<notes.size();i++){
			if(notes.get(i).getStudentFIO().equals(studentFIO)){
				notes.remove(i);
			}
		}
		saveModel();
	}

    public boolean isEmpty(){
        return (notes.isEmpty())?true:false;
    }

    public void clearModel(){
        notes.clear();
    }

	public void saveModel() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = f.newDocumentBuilder();
		org.w3c.dom.Document d = builder.newDocument();
		Element base = d.createElement("student_base");
		d.appendChild(base);
		for(int i=0;i<notes.size();i++){
			Element student = d.createElement("student");
			base.appendChild(student);
			Element nodeStudentFIO = d.createElement("student_fio");
			nodeStudentFIO.setTextContent(notes.get(i).getStudentFIO());
			student.appendChild(nodeStudentFIO);
			
			Element nodeParentsFIO = d.createElement("parents_fio");
			nodeParentsFIO.setTextContent(notes.get(i).getParentsFIO());
			student.appendChild(nodeParentsFIO);
			
			Element nodeWorkingAddress = d.createElement("working_address");
			nodeWorkingAddress.setTextContent(notes.get(i).getWorkingAddress());
			student.appendChild(nodeWorkingAddress);
			
			Element nodeParentsPost = d.createElement("parents_post");
			nodeParentsPost.setTextContent(notes.get(i).getParentsPost());
			student.appendChild(nodeParentsPost);
			
			Element nodeParentsExperience = d.createElement("parents_experience");
			nodeParentsExperience.setTextContent(String.valueOf(notes.get(i).getParentsExperience()));
			student.appendChild(nodeParentsExperience);
			
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(d);
        StreamResult result =  new StreamResult(new File(docName));
		transformer.transform(source, result);
	}
	
	public List<Note> openModel() throws ParserConfigurationException, SAXException, IOException{
		File file = new File(docName);
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
		return notes;

	}
	
	public List<Note> getRangeItems(int beg, int pageCount) throws ParserConfigurationException, SAXException, IOException{
		File file = new File(docName);
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = f.newDocumentBuilder();
		org.w3c.dom.Document d = builder.parse(file);
		NodeList studentList = d.getElementsByTagName("student");
        notes = new Vector<Note>();
        int studentListCount = studentList.getLength();
        for(int i=beg-1;i<beg+pageCount;i++){
			 Note tempNote = null;
	             if(i<studentListCount){
	            	 NodeList studentFields = studentList.item(i).getChildNodes();
		             tempNote  = new Note(
		            		 		studentFields.item(0).getTextContent(),
		                    		studentFields.item(1).getTextContent(),
		                            studentFields.item(2).getTextContent(),
		                            studentFields.item(3).getTextContent(),
		                            Integer.parseInt((String)studentFields.item(4).getTextContent()));
	             }
	             notes.add(tempNote);
	           	} 
        return notes;
       
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
	public List<Note> getDataByStFIO(String studentFIO) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
		List<Note> list = getNotesByStFIO(studentFIO);
		saveModel();
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
	public List<Note> getDataByParFIOWorkAddr(String parentFIO, String workingAddress) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
		List<Note> list = getNotesByParFIOWorkAddr(parentFIO,workingAddress);
		saveModel();
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
	public List<Note> getDataByParExper(int parentExper1, int parentExper2) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
		List<Note> list = getNotesByParExper(parentExper1, parentExper2);
		saveModel();
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
	public List<Note> getDataByStFIOWorkAddr(String studentFIO, String workingAddress) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
		List<Note> list = getNotesByStFIOWorkAddr(studentFIO,workingAddress);
		saveModel();
		return list;
	}
	
	public List<Note> eraseDataByStFIO(String studentFIO) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
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
		saveModel();
		return foundedNotes;
	}
	
	public List<Note> eraseDataByParFIOWorkAddr(String parentFIO, String workingAddress) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
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
		saveModel();
		return foundedNotes;
	}
	public List<Note> eraseDataByParExper(int parentExper1, int parentExper2) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
		List<Note> foundedNotes = new Vector<Note>();
		for(int i=0;i<notes.size();i++){
			int currentParentExper = notes.get(i).getParentsExperience();
			if((currentParentExper>=parentExper1)&&(currentParentExper<=parentExper2)){
				foundedNotes.add(notes.get(i));
				notes.remove(i);
			}
		}
		saveModel();
		return foundedNotes;
	}
	public List<Note> eraseDataByStFIOWorkAddr(String studentFIO, String workingAddress) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		openModel();
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
		saveModel();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Note;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class service {

    public static final String DB_FILE_PATH = "G:/workspace/concepts.xml";
    private List<Note> noteList;
    
    public List<String> getAllConcepts() throws ParserConfigurationException, SAXException, IOException, TransformerException{
        noteList = openModel();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<noteList.size();i++){
           list.add(noteList.get(i).getName());
        }
        return list;
    }
    public void addConcept(String name, String content) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        noteList = openModel();
        Note addedNote = new Note(name, content);
        noteList.add(addedNote);
        saveModel();
    }
    public String getConceptContent(String conceptName) throws ParserConfigurationException, SAXException, IOException{
        noteList = openModel();
        for(int i=0;i<noteList.size();i++){
            Note tmp = noteList.get(i);
            String name = tmp.getName();
            if(name.equals(conceptName)){
                return tmp.getContent();
            }
        }
        return null;
    }
    public void changeConcept(String conceptName, String content) throws ParserConfigurationException, SAXException, IOException, IOException, TransformerException{
         noteList = openModel();
         for(int i=0;i<noteList.size();i++){
            Note tmp = noteList.get(i);
            String name;
            name = tmp.getName();
            if(name.equals(conceptName)){
                Note n = new Note(conceptName, content);
                noteList.set(i, n);
            }
         }
        saveModel();
    }
    public void eraseConcept(String conceptName) throws ParserConfigurationException, SAXException, IOException, TransformerException{
         noteList = openModel();
         for(int i=0;i<noteList.size();i++){
            Note tmp = noteList.get(i);
            String name = tmp.getName();
            if(name.equals(conceptName)){
                noteList.remove(i);
                break;
            }
         }
        saveModel();
    }
    private void saveModel() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = f.newDocumentBuilder();
		org.w3c.dom.Document d = builder.newDocument();
		Element concepts = d.createElement("concepts");
		d.appendChild(concepts);
		for(int i=0;i<noteList.size();i++){
			Element concept = d.createElement("concept");
			concepts.appendChild(concept);
                        
			Element nodeName = d.createElement("name");
			nodeName.setTextContent(noteList.get(i).getName());
			concept.appendChild(nodeName);
			
			Element nodeContent = d.createElement("content");
			nodeContent.setTextContent(noteList.get(i).getContent());
			concept.appendChild(nodeContent);	
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(d);
                StreamResult result =  new StreamResult(new File(DB_FILE_PATH));
		transformer.transform(source, result);
	}
	
	private List<Note> openModel() throws ParserConfigurationException, SAXException, IOException{
		File file = new File(DB_FILE_PATH);
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = f.newDocumentBuilder();
		org.w3c.dom.Document d = builder.parse(file);
		NodeList conceptList = d.getElementsByTagName("concept");
                noteList = new Vector<Note>();
		for(int i=0;i<conceptList.getLength();i++){
                    NodeList conceptFields = conceptList.item(i).getChildNodes();
                    String name = conceptFields.item(0).getTextContent();
                    String content = conceptFields.item(1).getTextContent();
                    Note tempNote  = new Note(name,content);
                    noteList.add(tempNote);
                }
		return noteList;

	}        
   
}

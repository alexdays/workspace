package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import by.bsuir.ppvis.client.view.ClientFrame;

public class SaveEvent implements ActionListener{
	private ClientFrame mainFrame;
	public SaveEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		if(mainFrame.getCurrentFileName().isEmpty()){
			(new SaveasEvent(mainFrame)).actionPerformed(e);
		} else {
			try {
				mainFrame.getDocument().saveModel(mainFrame.getCurrentFileName());
			} catch (ParserConfigurationException e1) {
				e1.printStackTrace();
			} catch (SAXException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (TransformerException e1) {
				e1.printStackTrace();
			}
		}
	}

}

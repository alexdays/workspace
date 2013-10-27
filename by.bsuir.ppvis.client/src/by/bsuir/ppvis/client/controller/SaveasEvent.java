package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import by.bsuir.ppvis.client.view.ClientFrame;

public class SaveasEvent implements ActionListener{
	private ClientFrame mainFrame;
	public SaveasEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		JFileChooser saveDialog = new JFileChooser();
		if(saveDialog.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
			File file = saveDialog.getSelectedFile();
			mainFrame.setCurrentFileName(file.getAbsolutePath());
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

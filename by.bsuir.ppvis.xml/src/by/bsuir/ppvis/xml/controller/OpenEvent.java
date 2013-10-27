package by.bsuir.ppvis.xml.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.bsuir.ppvis.xml.view.MainFrame;

public class OpenEvent implements ActionListener{
	private MainFrame mainFrame;
	public OpenEvent(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		JFileChooser openDialog = new JFileChooser();
		if(openDialog.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File file = openDialog.getSelectedFile();
                        mainFrame.setCurrentFileName(file.getAbsolutePath());
			try {
				mainFrame.getDocument().openModel(file);
                mainFrame.redrawTable();
			} catch (ParserConfigurationException e1) {
				e1.printStackTrace();
			} catch (SAXException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}

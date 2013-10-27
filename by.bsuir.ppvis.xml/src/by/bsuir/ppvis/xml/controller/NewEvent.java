package by.bsuir.ppvis.xml.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import by.bsuir.ppvis.xml.view.MainFrame;

public class NewEvent implements ActionListener{
	private MainFrame mainFrame;
	public NewEvent(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		if(!mainFrame.getDocument().isEmpty()){
			ResourceBundle bundle = ResourceBundle.getBundle(mainFrame.getCurrentLanguage());
            	int result = JOptionPane.showConfirmDialog(mainFrame,
        				bundle.getString("savemsgcontent"),
        			    bundle.getString("savemsgtitle"),
        			    JOptionPane.YES_NO_CANCEL_OPTION
        			    );
            	switch(result){
            	case 1:{
            		 mainFrame.getDocument().clearModel();
                     mainFrame.clearTable();
            		break;
            	}
            	case 0:{
            		(new SaveasEvent(mainFrame)).actionPerformed(e);
                    mainFrame.getDocument().clearModel();
                    mainFrame.clearTable();
                    break;
            	}
            	case 2:{}
            	}
               
            }
	}
}

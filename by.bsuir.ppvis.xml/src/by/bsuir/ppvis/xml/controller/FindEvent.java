/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.ppvis.xml.controller;

import by.bsuir.ppvis.xml.view.FindDialog;
import by.bsuir.ppvis.xml.view.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindEvent implements ActionListener{
	private MainFrame mainFrame;
	public FindEvent(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		FindDialog findDialog = new FindDialog(mainFrame);
		findDialog.setVisible(true);
	}
}
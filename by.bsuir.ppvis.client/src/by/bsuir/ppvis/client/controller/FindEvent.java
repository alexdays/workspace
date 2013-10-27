/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.ppvis.client.controller;

import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.FindDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindEvent implements ActionListener{
	private ClientFrame mainFrame;
	public FindEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		FindDialog findDialog = mainFrame.getFindDialog();
		findDialog.setVisible(true);
	}
}
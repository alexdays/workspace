package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.TablePage;


public class ErasePagingNextEvent implements ActionListener{
	private ClientFrame mainFrame;
	
	public ErasePagingNextEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		TablePage tablePage = mainFrame.getEraseDialog().getTablePage();
		int pageNumber = tablePage.getPageNumber();
		int rowCount = tablePage.getRowCount();
		tablePage.setPageNumber(pageNumber+1);
		tablePage.setBegIndex((pageNumber-1)*rowCount);
		tablePage.setPageNumber(pageNumber+1);
		tablePage.update();		
	}

}

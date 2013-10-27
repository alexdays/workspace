package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.TablePage;


public class FindPagingNextEvent implements ActionListener{
	private ClientFrame mainFrame;
	
	public FindPagingNextEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		TablePage tablePage = mainFrame.getFindDialog().getTablePage();
		int pageNumber = tablePage.getPageNumber();
		int rowCount = tablePage.getRowCount();
		tablePage.setPageNumber(pageNumber+1);
		tablePage.setBegIndex((pageNumber-1)*rowCount);
		tablePage.setPageNumber(pageNumber+1);
		
		(new FindBtnEvent(mainFrame)).actionPerformed(e);
		
	}

}
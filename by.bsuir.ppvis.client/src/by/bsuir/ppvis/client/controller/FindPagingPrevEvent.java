package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.client.view.ClientFrame;
import by.bsuir.ppvis.client.view.TablePage;

public class FindPagingPrevEvent implements ActionListener{
	private ClientFrame mainFrame;
	
	public FindPagingPrevEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		TablePage tablePage = mainFrame.getFindDialog().getTablePage();
		int pageNumber = tablePage.getPageNumber();
		int rowCount = tablePage.getRowCount();
		int currentPageNumber = (pageNumber-1>1)?(pageNumber-1):1;
		tablePage.setPageNumber(currentPageNumber);
		tablePage.setBegIndex((pageNumber-1)*rowCount);
		tablePage.setPageNumber(currentPageNumber);
		
		(new FindBtnEvent(mainFrame)).actionPerformed(e);
	}

}
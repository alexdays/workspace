package by.bsuir.aipos.smtp_server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import by.bsuir.aipos.smtp_server.model.Account;
import by.bsuir.aipos.smtp_server.view.MainFrame;

public class CreateAccountBtnClick implements ActionListener{
	
	private MainFrame mainFrame;
	public CreateAccountBtnClick(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String email = mainFrame.getEmailField().getText();
		String password = mainFrame.getPasswordField().getText();
		List<Account> accountList = mainFrame.getAccountList();
		Account account = new Account(email, password);
		accountList.add(account);
	}

}

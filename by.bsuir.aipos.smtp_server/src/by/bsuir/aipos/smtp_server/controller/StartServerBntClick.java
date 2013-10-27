package by.bsuir.aipos.smtp_server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import by.bsuir.aipos.smtp_server.model.Server;

public class StartServerBntClick implements ActionListener{
	private Server server;
	public StartServerBntClick(Server server){
		this.server = server;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

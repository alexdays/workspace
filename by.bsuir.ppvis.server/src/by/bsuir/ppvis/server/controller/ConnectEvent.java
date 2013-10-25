package by.bsuir.ppvis.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import by.bsuir.ppvis.server.server.Server;
import by.bsuir.ppvis.server.view.ServerFrame;

public class ConnectEvent implements ActionListener{
	private ServerFrame mainFrame;
	public ConnectEvent(ServerFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		Server server = mainFrame.getServer();
		try {
			server.start();
			server.listenClient();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

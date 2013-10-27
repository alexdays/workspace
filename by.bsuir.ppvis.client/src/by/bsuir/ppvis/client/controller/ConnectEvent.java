package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.view.ClientFrame;

public class ConnectEvent implements ActionListener{
	private ClientFrame mainFrame;
	public ConnectEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		Client client = mainFrame.getClient();
		try {
			client.start();
			client.listenClient();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException w) {
			w.printStackTrace();
		}
	}
}

package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import by.bsuir.ppvis.client.client.Client;
import by.bsuir.ppvis.client.view.ClientFrame;

public class DisconnectEvent implements ActionListener{
	private ClientFrame mainFrame;
	public DisconnectEvent(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public void actionPerformed(ActionEvent e){
		try {
			Client client = mainFrame.getClient();
			client.destroyServerThread();
			client.stop();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
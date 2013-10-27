package by.bsuir.aipos.smtp_server.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import by.bsuir.aipos.smtp_server.view.MainFrame;

public class POP3Server{
	private ServerSocket pop3server;
	private MainFrame mainFrame;
	public POP3Server(MainFrame mainFrame) throws IOException{
		pop3server = new ServerSocket(110);
		this.mainFrame = mainFrame;
	}
	public void start(){
		POP3ClientProcessing p3c = new POP3ClientProcessing(this,mainFrame);
		p3c.start();
	}
	public Socket accept() throws IOException{
		return pop3server.accept();
	}
}

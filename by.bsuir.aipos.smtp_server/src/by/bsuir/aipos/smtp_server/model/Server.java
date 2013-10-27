package by.bsuir.aipos.smtp_server.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import by.bsuir.aipos.smtp_server.view.MainFrame;

public class Server {
	private ServerSocket server;
	private SMTPClientProcessing pct;
	private MainFrame mainFrame;
	public Server(int port, MainFrame mainFrame) throws IOException{
		server = new ServerSocket(port);
		this.mainFrame = mainFrame;
	}
	public void start() throws IOException{
		pct = new SMTPClientProcessing(this, mainFrame);
		pct.start();
	}
	public void stop() throws IOException{
		if(pct.isAlive()){
			pct.interrupt();
			server.close();
		}
	}
	public Socket accept() throws IOException{
		return server.accept();
	}
}

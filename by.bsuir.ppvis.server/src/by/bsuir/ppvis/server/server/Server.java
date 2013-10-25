package by.bsuir.ppvis.server.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import by.bsuir.ppvis.server.view.ServerFrame;

public class Server{
	public static final int DEFAULT_PORT = 4444;
	
	private ServerSocket server;
	private List<Socket> clients;
	private ServerFrame mainFrame;
	
	public Server(ServerFrame mainFrame){
		this.mainFrame = mainFrame;
		this.clients = new Vector<Socket>();
	}
	public void start() throws IOException{
		server = new ServerSocket(DEFAULT_PORT);
	}
	public void start(int port) throws IOException{
		server = new ServerSocket(port);
	}
	public void stop() throws IOException{
		server.close();
		if(server.isClosed()) mainFrame.appendAct("> server is closed");
		else mainFrame.appendAct("> can't close server");
	}
	public void listenClient(){
		ClientQueryThread clientThread = new ClientQueryThread(this, mainFrame);
		clientThread.start();
	}
	public ServerSocket getServerSocket(){
		return server;
	}
	public void appendClient(Socket client){
		clients.add(client);
	}
	public List<Socket> getClientList(){
		return clients;
	}
		
}

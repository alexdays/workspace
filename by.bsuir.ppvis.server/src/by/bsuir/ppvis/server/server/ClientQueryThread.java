package by.bsuir.ppvis.server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import by.bsuir.ppvis.server.view.ServerFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientQueryThread extends Thread{

	private ServerFrame mainFrame;
	private Server server;
	private Socket client;
		
	public ClientQueryThread(Server server, ServerFrame mainFrame){
		this.server = server;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void run() {
		try {
			waitClient();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
                    try {
                        server.stop();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientQueryThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    interrupt();
                }
		
	}
	
	private void waitClient() throws IOException{
		ServerSocket serverSocket = server.getServerSocket();
		mainFrame.appendAct("> server is started");
		while(true){
			client = serverSocket.accept();
			server.appendClient(client);
			(new ClientThread(mainFrame, client)).start();
			mainFrame.appendAct("> "+server.getClientList().size()+"th client is connected");
		}
		
	}
		
}

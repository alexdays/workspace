package by.bsuir.ppvis.client.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import by.bsuir.ppvis.utls.ClientCmd;
import by.bsuir.ppvis.client.view.ClientFrame;

public class Client {
	
public static final String DEFAULT_HOST = "localhost";
public static final int DEFAULT_PORT = 4444;

private Socket server;
private InputStream inStream;
private OutputStream outStream;
private ObjectInputStream in;
private ObjectOutputStream out;
private ClientFrame mainFrame;
private ListenServerThread clientQueryThread;

public Client(ClientFrame mainFrame){
	this.mainFrame = mainFrame;
}
public void start() throws IOException, ClassNotFoundException{
	server = new Socket("localhost", DEFAULT_PORT);
	inStream = server.getInputStream();
	outStream = server.getOutputStream();
	
	out = new ObjectOutputStream(outStream);	
	in = new ObjectInputStream(inStream);
	
}
public void start(int port) throws IOException{
	server = new Socket(DEFAULT_HOST, port);
	out = new ObjectOutputStream(server.getOutputStream());
	in = new ObjectInputStream(server.getInputStream());	
}
public void stop() throws IOException{
	out.writeObject(ClientCmd.disconnect);
	server.close();
}
public void setIOStreams(ObjectInputStream inStream, ObjectOutputStream outStream){
	in = inStream;
	out = outStream;
}
public void listenClient(){
	clientQueryThread = new ListenServerThread(this,mainFrame);
	clientQueryThread.start();
}
public ObjectInputStream getIn(){
	return in;
}
public ObjectOutputStream getOut(){
	return out;
}
public Socket getSocket(){
	return server;
}
public void destroyServerThread(){
	clientQueryThread.interrupt();
}
}

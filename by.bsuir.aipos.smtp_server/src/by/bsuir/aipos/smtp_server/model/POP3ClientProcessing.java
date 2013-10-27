package by.bsuir.aipos.smtp_server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import by.bsuir.aipos.smtp_server.view.MainFrame;

public class POP3ClientProcessing extends Thread{
	private MainFrame mainFrame;
	private POP3Server pop3server;
	private BufferedReader in;
	private PrintWriter out;
	public POP3ClientProcessing(POP3Server pop3server, MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.pop3server = pop3server;
	}
	public void run(){
		Socket client;
		try {
				client = pop3server.accept();
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream());
				out.write("+OK server is connected");
				mainFrame.appendLine("+OK server is connected");
				String cmd, user = "";
				boolean isAccess = false;
				while(true){
					cmd = in.readLine();
					mainFrame.appendLine(cmd);
					if(cmd.contains("USER")){
						user = cmd.replace("USER ", "");
						if(mainFrame.isAccount(user)){
							out.write("+OK");
							mainFrame.appendLine("+OK");
							String pass_ = in.readLine();
							mainFrame.appendLine(pass_);
							String pass = pass_.replace("PASS ", "");
							if(mainFrame.getAccount(user).passVerify(pass)){
								out.write("+OK");
								mainFrame.appendLine("+OK");
								isAccess = true;
							} else {
								out.write("-ERR");	
								mainFrame.appendLine("-ERR");
							}
						} else {
							out.write("-ERR");
							mainFrame.appendLine("-ERR");
						}
					} else if(cmd.contains("APOP")){
						out.write("+OK");
					} else if(cmd.contains("STAT")){
						if(isAccess){
							Account account = mainFrame.getAccount(user);
							int msgCount = account.getMsgCount();
							int octets = account.getOctets();
							out.write("+OK "+msgCount+" "+octets);
							mainFrame.appendLine("+OK "+msgCount+" "+octets);
						} else {
							out.write("-ERR");
							mainFrame.appendLine("-ERR");
						}
					} else if(cmd.contains("LIST")){
						if(isAccess){
							Account account = mainFrame.getAccount(user);
							int msgCount = account.getMsgCount();
							int octats = account.getOctets();
							out.write("+OK "+msgCount+" messages ("+octats+" octets)");
							mainFrame.appendLine("+OK "+msgCount+" messages ("+octats+" octets)");
							for(int i=0;i<msgCount;i++){
								out.write((i+1)+" "+account.getMsgByIndex(i).getOctets());
								mainFrame.appendLine(i+" "+account.getMsgByIndex(i).getOctets());
							}
						} else {
							out.write("-ERR");
							mainFrame.appendLine("-ERR");
						}
					} else if(cmd.contains("RETR")){
						if(isAccess){
							int msgNumber = Integer.parseInt(cmd.replace("RETR ", ""));
							Account account = mainFrame.getAccount(user);
							Msg msg = account.getMsgByIndex(msgNumber-1);
							int octets = msg.getOctets();
							out.write("+OK "+octets+" octets");
							mainFrame.appendLine("+OK "+octets+" octets");
							out.write(msg.getText());
							mainFrame.appendLine(msg.getText());
							out.write(".");
							mainFrame.appendLine(".");
						} else {
							out.write("-ERR");
							mainFrame.appendLine("-ERR");
						}
					} else if(cmd.contains("DELE")){
						if(isAccess){
							int msgNumber = Integer.parseInt(cmd.replace("DELE ", ""));
							Account account = mainFrame.getAccount(user);
							account.eraseMsg(msgNumber-1);
							out.write("+OK");
							mainFrame.appendLine("+OK");
						} else {
							out.write("-ERR");
							mainFrame.appendLine("-ERR");
						}
					} else if(cmd.contains("QUIT")){
						in.close();
						out.close();
						client.close();
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}

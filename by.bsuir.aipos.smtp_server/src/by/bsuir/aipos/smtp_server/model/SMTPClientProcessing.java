package by.bsuir.aipos.smtp_server.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import by.bsuir.aipos.smtp_server.view.MainFrame;

public class SMTPClientProcessing extends Thread{
	private Server server;
	private BufferedReader in;
	private PrintWriter out;
	private MainFrame mainFrame;
	public SMTPClientProcessing(Server server, MainFrame mainFrame){
		this.server = server;
		this.mainFrame = mainFrame;
	}
	private void save(String from, String to, String data){
		Msg msg = new Msg(from, to, data);
		Account account = mainFrame.getAccount(to);
		if(account!=null) {
			account.appendMsg(msg);
		}
	}
	public void run(){
		Socket client = null;
		try {
			client = server.accept();
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		out.write("220");
		mainFrame.appendLine("220 connect");
		String cmd;
		String from = "", to = "", data = "";
		Pattern pat = Pattern.compile("[a-zA-Z_\\.]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}");
		int i = 0;
		while(true){
			try {
				cmd = in.readLine();
				mainFrame.appendLine(cmd);
				if(cmd.contains("EHLO")){
					++i;
					out.write("530 make HELO");
					mainFrame.appendLine("530 make HELO");
				} else if(cmd.contains("HELO")){
					++i;
					out.write("250 ok");
					mainFrame.appendLine("250 HELLO ok");
				}else if(cmd.contains("MAIL")){
					Matcher matcher = pat.matcher(cmd);
					if(matcher.find()){
						from = matcher.group();
					} else ;
					++i;
					out.write("250 Sender ok");
					mainFrame.appendLine("250 <"+from+"> Sender ok");
				} else if(cmd.contains("RCPT")){
					Matcher matcher = pat.matcher(cmd);
					if(matcher.find()){
						to = matcher.group();
						if(mainFrame.isAccount(to)){
							out.write("250 <"+to+"> Recipient ok");
							mainFrame.appendLine("250 <"+to+"> Recipient ok");
						} else {
							out.write("530 Recipient<"+to+"> not found");
							mainFrame.appendLine("530 Recipient<"+to+"> not found");
						}
					} else ;
					++i;					
				} else if(cmd.contains("DATA")){
					out.write("354");
					mainFrame.appendLine("354");
					String t, text = "";					
					while((t=in.readLine())!=null){
						if(t.equals(".")){
							mainFrame.appendLine(text);
							save(from, to, text);
							break;
						} else text += t+"\r\n";
					}	
					out.write("250 OK");
					mainFrame.appendLine("250 OK");
					++i;
				} else if(cmd.contains("QUIT")){
					out.write("221");
					in.close();
					out.close();
					client.close();
					break;
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
		
}

package by.bsuir.aipos.smtp_server.model;

import java.util.List;
import java.util.Vector;

public class Account {
	private List<Msg> msgList;
	private String email;
	private String password;
	public Account(String email, String password){
		this.email = email;
		this.password = password;
		msgList = new Vector<Msg>();
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void appendMsg(String from, String to, String text){
		Msg msg = new Msg(from,to,text);
		msgList.add(msg);
	}
	public void appendMsg(Msg msg){
		msgList.add(msg);
	}
	public List<Msg> getMsgList(){
		return msgList;
	}
	public boolean passVerify(String pass){
		return (pass.equals(this.password))?true:false;
	}
	public int getMsgCount(){
		return msgList.size();
	}
	public Msg getMsgByIndex(int i){
		return msgList.get(i);
	}
	public int getOctets(){
		int octets = 0;
		for(int i=0;i<getMsgCount();i++){
			octets+=getMsgByIndex(i).getOctets();
		}
		return octets;
	}
	public void eraseMsg(int i){
		msgList.remove(i);
	}
}

package by.bsuir.aipos.smtp_server.model;

public class Msg {
	private String from;
	private String to;
	private String text;
	
	public Msg(String from, String to, String text){
		this.from = from;
		this.to = to;
		this.text = text;
	}
	

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOctets(){
		return text.getBytes().length;
	}
	
	
}

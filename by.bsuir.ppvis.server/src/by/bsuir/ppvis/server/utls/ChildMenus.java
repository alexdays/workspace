package by.bsuir.ppvis.server.utls;

import javax.swing.ImageIcon;


public enum ChildMenus {
	EXIT("exit", new ImageIcon("icon24\\exit.png")), 
	ABOUT("about", new ImageIcon("icon24\\about.png")),
	CONNECT("connect", new ImageIcon("icon24\\connect.png")),
	DISCONNECT("disconnect", new ImageIcon("icon24\\disconnect.png"));
	
	private String label;
	private ImageIcon icon;
	
	private ChildMenus(String label, ImageIcon icon){
		this.label = label;
		this.icon = icon;
	}
	public String getLabel(){
		return label;
	}
	public ImageIcon getIcon(){
		return icon;
	}
}

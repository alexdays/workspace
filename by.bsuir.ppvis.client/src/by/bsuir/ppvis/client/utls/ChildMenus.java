package by.bsuir.ppvis.client.utls;

import javax.swing.ImageIcon;


public enum ChildMenus {
	OPEN("open", new ImageIcon("icon24\\open.png")),
	SAVE("save", new ImageIcon("icon24\\save.png")),
	EXIT("exit", new ImageIcon("icon24\\exit.png")), 
	ADD("add", new ImageIcon("icon24\\add.png")),
	FIND("find", new ImageIcon("icon24\\find.png")),
	ERASE("erase", new ImageIcon("icon24\\erase.png")),    
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

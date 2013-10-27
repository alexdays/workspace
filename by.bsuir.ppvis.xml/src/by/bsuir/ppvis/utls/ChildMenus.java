package by.bsuir.ppvis.utls;

import javax.swing.ImageIcon;


public enum ChildMenus {
	NEW("new", new ImageIcon("icon24\\new.png")), 
	OPEN("open", new ImageIcon("icon24\\open.png")),
	SAVE("save", new ImageIcon("icon24\\save.png")),
	SAVEAS("saveas",new ImageIcon("icon24\\saveas.png")), 
	EXIT("exit", new ImageIcon("icon24\\exit.png")), 
	ADD("add", new ImageIcon("icon24\\add.png")),
	FIND("find", new ImageIcon("icon24\\find.png")),
	ERASE("erase", new ImageIcon("icon24\\erase.png")),    
	ABOUT("about", new ImageIcon("icon24\\about.png"));
	
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

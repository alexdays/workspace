package by.bsuir.ppvis.utls;

import javax.swing.ImageIcon;


public enum ChildMenus {
	NEW("new", new ImageIcon("icon24\\new.png")), 
	OPEN("open", new ImageIcon("icon24\\open.png")),
	SAVE("save", new ImageIcon("icon24\\save.png")),
	SAVEAS("saveas",new ImageIcon("icon24\\saveas.png")), 
	EXIT("exit", new ImageIcon("icon24\\exit.png")), 
	COPY("copy", new ImageIcon("icon24\\copy.png")),
	CUT("cut", new ImageIcon("icon24\\cut.png")), 
	PASTE("paste", new ImageIcon("icon24\\paste.png")),
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

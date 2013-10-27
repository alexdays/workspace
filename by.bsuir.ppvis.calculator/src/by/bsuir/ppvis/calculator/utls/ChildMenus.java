package by.bsuir.ppvis.calculator.utls;

import javax.swing.ImageIcon;


public enum ChildMenus {
	EXIT("exit", null), 
	CLEAR("clear", null),
	INGENER("ingener", null),
	DEFAULT("default", null),    
	ABOUT("about", null);
	
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

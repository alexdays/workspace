package by.bsuir.ppvis.calculator.utls;

import java.util.List;
import java.util.Vector;

public enum MainMenuEnum {
	MAIN("main", ChildMenus.EXIT),
	VIEW("view", ChildMenus.CLEAR, ChildMenus.DEFAULT, ChildMenus.INGENER),
	ABOUT("about", ChildMenus.ABOUT);
	
	
	private String menuLabel;
	private List<ChildMenus> childMenus;
	private MainMenuEnum(String menuLabel, ChildMenus... menus){
		this.menuLabel = menuLabel;
		childMenus = new Vector<ChildMenus>();
		for(int i=0;i<menus.length;i++){
			childMenus.add(i, menus[i]);
		}
	}
	
	public String getLabel(){
		return menuLabel;
	}
	
	public List<ChildMenus> getChildList(){
		return childMenus;
	}
}

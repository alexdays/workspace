package by.bsuir.ppvis.client.utls;

import java.util.List;
import java.util.Vector;

import by.bsuir.ppvis.client.utls.ChildMenus;

public enum MainMenuEnum {
	FIlE("file", ChildMenus.OPEN,ChildMenus.SAVE, ChildMenus.EXIT),
	EDIT("edit", ChildMenus.ADD, ChildMenus.FIND, ChildMenus.ERASE),
	CONNECT("connect", ChildMenus.CONNECT, ChildMenus.DISCONNECT),
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

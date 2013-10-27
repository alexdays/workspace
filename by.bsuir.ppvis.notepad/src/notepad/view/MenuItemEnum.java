package notepad.view;

import java.util.List;
import java.util.Vector;

import by.bsuir.ppvis.utls.ChildMenus;
import by.bsuir.ppvis.utls.MenuItemInterface;

public enum MenuItemEnum implements MenuItemInterface{
	FIlE("file", ChildMenus.NEW, ChildMenus.OPEN,ChildMenus.SAVE, ChildMenus.SAVEAS, ChildMenus.EXIT),
	EDIT("edit", ChildMenus.COPY, ChildMenus.CUT, ChildMenus.PASTE),
	ABOUT("about", ChildMenus.ABOUT);
	
	
	private String menuLabel;
	private List<ChildMenus> childMenus;
	private MenuItemEnum(String menuLabel, ChildMenus... menus){
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

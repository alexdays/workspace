package by.bsuir.ppvis.xml.controller;

import java.awt.event.ActionListener;
import by.bsuir.ppvis.xml.view.MainFrame;
import by.bsuir.ppvis.utls.ChildMenus;

public class Controller{
	private MainFrame mainFrame;
	public Controller(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public ActionListener getListener(ChildMenus i){
		switch(i){
			case NEW: {
				return new NewEvent(mainFrame);				
			}
			case OPEN: {
				return new OpenEvent(mainFrame);
			}
			case SAVE: {
				return new SaveEvent(mainFrame);
			}
			case SAVEAS: {
				return new SaveasEvent(mainFrame);
			}
			case EXIT: {
				return new ExitEvent(mainFrame);
			}
			case ERASE: {
				return new EraseEvent(mainFrame);
			}
                        case FIND: {
				return new FindEvent(mainFrame);
			}
			case ADD: {
				return new AddEvent(mainFrame);
			}
			case ABOUT: {
				return new AboutEvent(mainFrame);
			}
			default:{
				throw new NullPointerException();
			}
		}		
	}	
}

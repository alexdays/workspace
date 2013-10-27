package by.bsuir.ppvis.client.controller;

import java.awt.event.ActionListener;

import by.bsuir.ppvis.client.utls.ChildMenus;
import by.bsuir.ppvis.client.view.ClientFrame;

public class Controller{
	private ClientFrame mainFrame;
	public Controller(ClientFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public ActionListener getListener(ChildMenus i){
		switch(i){
			case OPEN: {
				return new OpenEvent(mainFrame);
			}
			case SAVE: {
				return new SaveEvent(mainFrame);
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
			case CONNECT: {
				return new ConnectEvent(mainFrame);
			}
			case DISCONNECT: {
				return new DisconnectEvent(mainFrame);
			}
			default:{
				throw new NullPointerException();
			}
		}		
	}	
}

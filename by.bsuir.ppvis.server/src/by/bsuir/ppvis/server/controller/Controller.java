package by.bsuir.ppvis.server.controller;

import java.awt.event.ActionListener;

import by.bsuir.ppvis.server.utls.ChildMenus;
import by.bsuir.ppvis.server.view.ServerFrame;

public class Controller{
	private ServerFrame mainFrame;
	public Controller(ServerFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	public ActionListener getListener(ChildMenus i){
		switch(i){
			
			case EXIT: {
				return new ExitEvent(mainFrame);
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

package by.bsuir.ppvis.calculator.utls;

import javax.swing.JMenu;

import by.bsuir.ppvis.calculator.controller.Controller;

public class MenuCreater {
	public static JMenu createMenu(TopOperEnum e, Controller controller){
		JMenu menu = new JMenu(e.getLabel());
		menu.addActionListener(controller.getListener(e));
		return menu;
	}
	public static JMenu createMenu(CenterOperEnum e, Controller controller){
		JMenu menu = new JMenu(e.getLabel());
		menu.addActionListener(controller.getListener(e));
		return menu;
	}
	public static JMenu createMenu(BottomOperEnum e, Controller controller){
		JMenu menu = new JMenu(e.getLabel());
		menu.addActionListener(controller.getListener(e));
		return menu;
	}
}

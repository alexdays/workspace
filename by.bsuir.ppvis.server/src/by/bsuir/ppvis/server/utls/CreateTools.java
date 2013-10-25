package by.bsuir.ppvis.server.utls;

import javax.swing.JButton;

import by.bsuir.ppvis.server.controller.Controller;

public class CreateTools {
	public static JButton createTools(ChildMenus item, Controller controller){
		JButton btn = new JButton(item.getIcon());
		btn.addActionListener(controller.getListener(item));
		return btn;
	}
}

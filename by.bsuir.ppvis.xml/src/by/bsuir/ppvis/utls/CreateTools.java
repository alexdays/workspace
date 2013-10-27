package by.bsuir.ppvis.utls;

import javax.swing.JButton;

import by.bsuir.ppvis.xml.controller.Controller;

public class CreateTools {
	public static JButton createTools(ChildMenus item, Controller controller){
		JButton btn = new JButton(item.getIcon());
		btn.addActionListener(controller.getListener(item));
		return btn;
	}
}

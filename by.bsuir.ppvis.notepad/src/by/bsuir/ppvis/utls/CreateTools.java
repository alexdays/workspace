package by.bsuir.ppvis.utls;

import javax.swing.JButton;

import notepad.controller.Controller;
import notepad.view.TextView;


public class CreateTools {
	public static JButton createTools(TextView textView, ChildMenus item){
		JButton btn = new JButton(item.getIcon());
		btn.addActionListener(Controller.getListener(textView, item));
		return btn;
	}
}

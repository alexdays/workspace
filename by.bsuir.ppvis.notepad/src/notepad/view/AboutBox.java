package notepad.view;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JEditorPane;

public class AboutBox extends JFrame {
	
	public AboutBox() throws IOException{
		setSize(320, 240);
		JEditorPane pane = new JEditorPane();
		pane.setContentType("text/html");
		pane.setText("<html><body>" +
				"<h3><center>NotePad</center></h3>" +
				"<div>"+
				"<ul>Версия: 1.0</ul>"+
				"<ul>Автор: Карпович Александр Юрьевич</ul>"+
				"<ul>E-mail: alexsure.k@gmail.com</ul>"+
				"</div>"+
				"</body></html>");
		add(pane);
	}
	
}

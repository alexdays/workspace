package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import by.bsuir.ppvis.calculator.view.CalcFrame;

public class AboutMenuEvent implements ActionListener{
	private CalcFrame calcFrame;
	
	public AboutMenuEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(calcFrame,
				"Calculator\nVersion: 1.0\nAuthor: Kharpovich Alexander",
				"About program",
			    JOptionPane.INFORMATION_MESSAGE,
			    null);
	}

}
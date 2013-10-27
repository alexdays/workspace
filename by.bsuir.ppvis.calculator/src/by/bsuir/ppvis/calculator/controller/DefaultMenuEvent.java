package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import by.bsuir.ppvis.calculator.view.CalcFrame;

public class DefaultMenuEvent implements ActionListener{
	private CalcFrame calcFrame;
	
	public DefaultMenuEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		calcFrame.setDefaultView();
	}

}
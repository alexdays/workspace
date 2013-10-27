package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.bsuir.ppvis.calculator.view.CalcFrame;

public class ExitMenuEvent implements ActionListener{
	private CalcFrame calcFrame;
	
	public ExitMenuEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		calcFrame.dispose();
	}

}
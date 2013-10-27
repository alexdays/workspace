package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import by.bsuir.ppvis.calculator.view.CalcFrame;

public class ClearPBtnEvent implements ActionListener{
	private CalcFrame calcFrame;

	public ClearPBtnEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField inField = calcFrame.getInField();
		String str = inField.getText();
		calcFrame.setCurrentIndex(0);
		if(!str.isEmpty()) inField.setText(str.substring(0,str.length()-1));
	}

}
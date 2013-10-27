/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.ppvis.calculator.controller;

import by.bsuir.ppvis.calculator.view.CalcFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class RBracketBtnEvent implements ActionListener{
	private CalcFrame calcFrame;

	public RBracketBtnEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField inField = calcFrame.getInField();
		String str = inField.getText();
		inField.setText(str+")");
	}

}

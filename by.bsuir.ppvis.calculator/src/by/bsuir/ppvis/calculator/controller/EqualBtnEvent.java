package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTree;
import org.antlr.runtime.RecognitionException;

import by.bsuir.ppvis.calculator.model.AstTreeModel;
import by.bsuir.ppvis.calculator.parse.GeneralParse;
import by.bsuir.ppvis.calculator.view.CalcFrame;

public class EqualBtnEvent implements ActionListener{
	private CalcFrame calcFrame;
	
	public EqualBtnEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField inField = calcFrame.getInField();
		JTree treeView = calcFrame.getTreeView();
		GeneralParse genParse = calcFrame.getGenParser();
		//inField.setText(genParse.changeToNextLavel(inField.getText()));
		try {
			String xArg = calcFrame.getxArg();
			if(xArg!=null) genParse.parse("("+xArg+")^("+inField.getText()+")");
			else genParse.parse(inField.getText());
			treeView.setModel(new AstTreeModel(genParse.getCommonTree()));
			calcFrame.expandAll(treeView);
			genParse.genStepList();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}

}

package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import by.bsuir.ppvis.calculator.view.CalcFrame;

public class ClearMenuEvent implements ActionListener{
	private CalcFrame calcFrame;
	
	public ClearMenuEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = calcFrame.getTreeView();
		calcFrame.getInField().setText("");
		tree.setModel(new DefaultTreeModel(null));
		
	}

}
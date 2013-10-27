package by.bsuir.ppvis.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTree;
import org.antlr.runtime.tree.Tree;
import by.bsuir.ppvis.calculator.model.AstTreeModel;
import by.bsuir.ppvis.calculator.parse.GeneralParse;
import by.bsuir.ppvis.calculator.view.CalcFrame;

public class PrevStepEvent implements ActionListener{
	private CalcFrame calcFrame;

	public PrevStepEvent(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		GeneralParse genParse = calcFrame.getGenParser();
		List<Tree> treeList = calcFrame.getTreeList();
		JTree treeView = calcFrame.getTreeView();
		int index = calcFrame.getCurrentIndex();
		if(index>0) {
			Tree t = treeList.get(index-1);
			treeView.setModel(new AstTreeModel(t));
			calcFrame.expandAll(treeView);
			calcFrame.setCurrentIndex(index-1);
			calcFrame.getInField().setText(genParse.backStep(t.toStringTree()));
		}		
	}

}

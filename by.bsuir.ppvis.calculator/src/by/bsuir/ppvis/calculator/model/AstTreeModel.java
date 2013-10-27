package by.bsuir.ppvis.calculator.model;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.antlr.runtime.tree.Tree;

public class AstTreeModel implements TreeModel{
	private Tree tree = null;
	public AstTreeModel(Tree tree){
		this.tree = tree;
	}
	
	public Tree toTree(Object o){
		return (Tree)o;
	}
	
	@Override
	public void addTreeModelListener(TreeModelListener arg0) {		
	}
	
	@Override
	public Object getChild(Object arg0, int arg1) {
		Tree child = toTree(arg0);
		return child.getChild(arg1);
	}

	@Override
	public int getChildCount(Object arg0) {
		return toTree(arg0).getChildCount();
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		return 0;
	}

	@Override
	public Object getRoot() {
		return tree;
	}

	@Override
	public boolean isLeaf(Object arg0) {
		return toTree(arg0).getChildCount() == 0;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {		
	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {		
	}

}

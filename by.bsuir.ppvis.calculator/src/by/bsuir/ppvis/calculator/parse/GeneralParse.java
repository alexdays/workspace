package by.bsuir.ppvis.calculator.parse;

import by.bsuir.ppvis.calculator.view.CalcFrame;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

public class GeneralParse {
	private ANTLRStringStream input;
	private ExprLexer lexer;
	private CommonTokenStream tokens;
	private ExprParser parser;
	private CommonTree commonTree;
	private CalcFrame calcFrame;
	private String expression;
	private boolean mark = true;
	private boolean away = false;
	
	public GeneralParse(CalcFrame calcFrame){
		this.calcFrame = calcFrame;
	}
	
	public void parse(String parseString) throws RecognitionException{
		input = new ANTLRStringStream(parseString);
		lexer = new ExprLexer(input);
		tokens = new CommonTokenStream(lexer);
		parser = new ExprParser(this, tokens);
		ExprParser.stat_return r = parser.stat();
		commonTree = (CommonTree)r.getTree();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(commonTree);
		Eval walker = new Eval(calcFrame, nodes);
		walker.stat();		
	}
	
	public CommonTree getCommonTree(){
		return commonTree;
	}
	boolean isNotOperation(Tree child){
		return child.getType()==Eval.INT||child.getType()==Eval.FLOAT||
				child.getType()==Eval.UNARY||child.getType()==Eval.EXPONENT;
	}

	public Tree nextStep(Tree root) {
		if (root != null) {
			if(away) return root;
			Tree t = root;
			int count = t.getChildCount();
			switch (t.getType()) {
			case Eval.FLOAT:
				;
			case Eval.EXPONENT:
				;
			case Eval.INT: {
				int Oper;
				double l;
				l = Double.parseDouble(t.getText());
				double r = 0;
				boolean isGood = false;
				Tree HandleParent = t.getParent();
				int index = t.getChildIndex();				
				int anotherIndex = (index == 0) ? 1 : 0;
				if (HandleParent.getType() == Eval.UNARY) {
					anotherIndex = (HandleParent.getChildIndex()==0)?1:0;
					HandleParent = HandleParent.getParent();
					l = (-1) * l;
				}
				Oper = HandleParent.getType();
				Tree child = HandleParent.getChild(anotherIndex);
				if (isNotOperation(child)) {
					if (child.getType() == Eval.UNARY) {
						Tree i = child.getChild(0);
						if (isNotOperation(i)) {
							r = (-1)*Double.parseDouble(i.getText());
							isGood = true;
						}
					} else {
						r = Double.parseDouble(child.getText());
						isGood = true;
					}
				}
				if (isGood) {
					int childIndex = HandleParent.getChildIndex();
					if(!HandleParent.equals(commonTree)){
						Tree parent = HandleParent.getParent();
						//parent.deleteChild(childIndex);
						Tree newNode = null;
						switch (Oper) {
						case Eval.DIV: {
							double result = l/r;
							if(result>=0.0){
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(result));
								newNode = new CommonTree(ct);
							} else {
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								CommonToken unaryToken = new CommonToken(Eval.UNARY,"UNARY");
								Tree unary = new CommonTree(ct);
								newNode = new CommonTree(unaryToken);
								newNode.addChild(unary);								
							}
							break;
						}
						case Eval.PLUS: {
							double result = l + r;
							if(result>=0){
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								newNode = new CommonTree(ct);
							} else {
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								CommonToken unaryToken = new CommonToken(Eval.UNARY,"UNARY");
								Tree unary = new CommonTree(ct);
								newNode = new CommonTree(unaryToken);
								newNode.addChild(unary);								
							}
							break;
						}
						case Eval.MINUS: {
							double result = l - r;
							if(result>=0){
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								newNode = new CommonTree(ct);
							} else {
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								CommonToken unaryToken = new CommonToken(Eval.UNARY,"UNARY");
								Tree unary = new CommonTree(ct);
								newNode = new CommonTree(unaryToken);
								newNode.addChild(unary);
								
							}
							break;
						}
						case Eval.MULT: {
							double result = l * r;
							if(result>=0){
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								newNode = new CommonTree(ct);
							} else {
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								CommonToken unaryToken = new CommonToken(Eval.UNARY,"UNARY");
								Tree unary = new CommonTree(ct);
								newNode = new CommonTree(unaryToken);
								newNode.addChild(unary);								
							}
							break;
						}
						case Eval.PROCENT: {
							double result = l % r;
							if(result>=0){
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								newNode = new CommonTree(ct);
							} else {
								CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(result)));
								CommonToken unaryToken = new CommonToken(Eval.UNARY,"UNARY");
								Tree unary = new CommonTree(ct);
								newNode = new CommonTree(unaryToken);
								newNode.addChild(unary);
								
							}
							break;
						}
						case Eval.POW: {
							double result = Math.pow(l,r);
							CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(result));
							newNode = new CommonTree(ct);							
							break;
						}
						}
						parent.setChild(childIndex, newNode);
						if(isOver(parent)) mark = false;
						away = true;
						
					} else {
						mark = false;
					}
				}
				
			}
			
			}
			for(int i=0;i<count;i++) nextStep(t.getChild(i));
		}
		return root;
	}

	private boolean isOver(Tree tree){
		boolean id = true;
		if(tree.equals(commonTree)){
			int count = tree.getChildCount();
			for(int i=0;i<count;i++){
				if(!isNotOperation(tree.getChild(i))){
					id = false; 
				}
			}
		} else return false;
		return id;
	}
	
	public String backStep(String treeString){
		String result = "";
		String checkPatternString = "^\\((\\S{1,5})\\s";
		Pattern checkPattern = Pattern.compile(checkPatternString);
		Matcher checkMatcher = checkPattern.matcher(treeString);
		if(checkMatcher.find()){
			String operation = checkMatcher.group(1);
			if(operation.equals("UNARY")){
				String pString = 	"\\(" +
									"(\\S{1,5})\\s" +
									"(\\d+(\\.\\d+(E-?\\d+)?)?|\\(.+\\s.+\\s.+\\)|\\(UNARY\\s.+\\))" +
									"\\)";
				Pattern p = Pattern.compile(pString);
				Matcher m = p.matcher(treeString);
				if(m.find()){
					String operand = m.group(2);
					if(operand.contains("(")){
						result = "-"+backStep(operand);
					} else {
						result = "-"+operand;
					}			
				}
			} else {
				String pString = 	"^\\("+
									"(\\S{1,5})\\s" +
									"(\\d+(\\.\\d+(E-?\\d+)?)?|\\(.+\\s.+\\s.+\\)|\\(UNARY\\s.+\\))\\s" +
									"(\\d+(\\.\\d+(E-?\\d+)?)?|\\(.+\\s.+\\s.+\\)|\\(UNARY\\s.+\\))" +
									"\\)$";
				Pattern p = Pattern.compile(pString);
				Matcher m = p.matcher(treeString);
				if(m.find()){
					String oper = operation;
					String leftOperand = m.group(2);
					String rightOperand = m.group(5);
					if(rightOperand.contains("(")&&leftOperand.contains("(")){
						result = "("+backStep(leftOperand)+oper+backStep(rightOperand)+")";
					} else if(rightOperand.contains("(")){
						result = "("+leftOperand+oper+backStep(rightOperand)+")";
					} else if(leftOperand.contains("(")){
						result = "("+backStep(leftOperand)+oper+rightOperand+")";
					} else {
						result = "("+leftOperand+oper+rightOperand+")";
					}			
				}
			}
		}
		return result;
	}
	public void setExpression(String expr){
		this.expression = expr;
	}
	public void genStepList() throws RecognitionException{
    	Tree temp = commonTree;
		List<Tree> treeList = new Vector<Tree>();
		treeList.add(copyTree((CommonTree)temp));
		do{
			temp = nextStep(temp);
			away = false;
			System.out.println(temp.toStringTree());
			treeList.add(copyTree((CommonTree)temp));
		} while(mark);
		Tree res = new CommonTree(new CommonToken(Eval.UNARY, "UNARY"));
		res.setParent(null);
		if(calcFrame.getResult()>=0){
			res.addChild(new CommonTree(new CommonToken(Eval.FLOAT, String.valueOf(calcFrame.getResult()))));
		} else {
			CommonToken ct = new CommonToken(Eval.FLOAT,String.valueOf(Math.abs(calcFrame.getResult())));
			CommonToken unaryToken = new CommonToken(Eval.UNARY,"UNARY");
			Tree unary = new CommonTree(ct);
			res = new CommonTree(unaryToken);
			res.addChild(unary);		
		}
		treeList.add(res);
		calcFrame.setTreeList(treeList);
		mark = true;
	}
	public static CommonTree copyTree(CommonTree original) {		
		return copyTreeRecursive(original);
	}
	private static CommonTree copyTreeRecursive(CommonTree original) {

		    CommonTree copy = new CommonTree(original); // Leverage constructor

		    if(original.getChildren() != null) {
		      for(Object o : original.getChildren()) {
		        CommonTree childCopy  = copyTreeRecursive((CommonTree)o);
		        childCopy.setParent(copy);
		        copy.addChild(childCopy);
		      }
		    };
		    return copy;
	}
}

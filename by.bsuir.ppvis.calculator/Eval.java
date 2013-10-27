// $ANTLR 3.5 G:\\by.bsuir.ppvis.calculator\\Eval.g 2013-06-10 18:39:34

	package by.bsuir.ppvis.calculator.parse;
	import by.bsuir.ppvis.calculator.view.CalcFrame;
	import java.lang.Math;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Eval extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIV", "EXPONENT", "FLOAT", "ID", 
		"INT", "MINUS", "MULT", "PLUS", "POW", "PROCENT", "UNARY", "WS", "'('", 
		"')'", "'E'", "'e'"
	};
	public static final int EOF=-1;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int DIV=4;
	public static final int EXPONENT=5;
	public static final int FLOAT=6;
	public static final int ID=7;
	public static final int INT=8;
	public static final int MINUS=9;
	public static final int MULT=10;
	public static final int PLUS=11;
	public static final int POW=12;
	public static final int PROCENT=13;
	public static final int UNARY=14;
	public static final int WS=15;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public Eval(CalcFrame calcFrame, TreeNodeStream input) {
		this(input, new RecognizerSharedState());
		this.calcFrame = calcFrame;
	}
	public Eval(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return Eval.tokenNames; }
	@Override public String getGrammarFileName() { return "G:\\by.bsuir.ppvis.calculator\\Eval.g"; }


		private CalcFrame calcFrame;



	// $ANTLR start "stat"
	// G:\\by.bsuir.ppvis.calculator\\Eval.g:15:1: stat : expr ;
	public final void stat()   {
		double expr1 =0.0;

		try {
			// G:\\by.bsuir.ppvis.calculator\\Eval.g:15:6: ( expr )
			// G:\\by.bsuir.ppvis.calculator\\Eval.g:16:2: expr
			{
			pushFollow(FOLLOW_expr_in_stat42);
			expr1=expr();
			state._fsp--;
            calcFrame.getInField().setText(String.valueOf(expr1));
            calcFrame.setResult(expr1);
			System.out.println(expr1);
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stat"



	// $ANTLR start "exp"
	// G:\\by.bsuir.ppvis.calculator\\Eval.g:18:1: exp returns [double value] :;
	public final double exp()   {
		double value = 0.0;


		try {
			// G:\\by.bsuir.ppvis.calculator\\Eval.g:19:2: ()
			// G:\\by.bsuir.ppvis.calculator\\Eval.g:19:4: 
			{
			value = Math.E;
			}

		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "exp"



	// $ANTLR start "expr"
	// G:\\by.bsuir.ppvis.calculator\\Eval.g:22:1: expr returns [double value] : ( ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( MULT a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( PROCENT a= expr b= expr ) | ^( UNARY a= expr ) | ^( POW a= expr b= expr ) | FLOAT | INT );
	public final double expr()   {
		double value = 0.0;


		CommonTree FLOAT2=null;
		CommonTree INT3=null;
		double a =0.0;
		double b =0.0;

		try {
			// G:\\by.bsuir.ppvis.calculator\\Eval.g:22:28: ( ^( PLUS a= expr b= expr ) | ^( MINUS a= expr b= expr ) | ^( MULT a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( PROCENT a= expr b= expr ) | ^( UNARY a= expr ) | ^( POW a= expr b= expr ) | FLOAT | INT )
			int alt1=9;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt1=1;
				}
				break;
			case MINUS:
				{
				alt1=2;
				}
				break;
			case MULT:
				{
				alt1=3;
				}
				break;
			case DIV:
				{
				alt1=4;
				}
				break;
			case PROCENT:
				{
				alt1=5;
				}
				break;
			case UNARY:
				{
				alt1=6;
				}
				break;
			case POW:
				{
				alt1=7;
				}
				break;
			case FLOAT:
				{
				alt1=8;
				}
				break;
			case INT:
				{
				alt1=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:23:5: ^( PLUS a= expr b= expr )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expr74); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr80);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr86);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = a+b;
					}
					break;
				case 2 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:24:5: ^( MINUS a= expr b= expr )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expr96); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr102);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr108);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = a-b;
					}
					break;
				case 3 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:25:5: ^( MULT a= expr b= expr )
					{
					match(input,MULT,FOLLOW_MULT_in_expr118); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr124);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr130);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = a*b;
					}
					break;
				case 4 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:26:5: ^( DIV a= expr b= expr )
					{
					match(input,DIV,FOLLOW_DIV_in_expr140); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr146);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr152);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = a/b;
					}
					break;
				case 5 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:27:5: ^( PROCENT a= expr b= expr )
					{
					match(input,PROCENT,FOLLOW_PROCENT_in_expr162); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr168);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr174);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = a/b;
					}
					break;
				case 6 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:28:5: ^( UNARY a= expr )
					{
					match(input,UNARY,FOLLOW_UNARY_in_expr184); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr190);
					a=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = (-1)*a;
					}
					break;
				case 7 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:29:5: ^( POW a= expr b= expr )
					{
					match(input,POW,FOLLOW_POW_in_expr200); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr206);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr212);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = Math.pow(a, b);
					}
					break;
				case 8 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:30:5: FLOAT
					{
					FLOAT2=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_expr221); 
					value = Double.parseDouble((FLOAT2!=null?FLOAT2.getText():null));
					}
					break;
				case 9 :
					// G:\\by.bsuir.ppvis.calculator\\Eval.g:31:5: INT
					{
					INT3=(CommonTree)match(input,INT,FOLLOW_INT_in_expr229); 
					value = Double.parseDouble((INT3!=null?INT3.getText():null));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_stat42 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expr74 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr80 = new BitSet(new long[]{0x0000000000007F50L});
	public static final BitSet FOLLOW_expr_in_expr86 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr96 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr102 = new BitSet(new long[]{0x0000000000007F50L});
	public static final BitSet FOLLOW_expr_in_expr108 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MULT_in_expr118 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr124 = new BitSet(new long[]{0x0000000000007F50L});
	public static final BitSet FOLLOW_expr_in_expr130 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expr140 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr146 = new BitSet(new long[]{0x0000000000007F50L});
	public static final BitSet FOLLOW_expr_in_expr152 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROCENT_in_expr162 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr168 = new BitSet(new long[]{0x0000000000007F50L});
	public static final BitSet FOLLOW_expr_in_expr174 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_in_expr184 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr190 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POW_in_expr200 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr206 = new BitSet(new long[]{0x0000000000007F50L});
	public static final BitSet FOLLOW_expr_in_expr212 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FLOAT_in_expr221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_expr229 = new BitSet(new long[]{0x0000000000000002L});
}

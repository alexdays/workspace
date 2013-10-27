// $ANTLR 3.5 G:\\by.bsuir.ppvis.calculator\\Expr.g 2013-06-10 18:39:29

	package by.bsuir.ppvis.calculator.parse;
	import 	by.bsuir.ppvis.calculator.parse.GeneralParse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ExprParser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExprParser(GeneralParse genParse, TokenStream input) {
		this(input, new RecognizerSharedState());
		this.genParse = genParse;
	}
	public ExprParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "G:\\by.bsuir.ppvis.calculator\\Expr.g"; }


		private GeneralParse genParse;


	public static class stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// G:\\by.bsuir.ppvis.calculator\\Expr.g:42:1: stat : expr -> expr ;
	public final ExprParser.stat_return stat()   {
		ExprParser.stat_return retval = new ExprParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr1 =null;

		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:42:6: ( expr -> expr )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:43:2: expr
			{
			pushFollow(FOLLOW_expr_in_stat271);
			expr1=expr();
			state._fsp--;

			stream_expr.add(expr1.getTree());
			System.out.println((expr1!=null?((CommonTree)expr1.getTree()):null).toStringTree());
			genParse.setExpression((expr1!=null?((CommonTree)expr1.getTree()):null).toStringTree());
			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 43:55: -> expr
			{
				adaptor.addChild(root_0, stream_expr.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stat"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// G:\\by.bsuir.ppvis.calculator\\Expr.g:45:1: expr : multExpr ( ( PLUS ^| MINUS ^) multExpr )* ;
	public final ExprParser.expr_return expr()   {
		ExprParser.expr_return retval = new ExprParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PLUS3=null;
		Token MINUS4=null;
		ParserRuleReturnScope multExpr2 =null;
		ParserRuleReturnScope multExpr5 =null;

		CommonTree PLUS3_tree=null;
		CommonTree MINUS4_tree=null;

		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:45:7: ( multExpr ( ( PLUS ^| MINUS ^) multExpr )* )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:46:3: multExpr ( ( PLUS ^| MINUS ^) multExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_multExpr_in_expr288);
			multExpr2=multExpr();
			state._fsp--;

			adaptor.addChild(root_0, multExpr2.getTree());

			// G:\\by.bsuir.ppvis.calculator\\Expr.g:46:11: ( ( PLUS ^| MINUS ^) multExpr )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==MINUS||LA2_0==PLUS) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:46:12: ( PLUS ^| MINUS ^) multExpr
					{
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:46:12: ( PLUS ^| MINUS ^)
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==PLUS) ) {
						alt1=1;
					}
					else if ( (LA1_0==MINUS) ) {
						alt1=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 1, 0, input);
						throw nvae;
					}

					switch (alt1) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:46:13: PLUS ^
							{
							PLUS3=(Token)match(input,PLUS,FOLLOW_PLUS_in_expr291); 
							PLUS3_tree = (CommonTree)adaptor.create(PLUS3);
							root_0 = (CommonTree)adaptor.becomeRoot(PLUS3_tree, root_0);

							}
							break;
						case 2 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:46:19: MINUS ^
							{
							MINUS4=(Token)match(input,MINUS,FOLLOW_MINUS_in_expr294); 
							MINUS4_tree = (CommonTree)adaptor.create(MINUS4);
							root_0 = (CommonTree)adaptor.becomeRoot(MINUS4_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_multExpr_in_expr298);
					multExpr5=multExpr();
					state._fsp--;

					adaptor.addChild(root_0, multExpr5.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class multExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "multExpr"
	// G:\\by.bsuir.ppvis.calculator\\Expr.g:48:1: multExpr : power ( ( MULT ^| DIV ^| PROCENT ^) power )* ;
	public final ExprParser.multExpr_return multExpr()   {
		ExprParser.multExpr_return retval = new ExprParser.multExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MULT7=null;
		Token DIV8=null;
		Token PROCENT9=null;
		ParserRuleReturnScope power6 =null;
		ParserRuleReturnScope power10 =null;

		CommonTree MULT7_tree=null;
		CommonTree DIV8_tree=null;
		CommonTree PROCENT9_tree=null;

		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:2: ( power ( ( MULT ^| DIV ^| PROCENT ^) power )* )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:4: power ( ( MULT ^| DIV ^| PROCENT ^) power )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_power_in_multExpr310);
			power6=power();
			state._fsp--;

			adaptor.addChild(root_0, power6.getTree());

			// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:9: ( ( MULT ^| DIV ^| PROCENT ^) power )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DIV||LA4_0==MULT||LA4_0==PROCENT) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:10: ( MULT ^| DIV ^| PROCENT ^) power
					{
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:10: ( MULT ^| DIV ^| PROCENT ^)
					int alt3=3;
					switch ( input.LA(1) ) {
					case MULT:
						{
						alt3=1;
						}
						break;
					case DIV:
						{
						alt3=2;
						}
						break;
					case PROCENT:
						{
						alt3=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}
					switch (alt3) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:11: MULT ^
							{
							MULT7=(Token)match(input,MULT,FOLLOW_MULT_in_multExpr313); 
							MULT7_tree = (CommonTree)adaptor.create(MULT7);
							root_0 = (CommonTree)adaptor.becomeRoot(MULT7_tree, root_0);

							}
							break;
						case 2 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:19: DIV ^
							{
							DIV8=(Token)match(input,DIV,FOLLOW_DIV_in_multExpr318); 
							DIV8_tree = (CommonTree)adaptor.create(DIV8);
							root_0 = (CommonTree)adaptor.becomeRoot(DIV8_tree, root_0);

							}
							break;
						case 3 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:49:25: PROCENT ^
							{
							PROCENT9=(Token)match(input,PROCENT,FOLLOW_PROCENT_in_multExpr322); 
							PROCENT9_tree = (CommonTree)adaptor.create(PROCENT9);
							root_0 = (CommonTree)adaptor.becomeRoot(PROCENT9_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_power_in_multExpr326);
					power10=power();
					state._fsp--;

					adaptor.addChild(root_0, power10.getTree());

					}
					break;

				default :
					break loop4;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class power_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "power"
	// G:\\by.bsuir.ppvis.calculator\\Expr.g:51:1: power : unary ( POW ^ unary )* ;
	public final ExprParser.power_return power()   {
		ExprParser.power_return retval = new ExprParser.power_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token POW12=null;
		ParserRuleReturnScope unary11 =null;
		ParserRuleReturnScope unary13 =null;

		CommonTree POW12_tree=null;

		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:51:7: ( unary ( POW ^ unary )* )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:52:2: unary ( POW ^ unary )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_unary_in_power338);
			unary11=unary();
			state._fsp--;

			adaptor.addChild(root_0, unary11.getTree());

			// G:\\by.bsuir.ppvis.calculator\\Expr.g:52:7: ( POW ^ unary )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==POW) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:52:8: POW ^ unary
					{
					POW12=(Token)match(input,POW,FOLLOW_POW_in_power340); 
					POW12_tree = (CommonTree)adaptor.create(POW12);
					root_0 = (CommonTree)adaptor.becomeRoot(POW12_tree, root_0);

					pushFollow(FOLLOW_unary_in_power343);
					unary13=unary();
					state._fsp--;

					adaptor.addChild(root_0, unary13.getTree());

					}
					break;

				default :
					break loop5;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "power"


	public static class unary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unary"
	// G:\\by.bsuir.ppvis.calculator\\Expr.g:54:1: unary : ( '-' atom -> ^( UNARY atom ) | atom );
	public final ExprParser.unary_return unary()   {
		ExprParser.unary_return retval = new ExprParser.unary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal14=null;
		ParserRuleReturnScope atom15 =null;
		ParserRuleReturnScope atom16 =null;

		CommonTree char_literal14_tree=null;
		RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:54:7: ( '-' atom -> ^( UNARY atom ) | atom )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==MINUS) ) {
				alt6=1;
			}
			else if ( (LA6_0==FLOAT||LA6_0==INT||LA6_0==16||(LA6_0 >= 18 && LA6_0 <= 19)) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:55:4: '-' atom
					{
					char_literal14=(Token)match(input,MINUS,FOLLOW_MINUS_in_unary358);  
					stream_MINUS.add(char_literal14);

					pushFollow(FOLLOW_atom_in_unary360);
					atom15=atom();
					state._fsp--;

					stream_atom.add(atom15.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 55:13: -> ^( UNARY atom )
					{
						// G:\\by.bsuir.ppvis.calculator\\Expr.g:55:16: ^( UNARY atom )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY, "UNARY"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:56:4: atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom_in_unary373);
					atom16=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom16.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unary"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// G:\\by.bsuir.ppvis.calculator\\Expr.g:58:1: atom : ( INT | FLOAT | exp -> exp | '(' ! expr ')' !);
	public final ExprParser.atom_return atom()   {
		ExprParser.atom_return retval = new ExprParser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT17=null;
		Token FLOAT18=null;
		Token char_literal20=null;
		Token char_literal22=null;
		ParserRuleReturnScope exp19 =null;
		ParserRuleReturnScope expr21 =null;

		CommonTree INT17_tree=null;
		CommonTree FLOAT18_tree=null;
		CommonTree char_literal20_tree=null;
		CommonTree char_literal22_tree=null;
		RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp");

		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:58:6: ( INT | FLOAT | exp -> exp | '(' ! expr ')' !)
			int alt7=4;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt7=1;
				}
				break;
			case FLOAT:
				{
				alt7=2;
				}
				break;
			case 18:
			case 19:
				{
				alt7=3;
				}
				break;
			case 16:
				{
				alt7=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:58:8: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					INT17=(Token)match(input,INT,FOLLOW_INT_in_atom383); 
					INT17_tree = (CommonTree)adaptor.create(INT17);
					adaptor.addChild(root_0, INT17_tree);

					}
					break;
				case 2 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:59:4: FLOAT
					{
					root_0 = (CommonTree)adaptor.nil();


					FLOAT18=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_atom388); 
					FLOAT18_tree = (CommonTree)adaptor.create(FLOAT18);
					adaptor.addChild(root_0, FLOAT18_tree);

					}
					break;
				case 3 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:60:4: exp
					{
					pushFollow(FOLLOW_exp_in_atom393);
					exp19=exp();
					state._fsp--;

					stream_exp.add(exp19.getTree());
					// AST REWRITE
					// elements: exp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 60:8: -> exp
					{
						adaptor.addChild(root_0, stream_exp.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:61:4: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal20=(Token)match(input,16,FOLLOW_16_in_atom402); 
					pushFollow(FOLLOW_expr_in_atom405);
					expr21=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr21.getTree());

					char_literal22=(Token)match(input,17,FOLLOW_17_in_atom407); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class exp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "exp"
	// G:\\by.bsuir.ppvis.calculator\\Expr.g:63:1: exp : ( 'e' | 'E' ) ;
	public final ExprParser.exp_return exp()   {
		ExprParser.exp_return retval = new ExprParser.exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set23=null;

		CommonTree set23_tree=null;

		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:63:5: ( ( 'e' | 'E' ) )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set23=input.LT(1);
			if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set23));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exp"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_stat271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr288 = new BitSet(new long[]{0x0000000000000A02L});
	public static final BitSet FOLLOW_PLUS_in_expr291 = new BitSet(new long[]{0x00000000000D0340L});
	public static final BitSet FOLLOW_MINUS_in_expr294 = new BitSet(new long[]{0x00000000000D0340L});
	public static final BitSet FOLLOW_multExpr_in_expr298 = new BitSet(new long[]{0x0000000000000A02L});
	public static final BitSet FOLLOW_power_in_multExpr310 = new BitSet(new long[]{0x0000000000002412L});
	public static final BitSet FOLLOW_MULT_in_multExpr313 = new BitSet(new long[]{0x00000000000D0340L});
	public static final BitSet FOLLOW_DIV_in_multExpr318 = new BitSet(new long[]{0x00000000000D0340L});
	public static final BitSet FOLLOW_PROCENT_in_multExpr322 = new BitSet(new long[]{0x00000000000D0340L});
	public static final BitSet FOLLOW_power_in_multExpr326 = new BitSet(new long[]{0x0000000000002412L});
	public static final BitSet FOLLOW_unary_in_power338 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_POW_in_power340 = new BitSet(new long[]{0x00000000000D0340L});
	public static final BitSet FOLLOW_unary_in_power343 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_MINUS_in_unary358 = new BitSet(new long[]{0x00000000000D0140L});
	public static final BitSet FOLLOW_atom_in_unary360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unary373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_atom383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_atom388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_in_atom393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_atom402 = new BitSet(new long[]{0x00000000000D0340L});
	public static final BitSet FOLLOW_expr_in_atom405 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_atom407 = new BitSet(new long[]{0x0000000000000002L});
}

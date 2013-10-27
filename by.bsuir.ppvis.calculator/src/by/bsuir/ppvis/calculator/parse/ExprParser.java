// $ANTLR 3.3 Nov 30, 2010 12:45:30 G:\\by.bsuir.ppvis.calculator\\Expr.g 2013-06-05 01:40:12

	package by.bsuir.ppvis.calculator.parse;	


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ExprParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'+'", "'-'", "'*'", "'/'", "'^'", "'%'", "'('", "')'"
    };
    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int ID=4;
    public static final int INT=5;
    public static final int WS=6;

    // delegates
    // delegators


        public ExprParser(TokenStream input) {
            this(input, new RecognizerSharedState());
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

    public String[] getTokenNames() { return ExprParser.tokenNames; }
    public String getGrammarFileName() { return "G:\\by.bsuir.ppvis.calculator\\Expr.g"; }


    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // G:\\by.bsuir.ppvis.calculator\\Expr.g:15:1: prog : ( stat )+ ;
    public final ExprParser.prog_return prog() throws RecognitionException {
        ExprParser.prog_return retval = new ExprParser.prog_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ExprParser.stat_return stat1 = null;



        try {
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:15:7: ( ( stat )+ )
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:16:2: ( stat )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // G:\\by.bsuir.ppvis.calculator\\Expr.g:16:2: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==INT||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // G:\\by.bsuir.ppvis.calculator\\Expr.g:16:3: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog91);
            	    stat1=stat();

            	    state._fsp--;

            	    adaptor.addChild(root_0, stat1.getTree());
            	    System.out.println((stat1!=null?((CommonTree)stat1.tree):null).toStringTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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
        }
        return retval;
    }
    // $ANTLR end "prog"

    public static class stat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stat"
    // G:\\by.bsuir.ppvis.calculator\\Expr.g:18:1: stat : expr -> expr ;
    public final ExprParser.stat_return stat() throws RecognitionException {
        ExprParser.stat_return retval = new ExprParser.stat_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        ExprParser.expr_return expr2 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:18:6: ( expr -> expr )
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:19:2: expr
            {
            pushFollow(FOLLOW_expr_in_stat105);
            expr2=expr();

            state._fsp--;

            stream_expr.add(expr2.getTree());


            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 19:7: -> expr
            {
                adaptor.addChild(root_0, stream_expr.nextTree());

            }

            retval.tree = root_0;
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
        }
        return retval;
    }
    // $ANTLR end "stat"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // G:\\by.bsuir.ppvis.calculator\\Expr.g:22:1: expr : multExpr ( ( '+' | '-' ) multExpr )* ;
    public final ExprParser.expr_return expr() throws RecognitionException {
        ExprParser.expr_return retval = new ExprParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal4=null;
        Token char_literal5=null;
        ExprParser.multExpr_return multExpr3 = null;

        ExprParser.multExpr_return multExpr6 = null;


        CommonTree char_literal4_tree=null;
        CommonTree char_literal5_tree=null;

        try {
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:22:7: ( multExpr ( ( '+' | '-' ) multExpr )* )
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:23:3: multExpr ( ( '+' | '-' ) multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_expr123);
            multExpr3=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr3.getTree());
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:23:11: ( ( '+' | '-' ) multExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=7 && LA3_0<=8)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // G:\\by.bsuir.ppvis.calculator\\Expr.g:23:12: ( '+' | '-' ) multExpr
            	    {
            	    // G:\\by.bsuir.ppvis.calculator\\Expr.g:23:12: ( '+' | '-' )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==7) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==8) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // G:\\by.bsuir.ppvis.calculator\\Expr.g:23:13: '+'
            	            {
            	            char_literal4=(Token)match(input,7,FOLLOW_7_in_expr126); 
            	            char_literal4_tree = (CommonTree)adaptor.create(char_literal4);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal4_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // G:\\by.bsuir.ppvis.calculator\\Expr.g:23:18: '-'
            	            {
            	            char_literal5=(Token)match(input,8,FOLLOW_8_in_expr129); 
            	            char_literal5_tree = (CommonTree)adaptor.create(char_literal5);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal5_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multExpr_in_expr133);
            	    multExpr6=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr6.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class multExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // G:\\by.bsuir.ppvis.calculator\\Expr.g:25:1: multExpr : atom ( ( '*' | '/' | '^' | '%' ) atom )* ;
    public final ExprParser.multExpr_return multExpr() throws RecognitionException {
        ExprParser.multExpr_return retval = new ExprParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal8=null;
        Token char_literal9=null;
        Token char_literal10=null;
        Token char_literal11=null;
        ExprParser.atom_return atom7 = null;

        ExprParser.atom_return atom12 = null;


        CommonTree char_literal8_tree=null;
        CommonTree char_literal9_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree char_literal11_tree=null;

        try {
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:2: ( atom ( ( '*' | '/' | '^' | '%' ) atom )* )
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:4: atom ( ( '*' | '/' | '^' | '%' ) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_multExpr145);
            atom7=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom7.getTree());
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:9: ( ( '*' | '/' | '^' | '%' ) atom )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=9 && LA5_0<=12)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:10: ( '*' | '/' | '^' | '%' ) atom
            	    {
            	    // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:10: ( '*' | '/' | '^' | '%' )
            	    int alt4=4;
            	    switch ( input.LA(1) ) {
            	    case 9:
            	        {
            	        alt4=1;
            	        }
            	        break;
            	    case 10:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case 11:
            	        {
            	        alt4=3;
            	        }
            	        break;
            	    case 12:
            	        {
            	        alt4=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:11: '*'
            	            {
            	            char_literal8=(Token)match(input,9,FOLLOW_9_in_multExpr149); 
            	            char_literal8_tree = (CommonTree)adaptor.create(char_literal8);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal8_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:18: '/'
            	            {
            	            char_literal9=(Token)match(input,10,FOLLOW_10_in_multExpr154); 
            	            char_literal9_tree = (CommonTree)adaptor.create(char_literal9);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal9_tree, root_0);


            	            }
            	            break;
            	        case 3 :
            	            // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:25: '^'
            	            {
            	            char_literal10=(Token)match(input,11,FOLLOW_11_in_multExpr159); 
            	            char_literal10_tree = (CommonTree)adaptor.create(char_literal10);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal10_tree, root_0);


            	            }
            	            break;
            	        case 4 :
            	            // G:\\by.bsuir.ppvis.calculator\\Expr.g:26:32: '%'
            	            {
            	            char_literal11=(Token)match(input,12,FOLLOW_12_in_multExpr164); 
            	            char_literal11_tree = (CommonTree)adaptor.create(char_literal11);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal11_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_multExpr168);
            	    atom12=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom12.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
        }
        return retval;
    }
    // $ANTLR end "multExpr"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // G:\\by.bsuir.ppvis.calculator\\Expr.g:28:1: atom : ( INT | '(' expr ')' );
    public final ExprParser.atom_return atom() throws RecognitionException {
        ExprParser.atom_return retval = new ExprParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT13=null;
        Token char_literal14=null;
        Token char_literal16=null;
        ExprParser.expr_return expr15 = null;


        CommonTree INT13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree char_literal16_tree=null;

        try {
            // G:\\by.bsuir.ppvis.calculator\\Expr.g:29:2: ( INT | '(' expr ')' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==INT) ) {
                alt6=1;
            }
            else if ( (LA6_0==13) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // G:\\by.bsuir.ppvis.calculator\\Expr.g:30:2: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INT13=(Token)match(input,INT,FOLLOW_INT_in_atom183); 
                    INT13_tree = (CommonTree)adaptor.create(INT13);
                    adaptor.addChild(root_0, INT13_tree);


                    }
                    break;
                case 2 :
                    // G:\\by.bsuir.ppvis.calculator\\Expr.g:31:4: '(' expr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal14=(Token)match(input,13,FOLLOW_13_in_atom189); 
                    pushFollow(FOLLOW_expr_in_atom192);
                    expr15=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr15.getTree());
                    char_literal16=(Token)match(input,14,FOLLOW_14_in_atom194); 

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
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog91 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_expr_in_stat105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr123 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_7_in_expr126 = new BitSet(new long[]{0x00000000000021A0L});
    public static final BitSet FOLLOW_8_in_expr129 = new BitSet(new long[]{0x00000000000021A0L});
    public static final BitSet FOLLOW_multExpr_in_expr133 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_atom_in_multExpr145 = new BitSet(new long[]{0x0000000000001E02L});
    public static final BitSet FOLLOW_9_in_multExpr149 = new BitSet(new long[]{0x0000000000003E20L});
    public static final BitSet FOLLOW_10_in_multExpr154 = new BitSet(new long[]{0x0000000000003E20L});
    public static final BitSet FOLLOW_11_in_multExpr159 = new BitSet(new long[]{0x0000000000003E20L});
    public static final BitSet FOLLOW_12_in_multExpr164 = new BitSet(new long[]{0x0000000000003E20L});
    public static final BitSet FOLLOW_atom_in_multExpr168 = new BitSet(new long[]{0x0000000000001E02L});
    public static final BitSet FOLLOW_INT_in_atom183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_atom189 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_expr_in_atom192 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_atom194 = new BitSet(new long[]{0x0000000000000002L});

}
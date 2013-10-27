// $ANTLR 3.3 Nov 30, 2010 12:45:30 G:\\by.bsuir.ppvis.calculator\\Eval.g 2013-06-05 01:40:17

	package by.bsuir.ppvis.calculator.parse;
	import java.lang.Math;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Eval extends TreeParser {
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


        public Eval(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public Eval(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return Eval.tokenNames; }
    public String getGrammarFileName() { return "G:\\by.bsuir.ppvis.calculator\\Eval.g"; }



    // $ANTLR start "prog"
    // G:\\by.bsuir.ppvis.calculator\\Eval.g:11:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // G:\\by.bsuir.ppvis.calculator\\Eval.g:11:6: ( ( stat )+ )
            // G:\\by.bsuir.ppvis.calculator\\Eval.g:12:2: ( stat )+
            {
            // G:\\by.bsuir.ppvis.calculator\\Eval.g:12:2: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==INT||(LA1_0>=7 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // G:\\by.bsuir.ppvis.calculator\\Eval.g:12:2: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog37);
            	    stat();

            	    state._fsp--;


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "stat"
    // G:\\by.bsuir.ppvis.calculator\\Eval.g:15:1: stat : expr ;
    public final void stat() throws RecognitionException {
        int expr1 = 0;


        try {
            // G:\\by.bsuir.ppvis.calculator\\Eval.g:15:6: ( expr )
            // G:\\by.bsuir.ppvis.calculator\\Eval.g:16:2: expr
            {
            pushFollow(FOLLOW_expr_in_stat50);
            expr1=expr();

            state._fsp--;

            System.out.println(expr1);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stat"


    // $ANTLR start "expr"
    // G:\\by.bsuir.ppvis.calculator\\Eval.g:19:1: expr returns [int value] : ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | ^( '%' a= expr b= expr ) | ^( '^' a= expr b= expr ) | INT );
    public final int expr() throws RecognitionException {
        int value = 0;

        CommonTree INT2=null;
        int a = 0;

        int b = 0;


        try {
            // G:\\by.bsuir.ppvis.calculator\\Eval.g:19:25: ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | ^( '%' a= expr b= expr ) | ^( '^' a= expr b= expr ) | INT )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 7:
                {
                alt2=1;
                }
                break;
            case 8:
                {
                alt2=2;
                }
                break;
            case 9:
                {
                alt2=3;
                }
                break;
            case 10:
                {
                alt2=4;
                }
                break;
            case 12:
                {
                alt2=5;
                }
                break;
            case 11:
                {
                alt2=6;
                }
                break;
            case INT:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // G:\\by.bsuir.ppvis.calculator\\Eval.g:20:5: ^( '+' a= expr b= expr )
                    {
                    match(input,7,FOLLOW_7_in_expr70); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr76);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr82);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    value = a+b;

                    }
                    break;
                case 2 :
                    // G:\\by.bsuir.ppvis.calculator\\Eval.g:21:5: ^( '-' a= expr b= expr )
                    {
                    match(input,8,FOLLOW_8_in_expr92); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr98);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr104);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    value = a-b;

                    }
                    break;
                case 3 :
                    // G:\\by.bsuir.ppvis.calculator\\Eval.g:22:5: ^( '*' a= expr b= expr )
                    {
                    match(input,9,FOLLOW_9_in_expr114); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr120);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr126);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    value = a*b;

                    }
                    break;
                case 4 :
                    // G:\\by.bsuir.ppvis.calculator\\Eval.g:23:5: ^( '/' a= expr b= expr )
                    {
                    match(input,10,FOLLOW_10_in_expr136); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr142);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr148);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    value = a/b;

                    }
                    break;
                case 5 :
                    // G:\\by.bsuir.ppvis.calculator\\Eval.g:24:5: ^( '%' a= expr b= expr )
                    {
                    match(input,12,FOLLOW_12_in_expr158); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr164);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr170);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    value = a/b;

                    }
                    break;
                case 6 :
                    // G:\\by.bsuir.ppvis.calculator\\Eval.g:25:5: ^( '^' a= expr b= expr )
                    {
                    match(input,11,FOLLOW_11_in_expr180); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr186);
                    a=expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr192);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    value = (int)Math.pow(a, b);

                    }
                    break;
                case 7 :
                    // G:\\by.bsuir.ppvis.calculator\\Eval.g:26:5: INT
                    {
                    INT2=(CommonTree)match(input,INT,FOLLOW_INT_in_expr201); 
                    value = Integer.parseInt((INT2!=null?INT2.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "expr"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog37 = new BitSet(new long[]{0x0000000000001FA2L});
    public static final BitSet FOLLOW_expr_in_stat50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_expr70 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr76 = new BitSet(new long[]{0x0000000000001FA8L});
    public static final BitSet FOLLOW_expr_in_expr82 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_8_in_expr92 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr98 = new BitSet(new long[]{0x0000000000001FA8L});
    public static final BitSet FOLLOW_expr_in_expr104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_9_in_expr114 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr120 = new BitSet(new long[]{0x0000000000001FA8L});
    public static final BitSet FOLLOW_expr_in_expr126 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_10_in_expr136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr142 = new BitSet(new long[]{0x0000000000001FA8L});
    public static final BitSet FOLLOW_expr_in_expr148 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_12_in_expr158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr164 = new BitSet(new long[]{0x0000000000001FA8L});
    public static final BitSet FOLLOW_expr_in_expr170 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_11_in_expr180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr186 = new BitSet(new long[]{0x0000000000001FA8L});
    public static final BitSet FOLLOW_expr_in_expr192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_expr201 = new BitSet(new long[]{0x0000000000000002L});

}
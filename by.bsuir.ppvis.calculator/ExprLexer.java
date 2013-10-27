// $ANTLR 3.5 G:\\by.bsuir.ppvis.calculator\\Expr.g 2013-06-10 18:39:30

	package by.bsuir.ppvis.calculator.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ExprLexer() {} 
	public ExprLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "G:\\by.bsuir.ppvis.calculator\\Expr.g"; }

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:11:5: ( '/' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:11:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:12:7: ( '-' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:12:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:13:6: ( '*' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:13:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:14:6: ( '+' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:14:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "POW"
	public final void mPOW() throws RecognitionException {
		try {
			int _type = POW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:15:5: ( '^' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:15:7: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POW"

	// $ANTLR start "PROCENT"
	public final void mPROCENT() throws RecognitionException {
		try {
			int _type = PROCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:16:9: ( '%' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:16:11: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROCENT"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:17:7: ( '(' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:17:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:18:7: ( ')' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:18:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:19:7: ( 'E' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:19:9: 'E'
			{
			match('E'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:20:7: ( 'e' )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:20:9: 'e'
			{
			match('e'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:28:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:28:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:28:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:31:5: ( ( '0' .. '9' )+ )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:31:7: ( '0' .. '9' )+
			{
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:31:7: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:34:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
			int alt9=3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:34:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
					{
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:34:9: ( '0' .. '9' )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					match('.'); 
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:34:25: ( '0' .. '9' )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop4;
						}
					}

					// G:\\by.bsuir.ppvis.calculator\\Expr.g:34:37: ( EXPONENT )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0=='E'||LA5_0=='e') ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:34:37: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:35:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
					{
					match('.'); 
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:35:13: ( '0' .. '9' )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					// G:\\by.bsuir.ppvis.calculator\\Expr.g:35:25: ( EXPONENT )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='E'||LA7_0=='e') ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:35:25: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 3 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:36:9: ( '0' .. '9' )+ EXPONENT
					{
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:36:9: ( '0' .. '9' )+
					int cnt8=0;
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt8 >= 1 ) break loop8;
							EarlyExitException eee = new EarlyExitException(8, input);
							throw eee;
						}
						cnt8++;
					}

					mEXPONENT(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:41:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( ( '0' .. '9' )+ )? )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:41:12: ( 'e' | 'E' ) ( '+' | '-' )? ( ( '0' .. '9' )+ )?
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:41:22: ( '+' | '-' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='+'||LA10_0=='-') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// G:\\by.bsuir.ppvis.calculator\\Expr.g:41:33: ( ( '0' .. '9' )+ )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:41:34: ( '0' .. '9' )+
					{
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:41:34: ( '0' .. '9' )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// G:\\by.bsuir.ppvis.calculator\\Expr.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPONENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:66:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:66:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// G:\\by.bsuir.ppvis.calculator\\Expr.g:66:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\t' && LA13_0 <= '\n')||LA13_0=='\r'||LA13_0==' ') ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// G:\\by.bsuir.ppvis.calculator\\Expr.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:8: ( DIV | MINUS | MULT | PLUS | POW | PROCENT | T__16 | T__17 | T__18 | T__19 | ID | INT | FLOAT | WS )
		int alt14=14;
		alt14 = dfa14.predict(input);
		switch (alt14) {
			case 1 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:10: DIV
				{
				mDIV(); 

				}
				break;
			case 2 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:14: MINUS
				{
				mMINUS(); 

				}
				break;
			case 3 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:20: MULT
				{
				mMULT(); 

				}
				break;
			case 4 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:25: PLUS
				{
				mPLUS(); 

				}
				break;
			case 5 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:30: POW
				{
				mPOW(); 

				}
				break;
			case 6 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:34: PROCENT
				{
				mPROCENT(); 

				}
				break;
			case 7 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:42: T__16
				{
				mT__16(); 

				}
				break;
			case 8 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:48: T__17
				{
				mT__17(); 

				}
				break;
			case 9 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:54: T__18
				{
				mT__18(); 

				}
				break;
			case 10 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:60: T__19
				{
				mT__19(); 

				}
				break;
			case 11 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:66: ID
				{
				mID(); 

				}
				break;
			case 12 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:69: INT
				{
				mINT(); 

				}
				break;
			case 13 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:73: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 14 :
				// G:\\by.bsuir.ppvis.calculator\\Expr.g:1:79: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	protected DFA14 dfa14 = new DFA14(this);
	static final String DFA9_eotS =
		"\5\uffff";
	static final String DFA9_eofS =
		"\5\uffff";
	static final String DFA9_minS =
		"\2\56\3\uffff";
	static final String DFA9_maxS =
		"\1\71\1\145\3\uffff";
	static final String DFA9_acceptS =
		"\2\uffff\1\2\1\1\1\3";
	static final String DFA9_specialS =
		"\5\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
			"",
			"",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "33:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
		}
	}

	static final String DFA14_eotS =
		"\11\uffff\1\17\1\20\1\uffff\1\21\5\uffff";
	static final String DFA14_eofS =
		"\22\uffff";
	static final String DFA14_minS =
		"\1\11\10\uffff\2\60\1\uffff\1\56\5\uffff";
	static final String DFA14_maxS =
		"\1\172\10\uffff\2\172\1\uffff\1\145\5\uffff";
	static final String DFA14_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\13\1\uffff\1\15\1"+
		"\16\1\11\1\12\1\14";
	static final String DFA14_specialS =
		"\22\uffff}>";
	static final String[] DFA14_transitionS = {
			"\2\16\2\uffff\1\16\22\uffff\1\16\4\uffff\1\6\2\uffff\1\7\1\10\1\3\1\4"+
			"\1\uffff\1\2\1\15\1\1\12\14\7\uffff\4\13\1\11\25\13\3\uffff\1\5\1\13"+
			"\1\uffff\4\13\1\12\25\13",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"",
			"\1\15\1\uffff\12\14\13\uffff\1\15\37\uffff\1\15",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( DIV | MINUS | MULT | PLUS | POW | PROCENT | T__16 | T__17 | T__18 | T__19 | ID | INT | FLOAT | WS );";
		}
	}

}

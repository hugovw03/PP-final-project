// Generated from /Users/chadmeng/Documents/TCS/M8/PP_Project/src/main/antlr4/ut/pp/ntr/Natural.g4 by ANTLR 4.12.0
package main.antlr4.ut.pp.ntr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NaturalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, IF=3, ELSE=4, WHILE=5, PRINT=6, LOCAL=7, GLOBAL=8, LOCK=9, 
		TRUE=10, FALSE=11, DOT=12, LON=13, LOFF=14, ASSIGN=15, LT=16, GT=17, EQ=18, 
		NE=19, LET=20, SET=21, NOT=22, SEMICOLON=23, LBRAC=24, RBRAC=25, LPAR=26, 
		RPAR=27, TIMES=28, PLUS=29, MINUS=30, RUNPAR=31, ID=32, NUM=33, STRING=34, 
		COMMENT=35, WS=36;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_expr = 2, RULE_op = 3, RULE_decl = 4, 
		RULE_type = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "expr", "op", "decl", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Bool'", "'If'", "'Else'", "'While'", "'Print'", "'Local'", 
			"'Global'", "'Lock'", "'True'", "'False'", "'.'", "'lock'", "'unlock'", 
			"'='", "'IsSmallerThan'", "'IsBiggerThan'", "'IsEqualTo'", "'IsNotEqualTo'", 
			"'IsBiggerThanOrEqualTo'", "'IsSmallerThanOrEqualTo'", "'!'", "';'", 
			"'{'", "'}'", "'('", "')'", "'*'", "'+'", "'-'", "'RunInParallel'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOL", "IF", "ELSE", "WHILE", "PRINT", "LOCAL", "GLOBAL", 
			"LOCK", "TRUE", "FALSE", "DOT", "LON", "LOFF", "ASSIGN", "LT", "GT", 
			"EQ", "NE", "LET", "SET", "NOT", "SEMICOLON", "LBRAC", "RBRAC", "LPAR", 
			"RPAR", "TIMES", "PLUS", "MINUS", "RUNPAR", "ID", "NUM", "STRING", "COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Natural.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NaturalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(NaturalParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				stat();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15120469998L) != 0) );
			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatContext extends StatContext {
		public TerminalNode IF() { return getToken(NaturalParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(NaturalParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(NaturalParser.RPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(NaturalParser.ELSE, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclNormalContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(NaturalParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(NaturalParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(NaturalParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclNormalContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterDeclNormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitDeclNormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitDeclNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LockStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(NaturalParser.DOT, 0); }
		public TerminalNode SEMICOLON() { return getToken(NaturalParser.SEMICOLON, 0); }
		public TerminalNode LON() { return getToken(NaturalParser.LON, 0); }
		public TerminalNode LOFF() { return getToken(NaturalParser.LOFF, 0); }
		public LockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterLockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitLockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitLockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignToVarContext extends StatContext {
		public TerminalNode ID() { return getToken(NaturalParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(NaturalParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NaturalParser.SEMICOLON, 0); }
		public AssignToVarContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterAssignToVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitAssignToVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitAssignToVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(NaturalParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(NaturalParser.LPAR, 0); }
		public TerminalNode STRING() { return getToken(NaturalParser.STRING, 0); }
		public TerminalNode RPAR() { return getToken(NaturalParser.RPAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(NaturalParser.SEMICOLON, 0); }
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclGlobalAndLocalContext extends StatContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(NaturalParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(NaturalParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(NaturalParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclGlobalAndLocalContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterDeclGlobalAndLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitDeclGlobalAndLocal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitDeclGlobalAndLocal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends StatContext {
		public TerminalNode LBRAC() { return getToken(NaturalParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(NaturalParser.RBRAC, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParallelStatContext extends StatContext {
		public TerminalNode RUNPAR() { return getToken(NaturalParser.RUNPAR, 0); }
		public TerminalNode LPAR() { return getToken(NaturalParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(NaturalParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ParallelStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterParallelStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitParallelStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitParallelStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(NaturalParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(NaturalParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(NaturalParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclGlobalAndLocalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				decl();
				setState(20);
				type();
				setState(21);
				match(ID);
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(22);
					match(ASSIGN);
					setState(23);
					expr(0);
					}
				}

				setState(26);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new DeclNormalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				type();
				setState(29);
				match(ID);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(30);
					match(ASSIGN);
					setState(31);
					expr(0);
					}
				}

				setState(34);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new AssignToVarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				match(ID);
				setState(37);
				match(ASSIGN);
				setState(38);
				expr(0);
				setState(39);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				match(IF);
				setState(42);
				match(LPAR);
				setState(43);
				expr(0);
				setState(44);
				match(RPAR);
				setState(45);
				stat();
				setState(48);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(46);
					match(ELSE);
					setState(47);
					stat();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				match(WHILE);
				setState(51);
				match(LPAR);
				setState(52);
				expr(0);
				setState(53);
				match(RPAR);
				setState(54);
				stat();
				}
				break;
			case 6:
				_localctx = new ParallelStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				match(RUNPAR);
				setState(57);
				match(LPAR);
				setState(58);
				expr(0);
				setState(59);
				match(RPAR);
				setState(60);
				stat();
				}
				break;
			case 7:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(62);
				match(LBRAC);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15120469998L) != 0)) {
					{
					{
					setState(63);
					stat();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69);
				match(RBRAC);
				}
				break;
			case 8:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(70);
				match(PRINT);
				setState(71);
				match(LPAR);
				setState(72);
				match(STRING);
				setState(73);
				match(RPAR);
				setState(74);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new LockStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(75);
				expr(0);
				setState(76);
				match(DOT);
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==LON || _la==LOFF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(78);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParExprContext extends ExprContext {
		public List<TerminalNode> LPAR() { return getTokens(NaturalParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(NaturalParser.LPAR, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(NaturalParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(NaturalParser.LT, 0); }
		public TerminalNode GT() { return getToken(NaturalParser.GT, 0); }
		public TerminalNode EQ() { return getToken(NaturalParser.EQ, 0); }
		public TerminalNode NE() { return getToken(NaturalParser.NE, 0); }
		public TerminalNode LET() { return getToken(NaturalParser.LET, 0); }
		public TerminalNode SET() { return getToken(NaturalParser.SET, 0); }
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(NaturalParser.TIMES, 0); }
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(NaturalParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(NaturalParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NaturalParser.FALSE, 0); }
		public ConstExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitConstExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitConstExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(NaturalParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(83);
				match(NOT);
				setState(84);
				expr(7);
				}
				break;
			case LPAR:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(LPAR);
				setState(86);
				expr(0);
				setState(87);
				match(LPAR);
				}
				break;
			case TRUE:
			case FALSE:
			case NUM:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589937664L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case ID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(103);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(93);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(94);
						match(TIMES);
						setState(95);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(97);
						op();
						setState(98);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(101);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4128768L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(NaturalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(NaturalParser.MINUS, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(NaturalParser.GLOBAL, 0); }
		public TerminalNode LOCAL() { return getToken(NaturalParser.LOCAL, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !(_la==LOCAL || _la==GLOBAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(NaturalParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(NaturalParser.BOOL, 0); }
		public TerminalNode LOCK() { return getToken(NaturalParser.LOCK, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalListener ) ((NaturalListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalVisitor ) return ((NaturalVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 518L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$s\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f\u0000"+
		"\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001!\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001A\b\u0001\n\u0001\f\u0001D\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001Q\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\\\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002h\b\u0002\n\u0002\f\u0002k\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0000\u0001\u0004\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0006"+
		"\u0001\u0000\r\u000e\u0002\u0000\n\u000b!!\u0001\u0000\u0010\u0015\u0001"+
		"\u0000\u001d\u001e\u0001\u0000\u0007\b\u0002\u0000\u0001\u0002\t\t\u007f"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0002P\u0001\u0000\u0000\u0000\u0004"+
		"[\u0001\u0000\u0000\u0000\u0006l\u0001\u0000\u0000\u0000\bn\u0001\u0000"+
		"\u0000\u0000\np\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000"+
		"\r\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f"+
		"\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0011"+
		"\u0001\u0000\u0000\u0000\u0011\u0012\u0005\u0000\u0000\u0001\u0012\u0001"+
		"\u0001\u0000\u0000\u0000\u0013\u0014\u0003\b\u0004\u0000\u0014\u0015\u0003"+
		"\n\u0005\u0000\u0015\u0018\u0005 \u0000\u0000\u0016\u0017\u0005\u000f"+
		"\u0000\u0000\u0017\u0019\u0003\u0004\u0002\u0000\u0018\u0016\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005\u0017\u0000\u0000\u001bQ\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0003\n\u0005\u0000\u001d \u0005 \u0000\u0000\u001e"+
		"\u001f\u0005\u000f\u0000\u0000\u001f!\u0003\u0004\u0002\u0000 \u001e\u0001"+
		"\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000"+
		"\"#\u0005\u0017\u0000\u0000#Q\u0001\u0000\u0000\u0000$%\u0005 \u0000\u0000"+
		"%&\u0005\u000f\u0000\u0000&\'\u0003\u0004\u0002\u0000\'(\u0005\u0017\u0000"+
		"\u0000(Q\u0001\u0000\u0000\u0000)*\u0005\u0003\u0000\u0000*+\u0005\u001a"+
		"\u0000\u0000+,\u0003\u0004\u0002\u0000,-\u0005\u001b\u0000\u0000-0\u0003"+
		"\u0002\u0001\u0000./\u0005\u0004\u0000\u0000/1\u0003\u0002\u0001\u0000"+
		"0.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001Q\u0001\u0000\u0000"+
		"\u000023\u0005\u0005\u0000\u000034\u0005\u001a\u0000\u000045\u0003\u0004"+
		"\u0002\u000056\u0005\u001b\u0000\u000067\u0003\u0002\u0001\u00007Q\u0001"+
		"\u0000\u0000\u000089\u0005\u001f\u0000\u00009:\u0005\u001a\u0000\u0000"+
		":;\u0003\u0004\u0002\u0000;<\u0005\u001b\u0000\u0000<=\u0003\u0002\u0001"+
		"\u0000=Q\u0001\u0000\u0000\u0000>B\u0005\u0018\u0000\u0000?A\u0003\u0002"+
		"\u0001\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000EQ\u0005\u0019\u0000\u0000FG\u0005\u0006\u0000"+
		"\u0000GH\u0005\u001a\u0000\u0000HI\u0005\"\u0000\u0000IJ\u0005\u001b\u0000"+
		"\u0000JQ\u0005\u0017\u0000\u0000KL\u0003\u0004\u0002\u0000LM\u0005\f\u0000"+
		"\u0000MN\u0007\u0000\u0000\u0000NO\u0005\u0017\u0000\u0000OQ\u0001\u0000"+
		"\u0000\u0000P\u0013\u0001\u0000\u0000\u0000P\u001c\u0001\u0000\u0000\u0000"+
		"P$\u0001\u0000\u0000\u0000P)\u0001\u0000\u0000\u0000P2\u0001\u0000\u0000"+
		"\u0000P8\u0001\u0000\u0000\u0000P>\u0001\u0000\u0000\u0000PF\u0001\u0000"+
		"\u0000\u0000PK\u0001\u0000\u0000\u0000Q\u0003\u0001\u0000\u0000\u0000"+
		"RS\u0006\u0002\uffff\uffff\u0000ST\u0005\u0016\u0000\u0000T\\\u0003\u0004"+
		"\u0002\u0007UV\u0005\u001a\u0000\u0000VW\u0003\u0004\u0002\u0000WX\u0005"+
		"\u001a\u0000\u0000X\\\u0001\u0000\u0000\u0000Y\\\u0007\u0001\u0000\u0000"+
		"Z\\\u0005 \u0000\u0000[R\u0001\u0000\u0000\u0000[U\u0001\u0000\u0000\u0000"+
		"[Y\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\i\u0001\u0000\u0000"+
		"\u0000]^\n\u0006\u0000\u0000^_\u0005\u001c\u0000\u0000_h\u0003\u0004\u0002"+
		"\u0007`a\n\u0005\u0000\u0000ab\u0003\u0006\u0003\u0000bc\u0003\u0004\u0002"+
		"\u0006ch\u0001\u0000\u0000\u0000de\n\u0004\u0000\u0000ef\u0007\u0002\u0000"+
		"\u0000fh\u0003\u0004\u0002\u0005g]\u0001\u0000\u0000\u0000g`\u0001\u0000"+
		"\u0000\u0000gd\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u0005\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000lm\u0007\u0003\u0000\u0000m\u0007\u0001"+
		"\u0000\u0000\u0000no\u0007\u0004\u0000\u0000o\t\u0001\u0000\u0000\u0000"+
		"pq\u0007\u0005\u0000\u0000q\u000b\u0001\u0000\u0000\u0000\t\u000f\u0018"+
		" 0BP[gi";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
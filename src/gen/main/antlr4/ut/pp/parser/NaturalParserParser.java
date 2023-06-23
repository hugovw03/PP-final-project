// Generated from /Users/chadmeng/Documents/TCS/M8/PP_Project/src/main/antlr4/ut/pp/parser/NaturalParser.g4 by ANTLR 4.12.0
package main.antlr4.ut.pp.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NaturalParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, IF=3, WHILE=4, PRINT=5, LOCAL=6, GLOBAL=7, LOCK=8, SEMICOLON=9, 
		BRAC=10, PARENS=11, CONST_INT=12, ID=13, TIMES=14, PLUS=15, MINUS=16, 
		RUNPAR=17, ASSIGN=18, EQUALS=19, CONST_BOOL=20;
	public static final int
		RULE_identifier = 0, RULE_condition = 1, RULE_constant_value = 2, RULE_scope_level = 3, 
		RULE_data_type = 4, RULE_somethinghereeeeeee = 5, RULE_data_type_definition = 6, 
		RULE_scope_type_definition = 7, RULE_if_statement = 8, RULE_while_statement = 9, 
		RULE_print_statement = 10, RULE_parallel_statement = 11, RULE_assignment_statement = 12, 
		RULE_expr = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier", "condition", "constant_value", "scope_level", "data_type", 
			"somethinghereeeeeee", "data_type_definition", "scope_type_definition", 
			"if_statement", "while_statement", "print_statement", "parallel_statement", 
			"assignment_statement", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Bool'", "'If'", "'While'", "'Print'", "'Local'", "'Global'", 
			"'Lock'", "';'", null, null, null, null, "'*'", "'+'", "'-'", "'RunInParallel'", 
			"'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOL", "IF", "WHILE", "PRINT", "LOCAL", "GLOBAL", "LOCK", 
			"SEMICOLON", "BRAC", "PARENS", "CONST_INT", "ID", "TIMES", "PLUS", "MINUS", 
			"RUNPAR", "ASSIGN", "EQUALS", "CONST_BOOL"
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
	public String getGrammarFileName() { return "NaturalParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NaturalParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NaturalParserParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(ID);
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
	public static class ConditionContext extends ParserRuleContext {
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(NaturalParserParser.EQUALS, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			data_type();
			setState(31);
			match(EQUALS);
			setState(32);
			data_type();
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
	public static class Constant_valueContext extends ParserRuleContext {
		public TerminalNode CONST_INT() { return getToken(NaturalParserParser.CONST_INT, 0); }
		public TerminalNode CONST_BOOL() { return getToken(NaturalParserParser.CONST_BOOL, 0); }
		public Constant_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterConstant_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitConstant_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitConstant_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_valueContext constant_value() throws RecognitionException {
		Constant_valueContext _localctx = new Constant_valueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constant_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(_la==CONST_INT || _la==CONST_BOOL) ) {
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
	public static class Scope_levelContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(NaturalParserParser.GLOBAL, 0); }
		public TerminalNode LOCAL() { return getToken(NaturalParserParser.LOCAL, 0); }
		public Scope_levelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope_level; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterScope_level(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitScope_level(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitScope_level(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scope_levelContext scope_level() throws RecognitionException {
		Scope_levelContext _localctx = new Scope_levelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_scope_level);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
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
	public static class Data_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(NaturalParserParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(NaturalParserParser.BOOL, 0); }
		public TerminalNode LOCK() { return getToken(NaturalParserParser.LOCK, 0); }
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterData_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitData_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitData_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_data_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 262L) != 0)) ) {
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
	public static class SomethinghereeeeeeeContext extends ParserRuleContext {
		public List<Constant_valueContext> constant_value() {
			return getRuleContexts(Constant_valueContext.class);
		}
		public Constant_valueContext constant_value(int i) {
			return getRuleContext(Constant_valueContext.class,i);
		}
		public SomethinghereeeeeeeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_somethinghereeeeeee; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterSomethinghereeeeeee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitSomethinghereeeeeee(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitSomethinghereeeeeee(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SomethinghereeeeeeeContext somethinghereeeeeee() throws RecognitionException {
		SomethinghereeeeeeeContext _localctx = new SomethinghereeeeeeeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_somethinghereeeeeee);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST_INT || _la==CONST_BOOL) {
				{
				{
				setState(40);
				constant_value();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Data_type_definitionContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(NaturalParserParser.ASSIGN, 0); }
		public Constant_valueContext constant_value() {
			return getRuleContext(Constant_valueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NaturalParserParser.SEMICOLON, 0); }
		public Data_type_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterData_type_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitData_type_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitData_type_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_type_definitionContext data_type_definition() throws RecognitionException {
		Data_type_definitionContext _localctx = new Data_type_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_data_type_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			data_type();
			setState(47);
			identifier();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(48);
				match(ASSIGN);
				setState(49);
				constant_value();
				setState(50);
				match(SEMICOLON);
				}
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
	public static class Scope_type_definitionContext extends ParserRuleContext {
		public Scope_levelContext scope_level() {
			return getRuleContext(Scope_levelContext.class,0);
		}
		public Data_type_definitionContext data_type_definition() {
			return getRuleContext(Data_type_definitionContext.class,0);
		}
		public Scope_type_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope_type_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterScope_type_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitScope_type_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitScope_type_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scope_type_definitionContext scope_type_definition() throws RecognitionException {
		Scope_type_definitionContext _localctx = new Scope_type_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scope_type_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			scope_level();
			setState(55);
			data_type_definition();
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
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(NaturalParserParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> BRAC() { return getTokens(NaturalParserParser.BRAC); }
		public TerminalNode BRAC(int i) {
			return getToken(NaturalParserParser.BRAC, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(IF);
			setState(58);
			condition();
			setState(59);
			match(BRAC);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139774L) != 0)) {
				{
				{
				setState(60);
				expr();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(BRAC);
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
	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(NaturalParserParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> BRAC() { return getTokens(NaturalParserParser.BRAC); }
		public TerminalNode BRAC(int i) {
			return getToken(NaturalParserParser.BRAC, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitWhile_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitWhile_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(WHILE);
			setState(69);
			condition();
			setState(70);
			match(BRAC);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 139774L) != 0)) {
				{
				{
				setState(71);
				expr();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(BRAC);
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
	public static class Print_statementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(NaturalParserParser.PRINT, 0); }
		public List<TerminalNode> PARENS() { return getTokens(NaturalParserParser.PARENS); }
		public TerminalNode PARENS(int i) {
			return getToken(NaturalParserParser.PARENS, i);
		}
		public SomethinghereeeeeeeContext somethinghereeeeeee() {
			return getRuleContext(SomethinghereeeeeeeContext.class,0);
		}
		public Print_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterPrint_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitPrint_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitPrint_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_statementContext print_statement() throws RecognitionException {
		Print_statementContext _localctx = new Print_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_print_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(PRINT);
			setState(80);
			match(PARENS);
			setState(81);
			somethinghereeeeeee();
			setState(82);
			match(PARENS);
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
	public static class Parallel_statementContext extends ParserRuleContext {
		public TerminalNode RUNPAR() { return getToken(NaturalParserParser.RUNPAR, 0); }
		public List<TerminalNode> PARENS() { return getTokens(NaturalParserParser.PARENS); }
		public TerminalNode PARENS(int i) {
			return getToken(NaturalParserParser.PARENS, i);
		}
		public TerminalNode INT() { return getToken(NaturalParserParser.INT, 0); }
		public TerminalNode CONST_INT() { return getToken(NaturalParserParser.CONST_INT, 0); }
		public Parallel_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parallel_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterParallel_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitParallel_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitParallel_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parallel_statementContext parallel_statement() throws RecognitionException {
		Parallel_statementContext _localctx = new Parallel_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parallel_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(RUNPAR);
			setState(85);
			match(PARENS);
			setState(86);
			match(INT);
			setState(87);
			match(CONST_INT);
			setState(88);
			match(PARENS);
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
	public static class Assignment_statementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(NaturalParserParser.ASSIGN, 0); }
		public Constant_valueContext constant_value() {
			return getRuleContext(Constant_valueContext.class,0);
		}
		public Assignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterAssignment_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitAssignment_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitAssignment_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_statementContext assignment_statement() throws RecognitionException {
		Assignment_statementContext _localctx = new Assignment_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			identifier();
			setState(91);
			match(ASSIGN);
			setState(92);
			constant_value();
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
		public Data_type_definitionContext data_type_definition() {
			return getRuleContext(Data_type_definitionContext.class,0);
		}
		public Scope_type_definitionContext scope_type_definition() {
			return getRuleContext(Scope_type_definitionContext.class,0);
		}
		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public Print_statementContext print_statement() {
			return getRuleContext(Print_statementContext.class,0);
		}
		public Parallel_statementContext parallel_statement() {
			return getRuleContext(Parallel_statementContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case LOCK:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				data_type_definition();
				}
				break;
			case LOCAL:
			case GLOBAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				scope_type_definition();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				assignment_statement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				if_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				while_statement();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				print_statement();
				}
				break;
			case RUNPAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(100);
				parallel_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0014h\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0005\u0005*\b\u0005\n\u0005\f\u0005"+
		"-\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u00065\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b>\b\b\n\b\f\bA\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tI\b\t\n\t\f\tL\t\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\rf\b"+
		"\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u0000\u0003\u0002\u0000\f\f\u0014\u0014"+
		"\u0001\u0000\u0006\u0007\u0002\u0000\u0001\u0002\b\bc\u0000\u001c\u0001"+
		"\u0000\u0000\u0000\u0002\u001e\u0001\u0000\u0000\u0000\u0004\"\u0001\u0000"+
		"\u0000\u0000\u0006$\u0001\u0000\u0000\u0000\b&\u0001\u0000\u0000\u0000"+
		"\n+\u0001\u0000\u0000\u0000\f.\u0001\u0000\u0000\u0000\u000e6\u0001\u0000"+
		"\u0000\u0000\u00109\u0001\u0000\u0000\u0000\u0012D\u0001\u0000\u0000\u0000"+
		"\u0014O\u0001\u0000\u0000\u0000\u0016T\u0001\u0000\u0000\u0000\u0018Z"+
		"\u0001\u0000\u0000\u0000\u001ae\u0001\u0000\u0000\u0000\u001c\u001d\u0005"+
		"\r\u0000\u0000\u001d\u0001\u0001\u0000\u0000\u0000\u001e\u001f\u0003\b"+
		"\u0004\u0000\u001f \u0005\u0013\u0000\u0000 !\u0003\b\u0004\u0000!\u0003"+
		"\u0001\u0000\u0000\u0000\"#\u0007\u0000\u0000\u0000#\u0005\u0001\u0000"+
		"\u0000\u0000$%\u0007\u0001\u0000\u0000%\u0007\u0001\u0000\u0000\u0000"+
		"&\'\u0007\u0002\u0000\u0000\'\t\u0001\u0000\u0000\u0000(*\u0003\u0004"+
		"\u0002\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,\u000b\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000./\u0003\b\u0004\u0000/4\u0003\u0000\u0000"+
		"\u000001\u0005\u0012\u0000\u000012\u0003\u0004\u0002\u000023\u0005\t\u0000"+
		"\u000035\u0001\u0000\u0000\u000040\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u00005\r\u0001\u0000\u0000\u000067\u0003\u0006\u0003\u000078\u0003"+
		"\f\u0006\u00008\u000f\u0001\u0000\u0000\u00009:\u0005\u0003\u0000\u0000"+
		":;\u0003\u0002\u0001\u0000;?\u0005\n\u0000\u0000<>\u0003\u001a\r\u0000"+
		"=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000BC\u0005\n\u0000\u0000C\u0011\u0001\u0000\u0000\u0000DE\u0005"+
		"\u0004\u0000\u0000EF\u0003\u0002\u0001\u0000FJ\u0005\n\u0000\u0000GI\u0003"+
		"\u001a\r\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000MN\u0005\n\u0000\u0000N\u0013\u0001\u0000\u0000"+
		"\u0000OP\u0005\u0005\u0000\u0000PQ\u0005\u000b\u0000\u0000QR\u0003\n\u0005"+
		"\u0000RS\u0005\u000b\u0000\u0000S\u0015\u0001\u0000\u0000\u0000TU\u0005"+
		"\u0011\u0000\u0000UV\u0005\u000b\u0000\u0000VW\u0005\u0001\u0000\u0000"+
		"WX\u0005\f\u0000\u0000XY\u0005\u000b\u0000\u0000Y\u0017\u0001\u0000\u0000"+
		"\u0000Z[\u0003\u0000\u0000\u0000[\\\u0005\u0012\u0000\u0000\\]\u0003\u0004"+
		"\u0002\u0000]\u0019\u0001\u0000\u0000\u0000^f\u0003\f\u0006\u0000_f\u0003"+
		"\u000e\u0007\u0000`f\u0003\u0018\f\u0000af\u0003\u0010\b\u0000bf\u0003"+
		"\u0012\t\u0000cf\u0003\u0014\n\u0000df\u0003\u0016\u000b\u0000e^\u0001"+
		"\u0000\u0000\u0000e_\u0001\u0000\u0000\u0000e`\u0001\u0000\u0000\u0000"+
		"ea\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ed\u0001\u0000\u0000\u0000f\u001b\u0001\u0000\u0000\u0000\u0005"+
		"+4?Je";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
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
		LBRAC=10, RBRAC=11, LPAR=12, RPAR=13, CONST_INT=14, ID=15, TIMES=16, PLUS=17, 
		MINUS=18, RUNPAR=19, ASSIGN=20, EQUALS=21, CONST_BOOL=22, WS=23;
	public static final int
		RULE_identifier = 0, RULE_constant_value = 1, RULE_scope_level = 2, RULE_data_type = 3, 
		RULE_somethinghereeeeeee = 4, RULE_conditionPara = 5, RULE_condition = 6, 
		RULE_if_statement = 7, RULE_data_type_definition = 8, RULE_scope_type_definition = 9, 
		RULE_opPara = 10, RULE_op_expr = 11, RULE_assignment_statement = 12, RULE_while_statement = 13, 
		RULE_print_statement = 14, RULE_parallel_statement = 15, RULE_expr = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier", "constant_value", "scope_level", "data_type", "somethinghereeeeeee", 
			"conditionPara", "condition", "if_statement", "data_type_definition", 
			"scope_type_definition", "opPara", "op_expr", "assignment_statement", 
			"while_statement", "print_statement", "parallel_statement", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Bool'", "'If'", "'While'", "'Print'", "'Local'", "'Global'", 
			"'Lock'", "';'", "'{'", "'}'", "'('", "')'", null, null, "'*'", "'+'", 
			"'-'", "'RunInParallel'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOL", "IF", "WHILE", "PRINT", "LOCAL", "GLOBAL", "LOCK", 
			"SEMICOLON", "LBRAC", "RBRAC", "LPAR", "RPAR", "CONST_INT", "ID", "TIMES", 
			"PLUS", "MINUS", "RUNPAR", "ASSIGN", "EQUALS", "CONST_BOOL", "WS"
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
			setState(34);
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
		enterRule(_localctx, 2, RULE_constant_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
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
		enterRule(_localctx, 4, RULE_scope_level);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
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
		enterRule(_localctx, 6, RULE_data_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
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
		enterRule(_localctx, 8, RULE_somethinghereeeeeee);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST_INT || _la==CONST_BOOL) {
				{
				{
				setState(42);
				constant_value();
				}
				}
				setState(47);
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
	public static class ConditionParaContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Constant_valueContext constant_value() {
			return getRuleContext(Constant_valueContext.class,0);
		}
		public Op_exprContext op_expr() {
			return getRuleContext(Op_exprContext.class,0);
		}
		public ConditionParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterConditionPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitConditionPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitConditionPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionParaContext conditionPara() throws RecognitionException {
		ConditionParaContext _localctx = new ConditionParaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditionPara);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				constant_value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				op_expr(0);
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
	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(NaturalParserParser.LPAR, 0); }
		public List<ConditionParaContext> conditionPara() {
			return getRuleContexts(ConditionParaContext.class);
		}
		public ConditionParaContext conditionPara(int i) {
			return getRuleContext(ConditionParaContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(NaturalParserParser.EQUALS, 0); }
		public TerminalNode RPAR() { return getToken(NaturalParserParser.RPAR, 0); }
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
		enterRule(_localctx, 12, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(LPAR);
			setState(54);
			conditionPara();
			setState(55);
			match(EQUALS);
			setState(56);
			conditionPara();
			setState(57);
			match(RPAR);
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
		public TerminalNode LBRAC() { return getToken(NaturalParserParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(NaturalParserParser.RBRAC, 0); }
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
		enterRule(_localctx, 14, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(IF);
			setState(60);
			condition();
			setState(61);
			match(LBRAC);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 573950L) != 0)) {
				{
				{
				setState(62);
				expr();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			match(RBRAC);
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
		public TerminalNode SEMICOLON() { return getToken(NaturalParserParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(NaturalParserParser.ASSIGN, 0); }
		public Op_exprContext op_expr() {
			return getRuleContext(Op_exprContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_data_type_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			data_type();
			setState(71);
			identifier();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(72);
				match(ASSIGN);
				setState(73);
				op_expr(0);
				}
			}

			setState(76);
			match(SEMICOLON);
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
		public TerminalNode SEMICOLON() { return getToken(NaturalParserParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 18, RULE_scope_type_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			scope_level();
			setState(79);
			data_type_definition();
			setState(80);
			match(SEMICOLON);
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
	public static class OpParaContext extends ParserRuleContext {
		public TerminalNode CONST_INT() { return getToken(NaturalParserParser.CONST_INT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public OpParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterOpPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitOpPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitOpPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpParaContext opPara() throws RecognitionException {
		OpParaContext _localctx = new OpParaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_opPara);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(CONST_INT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Op_exprContext extends ParserRuleContext {
		public OpParaContext opPara() {
			return getRuleContext(OpParaContext.class,0);
		}
		public List<Op_exprContext> op_expr() {
			return getRuleContexts(Op_exprContext.class);
		}
		public Op_exprContext op_expr(int i) {
			return getRuleContext(Op_exprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(NaturalParserParser.TIMES, 0); }
		public TerminalNode PLUS() { return getToken(NaturalParserParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(NaturalParserParser.MINUS, 0); }
		public Op_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).enterOp_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NaturalParserListener ) ((NaturalParserListener)listener).exitOp_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NaturalParserVisitor ) return ((NaturalParserVisitor<? extends T>)visitor).visitOp_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_exprContext op_expr() throws RecognitionException {
		return op_expr(0);
	}

	private Op_exprContext op_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Op_exprContext _localctx = new Op_exprContext(_ctx, _parentState);
		Op_exprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_op_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(87);
			opPara();
			}
			_ctx.stop = _input.LT(-1);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(98);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Op_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_op_expr);
						setState(89);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(90);
						match(TIMES);
						setState(91);
						op_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new Op_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_op_expr);
						setState(92);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(93);
						match(PLUS);
						setState(94);
						op_expr(4);
						}
						break;
					case 3:
						{
						_localctx = new Op_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_op_expr);
						setState(95);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(96);
						match(MINUS);
						setState(97);
						op_expr(3);
						}
						break;
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class Assignment_statementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(NaturalParserParser.ASSIGN, 0); }
		public Op_exprContext op_expr() {
			return getRuleContext(Op_exprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NaturalParserParser.SEMICOLON, 0); }
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
			setState(103);
			identifier();
			setState(104);
			match(ASSIGN);
			setState(105);
			op_expr(0);
			setState(106);
			match(SEMICOLON);
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
		public TerminalNode LBRAC() { return getToken(NaturalParserParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(NaturalParserParser.RBRAC, 0); }
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
		enterRule(_localctx, 26, RULE_while_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(WHILE);
			setState(109);
			condition();
			setState(110);
			match(LBRAC);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 573950L) != 0)) {
				{
				{
				setState(111);
				expr();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(RBRAC);
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
		public TerminalNode LPAR() { return getToken(NaturalParserParser.LPAR, 0); }
		public SomethinghereeeeeeeContext somethinghereeeeeee() {
			return getRuleContext(SomethinghereeeeeeeContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(NaturalParserParser.RPAR, 0); }
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
		enterRule(_localctx, 28, RULE_print_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(PRINT);
			setState(120);
			match(LPAR);
			setState(121);
			somethinghereeeeeee();
			setState(122);
			match(RPAR);
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
		public TerminalNode LPAR() { return getToken(NaturalParserParser.LPAR, 0); }
		public TerminalNode INT() { return getToken(NaturalParserParser.INT, 0); }
		public TerminalNode CONST_INT() { return getToken(NaturalParserParser.CONST_INT, 0); }
		public TerminalNode RPAR() { return getToken(NaturalParserParser.RPAR, 0); }
		public TerminalNode LBRAC() { return getToken(NaturalParserParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(NaturalParserParser.RBRAC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
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
		enterRule(_localctx, 30, RULE_parallel_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(RUNPAR);
			setState(125);
			match(LPAR);
			setState(126);
			match(INT);
			setState(127);
			match(CONST_INT);
			setState(128);
			match(RPAR);
			setState(129);
			match(LBRAC);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 573950L) != 0)) {
				{
				{
				setState(130);
				expr();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			match(RBRAC);
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
		public Op_exprContext op_expr() {
			return getRuleContext(Op_exprContext.class,0);
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
		enterRule(_localctx, 32, RULE_expr);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				data_type_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				scope_type_definition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				assignment_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				if_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
				while_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(143);
				print_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(144);
				op_expr(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(145);
				parallel_statement();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return op_expr_sempred((Op_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean op_expr_sempred(Op_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u0095\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0005"+
		"\u0004,\b\u0004\n\u0004\f\u0004/\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u00054\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007@\b\u0007\n\u0007\f\u0007C\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bK\b\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\nU\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bc\b"+
		"\u000b\n\u000b\f\u000bf\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\rq\b\r\n\r\f\rt\t\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u0084\b\u000f\n\u000f\f\u000f\u0087\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0093\b\u0010\u0001\u0010\u0000"+
		"\u0001\u0016\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \u0000\u0003\u0002\u0000\u000e\u000e\u0016"+
		"\u0016\u0001\u0000\u0006\u0007\u0002\u0000\u0001\u0002\b\b\u0095\u0000"+
		"\"\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004&\u0001"+
		"\u0000\u0000\u0000\u0006(\u0001\u0000\u0000\u0000\b-\u0001\u0000\u0000"+
		"\u0000\n3\u0001\u0000\u0000\u0000\f5\u0001\u0000\u0000\u0000\u000e;\u0001"+
		"\u0000\u0000\u0000\u0010F\u0001\u0000\u0000\u0000\u0012N\u0001\u0000\u0000"+
		"\u0000\u0014T\u0001\u0000\u0000\u0000\u0016V\u0001\u0000\u0000\u0000\u0018"+
		"g\u0001\u0000\u0000\u0000\u001al\u0001\u0000\u0000\u0000\u001cw\u0001"+
		"\u0000\u0000\u0000\u001e|\u0001\u0000\u0000\u0000 \u0092\u0001\u0000\u0000"+
		"\u0000\"#\u0005\u000f\u0000\u0000#\u0001\u0001\u0000\u0000\u0000$%\u0007"+
		"\u0000\u0000\u0000%\u0003\u0001\u0000\u0000\u0000&\'\u0007\u0001\u0000"+
		"\u0000\'\u0005\u0001\u0000\u0000\u0000()\u0007\u0002\u0000\u0000)\u0007"+
		"\u0001\u0000\u0000\u0000*,\u0003\u0002\u0001\u0000+*\u0001\u0000\u0000"+
		"\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.\t\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u000004\u0003"+
		"\u0000\u0000\u000014\u0003\u0002\u0001\u000024\u0003\u0016\u000b\u0000"+
		"30\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000"+
		"\u00004\u000b\u0001\u0000\u0000\u000056\u0005\f\u0000\u000067\u0003\n"+
		"\u0005\u000078\u0005\u0015\u0000\u000089\u0003\n\u0005\u00009:\u0005\r"+
		"\u0000\u0000:\r\u0001\u0000\u0000\u0000;<\u0005\u0003\u0000\u0000<=\u0003"+
		"\f\u0006\u0000=A\u0005\n\u0000\u0000>@\u0003 \u0010\u0000?>\u0001\u0000"+
		"\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"DE\u0005\u000b\u0000\u0000E\u000f\u0001\u0000\u0000\u0000FG\u0003\u0006"+
		"\u0003\u0000GJ\u0003\u0000\u0000\u0000HI\u0005\u0014\u0000\u0000IK\u0003"+
		"\u0016\u000b\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LM\u0005\t\u0000\u0000M\u0011\u0001\u0000\u0000"+
		"\u0000NO\u0003\u0004\u0002\u0000OP\u0003\u0010\b\u0000PQ\u0005\t\u0000"+
		"\u0000Q\u0013\u0001\u0000\u0000\u0000RU\u0005\u000e\u0000\u0000SU\u0003"+
		"\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000"+
		"U\u0015\u0001\u0000\u0000\u0000VW\u0006\u000b\uffff\uffff\u0000WX\u0003"+
		"\u0014\n\u0000Xd\u0001\u0000\u0000\u0000YZ\n\u0004\u0000\u0000Z[\u0005"+
		"\u0010\u0000\u0000[c\u0003\u0016\u000b\u0005\\]\n\u0003\u0000\u0000]^"+
		"\u0005\u0011\u0000\u0000^c\u0003\u0016\u000b\u0004_`\n\u0002\u0000\u0000"+
		"`a\u0005\u0012\u0000\u0000ac\u0003\u0016\u000b\u0003bY\u0001\u0000\u0000"+
		"\u0000b\\\u0001\u0000\u0000\u0000b_\u0001\u0000\u0000\u0000cf\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0017"+
		"\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gh\u0003\u0000\u0000"+
		"\u0000hi\u0005\u0014\u0000\u0000ij\u0003\u0016\u000b\u0000jk\u0005\t\u0000"+
		"\u0000k\u0019\u0001\u0000\u0000\u0000lm\u0005\u0004\u0000\u0000mn\u0003"+
		"\f\u0006\u0000nr\u0005\n\u0000\u0000oq\u0003 \u0010\u0000po\u0001\u0000"+
		"\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"uv\u0005\u000b\u0000\u0000v\u001b\u0001\u0000\u0000\u0000wx\u0005\u0005"+
		"\u0000\u0000xy\u0005\f\u0000\u0000yz\u0003\b\u0004\u0000z{\u0005\r\u0000"+
		"\u0000{\u001d\u0001\u0000\u0000\u0000|}\u0005\u0013\u0000\u0000}~\u0005"+
		"\f\u0000\u0000~\u007f\u0005\u0001\u0000\u0000\u007f\u0080\u0005\u000e"+
		"\u0000\u0000\u0080\u0081\u0005\r\u0000\u0000\u0081\u0085\u0005\n\u0000"+
		"\u0000\u0082\u0084\u0003 \u0010\u0000\u0083\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000"+
		"\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u000b\u0000\u0000"+
		"\u0089\u001f\u0001\u0000\u0000\u0000\u008a\u0093\u0003\u0010\b\u0000\u008b"+
		"\u0093\u0003\u0012\t\u0000\u008c\u0093\u0003\u0018\f\u0000\u008d\u0093"+
		"\u0003\u000e\u0007\u0000\u008e\u0093\u0003\u001a\r\u0000\u008f\u0093\u0003"+
		"\u001c\u000e\u0000\u0090\u0093\u0003\u0016\u000b\u0000\u0091\u0093\u0003"+
		"\u001e\u000f\u0000\u0092\u008a\u0001\u0000\u0000\u0000\u0092\u008b\u0001"+
		"\u0000\u0000\u0000\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u008d\u0001"+
		"\u0000\u0000\u0000\u0092\u008e\u0001\u0000\u0000\u0000\u0092\u008f\u0001"+
		"\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0091\u0001"+
		"\u0000\u0000\u0000\u0093!\u0001\u0000\u0000\u0000\n-3AJTbdr\u0085\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
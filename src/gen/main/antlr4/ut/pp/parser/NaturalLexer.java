// Generated from /Users/chadmeng/Documents/TCS/M8/PP_Project/src/main/antlr4/ut/pp/parser/NaturalLexer.g4 by ANTLR 4.12.0
package main.antlr4.ut.pp.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NaturalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, IF=3, WHILE=4, PRINT=5, LOCAL=6, GLOBAL=7, LOCK=8, SEMICOLON=9, 
		BRAC=10, PARENS=11, CONST_INT=12, ID=13, TIMES=14, PLUS=15, MINUS=16, 
		RUNPAR=17, ASSIGN=18, EQUALS=19, CONST_BOOL=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOL", "IF", "WHILE", "PRINT", "LOCAL", "GLOBAL", "LOCK", "SEMICOLON", 
			"BRAC", "PARENS", "CONST_INT", "ID", "TIMES", "PLUS", "MINUS", "RUNPAR", 
			"ASSIGN", "EQUALS", "CONST_BOOL"
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


	public NaturalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NaturalLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0014\u00df\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0004\u000b[\b\u000b\u000b\u000b"+
		"\f\u000b\\\u0001\f\u0001\f\u0005\fa\b\f\n\f\f\fd\t\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00d3"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00de\b\u0013\u0000"+
		"\u0000\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000"+
		"\u0004\u0002\u0000{{}}\u0001\u000009\u0002\u0000AZaz\u0003\u000009AZa"+
		"z\u00e6\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000"+
		"\u0000\u0000\u0003-\u0001\u0000\u0000\u0000\u00052\u0001\u0000\u0000\u0000"+
		"\u00075\u0001\u0000\u0000\u0000\t;\u0001\u0000\u0000\u0000\u000bA\u0001"+
		"\u0000\u0000\u0000\rG\u0001\u0000\u0000\u0000\u000fN\u0001\u0000\u0000"+
		"\u0000\u0011S\u0001\u0000\u0000\u0000\u0013U\u0001\u0000\u0000\u0000\u0015"+
		"W\u0001\u0000\u0000\u0000\u0017Z\u0001\u0000\u0000\u0000\u0019^\u0001"+
		"\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000\u001dg\u0001\u0000\u0000"+
		"\u0000\u001fi\u0001\u0000\u0000\u0000!k\u0001\u0000\u0000\u0000#y\u0001"+
		"\u0000\u0000\u0000%\u00d2\u0001\u0000\u0000\u0000\'\u00dd\u0001\u0000"+
		"\u0000\u0000)*\u0005I\u0000\u0000*+\u0005n\u0000\u0000+,\u0005t\u0000"+
		"\u0000,\u0002\u0001\u0000\u0000\u0000-.\u0005B\u0000\u0000./\u0005o\u0000"+
		"\u0000/0\u0005o\u0000\u000001\u0005l\u0000\u00001\u0004\u0001\u0000\u0000"+
		"\u000023\u0005I\u0000\u000034\u0005f\u0000\u00004\u0006\u0001\u0000\u0000"+
		"\u000056\u0005W\u0000\u000067\u0005h\u0000\u000078\u0005i\u0000\u0000"+
		"89\u0005l\u0000\u00009:\u0005e\u0000\u0000:\b\u0001\u0000\u0000\u0000"+
		";<\u0005P\u0000\u0000<=\u0005r\u0000\u0000=>\u0005i\u0000\u0000>?\u0005"+
		"n\u0000\u0000?@\u0005t\u0000\u0000@\n\u0001\u0000\u0000\u0000AB\u0005"+
		"L\u0000\u0000BC\u0005o\u0000\u0000CD\u0005c\u0000\u0000DE\u0005a\u0000"+
		"\u0000EF\u0005l\u0000\u0000F\f\u0001\u0000\u0000\u0000GH\u0005G\u0000"+
		"\u0000HI\u0005l\u0000\u0000IJ\u0005o\u0000\u0000JK\u0005b\u0000\u0000"+
		"KL\u0005a\u0000\u0000LM\u0005l\u0000\u0000M\u000e\u0001\u0000\u0000\u0000"+
		"NO\u0005L\u0000\u0000OP\u0005o\u0000\u0000PQ\u0005c\u0000\u0000QR\u0005"+
		"k\u0000\u0000R\u0010\u0001\u0000\u0000\u0000ST\u0005;\u0000\u0000T\u0012"+
		"\u0001\u0000\u0000\u0000UV\u0007\u0000\u0000\u0000V\u0014\u0001\u0000"+
		"\u0000\u0000WX\u0002()\u0000X\u0016\u0001\u0000\u0000\u0000Y[\u0007\u0001"+
		"\u0000\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001"+
		"\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u0018\u0001\u0000\u0000"+
		"\u0000^b\u0007\u0002\u0000\u0000_a\u0007\u0003\u0000\u0000`_\u0001\u0000"+
		"\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000c\u001a\u0001\u0000\u0000\u0000db\u0001\u0000\u0000"+
		"\u0000ef\u0005*\u0000\u0000f\u001c\u0001\u0000\u0000\u0000gh\u0005+\u0000"+
		"\u0000h\u001e\u0001\u0000\u0000\u0000ij\u0005-\u0000\u0000j \u0001\u0000"+
		"\u0000\u0000kl\u0005R\u0000\u0000lm\u0005u\u0000\u0000mn\u0005n\u0000"+
		"\u0000no\u0005I\u0000\u0000op\u0005n\u0000\u0000pq\u0005P\u0000\u0000"+
		"qr\u0005a\u0000\u0000rs\u0005r\u0000\u0000st\u0005a\u0000\u0000tu\u0005"+
		"l\u0000\u0000uv\u0005l\u0000\u0000vw\u0005e\u0000\u0000wx\u0005l\u0000"+
		"\u0000x\"\u0001\u0000\u0000\u0000yz\u0005=\u0000\u0000z$\u0001\u0000\u0000"+
		"\u0000{|\u0005I\u0000\u0000|}\u0005s\u0000\u0000}~\u0005B\u0000\u0000"+
		"~\u007f\u0005i\u0000\u0000\u007f\u0080\u0005g\u0000\u0000\u0080\u0081"+
		"\u0005g\u0000\u0000\u0081\u0082\u0005e\u0000\u0000\u0082\u0083\u0005r"+
		"\u0000\u0000\u0083\u0084\u0005T\u0000\u0000\u0084\u0085\u0005h\u0000\u0000"+
		"\u0085\u0086\u0005a\u0000\u0000\u0086\u00d3\u0005n\u0000\u0000\u0087\u0088"+
		"\u0005I\u0000\u0000\u0088\u0089\u0005s\u0000\u0000\u0089\u008a\u0005S"+
		"\u0000\u0000\u008a\u008b\u0005m\u0000\u0000\u008b\u008c\u0005a\u0000\u0000"+
		"\u008c\u008d\u0005l\u0000\u0000\u008d\u008e\u0005l\u0000\u0000\u008e\u008f"+
		"\u0005e\u0000\u0000\u008f\u0090\u0005r\u0000\u0000\u0090\u0091\u0005T"+
		"\u0000\u0000\u0091\u0092\u0005h\u0000\u0000\u0092\u0093\u0005a\u0000\u0000"+
		"\u0093\u00d3\u0005n\u0000\u0000\u0094\u0095\u0005I\u0000\u0000\u0095\u0096"+
		"\u0005s\u0000\u0000\u0096\u0097\u0005E\u0000\u0000\u0097\u0098\u0005q"+
		"\u0000\u0000\u0098\u0099\u0005u\u0000\u0000\u0099\u009a\u0005a\u0000\u0000"+
		"\u009a\u009b\u0005l\u0000\u0000\u009b\u009c\u0005T\u0000\u0000\u009c\u00d3"+
		"\u0005o\u0000\u0000\u009d\u009e\u0005I\u0000\u0000\u009e\u009f\u0005s"+
		"\u0000\u0000\u009f\u00a0\u0005S\u0000\u0000\u00a0\u00a1\u0005m\u0000\u0000"+
		"\u00a1\u00a2\u0005a\u0000\u0000\u00a2\u00a3\u0005l\u0000\u0000\u00a3\u00a4"+
		"\u0005l\u0000\u0000\u00a4\u00a5\u0005e\u0000\u0000\u00a5\u00a6\u0005r"+
		"\u0000\u0000\u00a6\u00a7\u0005T\u0000\u0000\u00a7\u00a8\u0005h\u0000\u0000"+
		"\u00a8\u00a9\u0005a\u0000\u0000\u00a9\u00aa\u0005n\u0000\u0000\u00aa\u00ab"+
		"\u0005O\u0000\u0000\u00ab\u00ac\u0005r\u0000\u0000\u00ac\u00ad\u0005E"+
		"\u0000\u0000\u00ad\u00ae\u0005q\u0000\u0000\u00ae\u00af\u0005u\u0000\u0000"+
		"\u00af\u00b0\u0005a\u0000\u0000\u00b0\u00b1\u0005l\u0000\u0000\u00b1\u00b2"+
		"\u0005T\u0000\u0000\u00b2\u00d3\u0005o\u0000\u0000\u00b3\u00b4\u0005I"+
		"\u0000\u0000\u00b4\u00b5\u0005s\u0000\u0000\u00b5\u00b6\u0005B\u0000\u0000"+
		"\u00b6\u00b7\u0005i\u0000\u0000\u00b7\u00b8\u0005g\u0000\u0000\u00b8\u00b9"+
		"\u0005g\u0000\u0000\u00b9\u00ba\u0005e\u0000\u0000\u00ba\u00bb\u0005r"+
		"\u0000\u0000\u00bb\u00bc\u0005T\u0000\u0000\u00bc\u00bd\u0005h\u0000\u0000"+
		"\u00bd\u00be\u0005a\u0000\u0000\u00be\u00bf\u0005n\u0000\u0000\u00bf\u00c0"+
		"\u0005O\u0000\u0000\u00c0\u00c1\u0005r\u0000\u0000\u00c1\u00c2\u0005E"+
		"\u0000\u0000\u00c2\u00c3\u0005q\u0000\u0000\u00c3\u00c4\u0005u\u0000\u0000"+
		"\u00c4\u00c5\u0005a\u0000\u0000\u00c5\u00c6\u0005l\u0000\u0000\u00c6\u00c7"+
		"\u0005T\u0000\u0000\u00c7\u00d3\u0005o\u0000\u0000\u00c8\u00c9\u0005N"+
		"\u0000\u0000\u00c9\u00ca\u0005o\u0000\u0000\u00ca\u00cb\u0005t\u0000\u0000"+
		"\u00cb\u00cc\u0005E\u0000\u0000\u00cc\u00cd\u0005q\u0000\u0000\u00cd\u00ce"+
		"\u0005u\u0000\u0000\u00ce\u00cf\u0005a\u0000\u0000\u00cf\u00d0\u0005l"+
		"\u0000\u0000\u00d0\u00d1\u0005T\u0000\u0000\u00d1\u00d3\u0005o\u0000\u0000"+
		"\u00d2{\u0001\u0000\u0000\u0000\u00d2\u0087\u0001\u0000\u0000\u0000\u00d2"+
		"\u0094\u0001\u0000\u0000\u0000\u00d2\u009d\u0001\u0000\u0000\u0000\u00d2"+
		"\u00b3\u0001\u0000\u0000\u0000\u00d2\u00c8\u0001\u0000\u0000\u0000\u00d3"+
		"&\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005T\u0000\u0000\u00d5\u00d6\u0005"+
		"r\u0000\u0000\u00d6\u00d7\u0005u\u0000\u0000\u00d7\u00de\u0005e\u0000"+
		"\u0000\u00d8\u00d9\u0005F\u0000\u0000\u00d9\u00da\u0005a\u0000\u0000\u00da"+
		"\u00db\u0005l\u0000\u0000\u00db\u00dc\u0005s\u0000\u0000\u00dc\u00de\u0005"+
		"e\u0000\u0000\u00dd\u00d4\u0001\u0000\u0000\u0000\u00dd\u00d8\u0001\u0000"+
		"\u0000\u0000\u00de(\u0001\u0000\u0000\u0000\u0005\u0000\\b\u00d2\u00dd"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
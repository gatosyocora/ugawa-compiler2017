// Generated from parser/PiLang.g4 by ANTLR 4.6
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, NOTOP=15, ADDOP=16, SUBOP=17, 
		MULOP=18, ANDOP=19, OROP=20, CMPOP=21, EQUALOP=22, LOGICANDOP=23, LOGICOROP=24, 
		LOGICNOTOP=25, BREAK=26, IDENTIFIER=27, VALUE=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "NOTOP", "ADDOP", "SUBOP", 
		"MULOP", "ANDOP", "OROP", "CMPOP", "EQUALOP", "LOGICANDOP", "LOGICOROP", 
		"LOGICNOTOP", "BREAK", "IDENTIFIER", "VALUE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'function'", "'('", "')'", "'{'", "'}'", "','", "'var'", "';'", 
		"'='", "'if'", "'else'", "'while'", "'return'", "'print'", "'~'", "'+'", 
		"'-'", null, "'&'", "'|'", null, null, "'&&'", "'||'", "'!'", "'break'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "NOTOP", "ADDOP", "SUBOP", "MULOP", "ANDOP", "OROP", 
		"CMPOP", "EQUALOP", "LOGICANDOP", "LOGICOROP", "LOGICNOTOP", "BREAK", 
		"IDENTIFIER", "VALUE", "WS"
	};
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


	public PiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\5\26\u0082\n\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\6\34\u009c\n\34\r\34\16\34\u009d\5\34\u00a0\n\34\3\35\3\35\3\35"+
		"\7\35\u00a5\n\35\f\35\16\35\u00a8\13\35\5\35\u00aa\n\35\3\36\3\36\3\36"+
		"\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37\3\2\n\4\2,,\61\61\5\2>>@@~~\5\2##??~~\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\u00b4\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5F\3"+
		"\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13L\3\2\2\2\rN\3\2\2\2\17P\3\2\2\2\21T\3"+
		"\2\2\2\23V\3\2\2\2\25X\3\2\2\2\27[\3\2\2\2\31`\3\2\2\2\33f\3\2\2\2\35"+
		"m\3\2\2\2\37s\3\2\2\2!u\3\2\2\2#w\3\2\2\2%y\3\2\2\2\'{\3\2\2\2)}\3\2\2"+
		"\2+\177\3\2\2\2-\u0083\3\2\2\2/\u0086\3\2\2\2\61\u0089\3\2\2\2\63\u008c"+
		"\3\2\2\2\65\u008e\3\2\2\2\67\u009f\3\2\2\29\u00a9\3\2\2\2;\u00ab\3\2\2"+
		"\2=>\7h\2\2>?\7w\2\2?@\7p\2\2@A\7e\2\2AB\7v\2\2BC\7k\2\2CD\7q\2\2DE\7"+
		"p\2\2E\4\3\2\2\2FG\7*\2\2G\6\3\2\2\2HI\7+\2\2I\b\3\2\2\2JK\7}\2\2K\n\3"+
		"\2\2\2LM\7\177\2\2M\f\3\2\2\2NO\7.\2\2O\16\3\2\2\2PQ\7x\2\2QR\7c\2\2R"+
		"S\7t\2\2S\20\3\2\2\2TU\7=\2\2U\22\3\2\2\2VW\7?\2\2W\24\3\2\2\2XY\7k\2"+
		"\2YZ\7h\2\2Z\26\3\2\2\2[\\\7g\2\2\\]\7n\2\2]^\7u\2\2^_\7g\2\2_\30\3\2"+
		"\2\2`a\7y\2\2ab\7j\2\2bc\7k\2\2cd\7n\2\2de\7g\2\2e\32\3\2\2\2fg\7t\2\2"+
		"gh\7g\2\2hi\7v\2\2ij\7w\2\2jk\7t\2\2kl\7p\2\2l\34\3\2\2\2mn\7r\2\2no\7"+
		"t\2\2op\7k\2\2pq\7p\2\2qr\7v\2\2r\36\3\2\2\2st\7\u0080\2\2t \3\2\2\2u"+
		"v\7-\2\2v\"\3\2\2\2wx\7/\2\2x$\3\2\2\2yz\t\2\2\2z&\3\2\2\2{|\7(\2\2|("+
		"\3\2\2\2}~\7~\2\2~*\3\2\2\2\177\u0081\t\3\2\2\u0080\u0082\7?\2\2\u0081"+
		"\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082,\3\2\2\2\u0083\u0084\t\4\2\2"+
		"\u0084\u0085\7?\2\2\u0085.\3\2\2\2\u0086\u0087\7(\2\2\u0087\u0088\7(\2"+
		"\2\u0088\60\3\2\2\2\u0089\u008a\7~\2\2\u008a\u008b\7~\2\2\u008b\62\3\2"+
		"\2\2\u008c\u008d\7#\2\2\u008d\64\3\2\2\2\u008e\u008f\7d\2\2\u008f\u0090"+
		"\7t\2\2\u0090\u0091\7g\2\2\u0091\u0092\7c\2\2\u0092\u0093\7m\2\2\u0093"+
		"\66\3\2\2\2\u0094\u00a0\4z|\2\u0095\u0096\7o\2\2\u0096\u0097\7c\2\2\u0097"+
		"\u0098\7k\2\2\u0098\u00a0\7p\2\2\u0099\u009b\t\5\2\2\u009a\u009c\t\6\2"+
		"\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u0094\3\2\2\2\u009f\u0095\3\2\2\2\u009f"+
		"\u0099\3\2\2\2\u00a08\3\2\2\2\u00a1\u00aa\7\62\2\2\u00a2\u00a6\t\7\2\2"+
		"\u00a3\u00a5\t\b\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00a1\3\2\2\2\u00a9\u00a2\3\2\2\2\u00aa:\3\2\2\2\u00ab\u00ac\t\t\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\36\2\2\u00ae<\3\2\2\2\b\2\u0081\u009d"+
		"\u009f\u00a6\u00a9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
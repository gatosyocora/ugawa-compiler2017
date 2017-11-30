// Generated from parser/TinyPiS.g4 by ANTLR 4.6
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
public class TinyPiSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NOTOP=12, ADDOP=13, SUBOP=14, MULOP=15, ANDOP=16, OROP=17, 
		CMPOP=18, EQUALOP=19, LOGICANDOP=20, LOGICOROP=21, LOGICNOTOP=22, IDENTIFIER=23, 
		VALUE=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NOTOP", "ADDOP", "SUBOP", "MULOP", "ANDOP", "OROP", 
		"CMPOP", "EQUALOP", "LOGICANDOP", "LOGICOROP", "LOGICNOTOP", "IDENTIFIER", 
		"VALUE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'var'", "';'", "'{'", "'}'", "'='", "'if'", "'('", "')'", "'else'", 
		"'while'", "'print'", "'~'", "'+'", "'-'", null, "'&'", "'|'", null, null, 
		"'&&'", "'||'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NOTOP", "ADDOP", "SUBOP", "MULOP", "ANDOP", "OROP", "CMPOP", "EQUALOP", 
		"LOGICANDOP", "LOGICOROP", "LOGICNOTOP", "IDENTIFIER", "VALUE", "WS"
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


	public TinyPiSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TinyPiS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u0091\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\5\23h\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\6\30"+
		"~\n\30\r\30\16\30\177\5\30\u0082\n\30\3\31\3\31\3\31\7\31\u0087\n\31\f"+
		"\31\16\31\u008a\13\31\5\31\u008c\n\31\3\32\3\32\3\32\3\32\2\2\33\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\n\4\2,,\61\61\5\2>>"+
		"@@~~\5\2##??~~\5\2C\\aac|\6\2\62;C\\aac|\3\2\63;\3\2\62;\5\2\13\f\17\17"+
		"\"\"\u0096\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\59\3\2\2\2\7;\3\2\2"+
		"\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23H\3\2\2"+
		"\2\25M\3\2\2\2\27S\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2\35]\3\2\2\2\37_\3\2"+
		"\2\2!a\3\2\2\2#c\3\2\2\2%e\3\2\2\2\'i\3\2\2\2)l\3\2\2\2+o\3\2\2\2-r\3"+
		"\2\2\2/\u0081\3\2\2\2\61\u008b\3\2\2\2\63\u008d\3\2\2\2\65\66\7x\2\2\66"+
		"\67\7c\2\2\678\7t\2\28\4\3\2\2\29:\7=\2\2:\6\3\2\2\2;<\7}\2\2<\b\3\2\2"+
		"\2=>\7\177\2\2>\n\3\2\2\2?@\7?\2\2@\f\3\2\2\2AB\7k\2\2BC\7h\2\2C\16\3"+
		"\2\2\2DE\7*\2\2E\20\3\2\2\2FG\7+\2\2G\22\3\2\2\2HI\7g\2\2IJ\7n\2\2JK\7"+
		"u\2\2KL\7g\2\2L\24\3\2\2\2MN\7y\2\2NO\7j\2\2OP\7k\2\2PQ\7n\2\2QR\7g\2"+
		"\2R\26\3\2\2\2ST\7r\2\2TU\7t\2\2UV\7k\2\2VW\7p\2\2WX\7v\2\2X\30\3\2\2"+
		"\2YZ\7\u0080\2\2Z\32\3\2\2\2[\\\7-\2\2\\\34\3\2\2\2]^\7/\2\2^\36\3\2\2"+
		"\2_`\t\2\2\2` \3\2\2\2ab\7(\2\2b\"\3\2\2\2cd\7~\2\2d$\3\2\2\2eg\t\3\2"+
		"\2fh\7?\2\2gf\3\2\2\2gh\3\2\2\2h&\3\2\2\2ij\t\4\2\2jk\7?\2\2k(\3\2\2\2"+
		"lm\7(\2\2mn\7(\2\2n*\3\2\2\2op\7~\2\2pq\7~\2\2q,\3\2\2\2rs\7#\2\2s.\3"+
		"\2\2\2t\u0082\4z|\2uv\7c\2\2vw\7p\2\2wx\7u\2\2xy\7y\2\2yz\7g\2\2z\u0082"+
		"\7t\2\2{}\t\5\2\2|~\t\6\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0082\3\2\2\2\u0081t\3\2\2\2\u0081u\3\2\2\2\u0081{\3\2"+
		"\2\2\u0082\60\3\2\2\2\u0083\u008c\7\62\2\2\u0084\u0088\t\7\2\2\u0085\u0087"+
		"\t\b\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0083\3\2"+
		"\2\2\u008b\u0084\3\2\2\2\u008c\62\3\2\2\2\u008d\u008e\t\t\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0090\b\32\2\2\u0090\64\3\2\2\2\b\2g\177\u0081\u0088\u008b"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
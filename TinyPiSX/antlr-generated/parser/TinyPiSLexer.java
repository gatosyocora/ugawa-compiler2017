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
		CMPOP=18, EQUALOP=19, IDENTIFIER=20, VALUE=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NOTOP", "ADDOP", "SUBOP", "MULOP", "ANDOP", "OROP", 
		"CMPOP", "EQUALOP", "IDENTIFIER", "VALUE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'var'", "';'", "'{'", "'}'", "'='", "'if'", "'('", "')'", "'else'", 
		"'while'", "'print'", "'~'", "'+'", "'-'", null, "'&'", "'|'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NOTOP", "ADDOP", "SUBOP", "MULOP", "ANDOP", "OROP", "CMPOP", "EQUALOP", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\5\23"+
		"b\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\6\25"+
		"p\n\25\r\25\16\25q\5\25t\n\25\3\26\3\26\3\26\7\26y\n\26\f\26\16\26|\13"+
		"\26\5\26~\n\26\3\27\3\27\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30\3\2\n\4\2,,\61\61\5\2>>@@~~\5\2##??~~\5\2C\\aac|\6\2\62;C\\aa"+
		"c|\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\u0088\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2"+
		"\2\t\67\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17>\3\2\2\2\21@\3\2\2\2\23B\3\2"+
		"\2\2\25G\3\2\2\2\27M\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37Y\3"+
		"\2\2\2![\3\2\2\2#]\3\2\2\2%_\3\2\2\2\'c\3\2\2\2)s\3\2\2\2+}\3\2\2\2-\177"+
		"\3\2\2\2/\60\7x\2\2\60\61\7c\2\2\61\62\7t\2\2\62\4\3\2\2\2\63\64\7=\2"+
		"\2\64\6\3\2\2\2\65\66\7}\2\2\66\b\3\2\2\2\678\7\177\2\28\n\3\2\2\29:\7"+
		"?\2\2:\f\3\2\2\2;<\7k\2\2<=\7h\2\2=\16\3\2\2\2>?\7*\2\2?\20\3\2\2\2@A"+
		"\7+\2\2A\22\3\2\2\2BC\7g\2\2CD\7n\2\2DE\7u\2\2EF\7g\2\2F\24\3\2\2\2GH"+
		"\7y\2\2HI\7j\2\2IJ\7k\2\2JK\7n\2\2KL\7g\2\2L\26\3\2\2\2MN\7r\2\2NO\7t"+
		"\2\2OP\7k\2\2PQ\7p\2\2QR\7v\2\2R\30\3\2\2\2ST\7\u0080\2\2T\32\3\2\2\2"+
		"UV\7-\2\2V\34\3\2\2\2WX\7/\2\2X\36\3\2\2\2YZ\t\2\2\2Z \3\2\2\2[\\\7(\2"+
		"\2\\\"\3\2\2\2]^\7~\2\2^$\3\2\2\2_a\t\3\2\2`b\7?\2\2a`\3\2\2\2ab\3\2\2"+
		"\2b&\3\2\2\2cd\t\4\2\2de\7?\2\2e(\3\2\2\2ft\4z|\2gh\7c\2\2hi\7p\2\2ij"+
		"\7u\2\2jk\7y\2\2kl\7g\2\2lt\7t\2\2mo\t\5\2\2np\t\6\2\2on\3\2\2\2pq\3\2"+
		"\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sf\3\2\2\2sg\3\2\2\2sm\3\2\2\2t*\3\2"+
		"\2\2u~\7\62\2\2vz\t\7\2\2wy\t\b\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3"+
		"\2\2\2{~\3\2\2\2|z\3\2\2\2}u\3\2\2\2}v\3\2\2\2~,\3\2\2\2\177\u0080\t\t"+
		"\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\27\2\2\u0082.\3\2\2\2\b\2aqsz}"+
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
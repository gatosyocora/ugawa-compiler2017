// Generated from parser/TinyPiS.g4 by ANTLR 4.6
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinyPiSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NOTOP=12, ADDOP=13, SUBOP=14, MULOP=15, ANDOP=16, OROP=17, 
		CMPOP=18, EQUALOP=19, LOGICANDOP=20, LOGICOROP=21, LOGICNOTOP=22, IDENTIFIER=23, 
		VALUE=24, WS=25;
	public static final int
		RULE_prog = 0, RULE_varDecls = 1, RULE_stmt = 2, RULE_expr = 3, RULE_logicOrExpr = 4, 
		RULE_logicAndExpr = 5, RULE_orExpr = 6, RULE_andExpr = 7, RULE_equalExpr = 8, 
		RULE_cmpExpr = 9, RULE_addExpr = 10, RULE_mulExpr = 11, RULE_logicNotExpr = 12, 
		RULE_unaryExpr = 13;
	public static final String[] ruleNames = {
		"prog", "varDecls", "stmt", "expr", "logicOrExpr", "logicAndExpr", "orExpr", 
		"andExpr", "equalExpr", "cmpExpr", "addExpr", "mulExpr", "logicNotExpr", 
		"unaryExpr"
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

	@Override
	public String getGrammarFileName() { return "TinyPiS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TinyPiSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			varDecls();
			setState(29);
			stmt();
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

	public static class VarDeclsContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(TinyPiSParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(TinyPiSParser.IDENTIFIER, i);
		}
		public VarDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecls; }
	}

	public final VarDeclsContext varDecls() throws RecognitionException {
		VarDeclsContext _localctx = new VarDeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_varDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(31);
				match(T__0);
				setState(32);
				match(IDENTIFIER);
				setState(33);
				match(T__1);
				}
				}
				setState(38);
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

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class CompoundStmtContext extends StmtContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public CompoundStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStmtContext extends StmtContext {
		public TerminalNode IDENTIFIER() { return getToken(TinyPiSParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new CompoundStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(T__2);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(40);
					stmt();
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(46);
				match(T__3);
				}
				break;
			case IDENTIFIER:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(IDENTIFIER);
				setState(48);
				match(T__4);
				setState(49);
				expr();
				setState(50);
				match(T__1);
				}
				break;
			case T__5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				match(T__5);
				setState(53);
				match(T__6);
				setState(54);
				expr();
				setState(55);
				match(T__7);
				setState(56);
				stmt();
				setState(57);
				match(T__8);
				setState(58);
				stmt();
				}
				break;
			case T__9:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				match(T__9);
				setState(61);
				match(T__6);
				setState(62);
				expr();
				setState(63);
				match(T__7);
				setState(64);
				stmt();
				}
				break;
			case T__10:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				match(T__10);
				setState(67);
				expr();
				setState(68);
				match(T__1);
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

	public static class ExprContext extends ParserRuleContext {
		public LogicOrExprContext logicOrExpr() {
			return getRuleContext(LogicOrExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			logicOrExpr(0);
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

	public static class LogicOrExprContext extends ParserRuleContext {
		public LogicAndExprContext logicAndExpr() {
			return getRuleContext(LogicAndExprContext.class,0);
		}
		public LogicOrExprContext logicOrExpr() {
			return getRuleContext(LogicOrExprContext.class,0);
		}
		public TerminalNode LOGICOROP() { return getToken(TinyPiSParser.LOGICOROP, 0); }
		public LogicOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrExpr; }
	}

	public final LogicOrExprContext logicOrExpr() throws RecognitionException {
		return logicOrExpr(0);
	}

	private LogicOrExprContext logicOrExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicOrExprContext _localctx = new LogicOrExprContext(_ctx, _parentState);
		LogicOrExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_logicOrExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(75);
			logicAndExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicOrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicOrExpr);
					setState(77);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(78);
					match(LOGICOROP);
					setState(79);
					logicAndExpr(0);
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class LogicAndExprContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public LogicAndExprContext logicAndExpr() {
			return getRuleContext(LogicAndExprContext.class,0);
		}
		public TerminalNode LOGICANDOP() { return getToken(TinyPiSParser.LOGICANDOP, 0); }
		public LogicAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndExpr; }
	}

	public final LogicAndExprContext logicAndExpr() throws RecognitionException {
		return logicAndExpr(0);
	}

	private LogicAndExprContext logicAndExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicAndExprContext _localctx = new LogicAndExprContext(_ctx, _parentState);
		LogicAndExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_logicAndExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(86);
			orExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicAndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicAndExpr);
					setState(88);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(89);
					match(LOGICANDOP);
					setState(90);
					orExpr(0);
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class OrExprContext extends ParserRuleContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode OROP() { return getToken(TinyPiSParser.OROP, 0); }
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
	}

	public final OrExprContext orExpr() throws RecognitionException {
		return orExpr(0);
	}

	private OrExprContext orExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrExprContext _localctx = new OrExprContext(_ctx, _parentState);
		OrExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_orExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(97);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(99);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(100);
					match(OROP);
					setState(101);
					andExpr(0);
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class AndExprContext extends ParserRuleContext {
		public EqualExprContext equalExpr() {
			return getRuleContext(EqualExprContext.class,0);
		}
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode ANDOP() { return getToken(TinyPiSParser.ANDOP, 0); }
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(108);
			equalExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(110);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(111);
					match(ANDOP);
					setState(112);
					equalExpr(0);
					}
					} 
				}
				setState(117);
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

	public static class EqualExprContext extends ParserRuleContext {
		public CmpExprContext cmpExpr() {
			return getRuleContext(CmpExprContext.class,0);
		}
		public EqualExprContext equalExpr() {
			return getRuleContext(EqualExprContext.class,0);
		}
		public TerminalNode EQUALOP() { return getToken(TinyPiSParser.EQUALOP, 0); }
		public EqualExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalExpr; }
	}

	public final EqualExprContext equalExpr() throws RecognitionException {
		return equalExpr(0);
	}

	private EqualExprContext equalExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualExprContext _localctx = new EqualExprContext(_ctx, _parentState);
		EqualExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_equalExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(119);
			cmpExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equalExpr);
					setState(121);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(122);
					match(EQUALOP);
					setState(123);
					cmpExpr(0);
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class CmpExprContext extends ParserRuleContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public CmpExprContext cmpExpr() {
			return getRuleContext(CmpExprContext.class,0);
		}
		public TerminalNode CMPOP() { return getToken(TinyPiSParser.CMPOP, 0); }
		public CmpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpExpr; }
	}

	public final CmpExprContext cmpExpr() throws RecognitionException {
		return cmpExpr(0);
	}

	private CmpExprContext cmpExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CmpExprContext _localctx = new CmpExprContext(_ctx, _parentState);
		CmpExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_cmpExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(130);
			addExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CmpExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cmpExpr);
					setState(132);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(133);
					match(CMPOP);
					setState(134);
					addExpr(0);
					}
					} 
				}
				setState(139);
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

	public static class AddExprContext extends ParserRuleContext {
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(TinyPiSParser.ADDOP, 0); }
		public TerminalNode SUBOP() { return getToken(TinyPiSParser.SUBOP, 0); }
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
	}

	public final AddExprContext addExpr() throws RecognitionException {
		return addExpr(0);
	}

	private AddExprContext addExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExprContext _localctx = new AddExprContext(_ctx, _parentState);
		AddExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_addExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(141);
			mulExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
						setState(143);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(144);
						match(ADDOP);
						setState(145);
						mulExpr(0);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
						setState(146);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(147);
						match(SUBOP);
						setState(148);
						mulExpr(0);
						}
						break;
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class MulExprContext extends ParserRuleContext {
		public LogicNotExprContext logicNotExpr() {
			return getRuleContext(LogicNotExprContext.class,0);
		}
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(TinyPiSParser.MULOP, 0); }
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		return mulExpr(0);
	}

	private MulExprContext mulExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExprContext _localctx = new MulExprContext(_ctx, _parentState);
		MulExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_mulExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(155);
			logicNotExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExpr);
					setState(157);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(158);
					match(MULOP);
					setState(159);
					logicNotExpr();
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class LogicNotExprContext extends ParserRuleContext {
		public TerminalNode LOGICNOTOP() { return getToken(TinyPiSParser.LOGICNOTOP, 0); }
		public LogicNotExprContext logicNotExpr() {
			return getRuleContext(LogicNotExprContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public LogicNotExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicNotExpr; }
	}

	public final LogicNotExprContext logicNotExpr() throws RecognitionException {
		LogicNotExprContext _localctx = new LogicNotExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logicNotExpr);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOGICNOTOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(LOGICNOTOP);
				setState(166);
				logicNotExpr();
				}
				break;
			case T__6:
			case NOTOP:
			case SUBOP:
			case IDENTIFIER:
			case VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				unaryExpr();
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

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	 
		public UnaryExprContext() { }
		public void copyFrom(UnaryExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarExprContext extends UnaryExprContext {
		public TerminalNode IDENTIFIER() { return getToken(TinyPiSParser.IDENTIFIER, 0); }
		public VarExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class NotExprContext extends UnaryExprContext {
		public TerminalNode NOTOP() { return getToken(TinyPiSParser.NOTOP, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public NotExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExprContext extends UnaryExprContext {
		public TerminalNode VALUE() { return getToken(TinyPiSParser.VALUE, 0); }
		public LiteralExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class SubExprContext extends UnaryExprContext {
		public TerminalNode SUBOP() { return getToken(TinyPiSParser.SUBOP, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public SubExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExprContext extends UnaryExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unaryExpr);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUE:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(VALUE);
				}
				break;
			case IDENTIFIER:
				_localctx = new VarExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(IDENTIFIER);
				}
				break;
			case T__6:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(T__6);
				setState(173);
				expr();
				setState(174);
				match(T__7);
				}
				break;
			case SUBOP:
				_localctx = new SubExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(SUBOP);
				setState(177);
				unaryExpr();
				}
				break;
			case NOTOP:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				match(NOTOP);
				setState(179);
				unaryExpr();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return logicOrExpr_sempred((LogicOrExprContext)_localctx, predIndex);
		case 5:
			return logicAndExpr_sempred((LogicAndExprContext)_localctx, predIndex);
		case 6:
			return orExpr_sempred((OrExprContext)_localctx, predIndex);
		case 7:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 8:
			return equalExpr_sempred((EqualExprContext)_localctx, predIndex);
		case 9:
			return cmpExpr_sempred((CmpExprContext)_localctx, predIndex);
		case 10:
			return addExpr_sempred((AddExprContext)_localctx, predIndex);
		case 11:
			return mulExpr_sempred((MulExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicOrExpr_sempred(LogicOrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean logicAndExpr_sempred(LogicAndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean orExpr_sempred(OrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equalExpr_sempred(EqualExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean cmpExpr_sempred(CmpExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean addExpr_sempred(AddExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulExpr_sempred(MulExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00b9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\7\3"+
		"%\n\3\f\3\16\3(\13\3\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4I\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6S\n\6\f\6\16\6V\13"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\7\bi\n\b\f\b\16\bl\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tt\n\t\f\t\16\t"+
		"w\13\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\177\n\n\f\n\16\n\u0082\13\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u008a\n\13\f\13\16\13\u008d\13\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b\13\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u00a3\n\r\f\r\16\r\u00a6\13\r\3\16\3\16\3\16\5\16"+
		"\u00ab\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b7"+
		"\n\17\3\17\2\n\n\f\16\20\22\24\26\30\20\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\2\2\u00be\2\36\3\2\2\2\4&\3\2\2\2\6H\3\2\2\2\bJ\3\2\2\2\nL\3\2"+
		"\2\2\fW\3\2\2\2\16b\3\2\2\2\20m\3\2\2\2\22x\3\2\2\2\24\u0083\3\2\2\2\26"+
		"\u008e\3\2\2\2\30\u009c\3\2\2\2\32\u00aa\3\2\2\2\34\u00b6\3\2\2\2\36\37"+
		"\5\4\3\2\37 \5\6\4\2 \3\3\2\2\2!\"\7\3\2\2\"#\7\31\2\2#%\7\4\2\2$!\3\2"+
		"\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\5\3\2\2\2(&\3\2\2\2)-\7\5\2\2*,"+
		"\5\6\4\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2"+
		"\60I\7\6\2\2\61\62\7\31\2\2\62\63\7\7\2\2\63\64\5\b\5\2\64\65\7\4\2\2"+
		"\65I\3\2\2\2\66\67\7\b\2\2\678\7\t\2\289\5\b\5\29:\7\n\2\2:;\5\6\4\2;"+
		"<\7\13\2\2<=\5\6\4\2=I\3\2\2\2>?\7\f\2\2?@\7\t\2\2@A\5\b\5\2AB\7\n\2\2"+
		"BC\5\6\4\2CI\3\2\2\2DE\7\r\2\2EF\5\b\5\2FG\7\4\2\2GI\3\2\2\2H)\3\2\2\2"+
		"H\61\3\2\2\2H\66\3\2\2\2H>\3\2\2\2HD\3\2\2\2I\7\3\2\2\2JK\5\n\6\2K\t\3"+
		"\2\2\2LM\b\6\1\2MN\5\f\7\2NT\3\2\2\2OP\f\4\2\2PQ\7\27\2\2QS\5\f\7\2RO"+
		"\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\13\3\2\2\2VT\3\2\2\2WX\b\7\1\2"+
		"XY\5\16\b\2Y_\3\2\2\2Z[\f\4\2\2[\\\7\26\2\2\\^\5\16\b\2]Z\3\2\2\2^a\3"+
		"\2\2\2_]\3\2\2\2_`\3\2\2\2`\r\3\2\2\2a_\3\2\2\2bc\b\b\1\2cd\5\20\t\2d"+
		"j\3\2\2\2ef\f\4\2\2fg\7\23\2\2gi\5\20\t\2he\3\2\2\2il\3\2\2\2jh\3\2\2"+
		"\2jk\3\2\2\2k\17\3\2\2\2lj\3\2\2\2mn\b\t\1\2no\5\22\n\2ou\3\2\2\2pq\f"+
		"\4\2\2qr\7\22\2\2rt\5\22\n\2sp\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v"+
		"\21\3\2\2\2wu\3\2\2\2xy\b\n\1\2yz\5\24\13\2z\u0080\3\2\2\2{|\f\4\2\2|"+
		"}\7\25\2\2}\177\5\24\13\2~{\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\23\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\b\13\1"+
		"\2\u0084\u0085\5\26\f\2\u0085\u008b\3\2\2\2\u0086\u0087\f\4\2\2\u0087"+
		"\u0088\7\24\2\2\u0088\u008a\5\26\f\2\u0089\u0086\3\2\2\2\u008a\u008d\3"+
		"\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\25\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u008f\b\f\1\2\u008f\u0090\5\30\r\2\u0090\u0099\3"+
		"\2\2\2\u0091\u0092\f\5\2\2\u0092\u0093\7\17\2\2\u0093\u0098\5\30\r\2\u0094"+
		"\u0095\f\4\2\2\u0095\u0096\7\20\2\2\u0096\u0098\5\30\r\2\u0097\u0091\3"+
		"\2\2\2\u0097\u0094\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\27\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\b\r\1"+
		"\2\u009d\u009e\5\32\16\2\u009e\u00a4\3\2\2\2\u009f\u00a0\f\4\2\2\u00a0"+
		"\u00a1\7\21\2\2\u00a1\u00a3\5\32\16\2\u00a2\u009f\3\2\2\2\u00a3\u00a6"+
		"\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\31\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00a8\7\30\2\2\u00a8\u00ab\5\32\16\2\u00a9\u00ab"+
		"\5\34\17\2\u00aa\u00a7\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\33\3\2\2\2\u00ac"+
		"\u00b7\7\32\2\2\u00ad\u00b7\7\31\2\2\u00ae\u00af\7\t\2\2\u00af\u00b0\5"+
		"\b\5\2\u00b0\u00b1\7\n\2\2\u00b1\u00b7\3\2\2\2\u00b2\u00b3\7\20\2\2\u00b3"+
		"\u00b7\5\34\17\2\u00b4\u00b5\7\16\2\2\u00b5\u00b7\5\34\17\2\u00b6\u00ac"+
		"\3\2\2\2\u00b6\u00ad\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\35\3\2\2\2\20&-HT_ju\u0080\u008b\u0097\u0099\u00a4"+
		"\u00aa\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
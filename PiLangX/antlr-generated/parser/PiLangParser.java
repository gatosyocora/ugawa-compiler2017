// Generated from parser/PiLang.g4 by ANTLR 4.6
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
public class PiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, NOTOP=15, ADDOP=16, SUBOP=17, 
		MULOP=18, ANDOP=19, OROP=20, CMPOP=21, EQUALOP=22, LOGICANDOP=23, LOGICOROP=24, 
		LOGICNOTOP=25, BREAK=26, IDENTIFIER=27, VALUE=28, WS=29;
	public static final int
		RULE_prog = 0, RULE_funcDecl = 1, RULE_params = 2, RULE_varDecls = 3, 
		RULE_stmt = 4, RULE_stmtd = 5, RULE_expr = 6, RULE_logicOrExpr = 7, RULE_logicAndExpr = 8, 
		RULE_orExpr = 9, RULE_andExpr = 10, RULE_equalExpr = 11, RULE_cmpExpr = 12, 
		RULE_addExpr = 13, RULE_mulExpr = 14, RULE_logicNotExpr = 15, RULE_unaryExpr = 16, 
		RULE_args = 17;
	public static final String[] ruleNames = {
		"prog", "funcDecl", "params", "varDecls", "stmt", "stmtd", "expr", "logicOrExpr", 
		"logicAndExpr", "orExpr", "andExpr", "equalExpr", "cmpExpr", "addExpr", 
		"mulExpr", "logicNotExpr", "unaryExpr", "args"
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

	@Override
	public String getGrammarFileName() { return "PiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public List<FuncDeclContext> funcDecl() {
			return getRuleContexts(FuncDeclContext.class);
		}
		public FuncDeclContext funcDecl(int i) {
			return getRuleContext(FuncDeclContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			varDecls();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(37);
				funcDecl();
				}
				}
				setState(42);
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

	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public VarDeclsContext varDecls() {
			return getRuleContext(VarDeclsContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			setState(44);
			match(IDENTIFIER);
			setState(45);
			match(T__1);
			setState(46);
			params();
			setState(47);
			match(T__2);
			setState(48);
			match(T__3);
			setState(49);
			varDecls();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(50);
				stmt();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(T__4);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PiLangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PiLangParser.IDENTIFIER, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(IDENTIFIER);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(60);
					match(T__5);
					setState(61);
					match(IDENTIFIER);
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class VarDeclsContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(PiLangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PiLangParser.IDENTIFIER, i);
		}
		public VarDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecls; }
	}

	public final VarDeclsContext varDecls() throws RecognitionException {
		VarDeclsContext _localctx = new VarDeclsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(69);
				match(T__6);
				setState(70);
				match(IDENTIFIER);
				setState(71);
				match(T__7);
				}
				}
				setState(76);
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
		public StmtdContext stmtd() {
			return getRuleContext(StmtdContext.class,0);
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
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		int _la;
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new CompoundStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(T__3);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(78);
					stmt();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(T__4);
				}
				break;
			case IDENTIFIER:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(IDENTIFIER);
				setState(86);
				match(T__8);
				setState(87);
				expr();
				setState(88);
				match(T__7);
				}
				break;
			case T__9:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__9);
				setState(91);
				match(T__1);
				setState(92);
				expr();
				setState(93);
				match(T__2);
				setState(94);
				stmt();
				setState(95);
				match(T__10);
				setState(96);
				stmt();
				}
				break;
			case T__11:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				match(T__11);
				setState(99);
				match(T__1);
				setState(100);
				expr();
				setState(101);
				match(T__2);
				setState(102);
				stmtd();
				}
				break;
			case T__12:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(104);
				match(T__12);
				setState(105);
				expr();
				setState(106);
				match(T__7);
				}
				break;
			case T__13:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				match(T__13);
				setState(109);
				expr();
				setState(110);
				match(T__7);
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

	public static class StmtdContext extends ParserRuleContext {
		public StmtdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtd; }
	 
		public StmtdContext() { }
		public void copyFrom(StmtdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompoundStmtdContext extends StmtdContext {
		public List<StmtdContext> stmtd() {
			return getRuleContexts(StmtdContext.class);
		}
		public StmtdContext stmtd(int i) {
			return getRuleContext(StmtdContext.class,i);
		}
		public CompoundStmtdContext(StmtdContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStmtdContext extends StmtdContext {
		public TerminalNode BREAK() { return getToken(PiLangParser.BREAK, 0); }
		public BreakStmtdContext(StmtdContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtdContext extends StmtdContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtdContext> stmtd() {
			return getRuleContexts(StmtdContext.class);
		}
		public StmtdContext stmtd(int i) {
			return getRuleContext(StmtdContext.class,i);
		}
		public IfStmtdContext(StmtdContext ctx) { copyFrom(ctx); }
	}
	public static class RemoveStmtdContext extends StmtdContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public RemoveStmtdContext(StmtdContext ctx) { copyFrom(ctx); }
	}

	public final StmtdContext stmtd() throws RecognitionException {
		StmtdContext _localctx = new StmtdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmtd);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new BreakStmtdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(BREAK);
				setState(115);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new CompoundStmtdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__3);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << BREAK) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(117);
					stmtd();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(T__4);
				}
				break;
			case 3:
				_localctx = new IfStmtdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(T__9);
				setState(125);
				match(T__1);
				setState(126);
				expr();
				setState(127);
				match(T__2);
				setState(128);
				stmtd();
				setState(129);
				match(T__10);
				setState(130);
				stmtd();
				}
				break;
			case 4:
				_localctx = new RemoveStmtdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				stmt();
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
		enterRule(_localctx, 12, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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
		public TerminalNode LOGICOROP() { return getToken(PiLangParser.LOGICOROP, 0); }
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_logicOrExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(138);
			logicAndExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicOrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicOrExpr);
					setState(140);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(141);
					match(LOGICOROP);
					setState(142);
					logicAndExpr(0);
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public TerminalNode LOGICANDOP() { return getToken(PiLangParser.LOGICANDOP, 0); }
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_logicAndExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(149);
			orExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicAndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicAndExpr);
					setState(151);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(152);
					match(LOGICANDOP);
					setState(153);
					orExpr(0);
					}
					} 
				}
				setState(158);
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

	public static class OrExprContext extends ParserRuleContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode OROP() { return getToken(PiLangParser.OROP, 0); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_orExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(160);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(162);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(163);
					match(OROP);
					setState(164);
					andExpr(0);
					}
					} 
				}
				setState(169);
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

	public static class AndExprContext extends ParserRuleContext {
		public EqualExprContext equalExpr() {
			return getRuleContext(EqualExprContext.class,0);
		}
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode ANDOP() { return getToken(PiLangParser.ANDOP, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(171);
			equalExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(173);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(174);
					match(ANDOP);
					setState(175);
					equalExpr(0);
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public TerminalNode EQUALOP() { return getToken(PiLangParser.EQUALOP, 0); }
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_equalExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(182);
			cmpExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equalExpr);
					setState(184);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(185);
					match(EQUALOP);
					setState(186);
					cmpExpr(0);
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public TerminalNode CMPOP() { return getToken(PiLangParser.CMPOP, 0); }
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_cmpExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(193);
			addExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CmpExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cmpExpr);
					setState(195);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(196);
					match(CMPOP);
					setState(197);
					addExpr(0);
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public TerminalNode ADDOP() { return getToken(PiLangParser.ADDOP, 0); }
		public TerminalNode SUBOP() { return getToken(PiLangParser.SUBOP, 0); }
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_addExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(204);
			mulExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(212);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
						setState(206);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(207);
						match(ADDOP);
						setState(208);
						mulExpr(0);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
						setState(209);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(210);
						match(SUBOP);
						setState(211);
						mulExpr(0);
						}
						break;
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public TerminalNode MULOP() { return getToken(PiLangParser.MULOP, 0); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_mulExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(218);
			logicNotExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExpr);
					setState(220);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(221);
					match(MULOP);
					setState(222);
					logicNotExpr();
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public TerminalNode LOGICNOTOP() { return getToken(PiLangParser.LOGICNOTOP, 0); }
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
		enterRule(_localctx, 30, RULE_logicNotExpr);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOGICNOTOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(LOGICNOTOP);
				setState(229);
				logicNotExpr();
				}
				break;
			case T__1:
			case NOTOP:
			case SUBOP:
			case IDENTIFIER:
			case VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
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
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public VarExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class NotExprContext extends UnaryExprContext {
		public TerminalNode NOTOP() { return getToken(PiLangParser.NOTOP, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public NotExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExprContext extends UnaryExprContext {
		public TerminalNode VALUE() { return getToken(PiLangParser.VALUE, 0); }
		public LiteralExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class SubExprContext extends UnaryExprContext {
		public TerminalNode SUBOP() { return getToken(PiLangParser.SUBOP, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public SubExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class CallExprContext extends UnaryExprContext {
		public TerminalNode IDENTIFIER() { return getToken(PiLangParser.IDENTIFIER, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CallExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExprContext extends UnaryExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(UnaryExprContext ctx) { copyFrom(ctx); }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unaryExpr);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(VALUE);
				}
				break;
			case 2:
				_localctx = new VarExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(IDENTIFIER);
				}
				break;
			case 3:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(T__1);
				setState(236);
				expr();
				setState(237);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new SubExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(239);
				match(SUBOP);
				setState(240);
				unaryExpr();
				}
				break;
			case 5:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(241);
				match(NOTOP);
				setState(242);
				unaryExpr();
				}
				break;
			case 6:
				_localctx = new CallExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				match(IDENTIFIER);
				setState(244);
				match(T__1);
				setState(245);
				args();
				setState(246);
				match(T__2);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_args);
		int _la;
		try {
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__1:
			case NOTOP:
			case SUBOP:
			case LOGICNOTOP:
			case IDENTIFIER:
			case VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				expr();
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(252);
					match(T__5);
					setState(253);
					expr();
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		case 7:
			return logicOrExpr_sempred((LogicOrExprContext)_localctx, predIndex);
		case 8:
			return logicAndExpr_sempred((LogicAndExprContext)_localctx, predIndex);
		case 9:
			return orExpr_sempred((OrExprContext)_localctx, predIndex);
		case 10:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 11:
			return equalExpr_sempred((EqualExprContext)_localctx, predIndex);
		case 12:
			return cmpExpr_sempred((CmpExprContext)_localctx, predIndex);
		case 13:
			return addExpr_sempred((AddExprContext)_localctx, predIndex);
		case 14:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u0108\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3\66\n\3\f\3\16\39\13\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4A\n\4\f\4\16"+
		"\4D\13\4\5\4F\n\4\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\6\3\6\7\6R\n\6"+
		"\f\6\16\6U\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6s\n\6\3"+
		"\7\3\7\3\7\3\7\7\7y\n\7\f\7\16\7|\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u0088\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0092\n\t\f"+
		"\t\16\t\u0095\13\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u009d\n\n\f\n\16\n\u00a0"+
		"\13\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a8\n\13\f\13\16\13\u00ab\13"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b3\n\f\f\f\16\f\u00b6\13\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u00be\n\r\f\r\16\r\u00c1\13\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u00c9\n\16\f\16\16\16\u00cc\13\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00d7\n\17\f\17\16\17\u00da\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u00e2\n\20\f\20\16\20\u00e5\13\20\3\21"+
		"\3\21\3\21\5\21\u00ea\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fb\n\22\3\23\3\23\3\23\3\23\7\23"+
		"\u0101\n\23\f\23\16\23\u0104\13\23\5\23\u0106\n\23\3\23\2\n\20\22\24\26"+
		"\30\32\34\36\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\u0115\2"+
		"&\3\2\2\2\4-\3\2\2\2\6E\3\2\2\2\bL\3\2\2\2\nr\3\2\2\2\f\u0087\3\2\2\2"+
		"\16\u0089\3\2\2\2\20\u008b\3\2\2\2\22\u0096\3\2\2\2\24\u00a1\3\2\2\2\26"+
		"\u00ac\3\2\2\2\30\u00b7\3\2\2\2\32\u00c2\3\2\2\2\34\u00cd\3\2\2\2\36\u00db"+
		"\3\2\2\2 \u00e9\3\2\2\2\"\u00fa\3\2\2\2$\u0105\3\2\2\2&*\5\b\5\2\')\5"+
		"\4\3\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\3\3\2\2\2,*\3\2\2\2-"+
		".\7\3\2\2./\7\35\2\2/\60\7\4\2\2\60\61\5\6\4\2\61\62\7\5\2\2\62\63\7\6"+
		"\2\2\63\67\5\b\5\2\64\66\5\n\6\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2"+
		"\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\7\7\2\2;\5\3\2\2\2<F\3\2\2\2=B"+
		"\7\35\2\2>?\7\b\2\2?A\7\35\2\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2"+
		"CF\3\2\2\2DB\3\2\2\2E<\3\2\2\2E=\3\2\2\2F\7\3\2\2\2GH\7\t\2\2HI\7\35\2"+
		"\2IK\7\n\2\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\t\3\2\2\2NL\3\2"+
		"\2\2OS\7\6\2\2PR\5\n\6\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2"+
		"\2\2US\3\2\2\2Vs\7\7\2\2WX\7\35\2\2XY\7\13\2\2YZ\5\16\b\2Z[\7\n\2\2[s"+
		"\3\2\2\2\\]\7\f\2\2]^\7\4\2\2^_\5\16\b\2_`\7\5\2\2`a\5\n\6\2ab\7\r\2\2"+
		"bc\5\n\6\2cs\3\2\2\2de\7\16\2\2ef\7\4\2\2fg\5\16\b\2gh\7\5\2\2hi\5\f\7"+
		"\2is\3\2\2\2jk\7\17\2\2kl\5\16\b\2lm\7\n\2\2ms\3\2\2\2no\7\20\2\2op\5"+
		"\16\b\2pq\7\n\2\2qs\3\2\2\2rO\3\2\2\2rW\3\2\2\2r\\\3\2\2\2rd\3\2\2\2r"+
		"j\3\2\2\2rn\3\2\2\2s\13\3\2\2\2tu\7\34\2\2u\u0088\7\n\2\2vz\7\6\2\2wy"+
		"\5\f\7\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}"+
		"\u0088\7\7\2\2~\177\7\f\2\2\177\u0080\7\4\2\2\u0080\u0081\5\16\b\2\u0081"+
		"\u0082\7\5\2\2\u0082\u0083\5\f\7\2\u0083\u0084\7\r\2\2\u0084\u0085\5\f"+
		"\7\2\u0085\u0088\3\2\2\2\u0086\u0088\5\n\6\2\u0087t\3\2\2\2\u0087v\3\2"+
		"\2\2\u0087~\3\2\2\2\u0087\u0086\3\2\2\2\u0088\r\3\2\2\2\u0089\u008a\5"+
		"\20\t\2\u008a\17\3\2\2\2\u008b\u008c\b\t\1\2\u008c\u008d\5\22\n\2\u008d"+
		"\u0093\3\2\2\2\u008e\u008f\f\4\2\2\u008f\u0090\7\32\2\2\u0090\u0092\5"+
		"\22\n\2\u0091\u008e\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\21\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\b\n\1"+
		"\2\u0097\u0098\5\24\13\2\u0098\u009e\3\2\2\2\u0099\u009a\f\4\2\2\u009a"+
		"\u009b\7\31\2\2\u009b\u009d\5\24\13\2\u009c\u0099\3\2\2\2\u009d\u00a0"+
		"\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\23\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a2\b\13\1\2\u00a2\u00a3\5\26\f\2\u00a3\u00a9\3"+
		"\2\2\2\u00a4\u00a5\f\4\2\2\u00a5\u00a6\7\26\2\2\u00a6\u00a8\5\26\f\2\u00a7"+
		"\u00a4\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\25\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\b\f\1\2\u00ad\u00ae"+
		"\5\30\r\2\u00ae\u00b4\3\2\2\2\u00af\u00b0\f\4\2\2\u00b0\u00b1\7\25\2\2"+
		"\u00b1\u00b3\5\30\r\2\u00b2\u00af\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\27\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b8\b\r\1\2\u00b8\u00b9\5\32\16\2\u00b9\u00bf\3\2\2\2\u00ba\u00bb\f"+
		"\4\2\2\u00bb\u00bc\7\30\2\2\u00bc\u00be\5\32\16\2\u00bd\u00ba\3\2\2\2"+
		"\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\31"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\b\16\1\2\u00c3\u00c4\5\34\17"+
		"\2\u00c4\u00ca\3\2\2\2\u00c5\u00c6\f\4\2\2\u00c6\u00c7\7\27\2\2\u00c7"+
		"\u00c9\5\34\17\2\u00c8\u00c5\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3"+
		"\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\33\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00ce\b\17\1\2\u00ce\u00cf\5\36\20\2\u00cf\u00d8\3\2\2\2\u00d0\u00d1"+
		"\f\5\2\2\u00d1\u00d2\7\22\2\2\u00d2\u00d7\5\36\20\2\u00d3\u00d4\f\4\2"+
		"\2\u00d4\u00d5\7\23\2\2\u00d5\u00d7\5\36\20\2\u00d6\u00d0\3\2\2\2\u00d6"+
		"\u00d3\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\35\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\b\20\1\2\u00dc\u00dd"+
		"\5 \21\2\u00dd\u00e3\3\2\2\2\u00de\u00df\f\4\2\2\u00df\u00e0\7\24\2\2"+
		"\u00e0\u00e2\5 \21\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\37\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e7\7\33\2\2\u00e7\u00ea\5 \21\2\u00e8\u00ea\5\"\22\2\u00e9\u00e6\3"+
		"\2\2\2\u00e9\u00e8\3\2\2\2\u00ea!\3\2\2\2\u00eb\u00fb\7\36\2\2\u00ec\u00fb"+
		"\7\35\2\2\u00ed\u00ee\7\4\2\2\u00ee\u00ef\5\16\b\2\u00ef\u00f0\7\5\2\2"+
		"\u00f0\u00fb\3\2\2\2\u00f1\u00f2\7\23\2\2\u00f2\u00fb\5\"\22\2\u00f3\u00f4"+
		"\7\21\2\2\u00f4\u00fb\5\"\22\2\u00f5\u00f6\7\35\2\2\u00f6\u00f7\7\4\2"+
		"\2\u00f7\u00f8\5$\23\2\u00f8\u00f9\7\5\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00eb"+
		"\3\2\2\2\u00fa\u00ec\3\2\2\2\u00fa\u00ed\3\2\2\2\u00fa\u00f1\3\2\2\2\u00fa"+
		"\u00f3\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fb#\3\2\2\2\u00fc\u0106\3\2\2\2"+
		"\u00fd\u0102\5\16\b\2\u00fe\u00ff\7\b\2\2\u00ff\u0101\5\16\b\2\u0100\u00fe"+
		"\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u00fc\3\2\2\2\u0105\u00fd\3\2"+
		"\2\2\u0106%\3\2\2\2\30*\67BELSrz\u0087\u0093\u009e\u00a9\u00b4\u00bf\u00ca"+
		"\u00d6\u00d8\u00e3\u00e9\u00fa\u0102\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
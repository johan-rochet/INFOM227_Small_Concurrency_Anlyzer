// Generated from com/SmallConcurrency/SmallConcurrencyGrammar.g4 by ANTLR 4.13.1
package com.SmallConcurrency;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SmallConcurrencyGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, LBRACE=3, RBRACE=4, COMMA=5, SEMICOLON=6, ASSIGN=7, TRUE=8, 
		FALSE=9, PLUS=10, MINUS=11, MULTIPLY=12, SLASH=13, EQUAL=14, GREATER=15, 
		GREATER_EQUAL=16, LESS=17, LESS_EQUAL=18, DIFFERENT=19, AND=20, OR=21, 
		IF=22, ELSE=23, WHILE=24, RETURN=25, FUNCTION=26, VAR=27, GLOBAL_VAR=28, 
		TASK=29, ID=30, NUM=31, NEWLINE=32, WS=33;
	public static final int
		RULE_root = 0, RULE_op = 1, RULE_rop = 2, RULE_nOprnd = 3, RULE_bOprnd = 4, 
		RULE_binOP = 5, RULE_relOp = 6, RULE_arithmExp = 7, RULE_boolExp = 8, 
		RULE_expr = 9, RULE_returnStatement = 10, RULE_exprList = 11, RULE_funcCall = 12, 
		RULE_assignStatement = 13, RULE_statement = 14, RULE_ifStatement = 15, 
		RULE_whileStatement = 16, RULE_sequence = 17, RULE_paramList = 18, RULE_funcDef = 19, 
		RULE_varDecl = 20, RULE_globalVarDecl = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "op", "rop", "nOprnd", "bOprnd", "binOP", "relOp", "arithmExp", 
			"boolExp", "expr", "returnStatement", "exprList", "funcCall", "assignStatement", 
			"statement", "ifStatement", "whileStatement", "sequence", "paramList", 
			"funcDef", "varDecl", "globalVarDecl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "','", "';'", "'='", "'True'", "'False'", 
			"'+'", "'-'", "'*'", "'/'", "'=='", "'>'", "'>='", "'<'", "'<='", "'!='", 
			"'and'", "'or'", "'if'", "'else'", "'while'", "'return'", "'function'", 
			"'var'", "'gVar'", "'task'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAR", "RPAR", "LBRACE", "RBRACE", "COMMA", "SEMICOLON", "ASSIGN", 
			"TRUE", "FALSE", "PLUS", "MINUS", "MULTIPLY", "SLASH", "EQUAL", "GREATER", 
			"GREATER_EQUAL", "LESS", "LESS_EQUAL", "DIFFERENT", "AND", "OR", "IF", 
			"ELSE", "WHILE", "RETURN", "FUNCTION", "VAR", "GLOBAL_VAR", "TASK", "ID", 
			"NUM", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "SmallConcurrencyGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmallConcurrencyGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SmallConcurrencyGrammarParser.EOF, 0); }
		public List<GlobalVarDeclContext> globalVarDecl() {
			return getRuleContexts(GlobalVarDeclContext.class);
		}
		public GlobalVarDeclContext globalVarDecl(int i) {
			return getRuleContext(GlobalVarDeclContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(SmallConcurrencyGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(SmallConcurrencyGrammarParser.SEMICOLON, i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL_VAR) {
				{
				{
				setState(44);
				globalVarDecl();
				setState(45);
				match(SEMICOLON);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				funcDef();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNCTION );
			setState(57);
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
	public static class OpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(SmallConcurrencyGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SmallConcurrencyGrammarParser.MINUS, 0); }
		public TerminalNode MULTIPLY() { return getToken(SmallConcurrencyGrammarParser.MULTIPLY, 0); }
		public TerminalNode SLASH() { return getToken(SmallConcurrencyGrammarParser.SLASH, 0); }
		public TerminalNode EQUAL() { return getToken(SmallConcurrencyGrammarParser.EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(SmallConcurrencyGrammarParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(SmallConcurrencyGrammarParser.GREATER_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(SmallConcurrencyGrammarParser.LESS, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(SmallConcurrencyGrammarParser.LESS_EQUAL, 0); }
		public TerminalNode DIFFERENT() { return getToken(SmallConcurrencyGrammarParser.DIFFERENT, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1047552L) != 0)) ) {
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
	public static class RopContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SmallConcurrencyGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(SmallConcurrencyGrammarParser.OR, 0); }
		public RopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterRop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitRop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitRop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RopContext rop() throws RecognitionException {
		RopContext _localctx = new RopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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
	public static class NOprndContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(SmallConcurrencyGrammarParser.NUM, 0); }
		public NOprndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nOprnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterNOprnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitNOprnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitNOprnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NOprndContext nOprnd() throws RecognitionException {
		NOprndContext _localctx = new NOprndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nOprnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUM) ) {
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
	public static class BOprndContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SmallConcurrencyGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SmallConcurrencyGrammarParser.FALSE, 0); }
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public BOprndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bOprnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterBOprnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitBOprnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitBOprnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BOprndContext bOprnd() throws RecognitionException {
		BOprndContext _localctx = new BOprndContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bOprnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742592L) != 0)) ) {
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
	public static class BinOPContext extends ParserRuleContext {
		public List<NOprndContext> nOprnd() {
			return getRuleContexts(NOprndContext.class);
		}
		public NOprndContext nOprnd(int i) {
			return getRuleContext(NOprndContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public BinOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterBinOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitBinOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitBinOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinOPContext binOP() throws RecognitionException {
		BinOPContext _localctx = new BinOPContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_binOP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			nOprnd();
			setState(68);
			op();
			setState(69);
			nOprnd();
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
	public static class RelOpContext extends ParserRuleContext {
		public List<BOprndContext> bOprnd() {
			return getRuleContexts(BOprndContext.class);
		}
		public BOprndContext bOprnd(int i) {
			return getRuleContext(BOprndContext.class,i);
		}
		public RopContext rop() {
			return getRuleContext(RopContext.class,0);
		}
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitRelOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitRelOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			bOprnd();
			setState(72);
			rop();
			setState(73);
			bOprnd();
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
	public static class ArithmExpContext extends ParserRuleContext {
		public BinOPContext binOP() {
			return getRuleContext(BinOPContext.class,0);
		}
		public NOprndContext nOprnd() {
			return getRuleContext(NOprndContext.class,0);
		}
		public ArithmExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterArithmExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitArithmExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitArithmExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmExpContext arithmExp() throws RecognitionException {
		ArithmExpContext _localctx = new ArithmExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arithmExp);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				binOP();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				nOprnd();
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
	public static class BoolExpContext extends ParserRuleContext {
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public BOprndContext bOprnd() {
			return getRuleContext(BOprndContext.class,0);
		}
		public BoolExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterBoolExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitBoolExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExpContext boolExp() throws RecognitionException {
		BoolExpContext _localctx = new BoolExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boolExp);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				relOp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				bOprnd();
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
		public ArithmExpContext arithmExp() {
			return getRuleContext(ArithmExpContext.class,0);
		}
		public BoolExpContext boolExp() {
			return getRuleContext(BoolExpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				arithmExp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				boolExp();
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(SmallConcurrencyGrammarParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(RETURN);
			setState(88);
			expr();
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
	public static class ExprListContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SmallConcurrencyGrammarParser.COMMA, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprList);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				expr();
				setState(92);
				match(COMMA);
				setState(93);
				exprList();
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
	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SmallConcurrencyGrammarParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SmallConcurrencyGrammarParser.RPAR, 0); }
		public List<ExprListContext> exprList() {
			return getRuleContexts(ExprListContext.class);
		}
		public ExprListContext exprList(int i) {
			return getRuleContext(ExprListContext.class,i);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ID);
			setState(98);
			match(LPAR);
			{
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				exprList();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3221226240L) != 0) );
			}
			setState(104);
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
	public static class AssignStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SmallConcurrencyGrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignStatement);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(ID);
				setState(107);
				match(ASSIGN);
				setState(108);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(ID);
				setState(110);
				match(ASSIGN);
				setState(111);
				funcCall();
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
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(SmallConcurrencyGrammarParser.SEMICOLON, 0); }
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case VAR:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(114);
					assignStatement();
					}
					break;
				case RETURN:
					{
					setState(115);
					returnStatement();
					}
					break;
				case VAR:
					{
					setState(116);
					varDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(119);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				whileStatement();
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
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SmallConcurrencyGrammarParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(SmallConcurrencyGrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SmallConcurrencyGrammarParser.RPAR, 0); }
		public TerminalNode ELSE() { return getToken(SmallConcurrencyGrammarParser.ELSE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<SequenceContext> sequence() {
			return getRuleContexts(SequenceContext.class);
		}
		public SequenceContext sequence(int i) {
			return getRuleContext(SequenceContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(IF);
			setState(126);
			match(LPAR);
			setState(127);
			expr();
			setState(128);
			match(RPAR);
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case WHILE:
			case RETURN:
			case VAR:
			case ID:
				{
				setState(129);
				statement();
				}
				break;
			case LBRACE:
				{
				setState(130);
				sequence();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(133);
			match(ELSE);
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case WHILE:
			case RETURN:
			case VAR:
			case ID:
				{
				setState(134);
				statement();
				}
				break;
			case LBRACE:
				{
				setState(135);
				sequence();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SmallConcurrencyGrammarParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(SmallConcurrencyGrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SmallConcurrencyGrammarParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(WHILE);
			setState(139);
			match(LPAR);
			setState(140);
			expr();
			setState(141);
			match(RPAR);
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case WHILE:
			case RETURN:
			case VAR:
			case ID:
				{
				setState(142);
				statement();
				}
				break;
			case LBRACE:
				{
				setState(143);
				sequence();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class SequenceContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SmallConcurrencyGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SmallConcurrencyGrammarParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(LBRACE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1262485504L) != 0)) {
				{
				{
				setState(147);
				statement();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(RBRACE);
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
	public static class ParamListContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(SmallConcurrencyGrammarParser.COMMA, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_paramList);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(ID);
				setState(157);
				match(COMMA);
				setState(158);
				paramList();
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
	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(SmallConcurrencyGrammarParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SmallConcurrencyGrammarParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SmallConcurrencyGrammarParser.RPAR, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(FUNCTION);
			setState(162);
			match(ID);
			setState(163);
			match(LPAR);
			{
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(164);
				paramList();
				}
			}

			}
			setState(167);
			match(RPAR);
			setState(168);
			sequence();
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
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(SmallConcurrencyGrammarParser.VAR, 0); }
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(VAR);
			setState(171);
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
	public static class GlobalVarDeclContext extends ParserRuleContext {
		public TerminalNode GLOBAL_VAR() { return getToken(SmallConcurrencyGrammarParser.GLOBAL_VAR, 0); }
		public TerminalNode ID() { return getToken(SmallConcurrencyGrammarParser.ID, 0); }
		public GlobalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).enterGlobalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallConcurrencyGrammarListener ) ((SmallConcurrencyGrammarListener)listener).exitGlobalVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallConcurrencyGrammarVisitor ) return ((SmallConcurrencyGrammarVisitor<? extends T>)visitor).visitGlobalVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalVarDeclContext globalVarDecl() throws RecognitionException {
		GlobalVarDeclContext _localctx = new GlobalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_globalVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(GLOBAL_VAR);
			setState(174);
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

	public static final String _serializedATN =
		"\u0004\u0001!\u00b1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0004\u00006\b\u0000\u000b\u0000\f\u00007\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007N\b\u0007\u0001\b\u0001\b\u0003\bR\b\b\u0001"+
		"\t\u0001\t\u0003\tV\b\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b`\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0004\fe\b\f\u000b\f\f\ff\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\rq\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000ev\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e|\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0084\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u0089\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0091\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u0095\b\u0011\n\u0011\f\u0011\u0098\t\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00a0\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00a6\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0000\u0000\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0004\u0001\u0000\n\u0013"+
		"\u0001\u0000\u0014\u0015\u0001\u0000\u001e\u001f\u0002\u0000\b\t\u001e"+
		"\u001e\u00ac\u00001\u0001\u0000\u0000\u0000\u0002;\u0001\u0000\u0000\u0000"+
		"\u0004=\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\bA\u0001"+
		"\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fG\u0001\u0000\u0000\u0000"+
		"\u000eM\u0001\u0000\u0000\u0000\u0010Q\u0001\u0000\u0000\u0000\u0012U"+
		"\u0001\u0000\u0000\u0000\u0014W\u0001\u0000\u0000\u0000\u0016_\u0001\u0000"+
		"\u0000\u0000\u0018a\u0001\u0000\u0000\u0000\u001ap\u0001\u0000\u0000\u0000"+
		"\u001c{\u0001\u0000\u0000\u0000\u001e}\u0001\u0000\u0000\u0000 \u008a"+
		"\u0001\u0000\u0000\u0000\"\u0092\u0001\u0000\u0000\u0000$\u009f\u0001"+
		"\u0000\u0000\u0000&\u00a1\u0001\u0000\u0000\u0000(\u00aa\u0001\u0000\u0000"+
		"\u0000*\u00ad\u0001\u0000\u0000\u0000,-\u0003*\u0015\u0000-.\u0005\u0006"+
		"\u0000\u0000.0\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u000003\u0001"+
		"\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"25\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000046\u0003&\u0013\u0000"+
		"54\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000078\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0005\u0000"+
		"\u0000\u0001:\u0001\u0001\u0000\u0000\u0000;<\u0007\u0000\u0000\u0000"+
		"<\u0003\u0001\u0000\u0000\u0000=>\u0007\u0001\u0000\u0000>\u0005\u0001"+
		"\u0000\u0000\u0000?@\u0007\u0002\u0000\u0000@\u0007\u0001\u0000\u0000"+
		"\u0000AB\u0007\u0003\u0000\u0000B\t\u0001\u0000\u0000\u0000CD\u0003\u0006"+
		"\u0003\u0000DE\u0003\u0002\u0001\u0000EF\u0003\u0006\u0003\u0000F\u000b"+
		"\u0001\u0000\u0000\u0000GH\u0003\b\u0004\u0000HI\u0003\u0004\u0002\u0000"+
		"IJ\u0003\b\u0004\u0000J\r\u0001\u0000\u0000\u0000KN\u0003\n\u0005\u0000"+
		"LN\u0003\u0006\u0003\u0000MK\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000"+
		"\u0000N\u000f\u0001\u0000\u0000\u0000OR\u0003\f\u0006\u0000PR\u0003\b"+
		"\u0004\u0000QO\u0001\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000R\u0011"+
		"\u0001\u0000\u0000\u0000SV\u0003\u000e\u0007\u0000TV\u0003\u0010\b\u0000"+
		"US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000V\u0013\u0001\u0000"+
		"\u0000\u0000WX\u0005\u0019\u0000\u0000XY\u0003\u0012\t\u0000Y\u0015\u0001"+
		"\u0000\u0000\u0000Z`\u0003\u0012\t\u0000[\\\u0003\u0012\t\u0000\\]\u0005"+
		"\u0005\u0000\u0000]^\u0003\u0016\u000b\u0000^`\u0001\u0000\u0000\u0000"+
		"_Z\u0001\u0000\u0000\u0000_[\u0001\u0000\u0000\u0000`\u0017\u0001\u0000"+
		"\u0000\u0000ab\u0005\u001e\u0000\u0000bd\u0005\u0001\u0000\u0000ce\u0003"+
		"\u0016\u000b\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hi\u0005\u0002\u0000\u0000i\u0019\u0001\u0000\u0000\u0000jk\u0005"+
		"\u001e\u0000\u0000kl\u0005\u0007\u0000\u0000lq\u0003\u0012\t\u0000mn\u0005"+
		"\u001e\u0000\u0000no\u0005\u0007\u0000\u0000oq\u0003\u0018\f\u0000pj\u0001"+
		"\u0000\u0000\u0000pm\u0001\u0000\u0000\u0000q\u001b\u0001\u0000\u0000"+
		"\u0000rv\u0003\u001a\r\u0000sv\u0003\u0014\n\u0000tv\u0003(\u0014\u0000"+
		"ur\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000ut\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wx\u0005\u0006\u0000\u0000x|\u0001\u0000"+
		"\u0000\u0000y|\u0003\u001e\u000f\u0000z|\u0003 \u0010\u0000{u\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\u001d"+
		"\u0001\u0000\u0000\u0000}~\u0005\u0016\u0000\u0000~\u007f\u0005\u0001"+
		"\u0000\u0000\u007f\u0080\u0003\u0012\t\u0000\u0080\u0083\u0005\u0002\u0000"+
		"\u0000\u0081\u0084\u0003\u001c\u000e\u0000\u0082\u0084\u0003\"\u0011\u0000"+
		"\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0088\u0005\u0017\u0000\u0000"+
		"\u0086\u0089\u0003\u001c\u000e\u0000\u0087\u0089\u0003\"\u0011\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089"+
		"\u001f\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0018\u0000\u0000\u008b"+
		"\u008c\u0005\u0001\u0000\u0000\u008c\u008d\u0003\u0012\t\u0000\u008d\u0090"+
		"\u0005\u0002\u0000\u0000\u008e\u0091\u0003\u001c\u000e\u0000\u008f\u0091"+
		"\u0003\"\u0011\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u008f\u0001"+
		"\u0000\u0000\u0000\u0091!\u0001\u0000\u0000\u0000\u0092\u0096\u0005\u0003"+
		"\u0000\u0000\u0093\u0095\u0003\u001c\u000e\u0000\u0094\u0093\u0001\u0000"+
		"\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0099\u0001\u0000"+
		"\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0004"+
		"\u0000\u0000\u009a#\u0001\u0000\u0000\u0000\u009b\u00a0\u0005\u001e\u0000"+
		"\u0000\u009c\u009d\u0005\u001e\u0000\u0000\u009d\u009e\u0005\u0005\u0000"+
		"\u0000\u009e\u00a0\u0003$\u0012\u0000\u009f\u009b\u0001\u0000\u0000\u0000"+
		"\u009f\u009c\u0001\u0000\u0000\u0000\u00a0%\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005\u001a\u0000\u0000\u00a2\u00a3\u0005\u001e\u0000\u0000\u00a3"+
		"\u00a5\u0005\u0001\u0000\u0000\u00a4\u00a6\u0003$\u0012\u0000\u00a5\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0002\u0000\u0000\u00a8\u00a9"+
		"\u0003\"\u0011\u0000\u00a9\'\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005"+
		"\u001b\u0000\u0000\u00ab\u00ac\u0005\u001e\u0000\u0000\u00ac)\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0005\u001c\u0000\u0000\u00ae\u00af\u0005\u001e"+
		"\u0000\u0000\u00af+\u0001\u0000\u0000\u0000\u001017MQU_fpu{\u0083\u0088"+
		"\u0090\u0096\u009f\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
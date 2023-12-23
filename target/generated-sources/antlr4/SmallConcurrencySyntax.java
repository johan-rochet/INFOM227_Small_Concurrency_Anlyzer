// Generated from SmallConcurrencySyntax.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmallConcurrencySyntax extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, LBRACE=3, RBRACE=4, COMMA=5, SEMICOLON=6, ASSIGN=7, TRUE=8, 
		FALSE=9, PLUS=10, MINUS=11, MULTIPLY=12, SLASH=13, EQUAL=14, GREATER=15, 
		GREATER_EQUAL=16, LESS=17, LESS_EQUAL=18, DIFFERENT=19, AND=20, OR=21, 
		IF=22, ELSE=23, WHILE=24, RETURN=25, FUNCTION=26, ID=27, NUM=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAR", "RPAR", "LBRACE", "RBRACE", "COMMA", "SEMICOLON", "ASSIGN", "TRUE", 
		"FALSE", "PLUS", "MINUS", "MULTIPLY", "SLASH", "EQUAL", "GREATER", "GREATER_EQUAL", 
		"LESS", "LESS_EQUAL", "DIFFERENT", "AND", "OR", "IF", "ELSE", "WHILE", 
		"RETURN", "FUNCTION", "ID", "NUM", "LETTER", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "','", "';'", "'='", "'True'", "'False'", 
		"'+'", "'-'", "'*'", "'/'", "'=='", "'>'", "'>='", "'<'", "'<='", "'!='", 
		"'and'", "'or'", "'if'", "'else'", "'while'", "'return'", "'function'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAR", "RPAR", "LBRACE", "RBRACE", "COMMA", "SEMICOLON", "ASSIGN", 
		"TRUE", "FALSE", "PLUS", "MINUS", "MULTIPLY", "SLASH", "EQUAL", "GREATER", 
		"GREATER_EQUAL", "LESS", "LESS_EQUAL", "DIFFERENT", "AND", "OR", "IF", 
		"ELSE", "WHILE", "RETURN", "FUNCTION", "ID", "NUM"
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


	public SmallConcurrencySyntax(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SmallConcurrencySyntax.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\7\34\u0099"+
		"\n\34\f\34\16\34\u009c\13\34\3\35\6\35\u009f\n\35\r\35\16\35\u00a0\3\36"+
		"\3\36\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\2=\2\3\2\3\4\2C\\c|\u00a6\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3?\3\2\2\2\5A\3\2\2\2\7C\3\2\2"+
		"\2\tE\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23R\3\2\2"+
		"\2\25X\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33^\3\2\2\2\35`\3\2\2\2\37c\3"+
		"\2\2\2!e\3\2\2\2#h\3\2\2\2%j\3\2\2\2\'m\3\2\2\2)p\3\2\2\2+t\3\2\2\2-w"+
		"\3\2\2\2/z\3\2\2\2\61\177\3\2\2\2\63\u0085\3\2\2\2\65\u008c\3\2\2\2\67"+
		"\u0095\3\2\2\29\u009e\3\2\2\2;\u00a2\3\2\2\2=\u00a4\3\2\2\2?@\7*\2\2@"+
		"\4\3\2\2\2AB\7+\2\2B\6\3\2\2\2CD\7}\2\2D\b\3\2\2\2EF\7\177\2\2F\n\3\2"+
		"\2\2GH\7.\2\2H\f\3\2\2\2IJ\7=\2\2J\16\3\2\2\2KL\7?\2\2L\20\3\2\2\2MN\7"+
		"V\2\2NO\7t\2\2OP\7w\2\2PQ\7g\2\2Q\22\3\2\2\2RS\7H\2\2ST\7c\2\2TU\7n\2"+
		"\2UV\7u\2\2VW\7g\2\2W\24\3\2\2\2XY\7-\2\2Y\26\3\2\2\2Z[\7/\2\2[\30\3\2"+
		"\2\2\\]\7,\2\2]\32\3\2\2\2^_\7\61\2\2_\34\3\2\2\2`a\7?\2\2ab\7?\2\2b\36"+
		"\3\2\2\2cd\7@\2\2d \3\2\2\2ef\7@\2\2fg\7?\2\2g\"\3\2\2\2hi\7>\2\2i$\3"+
		"\2\2\2jk\7>\2\2kl\7?\2\2l&\3\2\2\2mn\7#\2\2no\7?\2\2o(\3\2\2\2pq\7c\2"+
		"\2qr\7p\2\2rs\7f\2\2s*\3\2\2\2tu\7q\2\2uv\7t\2\2v,\3\2\2\2wx\7k\2\2xy"+
		"\7h\2\2y.\3\2\2\2z{\7g\2\2{|\7n\2\2|}\7u\2\2}~\7g\2\2~\60\3\2\2\2\177"+
		"\u0080\7y\2\2\u0080\u0081\7j\2\2\u0081\u0082\7k\2\2\u0082\u0083\7n\2\2"+
		"\u0083\u0084\7g\2\2\u0084\62\3\2\2\2\u0085\u0086\7t\2\2\u0086\u0087\7"+
		"g\2\2\u0087\u0088\7v\2\2\u0088\u0089\7w\2\2\u0089\u008a\7t\2\2\u008a\u008b"+
		"\7p\2\2\u008b\64\3\2\2\2\u008c\u008d\7h\2\2\u008d\u008e\7w\2\2\u008e\u008f"+
		"\7p\2\2\u008f\u0090\7e\2\2\u0090\u0091\7v\2\2\u0091\u0092\7k\2\2\u0092"+
		"\u0093\7q\2\2\u0093\u0094\7p\2\2\u0094\66\3\2\2\2\u0095\u009a\5;\36\2"+
		"\u0096\u0099\5=\37\2\u0097\u0099\5;\36\2\u0098\u0096\3\2\2\2\u0098\u0097"+
		"\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"8\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\5=\37\2\u009e\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1:\3"+
		"\2\2\2\u00a2\u00a3\t\2\2\2\u00a3<\3\2\2\2\u00a4\u00a5\4\62;\2\u00a5>\3"+
		"\2\2\2\6\2\u0098\u009a\u00a0\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
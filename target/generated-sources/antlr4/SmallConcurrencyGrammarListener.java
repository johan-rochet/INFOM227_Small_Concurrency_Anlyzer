// Generated from SmallConcurrencyGrammar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmallConcurrencyGrammarParser}.
 */
public interface SmallConcurrencyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(SmallConcurrencyGrammarParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(SmallConcurrencyGrammarParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(SmallConcurrencyGrammarParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(SmallConcurrencyGrammarParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#rop}.
	 * @param ctx the parse tree
	 */
	void enterRop(SmallConcurrencyGrammarParser.RopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#rop}.
	 * @param ctx the parse tree
	 */
	void exitRop(SmallConcurrencyGrammarParser.RopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#nOprnd}.
	 * @param ctx the parse tree
	 */
	void enterNOprnd(SmallConcurrencyGrammarParser.NOprndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#nOprnd}.
	 * @param ctx the parse tree
	 */
	void exitNOprnd(SmallConcurrencyGrammarParser.NOprndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#bOprnd}.
	 * @param ctx the parse tree
	 */
	void enterBOprnd(SmallConcurrencyGrammarParser.BOprndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#bOprnd}.
	 * @param ctx the parse tree
	 */
	void exitBOprnd(SmallConcurrencyGrammarParser.BOprndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#binOP}.
	 * @param ctx the parse tree
	 */
	void enterBinOP(SmallConcurrencyGrammarParser.BinOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#binOP}.
	 * @param ctx the parse tree
	 */
	void exitBinOP(SmallConcurrencyGrammarParser.BinOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(SmallConcurrencyGrammarParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(SmallConcurrencyGrammarParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#arithmExp}.
	 * @param ctx the parse tree
	 */
	void enterArithmExp(SmallConcurrencyGrammarParser.ArithmExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#arithmExp}.
	 * @param ctx the parse tree
	 */
	void exitArithmExp(SmallConcurrencyGrammarParser.ArithmExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#boolExp}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(SmallConcurrencyGrammarParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#boolExp}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(SmallConcurrencyGrammarParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SmallConcurrencyGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SmallConcurrencyGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SmallConcurrencyGrammarParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SmallConcurrencyGrammarParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(SmallConcurrencyGrammarParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(SmallConcurrencyGrammarParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(SmallConcurrencyGrammarParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(SmallConcurrencyGrammarParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(SmallConcurrencyGrammarParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(SmallConcurrencyGrammarParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SmallConcurrencyGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SmallConcurrencyGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SmallConcurrencyGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SmallConcurrencyGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(SmallConcurrencyGrammarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(SmallConcurrencyGrammarParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(SmallConcurrencyGrammarParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(SmallConcurrencyGrammarParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(SmallConcurrencyGrammarParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(SmallConcurrencyGrammarParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallConcurrencyGrammarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(SmallConcurrencyGrammarParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallConcurrencyGrammarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(SmallConcurrencyGrammarParser.FuncDefContext ctx);
}
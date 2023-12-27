// Generated from com/SmallConcurrency/SmallConcurrencyGrammar.g4 by ANTLR 4.13.1
package com.SmallConcurrency;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmallConcurrencyGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmallConcurrencyGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(SmallConcurrencyGrammarParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(SmallConcurrencyGrammarParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#rop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRop(SmallConcurrencyGrammarParser.RopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#nOprnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOprnd(SmallConcurrencyGrammarParser.NOprndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#bOprnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOprnd(SmallConcurrencyGrammarParser.BOprndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#binOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOP(SmallConcurrencyGrammarParser.BinOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(SmallConcurrencyGrammarParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#arithmExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmExp(SmallConcurrencyGrammarParser.ArithmExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#boolExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExp(SmallConcurrencyGrammarParser.BoolExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SmallConcurrencyGrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SmallConcurrencyGrammarParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(SmallConcurrencyGrammarParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(SmallConcurrencyGrammarParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(SmallConcurrencyGrammarParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SmallConcurrencyGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SmallConcurrencyGrammarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(SmallConcurrencyGrammarParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(SmallConcurrencyGrammarParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(SmallConcurrencyGrammarParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(SmallConcurrencyGrammarParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(SmallConcurrencyGrammarParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallConcurrencyGrammarParser#globalVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVarDecl(SmallConcurrencyGrammarParser.GlobalVarDeclContext ctx);
}
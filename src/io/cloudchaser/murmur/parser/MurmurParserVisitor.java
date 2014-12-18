// Generated from C:\Users\Mihail\Documents\NetBeansProjects\Murmur\src\grammar\MurmurParser.g4 by ANTLR 4.4
package io.cloudchaser.murmur.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MurmurParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MurmurParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MurmurParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(@NotNull MurmurParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull MurmurParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#iTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITypeDeclaration(@NotNull MurmurParser.ITypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(@NotNull MurmurParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#initializerElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerElement(@NotNull MurmurParser.InitializerElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull MurmurParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#typeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatement(@NotNull MurmurParser.TypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#iTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITypeStatement(@NotNull MurmurParser.ITypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(@NotNull MurmurParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(@NotNull MurmurParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(@NotNull MurmurParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull MurmurParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#typeElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeElement(@NotNull MurmurParser.TypeElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#iTypeElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITypeElement(@NotNull MurmurParser.ITypeElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#keywordStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordStatement(@NotNull MurmurParser.KeywordStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull MurmurParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MurmurParser#initializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerList(@NotNull MurmurParser.InitializerListContext ctx);
}
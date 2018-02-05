import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import parser.PiLangParser.AddExprContext;
import parser.PiLangParser.AssignStmtContext;
import parser.PiLangParser.BreakStmtdContext;
import parser.PiLangParser.CallExprContext;
import parser.PiLangParser.CompoundStmtContext;
import parser.PiLangParser.CompoundStmtdContext;
import parser.PiLangParser.ExprContext;
import parser.PiLangParser.FuncDeclContext;
import parser.PiLangParser.IfStmtContext;
import parser.PiLangParser.IfStmtdContext;
import parser.PiLangParser.LiteralExprContext;
import parser.PiLangParser.MulExprContext;
import parser.PiLangParser.ParenExprContext;
import parser.PiLangParser.ProgContext;
import parser.PiLangParser.RemoveStmtdContext;
import parser.PiLangParser.ReturnStmtContext;
import parser.PiLangParser.StmtContext;
import parser.PiLangParser.StmtdContext;
import parser.PiLangParser.VarExprContext;
import parser.PiLangParser.WhileStmtContext;
import parser.PiLangParser.LogicNotExprContext;
import parser.PiLangParser.LogicAndExprContext;
import parser.PiLangParser.LogicOrExprContext;
import parser.PiLangParser.CmpExprContext;
import parser.PiLangParser.EqualExprContext;
import parser.PiLangParser.PrintStmtContext;
import parser.PiLangParser.NotExprContext;
import parser.PiLangParser.SubExprContext;
import parser.PiLangParser.AndExprContext;
import parser.PiLangParser.OrExprContext;

public class ASTGenerator {	
	ASTFunctionNode translateFuncDecl(FuncDeclContext ctx) {
		ArrayList<String> params = new ArrayList<String>();
		ArrayList<String> varDecls = new ArrayList<String>();
		ArrayList<ASTNode> stmts = new ArrayList<ASTNode>();
		String funcName = ctx.IDENTIFIER().getText();
		for (TerminalNode paramCtx: ctx.params().IDENTIFIER()) {
			String paramName = paramCtx.getText();
			params.add(paramName);
		}
		for (TerminalNode varCtx: ctx.varDecls().IDENTIFIER()) {
			String varName = varCtx.getText();
			varDecls.add(varName);
		}
		for (StmtContext stmtCtx: ctx.stmt()) {
			ASTNode stmt = translate(stmtCtx);
			stmts.add(stmt);
		}
		return new ASTFunctionNode(funcName, params, varDecls, stmts);
	}
	
	ASTNode translate(ParseTree ctxx) {
		if (ctxx instanceof ProgContext) {
			ProgContext ctx = (ProgContext) ctxx;
			ArrayList<String> varDecls = new ArrayList<String>();
			ArrayList<ASTFunctionNode> funcDecls = new ArrayList<ASTFunctionNode>();
			for (TerminalNode var: ctx.varDecls().IDENTIFIER()) {
				String varName = var.getText();
				varDecls.add(varName);
			}
			for (FuncDeclContext funcDeclCtx: ctx.funcDecl()) {
				ASTFunctionNode funcDecl = translateFuncDecl(funcDeclCtx);
				funcDecls.add(funcDecl);
			}
			return new ASTProgNode(varDecls, funcDecls);
		} else if (ctxx instanceof CompoundStmtContext) {
			CompoundStmtContext ctx = (CompoundStmtContext) ctxx;
			ArrayList<ASTNode> stmts = new ArrayList<ASTNode>();
			for (StmtContext t: ctx.stmt()) {
				ASTNode n = translate(t);
				stmts.add(n);
			}
			return new ASTCompoundStmtNode(stmts);
		} else if (ctxx instanceof AssignStmtContext) {
			AssignStmtContext ctx = (AssignStmtContext) ctxx;
			String var = ctx.IDENTIFIER().getText();
			ASTNode expr = translate(ctx.expr());
			return new ASTAssignStmtNode(var, expr);
		} else if (ctxx instanceof IfStmtContext) { // IfStmt
			IfStmtContext ctx = (IfStmtContext) ctxx;
			ASTNode cond = translate(ctx.expr());
			ASTNode thenClause = translate(ctx.stmt(0));
			ASTNode elseClause = translate(ctx.stmt(1));
			return new ASTIfStmtNode(cond, thenClause, elseClause);
		} else if (ctxx instanceof WhileStmtContext) { // WhileStmt
			WhileStmtContext ctx = (WhileStmtContext) ctxx;
			ASTNode cond = translate(ctx.expr());
			ASTNode stmt = translate(ctx.stmtd());
			return new ASTWhileStmtNode(cond, stmt);
	   } else if (ctxx instanceof ReturnStmtContext) {
			ReturnStmtContext ctx = (ReturnStmtContext) ctxx;
			ASTNode expr = translate(ctx.expr());
			return new ASTReturnNode(expr);
		} else if (ctxx instanceof PrintStmtContext) { // PrintStmt
 			PrintStmtContext ctx = (PrintStmtContext) ctxx;
 			ASTNode expr = translate(ctx.expr());
 			return new ASTPrintStmtNode(expr);
		} else if (ctxx instanceof BreakStmtdContext) { // breakStmtd
			return new ASTBreakStmtdNode();
		} else if (ctxx instanceof CompoundStmtdContext) { // compoundStmtd
			CompoundStmtdContext ctx = (CompoundStmtdContext) ctxx;
			ArrayList<ASTNode> stmts = new ArrayList<ASTNode>();
			for (StmtdContext t: ctx.stmtd()) {
				ASTNode n = translate(t);
				stmts.add(n);
			}
			return new ASTCompoundStmtdNode(stmts);
		} else if (ctxx instanceof IfStmtdContext) { // IfStmtd
			IfStmtdContext ctx = (IfStmtdContext) ctxx;
			ASTNode cond = translate(ctx.expr());
			ASTNode thenClause = translate(ctx.stmtd(0));
			ASTNode elseClause = translate(ctx.stmtd(1));
			return new ASTIfStmtdNode(cond, thenClause, elseClause);
		} else if (ctxx instanceof RemoveStmtdContext) { // removeStmtd
			RemoveStmtdContext ctx = (RemoveStmtdContext) ctxx;
			return translate(ctx.stmt());
		} else if (ctxx instanceof ExprContext) {
			ExprContext ctx = (ExprContext) ctxx;
			return translate(ctx.logicOrExpr());
		} else if (ctxx instanceof LogicOrExprContext) { // logicOrExpr
			LogicOrExprContext ctx = (LogicOrExprContext) ctxx;
			if (ctx.logicOrExpr() == null)
				return translate(ctx.logicAndExpr());
			ASTNode lhs = translate(ctx.logicOrExpr());
			ASTNode rhs = translate(ctx.logicAndExpr());
			return new ASTLogicExprNode(ctx.LOGICOROP().getText(), lhs, rhs);
		} else if (ctxx instanceof LogicAndExprContext) { // logicAndExpr
			LogicAndExprContext ctx = (LogicAndExprContext) ctxx;
			if (ctx.logicAndExpr() == null)
				return translate(ctx.orExpr());
			ASTNode lhs = translate(ctx.logicAndExpr());
			ASTNode rhs = translate(ctx.orExpr());
			return new ASTLogicExprNode(ctx.LOGICANDOP().getText(), lhs, rhs);
		} else if (ctxx instanceof OrExprContext) { // orExpr
			OrExprContext ctx = (OrExprContext) ctxx;
			if (ctx.orExpr() == null)
				return translate(ctx.andExpr());
			ASTNode lhs = translate(ctx.orExpr());
			ASTNode rhs = translate(ctx.andExpr());
			return new ASTBinaryExprNode(ctx.OROP().getText(), lhs, rhs);
		} else if (ctxx instanceof AndExprContext) { // andExpr
			AndExprContext ctx = (AndExprContext) ctxx;
			if (ctx.andExpr() == null)
				return translate(ctx.equalExpr());
			ASTNode lhs = translate(ctx.andExpr());
			ASTNode rhs = translate(ctx.equalExpr());
			return new ASTBinaryExprNode(ctx.ANDOP().getText(), lhs, rhs);
		} else if (ctxx instanceof EqualExprContext) { // equalExpr
			EqualExprContext ctx = (EqualExprContext) ctxx;
			if (ctx.equalExpr() == null)
				return translate(ctx.cmpExpr());
			ASTNode lhs = translate(ctx.equalExpr());
			ASTNode rhs = translate(ctx.cmpExpr());
			return new ASTCmpExprNode(ctx.EQUALOP().getText(), lhs, rhs);
		} else if (ctxx instanceof CmpExprContext) { // cmpExpr
			CmpExprContext ctx = (CmpExprContext) ctxx;
			if (ctx.cmpExpr() == null)
				return translate(ctx.addExpr());
			ASTNode lhs = translate(ctx.cmpExpr());
			ASTNode rhs = translate(ctx.addExpr());
			return new ASTCmpExprNode(ctx.CMPOP().getText(), lhs, rhs);
		} else if (ctxx instanceof AddExprContext) {
			AddExprContext ctx = (AddExprContext) ctxx;
			String calc;
			if (ctx.addExpr() == null)
				return translate(ctx.mulExpr());
			if (ctx.ADDOP() != null) {
				calc = ctx.ADDOP().getText();
			} else {
				calc = ctx.SUBOP().getText();
			}
			ASTNode lhs = translate(ctx.addExpr());
			ASTNode rhs = translate(ctx.mulExpr());
			return new ASTBinaryExprNode(calc, lhs, rhs);
		} else if (ctxx instanceof MulExprContext) {
			MulExprContext ctx = (MulExprContext) ctxx;
			if (ctx.mulExpr() == null)
				return translate(ctx.logicNotExpr());
			ASTNode lhs = translate(ctx.mulExpr());
			ASTNode rhs = translate(ctx.logicNotExpr());
			return new ASTBinaryExprNode(ctx.MULOP().getText(), lhs, rhs);
		} else if (ctxx instanceof LogicNotExprContext) { // logicNotExpr
			LogicNotExprContext ctx = (LogicNotExprContext) ctxx;
			if (ctx.LOGICNOTOP() == null)
				return translate(ctx.unaryExpr());
			ASTNode lhs = null;
			ASTNode rhs = translate(ctx.logicNotExpr());
			return new ASTLogicExprNode(ctx.LOGICNOTOP().getText(), lhs, rhs);
		} else if (ctxx instanceof LiteralExprContext) {
			LiteralExprContext ctx = (LiteralExprContext) ctxx;
			int value = Integer.parseInt(ctx.VALUE().getText());
			return new ASTNumberNode(value);
		} else if (ctxx instanceof VarExprContext) {
			VarExprContext ctx = (VarExprContext) ctxx;
			String varName = ctx.IDENTIFIER().getText();
			return new ASTVarRefNode(varName);
		} else if (ctxx instanceof ParenExprContext) {
			ParenExprContext ctx = (ParenExprContext) ctxx;
			return translate(ctx.expr());
		} else if (ctxx instanceof SubExprContext) { // subExpr
			SubExprContext ctx = (SubExprContext) ctxx;
			ASTNode rhs = translate(ctx.unaryExpr());
			return new ASTUnaryNode(ctx.SUBOP().getText(), rhs);
		} else if (ctxx instanceof NotExprContext) { // notExpr
			NotExprContext ctx = (NotExprContext) ctxx;
			ASTNode rhs = translate(ctx.unaryExpr());
			return new ASTUnaryNode(ctx.NOTOP().getText(), rhs);
		}else if (ctxx instanceof CallExprContext) {
			CallExprContext ctx = (CallExprContext) ctxx;
			String funcName = ctx.IDENTIFIER().getText();
			ArrayList<ASTNode> args = new ArrayList<ASTNode>();
			for (ExprContext exprCtx: ctx.args().expr()) {
				ASTNode arg = translate(exprCtx);
				args.add(arg);
			}
			return new ASTCallNode(funcName, args);
		}
		throw new Error("Unknown parse tree node: "+ctxx.getText());		
	}
}

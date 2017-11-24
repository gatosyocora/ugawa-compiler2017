import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import parser.TinyPiSParser.AddExprContext;
import parser.TinyPiSParser.CompoundStmtContext;
import parser.TinyPiSParser.ExprContext;
import parser.TinyPiSParser.LiteralExprContext;
import parser.TinyPiSParser.MulExprContext;
import parser.TinyPiSParser.ParenExprContext;
import parser.TinyPiSParser.ProgContext;
import parser.TinyPiSParser.StmtContext;
import parser.TinyPiSParser.VarDeclsContext;
import parser.TinyPiSParser.VarExprContext;
import parser.TinyPiSParser.AndExprContext;
import parser.TinyPiSParser.NotExprContext;
import parser.TinyPiSParser.OrExprContext;
import parser.TinyPiSParser.SubExprContext;
import parser.TinyPiSParser.*;

public class ASTGenerator {	
	ASTNode translate(ParseTree ctxx) {
		if (ctxx instanceof ProgContext) { // ProgStmt
			ProgContext ctx = (ProgContext)ctxx;
			ArrayList<String> varDecls = new ArrayList<String>();
			for (TerminalNode token: ctx.varDecls().IDENTIFIER())
				varDecls.add(token.getText());
			ASTNode stmt = translate(ctx.stmt());
			return new ASTProgNode(varDecls, stmt);
		}else if (ctxx instanceof CompoundStmtContext) { // CompoundStmt
			CompoundStmtContext ctx = (CompoundStmtContext) ctxx;
			ArrayList<ASTNode> stmts = new ArrayList<ASTNode>();
			for (StmtContext t: ctx.stmt()) {
				ASTNode n = translate(t);
				stmts.add(n);
			}
			return new ASTCompoundStmtNode(stmts);
		} else if (ctxx instanceof AssignStmtContext) { // AssignStmt
			AssignStmtContext ctx = (AssignStmtContext) ctxx;
			String var = ctx.IDENTIFIER().getText();
			ASTNode expr = translate(ctx.expr());
			return new ASTAssignStmtNode(var, expr);
		} else if (ctxx instanceof IfStmtContext) {  // IfStmt
			IfStmtContext ctx = (IfStmtContext) ctxx;
			ASTNode expr = translate(ctx.expr());
			ASTNode thenStmt = translate(ctx.stmt(0));
			ASTNode elseStmt = translate(ctx.stmt(1));
			return new ASTIfStmtNode(expr, thenStmt, elseStmt);
 		} else if (ctxx instanceof WhileStmtContext) { // whileStmt
 			WhileStmtContext ctx = (WhileStmtContext) ctxx;
 			ASTNode expr = translate(ctx.expr());
 			ASTNode stmt = translate(ctx.stmt());
 			return new ASTWhileStmtNode(expr, stmt);
		} else if (ctxx instanceof ExprContext) { // expr
			ExprContext ctx = (ExprContext) ctxx;
			return translate(ctx.andExpr());
		} else if (ctxx instanceof AndExprContext) { // andExpr
			AndExprContext ctx = (AndExprContext) ctxx;
			if (ctx.andExpr() == null)
				return translate(ctx.orExpr());
			ASTNode lhs = translate(ctx.andExpr());
			ASTNode rhs = translate(ctx.orExpr());
			return new ASTBinaryExprNode(ctx.ANDOP().getText(), lhs, rhs);
		} else if (ctxx instanceof OrExprContext) { // orExpr
			OrExprContext ctx = (OrExprContext) ctxx;
			if (ctx.orExpr() == null)
				return translate(ctx.addExpr());
			ASTNode lhs = translate(ctx.orExpr());
			ASTNode rhs = translate(ctx.addExpr());
			return new ASTBinaryExprNode(ctx.OROP().getText(), lhs, rhs);
		} else if (ctxx instanceof AddExprContext) { // addExpr
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
		} else if (ctxx instanceof MulExprContext) { // mulExpr
			MulExprContext ctx = (MulExprContext) ctxx;
			if (ctx.mulExpr() == null)
				return translate(ctx.unaryExpr());
			ASTNode lhs = translate(ctx.mulExpr());
			ASTNode rhs = translate(ctx.unaryExpr());
			return new ASTBinaryExprNode(ctx.MULOP().getText(), lhs, rhs);
		} else if (ctxx instanceof LiteralExprContext) { // literalExpr
			LiteralExprContext ctx = (LiteralExprContext) ctxx;
			int value = Integer.parseInt(ctx.VALUE().getText());
			return new ASTNumberNode(value);
		} else if (ctxx instanceof VarExprContext) { // varExpr
			VarExprContext ctx = (VarExprContext) ctxx;
			String varName = ctx.IDENTIFIER().getText();
			return new ASTVarRefNode(varName);
		} else if (ctxx instanceof ParenExprContext) { // parenExpr
			ParenExprContext ctx = (ParenExprContext) ctxx;
			return translate(ctx.expr());
		} else if (ctxx instanceof SubExprContext) { // subExpr
			SubExprContext ctx = (SubExprContext) ctxx;
			ASTNode rhs = translate(ctx.expr());
			return new ASTUnaryNode(ctx.SUBOP().getText(), rhs);
		} else if (ctxx instanceof NotExprContext) { // notExpr
			NotExprContext ctx = (NotExprContext) ctxx;
			ASTNode rhs = translate(ctx.expr());
			return new ASTUnaryNode(ctx.NOTOP().getText(), rhs);
		}
		throw new Error("Unknown parse tree node: "+ctxx.getText());		
	}
}

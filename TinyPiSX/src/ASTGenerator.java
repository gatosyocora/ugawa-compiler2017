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
		} else if (ctxx instanceof CompoundStmtContext) { // CompoundStmt
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
		} else if (ctxx instanceof PrintStmtContext) { // PrintStmt
 			PrintStmtContext ctx = (PrintStmtContext) ctxx;
 			ASTNode expr = translate(ctx.expr());
 			return new ASTPrintStmtNode(expr);
		} else if (ctxx instanceof ExprContext) { // expr
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
			ASTNode rhs = translate(ctx.unaryExpr());
			return new ASTUnaryNode(ctx.SUBOP().getText(), rhs);
		} else if (ctxx instanceof NotExprContext) { // notExpr
			NotExprContext ctx = (NotExprContext) ctxx;
			ASTNode rhs = translate(ctx.unaryExpr());
			return new ASTUnaryNode(ctx.NOTOP().getText(), rhs);
		}
		throw new Error("Unknown parse tree node: "+ctxx.getText());		
	}
}

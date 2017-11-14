import org.antlr.v4.runtime.tree.ParseTree;

import parser.TinyPiEParser.AddExprContext;
import parser.TinyPiEParser.AndExprContext;
import parser.TinyPiEParser.ExprContext;
import parser.TinyPiEParser.LiteralExprContext;
import parser.TinyPiEParser.MulExprContext;
import parser.TinyPiEParser.NotExprContext;
import parser.TinyPiEParser.OrExprContext;
import parser.TinyPiEParser.ParenExprContext;
import parser.TinyPiEParser.SubExprContext;
import parser.TinyPiEParser.VarExprContext;

public class ASTGenerator {	
	ASTNode translateExpr(ParseTree ctxx) {
		if (ctxx instanceof ExprContext) { // expr
			ExprContext ctx = (ExprContext) ctxx;
			return translateExpr(ctx.andExpr());
		} else if (ctxx instanceof AndExprContext) { // andExpr
			AndExprContext ctx = (AndExprContext) ctxx;
			if (ctx.andExpr() == null)
				return translateExpr(ctx.orExpr());
			ASTNode lhs = translateExpr(ctx.andExpr());
			ASTNode rhs = translateExpr(ctx.orExpr());
			return new ASTBinaryExprNode(ctx.ANDOP().getText(), lhs, rhs);
		} else if (ctxx instanceof OrExprContext) { // orExpr
			OrExprContext ctx = (OrExprContext) ctxx;
			if (ctx.orExpr() == null)
				return translateExpr(ctx.addExpr());
			ASTNode lhs = translateExpr(ctx.orExpr());
			ASTNode rhs = translateExpr(ctx.addExpr());
			return new ASTBinaryExprNode(ctx.OROP().getText(), lhs, rhs);
		}else if (ctxx instanceof AddExprContext) { // addExpr
			AddExprContext ctx = (AddExprContext) ctxx;
			String calc;
			if (ctx.addExpr() == null)
				return translateExpr(ctx.mulExpr());
			if (ctx.ADDOP() != null) {
				calc = ctx.ADDOP().getText();
			} else {
				calc = ctx.SUBOP().getText();
			}
			ASTNode lhs = translateExpr(ctx.addExpr());
			ASTNode rhs = translateExpr(ctx.mulExpr());
			return new ASTBinaryExprNode(calc, lhs, rhs);
		} else if (ctxx instanceof MulExprContext) { // mulExpr
			MulExprContext ctx = (MulExprContext) ctxx;
			if (ctx.mulExpr() == null)
				return translateExpr(ctx.unaryExpr());
			ASTNode lhs = translateExpr(ctx.mulExpr());
			ASTNode rhs = translateExpr(ctx.unaryExpr());
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
			return translateExpr(ctx.expr());
		} else if (ctxx instanceof SubExprContext) { // subExpr
			SubExprContext ctx = (SubExprContext) ctxx;
			ASTNode rhs = translateExpr(ctx.expr());
			return new ASTUnaryNode(ctx.SUBOP().getText(), rhs);
		} else if (ctxx instanceof NotExprContext) { // notExpr
			NotExprContext ctx = (NotExprContext) ctxx;
			ASTNode rhs = translateExpr(ctx.expr());
			return new ASTUnaryNode(ctx.NOTOP().getText(), rhs);
		}
		throw new Error("Unknown parse tree node: "+ctxx.getText());		
	}
	ASTNode translate(ParseTree ctxx) {
		return translateExpr(ctxx);
	}
}

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.TinyPiSLexer;
import parser.TinyPiSParser;
import parser.TinyPiSParser.ProgContext;

public class Interpreter extends InterpreterBase {
	int evalExpr(ASTNode ndx, Environment env) {
		if (ndx instanceof ASTLogicExprNode) {
			ASTLogicExprNode nd = (ASTLogicExprNode) ndx;
			int lhsValue = 0;
			if (nd.lhs != null)
				lhsValue = evalExpr(nd.lhs, env);
			int rhsValue = evalExpr(nd.rhs, env);
			if (nd.op.equals("&&"))
				return ((lhsValue != 0) && (rhsValue != 0))? 1:0;
			else if (nd.op.equals("||"))
				return ((lhsValue != 0) || (rhsValue != 0))? 1:0;
			else if (nd.op.equals("!"))
				return (rhsValue == 0)? 1:0;
			else
				throw new Error("Unknwon operator: "+nd.op);
		} else if (ndx instanceof ASTCmpExprNode) {
			ASTCmpExprNode nd = (ASTCmpExprNode) ndx;
			int lhsValue = evalExpr(nd.lhs, env);
			int rhsValue = evalExpr(nd.rhs, env);
			if (nd.op.equals("=="))
				return (lhsValue == rhsValue)? 1:0;
			else if (nd.op.equals("!="))
				return (lhsValue != rhsValue)? 1:0;
			else if (nd.op.equals(">"))
				return (lhsValue > rhsValue)? 1:0;
			else if (nd.op.equals("<"))
				return (lhsValue < rhsValue)? 1:0;
			else if (nd.op.equals(">="))
				return (lhsValue >= rhsValue)? 1:0;
			else if (nd.op.equals("<="))
				return (lhsValue <= rhsValue)? 1:0;
			else
				throw new Error("Unknwon operator: "+nd.op);
		}
		if (ndx instanceof ASTBinaryExprNode) {
			ASTBinaryExprNode nd = (ASTBinaryExprNode) ndx;
			int lhsValue = evalExpr(nd.lhs, env);
			int rhsValue = evalExpr(nd.rhs, env);
			if (nd.op.equals("+"))
				return lhsValue + rhsValue;
			else if (nd.op.equals("-"))
				return lhsValue - rhsValue;
			else if (nd.op.equals("*"))
				return lhsValue * rhsValue;
			else if (nd.op.equals("/"))
				return lhsValue / rhsValue;
			else if (nd.op.equals("&"))
				return lhsValue & rhsValue;
			else if (nd.op.equals("|"))
				return lhsValue | rhsValue;
			else
				throw new Error("Unknwon operator: "+nd.op);
		} else if (ndx instanceof ASTNumberNode) {
			ASTNumberNode nd = (ASTNumberNode) ndx;
			return nd.value;
		} else if (ndx instanceof ASTVarRefNode) {
			ASTVarRefNode nd = (ASTVarRefNode) ndx;
			Variable var = env.lookup(nd.varName);
			if (var == null)
				throw new Error("Undefined variable: "+nd.varName);
			return var.get();
		} else if (ndx instanceof ASTUnaryNode) {
			ASTUnaryNode nd = (ASTUnaryNode) ndx;
			int rhsValue = evalExpr(nd.operand, env);
			if (nd.op.equals("-"))
				return -1 * rhsValue;
			else if (nd.op.equals("~"))
				return ~rhsValue;
			else
				throw new Error("Unknown operator: "+nd.op);
		} else
			throw new Error("Unknown expression: "+ndx);
	}

	public int eval(ASTNode ast) {
		Environment env = new Environment();
		ASTProgNode prog = (ASTProgNode) ast;
		for (String varName: prog.varDecls) {
			if (env.lookup(varName) != null)
				throw new Error("Variable redefinded: " + varName);
			addGlobalVariable(env, varName, 0);
		}
		if (env.lookup("answer") == null)
			addGlobalVariable(env, "answer", 0);
		evalStmt(prog.stmt, env);
		Variable varAnswer = env.lookup("answer");
		return varAnswer.get();
	}
	
	void evalStmt(ASTNode ndx, Environment env) {
		if (ndx instanceof ASTCompoundStmtNode) {
			ASTCompoundStmtNode nd = (ASTCompoundStmtNode) ndx;
			ArrayList<ASTNode> stmts = nd.stmts;
			for (ASTNode child: stmts)
				evalStmt(child, env);
		} else if (ndx instanceof ASTAssignStmtNode) {
			ASTAssignStmtNode nd =(ASTAssignStmtNode) ndx;
			Variable var = env.lookup(nd.var);
			if (var == null)
				throw new Error("undefined variable: " + nd.var);
			int value = evalExpr(nd.expr, env);
			var.set(value);
		} else if (ndx instanceof ASTIfStmtNode) {
			ASTIfStmtNode nd =(ASTIfStmtNode) ndx;
			if (evalExpr(nd.cond, env) != 0)
				evalStmt(nd.thenClause, env);
			else
				evalStmt(nd.elseClause, env);
		} else if (ndx instanceof ASTWhileStmtNode) {
			ASTWhileStmtNode nd = (ASTWhileStmtNode) ndx;
			while (evalExpr(nd.cond, env) != 0)
				evalStmt(nd.stmt, env);
		} else if (ndx instanceof ASTPrintStmtNode) {
			ASTPrintStmtNode nd = (ASTPrintStmtNode) ndx;
			int num = evalExpr(nd.expr, env);
			System.out.println(String.format("%08X", num));
		} else
			throw new Error("Unknown statement: " +ndx);
	}

	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		TinyPiSLexer lexer = new TinyPiSLexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
        TinyPiSParser parser = new TinyPiSParser(token);
        ParseTree tree = parser.prog(); ////
        ASTGenerator astgen = new ASTGenerator();
        ASTNode ast = astgen.translate(tree);
        Interpreter interp = new Interpreter();
        int answer = interp.eval(ast);
        System.out.println(answer);
	}
}

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.PiLangLexer;
import parser.PiLangParser;

public class Interpreter extends InterpreterBase {
	
	static class ReturnValue {
		ReturnValue(int value) {
			this.value = value;
		}
		int value;
	}
	
	static class BreakValue extends ReturnValue {
		BreakValue(int value) {super(value);}
	}
	
	Environment globalEnv;
	ASTProgNode prog;
	ASTFunctionNode lookupFunction(String name) {
		for (ASTFunctionNode func: prog.funcDecls)
			if (func.name.equals(name))
				return func;
		throw new Error("undefined functin: "+name);
	}

	int evalFunction(ASTFunctionNode nd, ArrayList<Integer> args) {
		Environment env = new Environment();
		for (int i = 0; i < nd.params.size(); i++) {
			String name = nd.params.get(i);
			Variable var = new Variable(name);
			int arg = args.get(i);
			var.set(arg);
			env.push(var);
		}

		/* ローカル変数を追加するコードをここに書く(書いた) */
		for (String name: nd.varDecls) {
			Variable var = new Variable(name);
			var.set(0);
			env.push(var);
		}
		
		for (ASTNode stmt: nd.stmts) {
			ReturnValue retval = evalStmt(stmt, env);
			if (retval != null) 
				return retval.value;
		}
		return 0;
	}

	ReturnValue evalStmt(ASTNode ndx, Environment env) {
		ReturnValue retval = null;
		if (retval instanceof BreakValue)
			System.out.println("this1");
		if (ndx instanceof ASTCompoundStmtNode) {
			ASTCompoundStmtNode nd = (ASTCompoundStmtNode) ndx;
			ArrayList<ASTNode> stmts = nd.stmts;
			for (ASTNode child: stmts)
				retval = evalStmt(child, env);
		} else if (ndx instanceof ASTAssignStmtNode) {
			ASTAssignStmtNode nd =(ASTAssignStmtNode) ndx;
			Variable var = env.lookup(nd.var);
			if (var == null) {
				var = globalEnv.lookup(nd.var);
			}
			if (var == null)
				throw new Error("undefined variable: " + nd.var);
			int value = evalExpr(nd.expr, env);
			var.set(value);
		} else if (ndx instanceof ASTIfStmtNode) {
			ASTIfStmtNode nd =(ASTIfStmtNode) ndx;
			if (evalExpr(nd.cond, env) != 0)
				retval = evalStmt(nd.thenClause, env);
			else
				retval = evalStmt(nd.elseClause, env);
		} else if (ndx instanceof ASTWhileStmtNode) {
			ASTWhileStmtNode nd = (ASTWhileStmtNode) ndx;
			while (evalExpr(nd.cond, env) != 0) {
				retval = evalStmtd(nd.stmt, env);
				if (retval instanceof BreakValue) 
					return null;
			}
		} else if (ndx instanceof ASTReturnNode) {
			ASTReturnNode nd = (ASTReturnNode) ndx;
			int value = evalExpr(nd.expr, env);
			retval = new ReturnValue(value);
		} else if (ndx instanceof ASTPrintStmtNode) {
			ASTPrintStmtNode nd = (ASTPrintStmtNode) ndx;
			int num = evalExpr(nd.expr, env);
			System.out.println(String.format("%08X", num));
		} else
			throw new Error("Unknown statement: " +ndx);
		return retval;
	}
	
	ReturnValue evalStmtd(ASTNode ndx, Environment env) {
		ReturnValue retval = null;
		if (ndx instanceof ASTBreakStmtdNode) {
			System.out.println("this");
			return new BreakValue(0);
		}
		else if (ndx instanceof ASTCompoundStmtdNode) {
			ASTCompoundStmtdNode nd = (ASTCompoundStmtdNode) ndx;
			ArrayList<ASTNode> stmts = nd.stmts;
			for (ASTNode child: stmts) {
				retval = evalStmtd(child, env);
				if (retval instanceof BreakValue) {
					break;
				}
			}
		}
		else if (ndx instanceof ASTIfStmtdNode) {
			ASTIfStmtdNode nd =(ASTIfStmtdNode) ndx;
			if (evalExpr(nd.cond, env) != 0)
				retval = evalStmtd(nd.thenClause, env);
			else
				retval = evalStmtd(nd.elseClause, env);
		} else {
			retval = evalStmt(ndx, env);
		}
		return retval;
	}
	
	
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
		} else if (ndx instanceof ASTBinaryExprNode) {
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
		} else if (ndx instanceof ASTCallNode) {
			ASTCallNode nd = (ASTCallNode) ndx;
			ASTFunctionNode func = lookupFunction(nd.name);
			ArrayList<Integer> args = new ArrayList<Integer>();
			for (ASTNode argNode: nd.args) {
				int arg = evalExpr(argNode, env);
				args.add(arg);
			}
			return evalFunction(func, args);
		} else if (ndx instanceof ASTNumberNode) {
			ASTNumberNode nd = (ASTNumberNode) ndx;
			return nd.value;
		} else if (ndx instanceof ASTVarRefNode) {
			ASTVarRefNode nd = (ASTVarRefNode) ndx;
			Variable var = env.lookup(nd.varName); // 引数から探す
			if (var == null)
				var = globalEnv.lookup(nd.varName); // グローバル変数から探す
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
		globalEnv = new Environment();
		prog = (ASTProgNode) ast;
		for (String varName: prog.varDecls) {
			if (globalEnv.lookup(varName) != null)
				throw new Error("Variable redefined: "+varName);
			addGlobalVariable(globalEnv, varName, 0);
		}
		ASTFunctionNode mainFunc = lookupFunction("main");
		ArrayList<Integer> args = new ArrayList<Integer>();
		int answer = evalFunction(mainFunc, args);
		return answer;
	}

	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		PiLangLexer lexer = new PiLangLexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		PiLangParser parser = new PiLangParser(token);
		ParseTree tree = parser.prog();
		ASTGenerator astgen = new ASTGenerator();
		ASTNode ast = astgen.translate(tree);
		Interpreter interp = new Interpreter();
		int answer = interp.eval(ast);
		System.out.println(answer);
	}
}

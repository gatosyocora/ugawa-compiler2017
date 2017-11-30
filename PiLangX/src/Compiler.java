import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.PiLangLexer;
import parser.PiLangParser;

public class Compiler extends CompilerBase {
	Environment globalEnv;
	boolean isUsedPrint = false;
	
	void compileFunction(ASTFunctionNode nd) {
		Environment env = new Environment();
		String epilogueLabel = freshLabel();
		for (int i = 0; i < nd.params.size(); i++) {
			String name = nd.params.get(i);
			int offset = 4 * (i + 1);

			LocalVariable var = new LocalVariable(name, offset);
			env.push(var);
		}
		
		emitLabel(nd.name);
		System.out.println("\t@ prologue");
		emitPUSH(REG_FP);
		emitRR("mov", REG_FP, REG_SP);
		emitPUSH(REG_LR);
		emitPUSH(REG_R1);
		emitRRI("sub", REG_SP, REG_SP, nd.varDecls.size() * 4);
		
		emitRI("mov", REG_DST, 0);
		for (int i = 0; i < nd.varDecls.size(); i++) {
			String name = nd.varDecls.get(i);
			int offset = -4 * (i + 3);
			LocalVariable var = new LocalVariable(name, offset);
			emitSTR(REG_DST, REG_FP, offset); //　初期値を代入
			env.push(var);
		}
		for (ASTNode stmt: nd.stmts)
			compileStmt(stmt, epilogueLabel, env);
		emitRI("mov", REG_DST, 0); // returnがなかったときの戻り値0
		emitLabel(epilogueLabel);
		System.out.println("\t@ epilogue");
		emitRRI("add", REG_SP, REG_SP, nd.varDecls.size() * 4);
		emitPOP(REG_R1);
		emitPOP(REG_LR);
		emitPOP(REG_FP);
		emitRET();
	}
	
	void compileStmt(ASTNode ndx, String epilogueLabel, Environment env) {
		
		if (ndx instanceof ASTCompoundStmtNode) {					// compoundStmt
			ASTCompoundStmtNode nd = (ASTCompoundStmtNode) ndx;
			for (ASTNode stmt: nd.stmts) {
				compileStmt(stmt, epilogueLabel, env);
			}
		} else if (ndx instanceof ASTAssignStmtNode) {			// assignStmt
			ASTAssignStmtNode nd = (ASTAssignStmtNode) ndx;
			Variable var = env.lookup(nd.var);
			if (var == null)
				var = globalEnv.lookup(nd.var);
			if (var == null) 
				throw new Error("undefined variable: " + nd.var);
			compileExpr(nd.expr, env);
			if (var instanceof GlobalVariable) {					// assignStmt.globalVariable
				GlobalVariable globalVar = (GlobalVariable) var;
				emitLDC(REG_R1, globalVar.getLabel());
				emitSTR(REG_DST, REG_R1, 0);
			} else {													// assignStmt.localVariable
				LocalVariable localVar = (LocalVariable) var;
				int offset = localVar.offset;
				emitSTR(REG_DST, REG_FP, offset);
			}
		} else if (ndx instanceof ASTIfStmtNode) {				// ifStmt
			ASTIfStmtNode nd = (ASTIfStmtNode) ndx;
			String elseLabel = freshLabel();
			String endLabel = freshLabel();
			compileExpr(nd.cond, env);
			emitRI("cmp", REG_DST, 0);
			emitJMP("beq", elseLabel);
			compileStmt(nd.thenClause, epilogueLabel, env);
			emitJMP("b", endLabel);
			emitLabel(elseLabel);
			compileStmt(nd.elseClause, epilogueLabel, env);
			emitLabel(endLabel);
		} else if (ndx instanceof ASTWhileStmtNode) {				// whileStmt
			ASTWhileStmtNode nd = (ASTWhileStmtNode) ndx;
			String startLabel = freshLabel();
			String endLabel = freshLabel();
			emitLabel(startLabel);
			compileExpr(nd.cond, env);
			emitRI("cmp", REG_DST, 0);
			emitJMP("beq", endLabel);
			compileStmt(nd.stmt, epilogueLabel, env);
			emitJMP("b", startLabel);
			emitLabel(endLabel);
		} else if (ndx instanceof ASTReturnNode) {  				// returnStmt
			ASTReturnNode nd = (ASTReturnNode) ndx;
			compileExpr(nd.expr, env);
			emitJMP("b", epilogueLabel);
		} else if (ndx instanceof ASTPrintStmtNode) {				// printStmt
			ASTPrintStmtNode nd = (ASTPrintStmtNode) ndx;
			isUsedPrint = true;
			compileExpr(nd.expr, env);
			emitCALL(FUNCTION_PRINT);
		} else
			throw new Error("Unknown expression: " + ndx);
	}

	void compileExpr(ASTNode ndx, Environment env) {
		if (ndx instanceof ASTLogicExprNode) {
			ASTLogicExprNode nd = (ASTLogicExprNode) ndx;
			if (nd.lhs != null) {
				compileExpr(nd.lhs, env);
				emitRI("cmp",REG_DST, 0);
				emitRI("moveq", REG_DST, 0);
				emitPUSH(REG_R1);
				emitRR("mov", REG_R1, REG_DST);
			}
			compileExpr(nd.rhs, env);
			emitRI("cmp",REG_DST, 0);
			emitRI("moveq", REG_DST, 0);
			if (nd.op.equals("&&"))
				emitRRR("and", REG_DST, REG_DST, REG_R1);
			else if (nd.op.equals("||"))
				emitRRR("orr", REG_DST, REG_DST, REG_R1);
			else if (nd.op.equals("!")) 
				emitRR("mvn", REG_DST, REG_DST);
			else
				throw new Error("Unknown operator: "+nd.op);
			emitRRI("and", REG_DST, REG_DST, 1);
			if (nd.lhs != null)
				emitPOP(REG_R1);
		} else if (ndx instanceof ASTCmpExprNode) {
			ASTCmpExprNode nd = (ASTCmpExprNode) ndx;
			compileExpr(nd.lhs, env);
			emitPUSH(REG_R1);
			emitRR("mov", REG_R1, REG_DST);
			compileExpr(nd.rhs, env);
			emitRR("cmp", REG_R1, REG_DST);
			emitRI("mov", REG_DST, 0);
			if (nd.op.equals("=="))
				emitRI("moveq", REG_DST, 1);
			else if (nd.op.equals("!="))
				emitRI("movne", REG_DST, 1);
			else if (nd.op.equals(">"))
				emitRI("movgt", REG_DST, 1);
			else if (nd.op.equals("<"))
				emitRI("movlt", REG_DST, 1);
			else if (nd.op.equals(">="))
				emitRI("movge", REG_DST, 1);
			else if (nd.op.equals("<="))
				emitRI("movle", REG_DST, 1);
			else
				throw new Error("Unknown operator: "+nd.op);
			emitPOP(REG_R1);
		} else if (ndx instanceof ASTBinaryExprNode) {					// binaryExpr
			ASTBinaryExprNode nd = (ASTBinaryExprNode) ndx;
			compileExpr(nd.lhs, env);
			emitPUSH(REG_R1);
			emitRR("mov", REG_R1, REG_DST);
			compileExpr(nd.rhs, env);
			if (nd.op.equals("+"))
				emitRRR("add", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("-"))
				emitRRR("sub", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("*"))
				emitRRR("mul", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("/"))
				emitRRR("udiv", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("&")) 
				emitRRR("and", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("|")) 
				emitRRR("orr", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("&")) 
				emitRRR("and", REG_DST, REG_R1, REG_DST);
			else if (nd.op.equals("|")) 
				emitRRR("orr", REG_DST, REG_R1, REG_DST);
			else
				throw new Error("Unknwon operator: "+nd.op);
			emitPOP(REG_R1);
		} else if (ndx instanceof ASTCallNode) {					// callExpr
			ASTCallNode nd = (ASTCallNode) ndx;
			for (int i = nd.args.size()-1;i >= 0;i--) {
				ASTNode arg = nd.args.get(i);
				compileExpr(arg, env);
				emitPUSH(REG_DST);
			}
			emitCALL(nd.name);
			emitRRI("add", REG_SP, REG_SP, nd.args.size() * 4);
		} else if (ndx instanceof ASTNumberNode) {				// numberExpr
			ASTNumberNode nd = (ASTNumberNode) ndx;
			emitLDC(REG_DST, nd.value);
		} else if (ndx instanceof ASTVarRefNode) {				// varRefExpr
			ASTVarRefNode nd = (ASTVarRefNode) ndx;
			Variable var = env.lookup(nd.varName);
			if (var == null)
				var = globalEnv.lookup(nd.varName);
			if (var == null)
				throw new Error("Undefined variable: " + nd.varName);
			if (var instanceof GlobalVariable) {					// varRefExpr.globalVariable
				GlobalVariable globalVar = (GlobalVariable) var;
				emitLDC(REG_DST, globalVar.getLabel());
				emitLDR(REG_DST, REG_DST, 0);
			} else {													// varRefExpr.localVariable
				LocalVariable localVar = (LocalVariable) var;
				int offset = localVar.offset;
				emitLDR(REG_DST, REG_FP, offset);
			}
		} else if (ndx instanceof ASTUnaryNode) {					// unaryExpr
			ASTUnaryNode nd = (ASTUnaryNode) ndx;
			compileExpr(nd.operand, env);
			if (nd.op.equals("-")) {
				emitRR("mvn", REG_DST, REG_DST);
				emitRRI("add", REG_DST, REG_DST, 1);
			} else if (nd.op.equals("~"))
				emitRR("mvn", REG_DST, REG_DST);
			else
				throw new Error("Unknown operator: "+nd.op);
		} else
			throw new Error("Unknown expression: "+ndx);
	}
	
	void compile(ASTNode ast) {

		globalEnv = new Environment();
		ASTProgNode program = (ASTProgNode) ast;

		System.out.println("\t.section .data");
		System.out.println("\t@ 大域変数の定義");		
		for (String varName: program.varDecls) {
			if (globalEnv.lookup(varName) != null)
				throw new Error("Variable redefined: "+varName);
			GlobalVariable v = addGlobalVariable(globalEnv, varName);
			emitLabel(v.getLabel());
			System.out.println("\t.word 0");
		}

		System.out.println("\t.section .text");
		System.out.println("\t.global _start");
		System.out.println("_start:");
		System.out.println("\t@ main関数を呼出す．戻り値は r0 に入る");
		emitJMP("bl", "main");
		System.out.println("\t@ EXITシステムコール");
		emitRI("mov", "r7", 1);      // EXIT のシステムコール番号
		emitI("swi", 0);
		
		/* 関数定義 */
		for (ASTFunctionNode func: program.funcDecls)
			compileFunction(func);
		
		if (isUsedPrint) {
			/* プリント文を実装するためのプログラム */
			printCode();
		}
	}
	
	void printCode() {
		System.out.println(FUNCTION_PRINT+":");
		
		emitPUSH(REG_DST); //push!
		emitPUSH(REG_R1); // push!
		emitPUSH("r2"); // push!
		emitPUSH("r3"); // push!
		
		emitLDC(REG_R1, "buf"); // 先頭の番地
		emitRRI("add", "r3", REG_R1, 8); // 末尾の番地
		
		System.out.println("loop:");
		emitRRI("and", "r2", REG_DST, 0xf); // あまりを計算
		emitRI("cmp", "r2", 10); // 10より大きいか
		
		emitRRI("add", "r2", "r2", '0'); // 文字に変換
		
		// 10~15の時
		emitRRI("addcs", "r2", "r2", 7); // '0' + 7 = 'A'
		
		emitRRI("sub", "r3", "r3", 1);
		//emitSTR("r2", REG_R1, 0); // レジスタに格納、書き込み先更新
		System.out.println("\tstrb r2, [r3]");
		
		// 次の数へ
		emitRRI("lsr", REG_DST, REG_DST, 4); // 割られる数(r4 = r4 / 16)
		emitRR("cmp", "r3", REG_R1); // 0かどうか比較
		emitJMP("bcs", "loop"); // ０でなければループ
		
		/* 表示 */
		emitRI("mov", "r7", 4); // writeシステムコール番号
		emitRI("mov", REG_DST, 1); // 標準出力
		emitRI("mov", "r2", 9); // 文字の長さ+1
		emitI("swi", 0);
		
		emitPOP("r3");// pop!
		emitPOP("r2");// pop!
		emitPOP(REG_R1);// pop!
		emitPOP(REG_DST);// pop!
		
		emitRET();
		
		/* データ部 */
		System.out.println("\t.section .data");

		System.out.println("\t@ print用のデータ");
		System.out.println("buf:");
		System.out.println("\t.space 8, '0'");
		System.out.println("\t.byte	0x0a @ 末端文字");
	}

	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		PiLangLexer lexer = new PiLangLexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		PiLangParser parser = new PiLangParser(token);
		ParseTree tree = parser.prog();
		ASTGenerator astgen = new ASTGenerator();
		ASTNode ast = astgen.translate(tree);
		Compiler compiler = new Compiler();
		compiler.compile(ast);
	}
}

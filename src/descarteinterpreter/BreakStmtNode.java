/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descarteinterpreter;

/**
 *
 * @author benjamin
 */
public class BreakStmtNode extends ParseTreeNode {
	
	public BreakStmtNode(int code) {
		super(code);
	}
	
	protected BreakStmtNode(int code, ParseTreeNode parent) {
		super(code, parent);
	}

	/**
	 * Add child nodes based on the current token and the grammar's rules.
	 *
	 * @param token the current token
	 */
	public void populateChildren(TokenPair token) {
		int tokenNum = token.getTokenNum();
		
		switch (tokenNum) {
			
			case 10:     // BREAK
				doRule15(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 15 in the grammar: "break-stmt : BREAK
	 * id-option"
	 *
	 * @param token the current token
	 */
	private void doRule15(TokenPair token) {
		this.addChild(10);
		this.addChild(42);
	}
}

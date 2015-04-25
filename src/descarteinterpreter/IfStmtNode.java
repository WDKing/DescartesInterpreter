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
public class IfStmtNode extends ParseTreeNode {

	public IfStmtNode(int code) {
		super(code);
	}

	protected IfStmtNode(int code, ParseTreeNode parent) {
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

			case 2:     // IF
				doRule11(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 11 in the grammar: "if-stmt : IF expr
	 * THEN stmt-list else-part"
	 *
	 * @param token the current token
	 */
	private void doRule11(TokenPair token) {
		this.addChild(2);
		this.addChild(40);
		this.addChild(3);
		this.addChild(31);
		this.addChild(41);
	}
}

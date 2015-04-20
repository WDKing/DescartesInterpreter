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
public class ExprNode extends ParseTreeNode {

	public ExprNode(int code) {
		super(code);
	}

	protected ExprNode(int code, ParseTreeNode parent) {
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

			case 7:     // ID
			case 24:	// -
			case 27:	// (
			case 29:	// CONST
				doRule23(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 23 in the grammar: "expr : bool-term bool-term-tail"
	 *
	 * @param token the current token
	 */
	private void doRule23(TokenPair token) {
		this.addChild(44);
		this.addChild(45);
	}
}

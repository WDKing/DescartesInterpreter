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
public class ElsePartNode extends ParseTreeNode{
	
	public ElsePartNode(int code) {
		super(code);
	}

	protected ElsePartNode(int code, ParseTreeNode parent) {
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

			case 4:		// ELSE
				doRule12(token);
			case 5:		//FI
				doRule13(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 12 in the grammar: "else-part : ELSE stmt-lit FI"
	 *
	 * @param token the current token
	 */
	private void doRule12(TokenPair token) {
		this.addChild(4);
		this.addChild(31);
		this.addChild(5);
	}
	/**
	 * Add child nodes based on rule 13 in the grammar: "else-part : FI"
	 *
	 * @param token the current token
	 */
	private void doRule13(TokenPair token) {
		this.addChild(5);
	}
}

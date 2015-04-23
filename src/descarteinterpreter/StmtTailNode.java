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
public class StmtTailNode extends ParseTreeNode {

	public StmtTailNode(int code) {
		super(code);
	}

	protected StmtTailNode(int code, ParseTreeNode parent) {
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
			case 0:		// PERIOD
			case 4:		// ELSE
			case 5:		// FI
			case 9:		// REPEAT
				doRule3(token);
				break;
			case 1:		// SEMICOLON
				doRule2(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 2 in the grammar: "stmt-tail : SEMICOLON stmt stmt-tail"
	 *
	 * @param token the current token
	 */
	private void doRule2(TokenPair token) {
		this.addChild(1);
		this.addChild(32);
		this.addChild(33);
	}
	/**
	 * Add child nodes based on rule 3 in the grammar: "stmt-tail :"
	 *
	 * @param token the current token
	 */
	private void doRule3(TokenPair token) {
		//DO NOTHING
	}
}

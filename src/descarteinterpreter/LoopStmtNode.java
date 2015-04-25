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
public class LoopStmtNode extends ParseTreeNode {

	public LoopStmtNode(int code) {
		super(code);
	}

	protected LoopStmtNode(int code, ParseTreeNode parent) {
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

			case 6:     // LOOP
				doRule14(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 14 in the grammar: "loop-stmt : LOOP ID
	 * COLON stmt-list REPEAT"
	 *
	 * @param token the current token
	 */
	private void doRule14(TokenPair token) {
		this.addChild(6);
		this.addChild(7);
		this.addChild(8);
		this.addChild(31);
		this.addChild(9);
	}
}

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
public class PrintStmtNode extends ParseTreeNode {
	
	public PrintStmtNode(int code) {
		super(code);
	}

	protected PrintStmtNode(int code, ParseTreeNode parent) {
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

			case 12:     // PRINT
				doRule19(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 19 in the grammar: "print-stmt : PRINT ID id-list-tail"
	 *
	 * @param token the current token
	 */
	private void doRule19(TokenPair token) {
		this.addChild(12);
		this.addChild(7);
		this.addChild(43);
	}
}

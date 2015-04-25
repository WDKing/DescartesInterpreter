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
public class ReadStmtNode extends ParseTreeNode{
	
	public ReadStmtNode(int code) {
		super(code);
	}

	protected ReadStmtNode(int code, ParseTreeNode parent) {
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

			case 13:     // READ
				doRule20(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 20 in the grammar: "read-stmt : READ ID id-list-tail"
	 *
	 * @param token the current token
	 */
	private void doRule20(TokenPair token) {
		this.addChild(13);
		this.addChild(7);
		this.addChild(43);
	}
}

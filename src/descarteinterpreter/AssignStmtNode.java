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
public class AssignStmtNode extends ParseTreeNode{

	public AssignStmtNode(int code) {
		super(code);
	}

	protected AssignStmtNode(int code, ParseTreeNode parent) {
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
				doRule18(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 18 in the grammar: "assign-stmt : ID BECOMES expr"
	 *
	 * @param token the current token
	 */
	private void doRule18(TokenPair token) {
		this.addChild(7);
		this.addChild(11);
		this.addChild(40);
	}
}

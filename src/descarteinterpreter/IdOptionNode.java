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
public class IdOptionNode extends ParseTreeNode {

	public IdOptionNode(int code) {
		super(code);
	}

	protected IdOptionNode(int code, ParseTreeNode parent) {
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
			case 1:		// SEMICOLON
			case 4:		//ELSE
			case 5:		//FI
			case 9:		//REPEAT
				doRule17(token);
				break;
			case 7:		// ID
				doRule16(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 16 in the grammar: "id-option : ID"
	 *
	 * @param token the current token
	 */
	private void doRule16(TokenPair token) {
		this.addChild(7);
	}
	
	/**
	 * Add child nodes based on rule 17 in the grammar: "id-option : "
	 *
	 * @param token the current token
	 */
	private void doRule17(TokenPair token) {
		//DO NOTHING
	}	
}

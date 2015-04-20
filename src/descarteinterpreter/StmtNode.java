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
public class StmtNode extends ParseTreeNode {

	public StmtNode(int code) {
		super(code);
	}

	protected StmtNode(int code, ParseTreeNode parent) {
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
				doRule10(token);
				break;
			case 2:		// IF
				doRule4(token);
				break;
			case 6:		// LOOP
				doRule5(token);
				break;
			case 7:		// ID
				doRule7(token);
				break;
			case 10:	// BREAK
				doRule6(token);
				break;
			case 12:	// PRINT
				doRule9(token);
				break;
			case 13:	// READ
				doRule8(token);
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * Add child nodes based on rule 4 in the grammar: 
	 * "stmt : if-stmt"
	 *
	 * @param token the current token
	 */
	private void doRule4(TokenPair token) {
		this.addChild(34);
	}
	/**
	 * Add child nodes based on rule 5 in the grammar: 
	 * "stmt : loop-stmt"
	 *
	 * @param token the current token
	 */
	private void doRule5(TokenPair token) {
		this.addChild(35);
	}
	/**
	 * Add child nodes based on rule 6 in the grammar: 
	 * "stmt : break-stmt"
	 *
	 * @param token the current token
	 */
	private void doRule6(TokenPair token) {
		this.addChild(36);
	}

	/**
	 * Add child nodes based on rule 7 in the grammar: 
	 * "stmt : assign-stmt"
	 *
	 * @param token the current token
	 */
	private void doRule7(TokenPair token) {
		this.addChild(37);
	}
	/**
	 * Add child nodes based on rule 8 in the grammar: 
	 * "stmt : read-stmt"
	 *
	 * @param token the current token
	 */
	private void doRule8(TokenPair token) {
		this.addChild(38);

	}
	/**
	 * Add child nodes based on rule 9 in the grammar: 
	 * "stmt : print-stmt"
	 *
	 * @param token the current token
	 */
	private void doRule9(TokenPair token) {
		this.addChild(39);

	}
	/**
	 * Add child nodes based on rule 10 in the grammar: 
	 * "stmt : "
	 *
	 * @param token the current token
	 */
	private void doRule10(TokenPair token) {
		//DO NOTHING
	}

}

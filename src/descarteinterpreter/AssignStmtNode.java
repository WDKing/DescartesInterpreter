/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "assign-stmt" node (#48) in a parse tree for Descartes-2
 */
public class AssignStmtNode extends ExecTypeNode {

    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param   token   the current token
     */
    protected AssignStmtNode(int code, ParseTreeNode parent) {
            super(code, parent);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag = new ControlTag();
        TerminalNode id = (TerminalNode) getChildAt(0);
        ExprNode expr = (ExprNode) getChildAt(2);
        
        symbolTable.put(id.getTokenStr(), expr.evaluate());
            
        return tag;
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param token the current token
     */
    @Override
    public void populateChildren(TokenPair token) {
            int tokenNum = token.getTokenNum();

            switch (tokenNum) {

                    case 7:     // ID
                                doRule18(token);
                                break;
                    default:    throw new IllegalArgumentException();
            }
    }

    /**
     * Add child nodes based on rule 18 in the grammar:
     * "18. assign-stmt : ID BECOMES expr"
     * @param   token   the current token
     */
    private void doRule18(TokenPair token) {
            this.addChild(7);
            this.addChild(11);
            this.addChild(40);
    }
}

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
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected AssignStmtNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
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
     * @param   token   the current token
     */
    @Override
    public void populateChildren(DescartesToken token) {
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
    private void doRule18(DescartesToken token) {
            this.addChild(7, token.getLineNum());
            this.addChild(11, token.getLineNum());
            this.addChild(40, token.getLineNum());
    }
}

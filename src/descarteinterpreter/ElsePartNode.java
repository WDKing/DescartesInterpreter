/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "else-part" node (#41) in a parse tree for Descartes-2
 */
public class ElsePartNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected ElsePartNode(int code, ParseTreeNode parent) {
            super(code, parent);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag;
        StmtListNode stmtList;
        
        if(getChildCount() == 1) {
            tag = new ControlTag();
        } else {
            stmtList = (StmtListNode) getChildAt(1);
            tag = stmtList.execute();
        }
        
        return tag;
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     *
     * @param token the current token
     */
    @Override
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();

        switch (tokenNum) {

            case 4:     // ELSE
                        doRule12(token);
                        break;
            case 5:     // FI
                        doRule13(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 12 in the grammar:
     * "12. else-part : ELSE stmt-lit FI"
     * @param token the current token
     */
    private void doRule12(TokenPair token) {
            this.addChild(4);
            this.addChild(31);
            this.addChild(5);
    }
    /**
     * Add child nodes based on rule 13 in the grammar:
     * "13. else-part : FI"
     * @param token the current token
     */
    private void doRule13(TokenPair token) {
        this.addChild(5);
    }
}

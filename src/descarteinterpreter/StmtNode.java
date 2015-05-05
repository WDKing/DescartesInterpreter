/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "stmt" node (#32) in a parse tree for Descartes-2
 */
public class StmtNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected StmtNode(int code, ParseTreeNode parent, int lineNum) {
            super(code, parent, lineNum);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag;
        ExecTypeNode node;
        
        if(hasChildren()) {
            node = (ExecTypeNode) getChildAt(0);
            tag = node.execute();
        } else {
            tag = new ControlTag();
        }
        
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
                case 0:     // PERIOD
                case 1:     // SEMICOLON
                case 4:     // ELSE
                case 5:     // FI
                case 9:     // REPEAT
                            doRule10(token);
                            break;
                case 2:     // IF
                            doRule4(token);
                            break;
                case 6:     // LOOP
                            doRule5(token);
                            break;
                case 7:     // ID
                            doRule7(token);
                            break;
                case 10:    // BREAK
                            doRule6(token);
                            break;
                case 12:    // PRINT
                            doRule9(token);
                            break;
                case 13:    // READ
                            doRule8(token);
                            break;
                default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 4 in the grammar: 
     * "4. stmt : if-stmt"
     * @param   token   the current token
     */
    private void doRule4(DescartesToken token) {
        this.addChild(34, token.getLineNum());
    }
    
    /**
     * Add child nodes based on rule 5 in the grammar: 
     * "5. stmt : loop-stmt"
     * @param   token   the current token
     */
    private void doRule5(DescartesToken token) {
        this.addChild(35, token.getLineNum());
    }
    
    /**
     * Add child nodes based on rule 6 in the grammar: 
     * "6. stmt : break-stmt"
     * @param   token   the current token
     */
    private void doRule6(DescartesToken token) {
        this.addChild(36, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 7 in the grammar: 
     * "7. stmt : assign-stmt"
     * @param   token   the current token
     */
    private void doRule7(DescartesToken token) {
        this.addChild(37, token.getLineNum());
    }
    /**
     * Add child nodes based on rule 8 in the grammar: 
     * "8. stmt : read-stmt"
     * @param   token   the current token
     */
    private void doRule8(DescartesToken token) {
        this.addChild(38, token.getLineNum());

    }
    /**
     * Add child nodes based on rule 9 in the grammar: 
     * "9. stmt : print-stmt"
     * @param   token   the current token
     */
    private void doRule9(DescartesToken token) {
        this.addChild(39, token.getLineNum());
    }
    
    /**
     * Add child nodes based on rule 10 in the grammar: 
     * "10. stmt : "
     * @param   token   the current token
     */
    private void doRule10(DescartesToken token) {
            //DO NOTHING
    }

}

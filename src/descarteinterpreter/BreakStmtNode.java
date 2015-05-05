/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "break-stmt" node (#36) in a parse tree for Descartes-2
 */
public class BreakStmtNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected BreakStmtNode(int code, ParseTreeNode parent, int lineNum) {
            super(code, parent, lineNum);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag;
        TerminalNode id;
        
        IdOptionNode idOpt = (IdOptionNode) getChildAt(1);
        if(idOpt.hasChildren()) {
            id = (TerminalNode) idOpt.getChildAt(0);
            tag = new ControlTag(id.getTokenStr(), true, id.getLineNum());
        } else {
            tag = new ControlTag("", true, lineNum);
        }
        
        return tag;
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param token the current token
     */
    @Override
    public void populateChildren(DescartesToken token) {
        int tokenNum = token.getTokenNum();

        switch (tokenNum) {

            case 10:    // BREAK
                        doRule15(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 15 in the grammar:
     * "15. break-stmt : BREAK id-option"
     * @param token the current token
     */
    private void doRule15(DescartesToken token) {
        this.addChild(10, token.getLineNum());
        this.addChild(42, token.getLineNum());
    }
}

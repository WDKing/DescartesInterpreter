/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "loop-stmt" node (#35) in a parse tree for Descartes-2
 */
public class LoopStmtNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected LoopStmtNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag = null;
        TerminalNode id;
        StmtListNode stmtList;
        String label;
        boolean keepLooping = true;
        
        id = (TerminalNode) getChildAt(1);
        label = id.getTokenStr();
        stmtList = (StmtListNode) getChildAt(3);
        
        while(keepLooping) {
            tag = stmtList.execute();
            if(tag.isBreak()) {
                keepLooping = false; // stop
                if(tag.getLabel().equals(label) || tag.getLabel().isEmpty()) {
                    tag = new ControlTag(); // Consume the break
                } // else keep passing the break up the tree
            } else if(tag.isError()) {
                keepLooping = false; // stop and pass the error up the tree
            }
        }
        
        return tag;
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     *
     * @param token the current token
     */
    @Override
    public void populateChildren(DescartesToken token) {
        int tokenNum = token.getTokenNum();

        switch (tokenNum) {

            case 6:     // LOOP
                        doRule14(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 14 in the grammar: "loop-stmt : LOOP ID
     * COLON stmt-list REPEAT"
     *
     * @param token the current token
     */
    private void doRule14(DescartesToken token) {
        this.addChild(6, token.getLineNum());
        this.addChild(7, token.getLineNum());
        this.addChild(8, token.getLineNum());
        this.addChild(31, token.getLineNum());
        this.addChild(9, token.getLineNum());
    }
}

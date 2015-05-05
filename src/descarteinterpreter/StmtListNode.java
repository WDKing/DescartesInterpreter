/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "stmt-list" node (#31) in a parse tree for Descartes-2
 */
public class StmtListNode extends ExecTypeNode {
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected StmtListNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag;
        StmtNode stmt;
        StmtTailNode stmtTail;
        
        stmt = (StmtNode) getChildAt(0);
        stmtTail = (StmtTailNode) getChildAt(1);
        
        tag = stmt.execute();
        if(!tag.isBreak() && !tag.isError()) {
            tag = stmtTail.execute();
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
        
        switch(tokenNum) {
            case 0:     // PERIOD
            case 1:     // SEMICOLON
            case 2:     // IF
            case 4:     // ELSE
            case 5:     // FI
            case 6:     // LOOP
            case 7:     // ID
            case 9:     // REPEAT
            case 10:    // BREAK
            case 12:    // PRINT
            case 13:    // READ
                        doRule1(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
/**
 * Add child nodes based on rule 1 in the grammar:
 * "1. stmt-list : stmt stmt-tail"
 * @param   token   the current token
 */
    private void doRule1(DescartesToken token) {
        addChild(32, token.getLineNum());
        addChild(33, token.getLineNum());
    }
}
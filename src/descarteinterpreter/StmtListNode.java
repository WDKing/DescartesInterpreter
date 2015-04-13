/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "prog" node in a parse tree for Descartes-2
 */
public class StmtListNode extends ParseTreeNode {
    
    public StmtListNode(int code) {
        super(code);
    }
    
    protected StmtListNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
/**
 * Add child nodes based on the current token and the grammar's rules.
 * @param   token   the current token
 */
    public void populateChildren(TokenPair token) {
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
 * "1.    stmt-list : stmt stmt-tail"
 * @param   token   the current token
 */
    private void doRule1(TokenPair token) {
        addChild(31);
        addChild(33);
    }
}
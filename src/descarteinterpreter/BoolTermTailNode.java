/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "BoolTermTail" node in a parse tree for Descartes-2
 */
public class BoolTermTailNode extends ParseTreeNode {
    
    public BoolTermTailNode(int code) {
        super(code);
    }
    
    protected BoolTermTailNode(int code, ParseTreeNode parent) {
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
            case 3:     // THEN
            case 4:     // ELSE
            case 5:     // FI
            case 9:     // REPEAT
            case 28:    // )
                        doRule25(token);
                        break;
            case 15:    // OR
                        doRule24(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
      }
    
    //  List of Rules to Complete
   
    /**
     * Add child nodes based on rule 24 in the grammar:
     * "24.   bool-term-tail : OR bool-term bool-term-tail"
     * @param   token   the current token
     */
    private void doRule24(TokenPair token) {
        addChild(15);
        addChild(44);
        addChild(45);
    }
    
    /**
     * Add child nodes based on rule 25 in the grammar:
     * "25.   bool-term-tail : "
     * @param   token   the current token
     */
    private void doRule25(TokenPair token) {
        // Intentionally Left Empty
    }
}

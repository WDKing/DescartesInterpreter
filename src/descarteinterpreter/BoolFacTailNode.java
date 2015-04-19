/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "BoolFacTail" node in a parse tree for Descartes-2
 */
public class BoolFacTailNode extends ParseTreeNode {
    
    public BoolFacTailNode(int code) {
        super(code);
    }
    
    protected BoolFacTailNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param   token   the current token
     */
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();
        
        switch(tokenNum) {
            case :     // PERIOD
            case :     // SEMICOLON
            case :     // THEN
            case :     // ELSE
            case :     // FI
            case :     // REPEAT
            case :     // OR
            case :     // -)
                        doRule28(token);
                        break;
            case :     // AND
                        doRule27(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
      }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 27 in the grammar:
     * "27.   bool-factor-tail : AND bool-factor bool-factor-tail"
     * @param   token   the current token
     */
    private void doRule27(TokenPair token) {
        addChild(16);
        addChild(46);
        addChild(47);
    }
    
    /**
     * Add child nodes based on rule 28 in the grammar:
     * "28.   bool-factor-tail : "
     * @param   token   the current token
     */
    private void doRule28(TokenPair token) {
        // Intentionally Left Blank
    }
}
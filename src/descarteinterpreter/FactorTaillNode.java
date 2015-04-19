/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "FactorTail" node in a parse tree for Descartes-2
 */
public class FactorTailNode extends ParseTreeNode {
    
    public FactorTailNode(int code) {
        super(code);
    }
    
    protected FactorTailNode(int code, ParseTreeNode parent) {
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
            case 15:    // OR
            case 16:    // AND
            case 17:    // <
            case 18:    // <=
            case 19:    // =
            case 20:    // >=
            case 21:    // >
            case 22:    // <>
            case 23:    // +
            case 24:    // -
            case 28:    // )
                        doRule44(token);
                        break;
            case 25:    // *
                        doRule42(token);
                        break;
            case 26:    // /
                        doRule43(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
      }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 42 in the grammar:
     * "42.   factor-tail : * factor factor-tail"
     * @param   token   the current token
     */
    private void doRule42(TokenPair token) {
        addChild(25);
        addChild(52);
        addChild(53);
    }

    /**
     * Add child nodes based on rule 43 in the grammar:
     * "43.   factor-tail : / factor factor-tail"
     * @param   token   the current token
     */
    private void doRule43(TokenPair token) {
        addChild(26);
        addChild(52);
        addChild(53);
    }

    /**
     * Add child nodes based on rule 44 in the grammar:
     * "44.   factor-tail :"
     * @param   token   the current token
     */
    private void doRule44(TokenPair token) {
        // Intentionally Left Blank
    }
}

/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "BoolFac" node in a parse tree for Descartes-2
 */
public class BoolFacNode extends ParseTreeNode {
    
    public BoolFacNode(int code) {
        super(code);
    }
    
    protected BoolFacNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param   token   the current token
     */
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();
        
        switch(tokenNum) {
            case 7:     // ID
            case 24:     // -
            case 27:     // (
            case 29:     // CONST
                        doRule29(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
      }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 29 in the grammar:
     * "29.   bool-factor : arith-expr relation-option"
     * @param   token   the current token
     */
    private void doRule24(TokenPair token) {
        addChild(48);
        addChild(49);
    }
}

/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "BoolTerm" node in a parse tree for Descartes-2
 */
public class BoolTerm extends ParseTreeNode {
    
    public BoolTerm(int code) {
        super(code);
    }
    
    protected BoolTerm(int code, ParseTreeNode parent) {
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
            case 24:    // -
            case 27:    // (
            case 29:    // CONST
                        doRule26(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
      }
    
    //  List of Rules to Complete
   
    /**
     * Add child nodes based on rule 26 in the grammar:
     * "bool-term : bool-factor bool-factor-tail"
     * @param   token   the current token
     */
    private void doRule26(TokenPair token) {
        addChild(46);
        addChild(47);
    }
}
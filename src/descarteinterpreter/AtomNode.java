/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "Atom" node in a parse tree for Descartes-2
 */
public class AtomNode extends ParseTreeNode {
    
    public AtomNode(int code) {
        super(code);
    }
    
    protected AtomNode(int code, ParseTreeNode parent) {
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
                        doRule48(token);
                        break;
            case 29:    // CONST
                        doRule49(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
      }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 48 in the grammar:
     * "48.   atom : ID"
     * @param   token   the current token
     */
    private void doRule48(TokenPair token) {
        addChild(7);
    }

    /**
     * Add child nodes based on rule 49 in the grammar:
     * "49.   atom : CONST"
     * @param   token   the current token
     */
    private void doRule49(TokenPair token) {
        addChild(29);
    }
}

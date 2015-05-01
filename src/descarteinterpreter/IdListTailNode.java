/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "id-list-tail" node (#43) in a parse tree for Descartes-2
 */
public class IdListTailNode extends ParseTreeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected IdListTailNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param   token   the current token
     */
    @Override
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();
        
        switch(tokenNum) {
            case 0:     // PERIOD
            case 1:     // SEMICOLON
            case 4:     // ELSE
            case 5:     // FI
            case 9:     // REPEAT
                        doRule22(token);
                        break;
            case 14:    // ,
                        doRule21(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    //  List of Rules to Complete

    /**
     * Add child nodes based on rule 21 in the grammar:
     * "21. id-list-tail : , ID id-list-tail"
     * @param   token   the current token
     */
    private void doRule21(TokenPair token) {
        addChild(14);
        addChild(7);
        addChild(43);
    }
    
    /**
     * Add child nodes based on rule 22 in the grammar:
     * "22. id-list-tail :"
     * @param   token   the current token
     */
    private void doRule22(TokenPair token) {
        // Purposely Left Empty
    }
}

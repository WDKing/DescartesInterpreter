/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "id-option" node (#42) in a parse tree for Descartes-2
 */
public class IdOptionNode extends ParseTreeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected IdOptionNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param token the current token
     */
    @Override
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();

        switch (tokenNum) {
            case 0:     // PERIOD
            case 1:     // SEMICOLON
            case 4:     // ELSE
            case 5:     // FI
            case 9:     // REPEAT
                        doRule17(token);
                        break;
            case 7:     // ID
                        doRule16(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 16 in the grammar:
     * "16. id-option : ID"
     * @param token the current token
     */
    private void doRule16(TokenPair token) {
        this.addChild(7);
    }

    /**
     * Add child nodes based on rule 17 in the grammar:
     * 17. "id-option : "
     * @param token the current token
     */
    private void doRule17(TokenPair token) {
        //DO NOTHING
    }
}

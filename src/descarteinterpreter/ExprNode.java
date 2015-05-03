/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "expr" node (#40) in a parse tree for Descartes-2
 */
public class ExprNode extends EvalTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected ExprNode(int code, ParseTreeNode parent) {
            super(code, parent);
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     *
     * @param token the current token
     */
    @Override
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();

        switch (tokenNum) {

            case 7:     // ID
            case 24:	// -
            case 27:	// (
            case 29:	// CONST
                        doRule23(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 23 in the grammar:
     * "23. expr : bool-term bool-term-tail"
     * @param token the current token
     */
    private void doRule23(TokenPair token) {
        this.addChild(44);
        this.addChild(45);
    }
}

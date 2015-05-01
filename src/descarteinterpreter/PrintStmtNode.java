/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "print-stmt" node (#39) in a parse tree for Descartes-2
 */
public class PrintStmtNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected PrintStmtNode(int code, ParseTreeNode parent) {
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

            case 12:    // PRINT
                        doRule19(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 19 in the grammar:
     * "19. print-stmt : PRINT ID id-list-tail"
     * @param token the current token
     */
    private void doRule19(TokenPair token) {
        this.addChild(12);
        this.addChild(7);
        this.addChild(43);
    }
}

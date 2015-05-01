/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "read-stmt" node (#38) in a parse tree for Descartes-2
 */
public class ReadStmtNode extends ExecTypeNode{

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected ReadStmtNode(int code, ParseTreeNode parent) {
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
            case 13:    // READ
                        doRule20(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 20 in the grammar:
     * "20. read-stmt : READ ID id-list-tail"
     * @param token the current token
     */
    private void doRule20(TokenPair token) {
        this.addChild(13);
        this.addChild(7);
        this.addChild(43);
    }
}

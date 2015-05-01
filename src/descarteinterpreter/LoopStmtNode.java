/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "loop-stmt" node (#35) in a parse tree for Descartes-2
 */
public class LoopStmtNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected LoopStmtNode(int code, ParseTreeNode parent) {
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

            case 6:     // LOOP
                        doRule14(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 14 in the grammar: "loop-stmt : LOOP ID
     * COLON stmt-list REPEAT"
     *
     * @param token the current token
     */
    private void doRule14(TokenPair token) {
        this.addChild(6);
        this.addChild(7);
        this.addChild(8);
        this.addChild(31);
        this.addChild(9);
    }
}

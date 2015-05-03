/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "if-stmt" node (#34) in a parse tree for Descartes-2
 */
public class IfStmtNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected IfStmtNode(int code, ParseTreeNode parent) {
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

            case 2:     // IF
                        doRule11(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 11 in the grammar:
     * "11. if-stmt : IF expr THEN stmt-list else-part"
     * @param   token   the current token
     */
    private void doRule11(TokenPair token) {
        this.addChild(2);
        this.addChild(40);
        this.addChild(3);
        this.addChild(31);
        this.addChild(41);
    }
}

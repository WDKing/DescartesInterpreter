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
     * ParseTreeNode parent, lineNum)
     */
    protected IfStmtNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag;
        ExprNode conditional = (ExprNode) getChildAt(1);
        StmtListNode stmtList = (StmtListNode) getChildAt(3);
        ElsePartNode elsePart = (ElsePartNode) getChildAt(4);
        
        if(conditional.evaluate() != 0) {
            tag = stmtList.execute();
        } else {
            tag = elsePart.execute();
        }
        
        return tag;
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     *
     * @param token the current token
     */
    @Override
    public void populateChildren(DescartesToken token) {
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
    private void doRule11(DescartesToken token) {
        this.addChild(2, token.getLineNum());
        this.addChild(40, token.getLineNum());
        this.addChild(3, token.getLineNum());
        this.addChild(31, token.getLineNum());
        this.addChild(41, token.getLineNum());
    }
}

/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "relation-option" node (#49) in a parse tree for
 * Descartes-2
 */
public class RelOptNode extends ParseTreeNode {
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected RelOptNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param   token   the current token
     */
    @Override
    public void populateChildren(DescartesToken token) {
        int tokenNum = token.getTokenNum();
        
        switch(tokenNum) {
            case 0:     // PERIOD
            case 1:     // SEMICOLON
            case 3:     // THEN
            case 4:     // ELSE
            case 5:     // FI
            case 9:     // REPEAT
            case 15:    // OR
            case 16:    // AND
            case 28:    // )
                        doRule36(token);
                        break;
            case 17:    // <
                        doRule30(token);
                        break;
            case 18:    // <=
                        doRule31(token);
                        break;
            case 19:    // =
                        doRule32(token);
                        break;
            case 20:    // >=
                        doRule33(token);
                        break;
            case 21:    // >
                        doRule34(token);
                        break;
            case 22:    // <>
                        doRule35(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    /**
     * Add child nodes based on rule 30 in the grammar:
     * "30. relation-option : < arith-expr"
     * @param   token   the current token
     */
    private void doRule30(DescartesToken token) {
        addChild(17, token.getLineNum());
        addChild(48, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 31 in the grammar:
     * "31. relation-option : <= arith-expr"
     * @param   token   the current token
     */
    private void doRule31(DescartesToken token) {
        addChild(18, token.getLineNum());
        addChild(48, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 32 in the grammar:
     * "32. relation-option : = arith-expr"
     * @param   token   the current token
     */
    private void doRule32(DescartesToken token) {
        addChild(19, token.getLineNum());
        addChild(48, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 33 in the grammar:
     * "33. relation-option : >= arith-expr"
     * @param   token   the current token
     */
    private void doRule33(DescartesToken token) {
        addChild(20, token.getLineNum());
        addChild(48, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 34 in the grammar:
     * "34. relation-option : > arith-expr"
     * @param   token   the current token
     */
    private void doRule34(DescartesToken token) {
        addChild(21, token.getLineNum());
        addChild(48, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 35 in the grammar:
     * "35. relation-option : <> arith-expr"
     * @param   token   the current token
     */
    private void doRule35(DescartesToken token) {
        addChild(22, token.getLineNum());
        addChild(48, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 36 in the grammar:
     * "36. relation-option :"
     * @param   token   the current token
     */
    private void doRule36(DescartesToken token) {
        // Intentionally Left Blank
    }
}

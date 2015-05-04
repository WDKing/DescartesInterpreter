/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "bool-factor-tail" node (#47) in a parse tree for
 * Descartes-2
 */
public class BoolFacTailNode extends EvalTypeNode {
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected BoolFacTailNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public double evaluate() {
        double result;
        BoolFacNode bFac;
        BoolFacTailNode bFacTail;
        
        if(hasChildren()) {
            bFac = (BoolFacNode) getChildAt(1);
            bFacTail = (BoolFacTailNode) getChildAt(2);
            if(bFac.evaluate() == 0 || bFacTail.evaluate() == 0) {
                result = 0;
            } else {
                result = 1;
            }
        } else {
            result = 1;
        }
        
        return result;
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
            case 28:    // )
                        doRule28(token);
                        break;
            case 16:    // AND
                        doRule27(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 27 in the grammar:
     * "27. bool-factor-tail : AND bool-factor bool-factor-tail"
     * @param   token   the current token
     */
    private void doRule27(DescartesToken token) {
        addChild(16, token.getLineNum());
        addChild(46, token.getLineNum());
        addChild(47, token.getLineNum());
    }
    
    /**
     * Add child nodes based on rule 28 in the grammar:
     * "28.   bool-factor-tail : "
     * @param   token   the current token
     */
    private void doRule28(DescartesToken token) {
        // Intentionally Left Blank
    }
}

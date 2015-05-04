/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "bool-term-tail" node (#45) in a parse tree for
 * Descartes-2
 */
public class BoolTermTailNode extends EvalTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected BoolTermTailNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public double evaluate() {
        double result;
        BoolTermNode bTerm;
        BoolTermTailNode bTermTail;
        
        if(hasChildren()) {
            bTerm = (BoolTermNode) getChildAt(1);
            bTermTail = (BoolTermTailNode) getChildAt(2);
            if(bTerm.evaluate() == 0 && bTermTail.evaluate() == 0) {
                result = 0;
            } else {
                result = 1;
            }
        } else {
            result = 0;
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
            case 28:    // )
                        doRule25(token);
                        break;
            case 15:    // OR
                        doRule24(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    //  List of Rules to Complete
   
    /**
     * Add child nodes based on rule 24 in the grammar:
     * "24.   bool-term-tail : OR bool-term bool-term-tail"
     * @param   token   the current token
     */
    private void doRule24(DescartesToken token) {
        addChild(15, token.getLineNum());
        addChild(44, token.getLineNum());
        addChild(45, token.getLineNum());
    }
    
    /**
     * Add child nodes based on rule 25 in the grammar:
     * "25. bool-term-tail : "
     * @param   token   the current token
     */
    private void doRule25(DescartesToken token) {
        // Intentionally Left Empty
    }
}

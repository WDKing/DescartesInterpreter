/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "factor-tail" node (#53) in a parse tree for Descartes-2
 */
public class FactorTailNode extends EvalTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected FactorTailNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public double evaluate() {
        double result;
        TerminalNode tn;
        FactorNode factor;
        FactorTailNode facTail;
        
        if(getChildCount() == 0) {
            result = 1;
        } else {
            tn = (TerminalNode) getChildAt(0);
            factor = (FactorNode) getChildAt(1);
            facTail = (FactorTailNode) getChildAt(2);
            result = factor.evaluate();
            if(tn.getTokenStr().equals("*") && result != 0) {
		result = result* facTail.evaluate();
	    }
	    else if(tn.getTokenStr().equals("/") && result != 0) {
                result = 1 /result*facTail.evaluate();
            } else if(tn.getTokenStr().equals("/") && result == 0) {
                result = Double.NaN;
            }
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
            case 16:    // AND
            case 17:    // <
            case 18:    // <=
            case 19:    // =
            case 20:    // >=
            case 21:    // >
            case 22:    // <>
            case 23:    // +
            case 24:    // -
            case 28:    // )
                        doRule44(token);
                        break;
            case 25:    // *
                        doRule42(token);
                        break;
            case 26:    // /
                        doRule43(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
     }
    
    /**
     * Add child nodes based on rule 42 in the grammar:
     * "42. factor-tail : * factor factor-tail"
     * @param   token   the current token
     */
    private void doRule42(DescartesToken token) {
        addChild(25, token.getLineNum());
        addChild(52, token.getLineNum());
        addChild(53, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 43 in the grammar:
     * "43. factor-tail : / factor factor-tail"
     * @param   token   the current token
     */
    private void doRule43(DescartesToken token) {
        addChild(26, token.getLineNum());
        addChild(52, token.getLineNum());
        addChild(53, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 44 in the grammar:
     * "44. factor-tail :"
     * @param   token   the current token
     */
    private void doRule44(DescartesToken token) {
        // Intentionally Left Blank
    }
}

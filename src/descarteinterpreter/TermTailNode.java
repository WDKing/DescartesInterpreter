/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "term-tail" node (#51) in a parse tree for Descartes-2
 */
public class TermTailNode extends EvalTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected TermTailNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    @Override
    public double evaluate() {
        double result;
        TermNode term;
        TermTailNode termTail;
        TerminalNode tn;
        
        if(hasChildren()) {
            tn = (TerminalNode) getChildAt(0);
            term = (TermNode) getChildAt(1);
            termTail = (TermTailNode) getChildAt(2);

            result = term.evaluate() + termTail.evaluate();
            
            if(tn.getTokenStr().equals("-")) {
                result = 0 - result;
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
    public void populateChildren(TokenPair token) {
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
            case 28:    // )
                        doRule40(token);
                        break;
            case 23:    // +
                        doRule38(token);
                        break;
            case 24:    // -
                        doRule39(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 38 in the grammar:
     * "38. term-tail : + term term-tail"
     * @param   token   the current token
     */
    private void doRule38(TokenPair token) {
        addChild(23);
        addChild(50);
        addChild(51);
    }

    /**
     * Add child nodes based on rule 39 in the grammar:
     * "39. term-tail : - term term-tail"
     * @param   token   the current token
     */
    private void doRule39(TokenPair token) {
        addChild(24);
        addChild(50);
        addChild(51);
    }

    /**
     * Add child nodes based on rule 40 in the grammar:
     * "40. term-tail : "
     * @param   token   the current token
     */
    private void doRule40(TokenPair token) {
        // Intentionally Left Blank
    }
}

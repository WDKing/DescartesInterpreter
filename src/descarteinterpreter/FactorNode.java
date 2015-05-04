/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "factor" node (#52) in a parse tree for Descartes-2
 */
public class FactorNode extends EvalTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected FactorNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public double evaluate() {
        double result = Double.NaN;
        AtomNode at;
        FactorNode fac;
        ExprNode expr;
        
        switch(getChildCount()) {
            case 1:     at = (AtomNode) getChildAt(0);
                        result = at.evaluate();
                        break;
            case 2:     fac = (FactorNode) getChildAt(1);
                        result = 0 - fac.evaluate();
                        break;
            case 3:     expr = (ExprNode) getChildAt(1);
                        result = expr.evaluate();
                        break;
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
            case 7:     // ID
            case 29:    // CONST
                        doRule46(token);
                        break;
            case 24:    // -
                        doRule45(token);
                        break;
            case 27:    // (
                        doRule47(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    /**
     * Add child nodes based on rule 45 in the grammar:
     * "45. factor : - factor"
     * @param   token   the current token
     */
    private void doRule45(DescartesToken token) {
        addChild(24, token.getLineNum());
        addChild(52, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 46 in the grammar:
     * "46. factor : atom"
     * @param   token   the current token
     */
    private void doRule46(DescartesToken token) {
        addChild(54, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 47 in the grammar:
     * "47. factor : ( expr )"
     * @param   token   the current token
     */
    private void doRule47(DescartesToken token) {
        addChild(27, token.getLineNum());
        addChild(40, token.getLineNum());
        addChild(28, token.getLineNum());
    }
}

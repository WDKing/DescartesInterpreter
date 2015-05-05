/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "term" (#50) node in a parse tree for Descartes-2
 */
public class TermNode extends EvalTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected TermNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public double evaluate() {
        double result;
        FactorNode fac;
        FactorTailNode facTail;
        
        fac = (FactorNode) getChildAt(0);
        facTail = (FactorTailNode) getChildAt(1);
        
        result = fac.evaluate() * facTail.evaluate();
        
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
            case 24:    // -
            case 27:    // (
            case 29:    // CONST
                        doRule41(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    /**
     * Add child nodes based on rule 41 in the grammar:
     * "41. term : factor factor-tail"
     * @param   token   the current token
     */
    private void doRule41(DescartesToken token) {
        addChild(52, token.getLineNum());
        addChild(53, token.getLineNum());
    }
}

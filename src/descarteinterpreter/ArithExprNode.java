/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "arith-expr" node (#48) in a parse tree for Descartes-2
 */
public class ArithExprNode extends EvalTypeNode {
        
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected ArithExprNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public double evaluate() {
        double result;
        TermNode term;
        TermTailNode termTail;
        
        term = (TermNode) getChildAt(0);
        termTail = (TermTailNode) getChildAt(1);
        
        result = term.evaluate() + termTail.evaluate();
        
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
                        doRule37(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 37 in the grammar:
     * "37. arith-expr : term term-tail"
     * @param   token   the current token
     */
    private void doRule37(DescartesToken token) {
        addChild(50, token.getLineNum());
        addChild(51, token.getLineNum());
    }
}

/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "bool-factor" node (#46) in a parse tree for Descartes-2
 */
public class BoolFacNode extends EvalTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected BoolFacNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    @Override
    public double evaluate() {
        double result = Double.NaN;
        ArithExprNode arith1, arith2;
        RelOptNode rel;
        TerminalNode tn;
        
        arith1 = (ArithExprNode) getChildAt(0);
        rel = (RelOptNode) getChildAt(1);
        
        if(rel.hasChildren()) {
            tn = (TerminalNode) rel.getChildAt(0);
            arith2 = (ArithExprNode) rel.getChildAt(1);
            
            switch(tn.getTokenStr()) {
                case "<":   if(arith1.evaluate() < arith2.evaluate()) {
                                result = 1;
                            } else {
                                result = 0;
                            }
                            break;
                case "<=":   if(arith1.evaluate() <= arith2.evaluate()) {
                                result = 1;
                            } else {
                                result = 0;
                            }
                            break;
                case "=":   if(arith1.evaluate() == arith2.evaluate()) {
                                result = 1;
                            } else {
                                result = 0;
                            }
                            break;
                case ">=":   if(arith1.evaluate() >= arith2.evaluate()) {
                                result = 1;
                            } else {
                                result = 0;
                            }
                            break;
                case ">":   if(arith1.evaluate() > arith2.evaluate()) {
                                result = 1;
                            } else {
                                result = 0;
                            }
                            break;
                case "<>":   if(arith1.evaluate() != arith2.evaluate()) {
                                result = 1;
                            } else {
                                result = 0;
                            }
                            break;
            }
        } else {
            result = arith1.evaluate();
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
            case 7:     // ID
            case 24:     // -
            case 27:     // (
            case 29:     // CONST
                        doRule29(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 29 in the grammar:
     * "29. bool-factor : arith-expr relation-option"
     * @param   token   the current token
     */
    private void doRule29(TokenPair token) {
        addChild(48);
        addChild(49);
    }
}

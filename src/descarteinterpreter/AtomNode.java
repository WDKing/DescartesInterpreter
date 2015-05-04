/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "atom" node (#54) in a parse tree for Descartes-2
 */
public class AtomNode extends EvalTypeNode {
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected AtomNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public double evaluate() {
        double result = Double.NaN;
        TerminalNode child = (TerminalNode) getChildAt(0);
        
        try {
            if(child.getCode() == 7) { // if the child is an ID
                result = symbolTable.get(child.getTokenStr());
            } else if(child.getCode() == 29) {
                result = Double.parseDouble(child.getTokenStr());
            }
        } catch(RuntimeException e) {
            result = Double.NaN;
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
                        doRule48(token);
                        break;
            case 29:    // CONST
                        doRule49(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    //  List of Rules to Complete
    
    /**
     * Add child nodes based on rule 48 in the grammar:
     * "48. atom : ID"
     * @param   token   the current token
     */
    private void doRule48(DescartesToken token) {
        addChild(7, token.getLineNum());
    }

    /**
     * Add child nodes based on rule 49 in the grammar:
     * "49. atom : CONST"
     * @param   token   the current token
     */
    private void doRule49(DescartesToken token) {
        addChild(29, token.getLineNum());
    }
}

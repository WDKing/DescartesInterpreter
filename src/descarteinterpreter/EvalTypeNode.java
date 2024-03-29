/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Intermediate parent class for nodes that evaluate to a value.
 */
public abstract class EvalTypeNode extends ParseTreeNode {
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected EvalTypeNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    /**
     * @return the result of evaluating the tree descending from this node
     */
    public abstract double evaluate();
}
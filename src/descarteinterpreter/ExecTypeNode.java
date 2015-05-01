/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Intermediate parent class for nodes that execute statements.
 */
public abstract class ExecTypeNode extends ParseTreeNode {
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code)
     */
    public ExecTypeNode(int code) {
        super(code);
    }
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected ExecTypeNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    /**
     * Executes the tree descending from this node.
     * @return an object with control information such as a break
     */
    public abstract ControlTag execute();
}
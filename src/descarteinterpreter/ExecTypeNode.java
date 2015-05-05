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
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code, int lineNum)
     */
    protected ExecTypeNode(int code, int lineNum) {
        super(code, null, lineNum);
    }
    
    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected ExecTypeNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    /**
     * Executes the tree descending from this node.
     * @return an object with control information such as breaks or errors.
     */
    public abstract ControlTag execute();
}
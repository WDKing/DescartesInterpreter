/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Parent class for the nodes in ParseTree, for Descartes-2 Interpreter;
 */
public abstract class ParseTreeNode implements Iterable<ParseTreeNode> {
    /** The numeric code for element of the grammar the node represents */
    protected final int code;
    /** The line number to which this node corresponds, or -1 if unknown */
    protected final int lineNum;
    /** The parent node of this node */
    protected final ParseTreeNode parent;
    /** A list of the child nodes of this node */
    protected final List<ParseTreeNode> children =  new LinkedList<>();
    /** The symbol table for this program */
    protected static final HashMap<String, Double> symbolTable =
            new HashMap<>();
    /** The data that can be read in by this program */
    protected static final List<DescartesToken> inputData = new ArrayList<>(256);
    
    /**
     * Protected constructor. Initializes the parent field, but does not add the
     * new node to the children field of the parent node.
     * @param code          the numeric code for element of the grammar the new
     *                      node represents
     * @param parent        the parent node for the new node
     */
    protected ParseTreeNode(int code, ParseTreeNode parent, int lineNum) {
        this.code = code;
        this.parent = parent;
        this.lineNum = lineNum;
    }
    
    /**
     * Constructs new child node and adds it to the list of children.
     * @param code          the numeric code for element of the grammar the new
     *                      node represents
     */
    public void addChild(int code, int newLineNum) {
        ParseTreeNode newNode = null;
        
        if((code >= 0 && code <= 29)) {
        // Check for terminal symbols
            newNode = new TerminalNode(code, this, newLineNum);
        } else {
            // case statements commented out until class is created
            switch(code) {
                case 31:    // stmt-list
                            newNode = new StmtListNode(code, this, newLineNum);
                            break;
                case 32:    // stmt
                            newNode = new StmtNode(code, this, newLineNum);
                            break;
                case 33:    // stmt-tail
                            newNode = new StmtTailNode(code, this, newLineNum);
                            break;
                case 34:    // if-stmt
                            newNode = new IfStmtNode(code, this, newLineNum);
                            break;
                case 35:    // loop-stmt
                            newNode = new LoopStmtNode(code, this, newLineNum);
                            break;
                case 36:    // break-stmt
                            newNode = new BreakStmtNode(code, this, newLineNum);
                            break;
                case 37:    // assign-stmt
                            newNode = new AssignStmtNode(code, this, newLineNum);
                            break;
                case 38:    // read-stmt
                            newNode = new ReadStmtNode(code, this, newLineNum);
                            break;
                case 39:    // print-stmt
                            newNode = new PrintStmtNode(code, this, newLineNum);
                            break;
                case 40:    // expr
                            newNode = new ExprNode(code, this, newLineNum);
                            break;
                case 41:    // else-part
                            newNode = new ElsePartNode(code, this, newLineNum);
                            break;
                case 42:    // id-option
                            newNode = new IdOptionNode(code, this, newLineNum);
                            break;
                case 43:    // id-list-tail
                            newNode = new IdListTailNode(code, this, newLineNum);
                            break;
                case 44:    // bool-term
                            newNode = new BoolTermNode(code, this, newLineNum);
                            break;
                case 45:    // bool-term-tail
                            newNode = new BoolTermTailNode(code, this, newLineNum);
                            break;
                case 46:    // bool-factor
                            newNode = new BoolFacNode(code, this, newLineNum);
                            break;
                case 47:    // bool-factor-tail
                            newNode = new BoolFacTailNode(code, this, newLineNum);
                            break;
                case 48:    // arith-expr
                            newNode = new ArithExprNode(code, this, newLineNum);
                            break;
                case 49:    // relation-option
                            newNode = new RelOptNode(code, this, newLineNum);
                            break;
                case 50:    // term
                            newNode = new TermNode(code, this, newLineNum);
                            break;
                case 51:    // term-tail
                            newNode = new TermTailNode(code, this, newLineNum);
                            break;
                case 52:    // factor
                            newNode = new FactorNode(code, this, newLineNum);
                            break;
                case 53:    // factor-tail
                            newNode = new FactorTailNode(code, this, newLineNum);
                            break;
                case 54:    // atom
                            newNode = new AtomNode(code, this, newLineNum);
                            break;
                default:    throw new IllegalArgumentException();
            }
        }
        
        children.add(newNode);
    }
    
    /**
     * Build the tree starting with this node, using recursive descent.
     * @param   lexer   the Tokenizer that pulls tokens from the program file
     */
    public void buildTree(Tokenizer lexer) {
        ParseTreeNode nextNode;

        populateChildren(lexer.getCurrToken());
        nextNode = getNextInTree();
        if(nextNode != null) {
            nextNode.buildTree(lexer);
        }
    }
    
    /**
     * @param   index          the index in the children field
     * @return  the child at the given index
     */
    public ParseTreeNode getChildAt(int index) {
        return children.get(index);
    }
    
    /**
     * @return  the number of children
     */
    public int getChildCount() {
        return children.size();
    }
    
    /**
     * @return  the list of children
     */
    public List<ParseTreeNode> getChildren() {
        return new LinkedList<>(children);
    }
    
    /**
     * @return  the node's numeric code
     */
    public int getCode() {
        return code;
    }
    
    /**
     * @param node  the node to search for
     * @return      the index at which the given child is found,
     *              or null if it is not in the list of children
     */
    public int getIndexOfChild(ParseTreeNode node) {
        int result = -1;
        boolean gotResult = false;
        ParseTreeNode tempNode;
        
        for(int i = 0; i < children.size() && !gotResult; i++) {
            tempNode = children.get(i);
            if(tempNode == node) {
                gotResult = true;
                result = i;
            }
        }
        
        return result;
    }
    
    /**
     * @return the line in the program corresponding to this node
     */
    public int getLineNum() {
        return lineNum;
    }
    
    /**
     * @return      the first child of this node, or null if it has no children
     */
    private ParseTreeNode getNextDownTree()
    {
        ParseTreeNode result;
        
        if(hasChildren()) {
            result = children.get(0);
        } else {
            result = null;
        }
        
        return result;
    }
    
    /**
     * @return      the node which would come after this one in a left-first
     *              traversal, or null if this node is the last
     */
    public ParseTreeNode getNextInTree() {
        ParseTreeNode result;
        
        result = getNextDownTree();
        
        if(result == null) {
            result = getNextUpTree();
        }
        
        return result;
    }
    
    /**
     * @return  the next sibling in its parent's list, or if it doesn't have
     *          one, its parent's next sibling, or grandparent's next sibling,
     *          etc; or null of none of its ancestors have any siblings
     */
    private ParseTreeNode getNextUpTree()
    {
        ParseTreeNode result;
        
        if(isRoot()) {
            result = null;
        } else {
            result = getNextSibling();
            if(result == null) {
                result = getParent().getNextUpTree();
            }
        }
        
        return result;
    }
    
    /**
     * @return      the node whose index in the children field of this node's
     *              parent is one higher than the index for this node, or null
     *              if there are none
     */
    public ParseTreeNode getNextSibling() {
        int nextIndex = (parent.getIndexOfChild(this) + 1);
        ParseTreeNode result = null;

        if(parent.getChildCount() > nextIndex) {
            result = parent.getChildAt(nextIndex);
        }

        return result;
    }
    
    /**
     * @return      the parent node of this node
     */
    public ParseTreeNode getParent() {
        return this.parent;
    }
    
    public HashMap<String, Double> getSymbolTable() {
        return (HashMap<String, Double>) symbolTable.clone();
    }
    
    /**
     * @return      true if this node has any children, otherwise false
     */
    public boolean hasChildren() {
        return getChildCount() != 0;
    }
    
    /**
     * @return      true if this node's parent field is null, otherwise false
     */
    public boolean isRoot() {
        return parent == null;
    }
    
    /**
     * @param   node    the node to compare with this node
     * @return true if both nodes share the same parent, and false otherwise
     */
    public boolean isSibling(ParseTreeNode node) {
        return this.getParent() == node.getParent();
    }
    
    /**
     * @return      true if the code corresponds to a terminal symbol in the
     *              grammar
     */
    public boolean isTerminal() {
        return (this.code >= 0 && this.code <= 29);
    }
    
    /**
     * Add child nodes based on the current token and the grammar's rules.
     * @param   token   the current token
     */
    public abstract void populateChildren(DescartesToken token);
    
    /**
     * @return      an iterator for the tree descending from this node
     */
    @Override
    public ParseTreeIterator iterator() {
        return new ParseTreeIterator(this);
    }
}

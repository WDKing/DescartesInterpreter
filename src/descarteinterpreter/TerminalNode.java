/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a "prog" node in a parse tree for Descartes-2
 */
public class TerminalNode extends ParseTreeNode {

    private String tokenStr = "";
    
    public TerminalNode(int code) {
        super(code);
    }
    
    protected TerminalNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    protected TerminalNode(ParseTreeNode parent, TokenPair token) {
        super(token.getTokenNum(), parent);
        this.isLeaf = true;
        this.tokenStr = token.getTokenString();
    }
    
    /**
     * 
     * @return  a String holding the text of the node if it is a leaf, or null
     * if it isn't a leaf
     */
    public String getTokenStr() {
        return (isLeaf()? this.tokenStr : null);
    }
    
    /**
     * A leaf is a TerminalNode that has the isLeaf flag set to true, and has
     * a non-empty tokenStr;
     * @param   token   the current token
     */
    public void addLeaf(TokenPair token) {
        children.add(new TerminalNode(this, token));
    }
    
    /**
     * 
     * @return  true if the isLeaf flag is set to true, false otherwise
     */
    public boolean isLeaf() {
        return this.isLeaf;
    }
    
    /**
     * Add child nodes based on the implicit rule that a terminal node gets a child
     * that matches its numeric code, given that the tokenNum of token should be
     * the same as its code.
     * @param   token   the current token
     */
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();
        
        if(tokenNum != getCode()) {
            throw new IllegalArgumentException();
        }
        
        addLeaf(token);
    }
}
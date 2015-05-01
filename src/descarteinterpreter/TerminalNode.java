/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

import java.io.IOException;
import java.nio.BufferOverflowException;

/**
 * Representation of a terminal node in a parse tree for Descartes-2
 */
public class TerminalNode extends ParseTreeNode {

    /** The actual text in the program that this node represents */
    private String tokenStr = "";

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent)
     */
    protected TerminalNode(int code, ParseTreeNode parent) {
        super(code, parent);
    }
    
    /**
     * Protected constructor. Initializes the parent field, but does not add the
     * new node to the children field of the parent node. Also does not add the
     * tokenStr, but initializes it to null.
     * @param token         the token from which this node is constructed
     * @param parent        the parent node for the new node
     */
    protected TerminalNode(ParseTreeNode parent, TokenPair token) {
        super(token.getTokenNum(), parent);
        this.tokenStr = null;
    }
    
    @Override
    public void buildTree(Tokenizer lexer) {
        ParseTreeNode nextNode;

        try {
            populateChildren(lexer.getCurrToken());
            nextNode = getNextInTree();
            if(nextNode != null) {
                lexer.getToken();
                nextNode.buildTree(lexer);
            }
        } catch(BufferOverflowException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @return  a String holding the text of the node, if that has been
     *          populated yet, or null if it hasn't
     */
    public String getTokenStr() {
        return this.tokenStr;
    }
    
    /**
     * Doesn't actually add any children, but just fills in the tokenStr.
     * @param   token   the current token
     */
    public void populateChildren(TokenPair token) {
        int tokenNum = token.getTokenNum();
        
        if(tokenNum != getCode()) {
            throw new IllegalArgumentException();
        }
        
        tokenStr = token.getTokenString();
    }
}
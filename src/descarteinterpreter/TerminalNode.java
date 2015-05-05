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
     * ParseTreeNode parent, int lineNum)
     */
    protected TerminalNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    /**
     * Protected constructor. Initializes the parent field, but does not add the
     * new node to the children field of the parent node. Also does not add the
     * tokenStr, but initializes it to null.
     * @param parent    the parent node for the new node
     * @param token     the token from which this node is constructed
     * @param lineNum   the line number where the token corresponding to this
     *                  node was found
     */
    protected TerminalNode(ParseTreeNode parent, DescartesToken token,
            int lineNum) {
        super(token.getTokenNum(), parent, lineNum);
        this.tokenStr = null;
    }
    
    @Override
    public void buildTree(Tokenizer lexer) {
        ParseTreeNode nextNode;
        DescartesToken dataToken;

        try {
            populateChildren(lexer.getCurrToken());
            nextNode = getNextInTree();
            if(nextNode != null) {
                lexer.getToken();
                nextNode.buildTree(lexer);
            } else {
                if(getTokenStr().equals("0")) {
                    dataToken = lexer.getToken();
                    while(dataToken != null) {
                        inputData.add(dataToken);
                        dataToken = lexer.getToken();
                    }
                }
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
     * @return  the line number where this token was found, or -1 if unknown
     */
    public int getLineNum() {
        return lineNum;
    }
    
    /**
     * Doesn't actually add any children, but just fills in the tokenStr and the
     * lineNum.
     * @param   token   the current token
     */
    public void populateChildren(DescartesToken token) {
        int tokenNum = token.getTokenNum();
        
        if(tokenNum != getCode()) {
            throw new IllegalArgumentException();
        }
        
        tokenStr = token.getTokenString();
    }
}
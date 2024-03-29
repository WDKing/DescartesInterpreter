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
 * Representation of a "prog" node (#30) in a parse tree for Descartes-2
 */
public class ProgNode extends ExecTypeNode {

    /**
     * Sole public constructor of any ParseTreeNode. Initializes the code to 30
     * and the line number to 1. The parent is null.
     */
    public ProgNode() {
        super(30, 1);
    }
    
    /**
     * @see descarteinterpreter.ExecTypeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected ProgNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public void buildTree(Tokenizer lexer) {
        ParseTreeNode nextNode;

        try {
            populateChildren(lexer.getToken());
            nextNode = getNextInTree();
            if(nextNode != null) {
                nextNode.buildTree(lexer);
            }
        } catch(BufferOverflowException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag;
        StmtListNode stmtList = (StmtListNode) getChildAt(0);
        
        tag = stmtList.execute();
        
        return tag;
    }
    
/**
 * Add child nodes based on the current token and the grammar's rules.
 * @param   token   the current token
 */
    @Override
    public void populateChildren(DescartesToken token) {
        int tokenNum = token.getTokenNum();
        
        switch(tokenNum) {
            case 0:     // PERIOD
            case 1:     // SEMICOLON
            case 2:     // IF
            case 6:     // LOOP
            case 7:     // ID
            case 10:    // BREAK
            case 12:    // PRINT
            case 13:    // READ
                        doRule0(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
/**
 * Add child nodes based on rule 0 in the grammar:
 * "0. prog : stmt-list PERIOD"
 * @param   token   the current token
 */
    private void doRule0(DescartesToken token) {
        addChild(31, token.getLineNum());
        addChild(0, token.getLineNum());
    }
}
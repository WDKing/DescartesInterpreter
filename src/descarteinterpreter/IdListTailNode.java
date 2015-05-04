/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a "id-list-tail" node (#43) in a parse tree for Descartes-2
 */
public class IdListTailNode extends ParseTreeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected IdListTailNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    public List<String> getIdNames() {
        TerminalNode firstID;
        IdListTailNode idListTail;
        List<String> idNames;
        
        if(hasChildren()) {
            firstID = (TerminalNode) getChildAt(1);
            idListTail = (IdListTailNode) getChildAt(2);
            
            idNames = idListTail.getIdNames();
            idNames.add(0, firstID.getTokenStr());
        } else {
            idNames = new ArrayList<>();
        }
        
        return idNames;
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
            case 4:     // ELSE
            case 5:     // FI
            case 9:     // REPEAT
                        doRule22(token);
                        break;
            case 14:    // ,
                        doRule21(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }
    
    //  List of Rules to Complete

    /**
     * Add child nodes based on rule 21 in the grammar:
     * "21. id-list-tail : , ID id-list-tail"
     * @param   token   the current token
     */
    private void doRule21(DescartesToken token) {
        addChild(14, token.getLineNum());
        addChild(7, token.getLineNum());
        addChild(43, token.getLineNum());
    }
    
    /**
     * Add child nodes based on rule 22 in the grammar:
     * "22. id-list-tail :"
     * @param   token   the current token
     */
    private void doRule22(DescartesToken token) {
        // Purposely Left Empty
    }
}

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
 * Representation of a "print-stmt" node (#39) in a parse tree for Descartes-2
 */
public class PrintStmtNode extends ExecTypeNode {

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected PrintStmtNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public ControlTag execute() {
        ControlTag tag;
        TerminalNode firstID;
        IdListTailNode idListTail;
        List<String> idNames;
        
        firstID = (TerminalNode) getChildAt(1);
        idListTail = (IdListTailNode) getChildAt(2);
        
        idNames = idListTail.getIdNames();
        idNames.add(0, firstID.getTokenStr());
        
        for(int i = 0; i < idNames.size(); i++) {
            System.out.print(idNames.get(i));
            System.out.print("=");
            System.out.print(symbolTable.get(idNames.get(i)));
            if(i < (idNames.size() - 1)) {
                System.out.print(" ");
            }
        }
        System.out.println();
        
        return new ControlTag();
    }

    /**
     * Add child nodes based on the current token and the grammar's rules.
     *
     * @param token the current token
     */
    @Override
    public void populateChildren(DescartesToken token) {
        int tokenNum = token.getTokenNum();

        switch (tokenNum) {

            case 12:    // PRINT
                        doRule19(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 19 in the grammar:
     * "19. print-stmt : PRINT ID id-list-tail"
     * @param token the current token
     */
    private void doRule19(DescartesToken token) {
        this.addChild(12, token.getLineNum());
        this.addChild(7, token.getLineNum());
        this.addChild(43, token.getLineNum());
    }
}

/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

import java.util.List;

/**
 * Representation of a "read-stmt" node (#38) in a parse tree for Descartes-2
 */
public class ReadStmtNode extends ExecTypeNode{

    /**
     * @see descarteinterpreter.ParseTreeNode#Constructor(int code,
     * ParseTreeNode parent, int lineNum)
     */
    protected ReadStmtNode(int code, ParseTreeNode parent, int lineNum) {
        super(code, parent, lineNum);
    }
    
    @Override
    public ControlTag execute() {
        DescartesToken tp;
        TerminalNode firstID;
        IdListTailNode idListTail;
        List<String> idNames;
        double tempNum = 0;
        boolean validDouble, gotError = false;
        
        firstID = (TerminalNode) getChildAt(1);
        idListTail = (IdListTailNode) getChildAt(2);
        
        idNames = idListTail.getIdNames();
        idNames.add(0, firstID.getTokenStr());
        
        for(int i = 0; !gotError && i < idNames.size(); i++) {
            if(!inputData.isEmpty()) {
                tp = inputData.remove(0);
                validDouble = false;
                try {
                    tempNum = Double.parseDouble(tp.getTokenString());
                    validDouble = true;
                } catch(RuntimeException e) {
                    validDouble = false;
                }
                
                if(validDouble) {
                    symbolTable.put(idNames.get(1), tempNum);
                } else {
                    gotError = true;
                }
            } else {
                gotError = true;
            }
        }
        
        return new ControlTag(gotError, lineNum);
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
            case 13:    // READ
                        doRule20(token);
                        break;
            default:    throw new IllegalArgumentException();
        }
    }

    /**
     * Add child nodes based on rule 20 in the grammar:
     * "20. read-stmt : READ ID id-list-tail"
     * @param token the current token
     */
    private void doRule20(DescartesToken token) {
        this.addChild(13, token.getLineNum());
        this.addChild(7, token.getLineNum());
        this.addChild(43, token.getLineNum());
    }
}

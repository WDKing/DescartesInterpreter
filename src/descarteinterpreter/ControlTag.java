/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * A class to hold control information such as breaks or errors.
 */
public class ControlTag {
    /** The line number where the error or break occurred, or -1 if none did */
    private final int lineNum;
    /** The label, if there's a break that has one */
    private final String label;
    /** True if a break is indicated, false otherwise */
    private final boolean isBreak;
    /** True if an error is indicated, false otherwise */
    private final boolean isError;
    
    /**
     * Default constructor. Creates a control tag with no break or label.
     */
    public ControlTag() {
        label = "";
        isBreak = false;
        isError = false;
        lineNum = -1;
    }
    
    /**
     * Constructor that sets label and isBreak, with the line number.
     * @param   label   the label, if there's a break that has one
     * @param   isBreak true if a break is indicated, false otherwise
     * @param   lineNum the line number where the error or break occurred,
     *                  or -1 if none did
     */
    public ControlTag(String label, boolean isBreak, int lineNum) {
        this.label = label;
        this.isBreak = isBreak;
        this.lineNum = lineNum;
        isError = false;
    }
    
    /**
     * Constructor that sets isError, with the line number.
     * @param   isError true if an error is indicated, otherwise false
     * @param   lineNum the line number where the error or break occurred,
     *                  or -1 if none did
     */
    public ControlTag(boolean isError, int lineNum) {
        label = "";
        isBreak = false;
        this.isError = isError;
        this.lineNum = lineNum;
    }
    
    /**
     * Constructor that sets all parameters.
     * @param   label   the label, if there's a break that has one
     * @param   isBreak true if a break is indicated, false otherwise
     * @param   isError true if an error is indicated, otherwise false
     * @param   lineNum the line number where the error or break occurred,
     *                  or -1 if none did
     */
    public ControlTag(String label, boolean isBreak, boolean isError,
            int lineNum) {
        this.label = label;
        this.isBreak = isBreak;
        this.isError = isError;
        this.lineNum = lineNum;
    }

    /**
     * @return true if a break is indicated, false otherwise
     */
    public boolean isBreak() {
        return isBreak;
    }
    
    /**
     * @return true if an error is indicated, false otherwise
     */
    public boolean isError() {
        return isError;
    }
    
    /**
     * @return the label, if there's a break that has one
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * @return the line number where the error or break occurred, 
     * or -1 if none did
     */
    public int getLineNum() {
        return lineNum;
    }
}

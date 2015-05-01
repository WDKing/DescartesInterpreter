/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * A class to hold control information such as breaks.
 */
public class ControlTag {
    /** The label, if the break has one */
    private final String label;
    /** True if a break is indicated, false otherwise */
    private final boolean isBreak;
    
    /**
     * Default constructor. Creates a control tag with no break or label.
     */
    public ControlTag() {
        this.label = "";
        this.isBreak = false;
    }
    
    /**
     * Constructor with individual parameters.
     * @param   label   the label, if the break has one
     * @param   isBreak true if a break is indicated, false otherwise
     */
    public ControlTag(String label, boolean isBreak) {
        this.label = label;
        this.isBreak = isBreak;
    }
    
    public String getLabel() {
        return label;
    }
    
    public boolean isBreak() {
        return isBreak;
    }
}

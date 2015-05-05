package descarteinterpreter;

/**
 * Provides a set of tools for method testing
 *
 * @author Benjamin Boudra
 * @author Shelley King
 * @author William King
 */
public class TestingTools {

	/**
	 * A tool used to compare two different parse trees for equivalency.
	 *
	 * @param one parse tree node from the first tree.
	 * @param two parse tree node from the second tree.
	 * @return <code>true</code> if the Parse trees are equivalent.
	 * <code>false</code> if the Parse Trees are not equivalent
	 */
	public boolean compareTrees(ParseTreeNode one, ParseTreeNode two) {
		if (one.getClass() != two.getClass()) {
			return false;
		} else if (one.getCode() != two.getCode()) {
			return false;
		} else if (one.getChildCount() != two.getChildCount()) {
			return false;
		} else if (one.hasChildren() == false) {
			return true;
		} else {
			boolean same;
			same = true;
			for (int i = 0; i < one.getChildCount(); i++) {
				if (!compareTrees(one.getChildAt(i), two.getChildAt(i))) {
					same = false;
				}
			}
			if (same) {
				return true;
			} else {
				return false;
			}
		}

	}
}

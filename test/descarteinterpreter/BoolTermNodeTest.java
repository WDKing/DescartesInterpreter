
package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the ExprNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class BoolTermNodeTest {
	
	/**
	 * Holds the test tree based upon rule 23 in the grammar
	 */
	ProgNode rule26Tree;
	/**
	 * Parent node that will act as a parent of the object we are are
	 * testing, necessary because only prog node has a constructor that
	 * doesn't call parent.
	 */
	ProgNode parent;
	/**
	 * Holds the testing tools object
	 */
	TestingTools testTools;
	/** Generic constructor */
	public BoolTermNodeTest() {}
        
        /**
	 * Builds the Test Tree and creates testing objects.
	 */
	@Before
	public void setUp() {
		rule26Tree = this.buildTestTree26();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of populateChildren method, of class BoolTermNode.
	 */
	@Test
	public void testCase() {
		parent = new ProgNode();
		parent.addChild(44, -1);
		BoolTermNode Assign = (BoolTermNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID",7,-1);
		Assign.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule26Tree));
	}

        /**
	 * Builds a test Tree based on rule 23 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 23 of the grammar.
	 */
	public ProgNode buildTestTree26() {
		ProgNode parent = new ProgNode();
		parent.addChild(44, -1);
		BoolTermNode Assign = (BoolTermNode) parent.getChildAt(0);
		Assign.addChild(46, -1);
                Assign.addChild(47, -1);
		return parent;
	}
}

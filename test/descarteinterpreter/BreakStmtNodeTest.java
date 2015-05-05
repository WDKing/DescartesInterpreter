package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the BreakStmtNode Class.
 *
 * @author William King
 * @author Shelley King
 * @author Benjamin Boudra
 */
public class BreakStmtNodeTest {

	/**
	 * Holds the test tree based upon rule 15 in the grammar
	 */
	ProgNode rule15Tree;

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

	/**
	 * Builds the Test Tree and creates testing objects.
	 */
	@Before
	public void setUp() {
		rule15Tree = this.buildTestTree15();
		testTools = new TestingTools();
		parent = new ProgNode();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of the break case of the populateChildren method, of class
	 *
	 * BreakStmtNode.
	 */
	@Test
	public void TestBreakCase() {
		parent = new ProgNode();
		parent.addChild(36, -1);
		BreakStmtNode breakStmt = (BreakStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("BREAK", 10, -1);
		breakStmt.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule15Tree));
	}

	/**
	 * Builds a test tree based off of rule 15 of the grammar.
	 *
	 * @return the test tree
	 */
	public ProgNode buildTestTree15() {
		ProgNode prog = new ProgNode();
		prog.addChild(36, -1);
		BreakStmtNode breakStmt = (BreakStmtNode) prog.getChildAt(0);
		breakStmt.addChild(10, -1);
		breakStmt.addChild(42, -1);
		return prog;
	}
}

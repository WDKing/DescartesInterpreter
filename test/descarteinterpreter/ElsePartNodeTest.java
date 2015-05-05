package descarteinterpreter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the ElsePartNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class ElsePartNodeTest {

	/**
	 * Holds the test tree based upon rule 12 in the grammar
	 */
	ProgNode testTree12;

	/**
	 * Holds the test tree based upon rule 13 in the grammar
	 */
	ProgNode testTree13;

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
		testTree12 = this.buildTestTree12();
		testTree13 = this.buildTestTree13();
		testTools = new TestingTools();
		parent = new ProgNode();
	}

	/**
	 * Test of the Else Case of the populateChildren method, of class
	 * ElsePartNode.
	 */
	@Test
	public void testElseCase() {
		parent.addChild(41, -1);
		ElsePartNode elsePart = (ElsePartNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("ELSE", 4, -1);
		elsePart.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, testTree12));
	}

	/**
	 * Test of the Fi Case of the populateChildren method, of class
	 * ElsePartNode
	 */
	@Test
	public void testFiCase() {
		parent.addChild(41, -1);
		ElsePartNode elsePart = (ElsePartNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("FI", 5, -1);
		elsePart.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, testTree13));
	}

	/**
	 * Builds a test Tree based on rule 12 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 12 of the grammar.
	 */
	public ProgNode buildTestTree12() {
		ProgNode prog = new ProgNode();
		prog.addChild(41, -1);
		ElsePartNode elsePart = (ElsePartNode) prog.getChildAt(0);
		elsePart.addChild(4, -1);
		elsePart.addChild(31, -1);
		elsePart.addChild(5, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 13 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 13 of the grammar.
	 */
	public ProgNode buildTestTree13() {
		ProgNode prog = new ProgNode();
		prog.addChild(41, -1);
		ElsePartNode elsePart = (ElsePartNode) prog.getChildAt(0);
		elsePart.addChild(5, -1);
		return prog;
	}
}

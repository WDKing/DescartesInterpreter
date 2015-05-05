package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the StmtListNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class StmtListNodeTest {

	/**
	 * Holds the test tree based upon rule 1 in the grammar
	 */
	ProgNode rule1Tree;

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
		rule1Tree = this.buildRule1Tree();
		parent = new ProgNode();
		testTools = new TestingTools();
	}

	/**
	 * Test of the PERIOD case populateChildren method, of class
	 * StmtListNode.
	 */
	@Test
	public void testPeriodCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken(".", 0, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the semicolon case of the populateChildren method, of class
	 * StmtListNode.
	 */
	@Test
	public void testSemiColoncase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken(";", 1, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the if case of the populateChildren method, of class
	 * StmtListNode.
	 */
	@Test
	public void testIfCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("IF", 2, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of of the Else case of the populateChildren method, of class
	 * StmtListNode.
	 */
	@Test
	public void testElseCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("ELSE", 4, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the fi case of the populateChildren method, of class StmtListNode.
	 */
	@Test
	public void testFiCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("FI", 5, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the LOOP case of the populateChildren method, of class StmtListNode.
	 */
	@Test
	public void testLoopCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("LOOP", 6, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the ID case of the populateChildren method, of class StmtListNode.
	 */
	@Test
	public void testIdCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("SomeID", 7, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the REPEAT case of the populateChildren method, of class StmtListNode.
	 */
	@Test
	public void testRepeatCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("REPEAT", 9, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the BREAK case of the populateChildren method, of class StmtListNode.
	 */
	@Test
	public void testBreakCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("BREAK", 10, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the PRINT case of the populateChildren method, of class StmtListNode.
	 */
	@Test
	public void testPrintCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("PRINT", 12, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of the READ case of the populateChildren method, of class StmtListNode.
	 */
	@Test
	public void testReadCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("READ", 13, -1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildRule1Tree() {
		ProgNode prog = new ProgNode();
		prog.addChild(31, -1);
		StmtListNode stmt = (StmtListNode) prog.getChildAt(0);
		stmt.addChild(32, -1);
		stmt.addChild(33, -1);
		return prog;
	}
}

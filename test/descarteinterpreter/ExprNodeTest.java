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
public class ExprNodeTest {

	/**
	 * Holds the test tree based upon rule 23 in the grammar
	 */
	ProgNode rule23Tree;

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
		rule23Tree = this.buildTestTree23();
		testTools = new TestingTools();
		parent = new ProgNode();
	}

	/**
	 * Test of the ID case of the populateChildren method, of class
	 * ExprNode.
	 */
	@Test
	public void testIDCase() {
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID", 7, -1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));
	}

	/**
	 * Test of the minus case of the populateChildren method, of class
	 * ExprNode.
	 */
	@Test
	public void testMinusCase() {
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("-", 24, -1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));

	}

	/**
	 * Test of the OpenParen Case of the populateChildren method, of class
	 * ExprNode
	 */
	@Test
	public void testOpenParenCase() {
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("(", 27, -1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));
	}

	/**
	 * Test of the Const case of the populateChildren method, of class
	 * ExprNode
	 */
	@Test
	public void testConstCase() {
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("4", 29, -1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));
	}

	/**
	 * Builds a test Tree based on rule 23 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 23 of the grammar.
	 */
	public ProgNode buildTestTree23() {
		ProgNode parent = new ProgNode();
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		expr.addChild(44, -1);
		expr.addChild(45, -1);
		return parent;
	}

}

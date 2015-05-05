package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the stmtTailNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class StmtTailNodeTest {
	
	/**
	 * Holds the test tree based upon rule 2 in the grammar
	 */
	ProgNode rule2Tree; 
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
		rule2Tree = this.buildRule2Tree();
		parent = new ProgNode();
		testTools = new TestingTools();
	}
	
	/**
	 * Test of the Semicolon Case of the populateChildren method, of class
	 * StmtTailNode.
	 */
	@Test
	public void testSemicolonCase()
	{
		parent.addChild(33, -1);
		DescartesToken tok = new DescartesToken(";",1,-1);
		StmtTailNode stmt = (StmtTailNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule2Tree));
	}

	/**
	 * Builds a test Tree based on rule 2 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 2 of the grammar.
	 */
	public ProgNode buildRule2Tree()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(33, -1);
		StmtTailNode stmtTail = (StmtTailNode) parent.getChildAt(0);
        	stmtTail.addChild(1, -1);
        	stmtTail.addChild(32, -1);
        	stmtTail.addChild(33, -1);
		return parent;
	}
	
}
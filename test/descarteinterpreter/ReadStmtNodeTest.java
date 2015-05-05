package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the ReadStmtNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class ReadStmtNodeTest {
	
	/**
	 * Holds the test tree based upon rule 20 in the grammar
	 */
	ProgNode rule20Tree;

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
		rule20Tree = this.buildTestTree20();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of the READ Case of the populateChildren method, of class
	 * ReadStmtNode.
	 */
	@Test
	public void testReadStmtCase() {
		parent.addChild(38, -1);
		ReadStmtNode read =(ReadStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("READ",13,-1);
		read.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule20Tree));
	}

	/**
	 * Builds a test Tree based on rule 20 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 20 of the grammar.
	 */
	public ProgNode buildTestTree20()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(38, -1);
		ReadStmtNode read =(ReadStmtNode) parent.getChildAt(0);
		read.addChild(13, -1);
		read.addChild(7, -1);
		read.addChild(43, -1);
		return parent;
	}
	
}

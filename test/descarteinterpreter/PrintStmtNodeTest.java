package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the PrintStmtNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class PrintStmtNodeTest {
	
	/**
	 * Holds the test tree based upon rule 19 in the grammar.
	 */
	ProgNode rule19Tree;
	
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
		rule19Tree = this.buildTestTree19();
		testTools = new TestingTools();
		parent = new ProgNode();
	}


	/**
	 * Test of the Print Case of the populateChildren method, of class
	 * PrintStmtNode.
	 */
	@Test
	public void testReadStmtCase() {
		parent.addChild(39, -1);
		PrintStmtNode print =(PrintStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("PRINT",12,-1);
		print.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule19Tree));
	}

	/**
	 * Builds a test Tree based on rule 19 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 19 of the grammar.
	 */
	public ProgNode buildTestTree19()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(39, -1);
		PrintStmtNode print =(PrintStmtNode) parent.getChildAt(0);
		print.addChild(12,-1);
		print.addChild(7, -1);
		print.addChild(43, -1);
		return parent;
	}
}

package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class of the AssignStmtNode Class.
 * 
 * @author William King
 * @author Shelley King
 * @author Benjamin Boudra
 */
public class AssignStmtNodeTest {
	
	/**
	 * Holds a test Tree based on rule 18 in the grammar.
	 */
	ProgNode rule18Tree;
	
	/**
	 * Parent node that will act as a parent of the object we are are
	 * testing, necessary because only prog node has a constructor that
	 * doesn't call parent.
	 */
	ProgNode parent;

	/**
	 * holds the testing tools object
	 */
	TestingTools testTools;
	
	public AssignStmtNodeTest() {
	}
	
	/**
	 * Builds the Test Tree and creates the Testing objects.
	 */
	@Before
	public void setUp() {
		rule18Tree = this.buildTestTree18();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of the Assignment operator case of the populateChildren method, of class AssignStmtNode.
	 */
	@Test
	public void testAssignCase() {
		parent = new ProgNode();
		parent.addChild(37, -1);
		AssignStmtNode Assign = (AssignStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID",7,-1);
		Assign.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule18Tree));
	}

	/**
	 * Builds a test tree based upon rule 18 of the grammar and returns it to the caller.
	 * 
	 * @return The test tree based upon rule 18 of the grammar.
	 */
	public ProgNode buildTestTree18()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(37, -1);
		AssignStmtNode Assign = (AssignStmtNode) parent.getChildAt(0);
		Assign.addChild(7, -1);
		Assign.addChild(11, -1);
		Assign.addChild(40, -1);
		return parent;
	}
}
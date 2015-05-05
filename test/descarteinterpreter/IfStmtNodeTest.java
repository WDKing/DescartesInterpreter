package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the IfStmtNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class IfStmtNodeTest {
	
	/**
	 * Holds the test tree based upon rule 11 in the grammar
	 */
	ProgNode rule11Tree; 
	
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
		rule11Tree = this.buildTestTree11();
		parent = new ProgNode();
		testTools = new TestingTools();
	}

	/**
	 * Test of the If case of the populateChildren method, of class IfStmtNode.
	 */
	@Test
	public void testIfCase() {
		parent.addChild(34, -1);
		DescartesToken tok = new DescartesToken("IF",2,-1);
		IfStmtNode stmt = (IfStmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule11Tree));
		
	}

	
	/**
	 * Builds a test Tree based on rule 11 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 11 of the grammar.
	 */
	public ProgNode buildTestTree11()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(34, -1);
		IfStmtNode ifStmt = (IfStmtNode) prog.getChildAt(0);
        	ifStmt.addChild(2, -1);
        	ifStmt.addChild(40,-1);
        	ifStmt.addChild(3,-1);
        	ifStmt.addChild(31,-1);
        	ifStmt.addChild(41,-1);
		return prog;
	}
	
}

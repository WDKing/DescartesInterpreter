package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the LoopStmtNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class LoopStmtNodeTest {
	
	/**
	 * Holds the test tree based upon rule 14 in the grammar
	 */
	ProgNode rule14Tree;
	
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
		rule14Tree = this.buildTestTree14();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test Loop stmt case of the populateChildrent method, of class LoopStmtNode.
	 */
	@Test
	public void LoopStmtCase() {
		parent.addChild(35, -1);
		LoopStmtNode loop = (LoopStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("LOOP",6,-1);
		loop.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule14Tree));
	}


	/**
	 * Builds a test Tree based on rule 14 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 14 of the grammar.
	 */
	public ProgNode buildTestTree14()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(35, -1);
		LoopStmtNode loop = (LoopStmtNode) parent.getChildAt(0);
        	loop.addChild(6,-1);
        	loop.addChild(7,-1);
        	loop.addChild(8,-1);
        	loop.addChild(31,-1);
        	loop.addChild(9, -1);
		return parent;
	}
	
}

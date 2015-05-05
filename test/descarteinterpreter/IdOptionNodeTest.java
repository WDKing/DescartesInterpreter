package descarteinterpreter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the IdOptionNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class IdOptionNodeTest {
	
	/**
	 * Holds the test tree based upon rule 16 in the grammar
	 */
	ProgNode rule16Tree;
	
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
		rule16Tree = this.buildTestTree16();
		testTools = new TestingTools();
		parent = new ProgNode();
	}

	/**
	 * Test of the Id Case of the populateChildren method, of class IdOptionNode.
	 */
	@Test
	public void testIdCase() {
		parent.addChild(42, -1);
		IdOptionNode idOption = (IdOptionNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID",7,-1);
		idOption.addChild(7, -1);
		assertTrue(this.testTools.compareTrees(parent, rule16Tree));
	}
	
	/**
	 * Builds a test Tree based on rule 16 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 16 of the grammar.
	 */
	public ProgNode buildTestTree16()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(42, -1);
		IdOptionNode idOption = (IdOptionNode) prog.getChildAt(0);
		idOption.addChild(7, -1);
		return prog;
	}
}

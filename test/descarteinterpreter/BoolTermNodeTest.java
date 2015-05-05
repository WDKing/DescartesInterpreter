/*
 * @author Shelley King
 * @author Ben Boudra
 * @author William Price
 */

package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoolTermNodeTest {
	ProgNode rule26Tree;
	ProgNode parent;
	TestingTools testTools;
	public BoolTermNodeTest() {
	}
        
	@Before
	public void setUp() {
		rule26Tree = this.buildTestTree26();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of populateChildren method, of class BoolTermNode.
	 */
	@Test
	public void testAssignCase() {
		parent = new ProgNode();
		parent.addChild(44, -1);
		BoolTermNode Assign = (BoolTermNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID",7,-1);
		Assign.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule26Tree));
	}

	public ProgNode buildTestTree26() {
		ProgNode parent = new ProgNode();
		parent.addChild(44, -1);
		BoolTermNode Assign = (BoolTermNode) parent.getChildAt(0);
		Assign.addChild(46, -1);
                Assign.addChild(47, -1);
		return parent;
	}
}

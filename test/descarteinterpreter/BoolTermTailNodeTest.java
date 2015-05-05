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

public class BoolTermTailNodeTest {
	
  ProgNode rule24Tree;
	ProgNode rule25Tree;
	ProgNode parent;
	TestingTools testTools;
	public BoolTermTailNodeTest() {
	}
        
	@Before
	public void setUp() {
		rule24Tree = this.buildTestTree24();
                rule25Tree = this.buildTestTree25();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of populateChildren method, of class AssignStmtNode.
	 */
	@Test
	public void testAssignCase() {

		parent = new ProgNode();
		parent.addChild(45, -1);
		BoolTermTailNode Assign1 = (BoolTermTailNode) parent.getChildAt(0);
		DescartesToken dT1 = new DescartesToken("SOMEOR",15,-1);
		Assign1.populateChildren(dT1);
		assertTrue(this.testTools.compareTrees(parent, rule24Tree));

    parent = new ProgNode();
		parent.addChild(45, -1);
		BoolTermTailNode Assign2 = (BoolTermTailNode) parent.getChildAt(0);
		DescartesToken dT2 = new DescartesToken("SOMEPERIOD",0,-1);
		Assign2.populateChildren(dT2);
		assertTrue(this.testTools.compareTrees(parent, rule25Tree)); 
	}



  public ProgNode buildTestTree24() {
    ProgNode parent = new ProgNode();
	 	parent.addChild(45, -1);
    BoolTermTailNode Assign = (BoolTermTailNode) parent.getChildAt(0);
    Assign.addChild(15, -1);
    Assign.addChild(44, -1);
    Assign.addChild(45, -1);
    return parent;
  }

	public ProgNode buildTestTree25() {
		ProgNode parent = new ProgNode();
		parent.addChild(45, -1);
		BoolTermTailNode Assign = (BoolTermTailNode) parent.getChildAt(0);
		return parent;
	}
}

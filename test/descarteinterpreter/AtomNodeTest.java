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

public class AtomNodeTest {
	
        ProgNode rule48Tree;
	ProgNode rule49Tree;
	ProgNode parent;
	TestingTools testTools;
	public AtomNodeTest() {
	}
        
	@Before
	public void setUp() {
		rule48Tree = this.buildTestTree48();
                rule49Tree = this.buildTestTree49();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of populateChildren method, of class AssignStmtNode.
	 */
	@Test
	public void testAssignCase() {

		parent = new ProgNode();
		parent.addChild(54, -1);
		AtomNode Assign1 = (AtomNode) parent.getChildAt(0);
		DescartesToken dT1 = new DescartesToken("SOMECONST",7,-1);
		Assign1.populateChildren(dT1);
		assertTrue(this.testTools.compareTrees(parent, rule48Tree));

                parent = new ProgNode();
		parent.addChild(54, -1);
		AtomNode Assign2 = (AtomNode) parent.getChildAt(0);
		DescartesToken dT2 = new DescartesToken("SOMECONST",29,-1);
		Assign2.populateChildren(dT2);
		assertTrue(this.testTools.compareTrees(parent, rule49Tree)); 
	}



        public ProgNode buildTestTree48() {
                ProgNode parent = new ProgNode();
		parent.addChild(54, -1);
                AtomNode Assign = (AtomNode) parent.getChildAt(0);
                Assign.addChild(7, -1);
                return parent;
        }

	public ProgNode buildTestTree49() {
		ProgNode parent = new ProgNode();
		parent.addChild(54, -1);
		AtomNode Assign = (AtomNode) parent.getChildAt(0);
		Assign.addChild(29, -1);
		return parent;
	}
}

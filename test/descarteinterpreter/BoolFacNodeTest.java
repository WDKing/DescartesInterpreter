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

public class BoolFacNodeTest {
	
    ProgNode rule29Tree;
    ProgNode parent;
    TestingTools testTools;
    public BoolFacNodeTest() { }
        
    @Before
    public void setUp() {
        rule29Tree = this.buildTestTree29();
        testTools = new TestingTools();
        parent = new ProgNode();
    }
	
    /**
     * Test of populateChildren method, of class BoolFacNode.
     */
    @Test
    public void testAssignCase() {
        parent = new ProgNode();
        parent.addChild(46, -1);
        BoolFacNode Assign = (BoolFacNode) parent.getChildAt(0);
        DescartesToken dT = new DescartesToken("SOMEID",7,-1);
        Assign.populateChildren(dT);
        assertTrue(this.testTools.compareTrees(parent, rule29Tree)); 
    }

    public ProgNode buildTestTree29() {
        ProgNode parent = new ProgNode();
        parent.addChild(46, -1);
        BoolFacNode Assign = (BoolFacNode) parent.getChildAt(0);
        Assign.addChild(48, -1);
        Assign.addChild(49, -1);
        return parent;
    }
}

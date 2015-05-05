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
	
    /**
    * Holds the test tree based upon rule 29 in the grammar
    */
    ProgNode rule29Tree;
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
    /** General constructor */
    public BoolFacNodeTest() { }
        
    /**
     * Builds the Test Tree and creates testing objects.
     */    
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
    public void testCase() {
        parent = new ProgNode();
        parent.addChild(46, -1);
        BoolFacNode Assign = (BoolFacNode) parent.getChildAt(0);
        DescartesToken dT = new DescartesToken("SOMEID",7,-1);
        Assign.populateChildren(dT);
        assertTrue(this.testTools.compareTrees(parent, rule29Tree)); 
    }

    /**
     * Builds a test Tree based on rule 29 of the grammar and returns it to
     * the caller.
     *
     * @return the test Tree based on rule 29 of the grammar.
     */
    public ProgNode buildTestTree29() {
        ProgNode parent = new ProgNode();
        parent.addChild(46, -1);
        BoolFacNode Assign = (BoolFacNode) parent.getChildAt(0);
        Assign.addChild(48, -1);
        Assign.addChild(49, -1);
        return parent;
    }
}

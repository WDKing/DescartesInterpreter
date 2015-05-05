
package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the ExprNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class IdListTailNodeTest {
	
	/**
	 * Holds the test tree based upon rule 21 in the grammar
	 */
        ProgNode rule21Tree;
        /**
	 * Holds the test tree based upon rule 22 in the grammar
	 */
	ProgNode rule22Tree;
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
	/** Generic constructor */
	public IdListTailNodeTest() { }
        
        /**
	 * Builds the Test Tree and creates testing objects.
	 */
	@Before
	public void setUp() {
		rule21Tree = this.buildTestTree21();
                rule22Tree = this.buildTestTree22();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of populateChildren method, of class IdListTailNode.
	 */
	@Test
	public void testAssignCase() {
	  	parent = new ProgNode();
		parent.addChild(43, -1);
  	        IdListTailNode Assign1 = (IdListTailNode) parent.getChildAt(0);
	        DescartesToken dT1 = new DescartesToken("SOME PERIOD",0,-1);
  		Assign1.populateChildren(dT1);
	  	assertTrue(this.testTools.compareTrees(parent, rule22Tree));

                parent = new ProgNode();
		parent.addChild(43, -1);
  		IdListTailNode Assign2 = (IdListTailNode) parent.getChildAt(0);
	  	DescartesToken dT2 = new DescartesToken("SOME COMMA",14,-1);
		Assign2.populateChildren(dT2);
	  	assertTrue(this.testTools.compareTrees(parent, rule21Tree)); 
	}

        /**
	 * Builds a test Tree based on rule 21 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 21 of the grammar.
	 */
        public ProgNode buildTestTree21() {
             ProgNode parent = new ProgNode();
 	     parent.addChild(43, -1);
             IdListTailNode Assign = (IdListTailNode) parent.getChildAt(0);
             Assign.addChild(14, -1);
             Assign.addChild(7, -1);
             Assign.addChild(43, -1);
             return parent;
        }

        /**
	 * Builds a test Tree based on rule 22 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 22 of the grammar.
	 */
	public ProgNode buildTestTree22() {
	    ProgNode parent = new ProgNode();
	    parent.addChild(43, -1);
	    IdListTailNode Assign = (IdListTailNode) parent.getChildAt(0);
	    return parent;
	}
}

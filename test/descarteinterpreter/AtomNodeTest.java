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

/**
 * Test Class of the ExprNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class AtomNodeTest {
	
	/**
	 * Holds the test tree based upon rule 48 in the grammar
	 */
        ProgNode rule48Tree;
        /**
	 * Holds the test tree based upon rule 49 in the grammar
	 */
	ProgNode rule49Tree;
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
	public AtomNodeTest() {
	}
        
        /**
	 * Builds the Test Tree and creates testing objects.
	 */
	@Before
	public void setUp() {
		rule48Tree = this.buildTestTree48();
                rule49Tree = this.buildTestTree49();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of populateChildren method, of class AtomNode.
	 */
	@Test
	public void testAtomCase() {

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

        /**
	 * Builds a test Tree based on rule 48 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 48 of the grammar.
	 */
        public ProgNode buildTestTree48() {
                ProgNode parent = new ProgNode();
		parent.addChild(54, -1);
                AtomNode Assign = (AtomNode) parent.getChildAt(0);
                Assign.addChild(7, -1);
                return parent;
        }

        /**
	 * Builds a test Tree based on rule 49 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 49 of the grammar.
	 */
	public ProgNode buildTestTree49() {
		ProgNode parent = new ProgNode();
		parent.addChild(54, -1);
		AtomNode Assign = (AtomNode) parent.getChildAt(0);
		Assign.addChild(29, -1);
		return parent;
	}
}

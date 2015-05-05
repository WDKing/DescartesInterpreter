/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descarteinterpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benjamin
 */
public class LoopStmtNodeTest {
	
	ProgNode rule14Tree;
	ProgNode parent;
	TestingTools testTools;
	public LoopStmtNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule14Tree = this.buildTestTree14();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of execute method, of class LoopStmtNode.
	 */
	@Test
	public void LoopStmtCase() {
		parent.addChild(35, -1);
		LoopStmtNode loop = (LoopStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("LOOP",6,-1);
		loop.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule14Tree));
	}


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

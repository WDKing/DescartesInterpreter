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
public class BreakStmtNodeTest {
	
	ProgNode rule15Tree;
	ProgNode parent;
	TestingTools testTools;
	public BreakStmtNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule15Tree = this.buildTestTree15();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of populateChildren method, of class BreakStmtNode.
	 */
	@Test
	public void TestBreakCase() {
		parent= new ProgNode();
		parent.addChild(36, -1);
		BreakStmtNode breakStmt = (BreakStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("BREAK",10,-1);
		breakStmt.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule15Tree));
	}
	
	public ProgNode buildTestTree15()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(36, -1);
		BreakStmtNode breakStmt = (BreakStmtNode) prog.getChildAt(0);
		breakStmt.addChild(10, -1);
		breakStmt.addChild(42, -1);
		return prog;
	}
}

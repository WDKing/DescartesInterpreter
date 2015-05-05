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
public class IfStmtNodeTest {
	
	ProgNode rule11Tree; 
	ProgNode parent;
	TestingTools testTools;
	public IfStmtNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule11Tree = this.buildTestTree11();
		parent = new ProgNode();
		testTools = new TestingTools();
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of populateChildren method, of class IfStmtNode.
	 */
	@Test
	public void testIfCase() {
		parent.addChild(34, -1);
		DescartesToken tok = new DescartesToken("IF",2,-1);
		IfStmtNode stmt = (IfStmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule11Tree));
		
	}

	public ProgNode buildTestTree11()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(34, -1);
		IfStmtNode ifStmt = (IfStmtNode) prog.getChildAt(0);
        	ifStmt.addChild(2, -1);
        	ifStmt.addChild(40,-1);
        	ifStmt.addChild(3,-1);
        	ifStmt.addChild(31,-1);
        	ifStmt.addChild(41,-1);
		return prog;
	}
	
}

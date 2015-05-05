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
public class AssignStmtNodeTest {
	
	ProgNode rule18Tree;
	ProgNode parent;
	TestingTools testTools;
	public AssignStmtNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule18Tree = this.buildTestTree18();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	/**
	 * Test of populateChildren method, of class AssignStmtNode.
	 */
	@Test
	public void testAssignCase() {
		parent = new ProgNode();
		parent.addChild(37, -1);
		AssignStmtNode Assign = (AssignStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID",7,-1);
		Assign.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule18Tree));
	}

	public ProgNode buildTestTree18()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(37, -1);
		AssignStmtNode Assign = (AssignStmtNode) parent.getChildAt(0);
		Assign.addChild(7, -1);
		Assign.addChild(11, -1);
		Assign.addChild(40, -1);
		return parent;
	}
}
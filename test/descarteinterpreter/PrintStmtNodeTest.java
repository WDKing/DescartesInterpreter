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
public class PrintStmtNodeTest {
	
	ProgNode rule19Tree;
	ProgNode parent;
	TestingTools testTools;
	public PrintStmtNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule19Tree = this.buildTestTree19();
		testTools = new TestingTools();
		parent = new ProgNode();
	}


	@Test
	public void testReadStmtCase() {
		parent.addChild(39, -1);
		PrintStmtNode print =(PrintStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("PRINT",12,-1);
		print.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule19Tree));
	}

	public ProgNode buildTestTree19()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(39, -1);
		PrintStmtNode print =(PrintStmtNode) parent.getChildAt(0);
		print.addChild(12,-1);
		print.addChild(7, -1);
		print.addChild(43, -1);
		return parent;
	}
}

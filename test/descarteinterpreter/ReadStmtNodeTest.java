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
public class ReadStmtNodeTest {
	
	ProgNode rule20Tree;
	ProgNode parent;
	TestingTools testTools;
	public ReadStmtNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule20Tree = this.buildTestTree20();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testReadStmtCase() {
		parent.addChild(38, -1);
		ReadStmtNode read =(ReadStmtNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("READ",13,-1);
		read.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule20Tree));
	}

	public ProgNode buildTestTree20()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(38, -1);
		ReadStmtNode read =(ReadStmtNode) parent.getChildAt(0);
		read.addChild(13, -1);
		read.addChild(7, -1);
		read.addChild(43, -1);
		return parent;
	}
	
}

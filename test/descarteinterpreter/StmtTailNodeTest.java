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
public class StmtTailNodeTest {
	
	ProgNode rule2Tree; 
	ProgNode parent;
	TestingTools testTools;
	
	@Before
	public void setUp() {
		rule2Tree = this.buildRule2Tree();
		parent = new ProgNode();
		testTools = new TestingTools();
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testSemicolonCase()
	{
		parent.addChild(33, -1);
		DescartesToken tok = new DescartesToken(";",1,-1);
		StmtTailNode stmt = (StmtTailNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule2Tree));
	}

	public ProgNode buildRule2Tree()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(33, -1);
		StmtTailNode stmtTail = (StmtTailNode) parent.getChildAt(0);
        	stmtTail.addChild(1, -1);
        	stmtTail.addChild(32, -1);
        	stmtTail.addChild(33, -1);
		return parent;
	}
	
}
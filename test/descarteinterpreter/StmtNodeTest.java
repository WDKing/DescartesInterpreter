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
public class StmtNodeTest {
	ProgNode rule4Tree; 
	ProgNode rule5Tree;
	ProgNode rule6Tree;
	ProgNode rule7Tree;
	ProgNode rule8Tree;
	ProgNode rule9Tree;
	ProgNode parent;
	TestingTools testTools;
	public StmtNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule4Tree = this.buildRule4Tree();
		rule5Tree = this.buildRule5Tree();
		rule6Tree = this.buildRule6Tree();
		rule7Tree = this.buildRule7Tree();
		rule8Tree = this.buildRule8Tree();
		rule9Tree = this.buildRule9Tree();
		parent = new ProgNode();
		testTools = new TestingTools();
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testIfCase()
	{
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("IF",2,-1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule4Tree));
	}

	@Test
	public void testLoopCase()
	{
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("LOOP",6,-1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule5Tree));
	}
	@Test
	public void testIdCase()
	{
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("SomeID",7,-1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule7Tree));
	}
	@Test
	public void testBreakCase()
	{
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("BREAK",10,-1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule6Tree));
	}
	@Test
	public void testPrintCase()
	{
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("PRINT",12,-1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule9Tree));
	}
	@Test
	public void testReadCase()
	{
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("READ",13,-1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule8Tree));
	}

	public ProgNode buildRule4Tree()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(34, -1);
		return prog;
	}
	
	public ProgNode buildRule5Tree()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(35, -1);
		return prog;
	}

	public ProgNode buildRule6Tree()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(36, -1);
		return prog;
	}
	public ProgNode buildRule7Tree()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(37, -1);
		return prog;
	}
	public ProgNode buildRule8Tree()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(38, -1);
		return prog;
	}
	public ProgNode buildRule9Tree()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(39, -1);
		return prog;
	}
}

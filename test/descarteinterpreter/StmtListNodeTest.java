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
public class StmtListNodeTest {
	ProgNode rule1Tree; 
	ProgNode parent;
	TestingTools testTools;

	@Before
	public void setUp() {
		rule1Tree = this.buildRule1Tree();
		parent = new ProgNode();
		testTools = new TestingTools();
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testPeriodCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken(".",0,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}
	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testSemiColoncase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken(";",1,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testIfCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("IF",2,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testElseCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("ELSE",4,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testFiCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("FI",5,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testLoopCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("LOOP",6,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testIdCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("SomeID",7,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testRepeatCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("REPEAT",9,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testBreakCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("BREAK",10,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testPrintCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("PRINT",12,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	/**
	 * Test of populateChildren method, of class StmtTailNode.
	 */
	@Test
	public void testReadCase() {
		parent.addChild(31, -1);
		DescartesToken tok = new DescartesToken("READ",13,-1);
		StmtListNode stmt = (StmtListNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule1Tree));
	}

	public ProgNode buildRule1Tree()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31, -1);
		StmtListNode stmt = (StmtListNode) prog.getChildAt(0);
		stmt.addChild(32, -1);
		stmt.addChild(33, -1);
		return prog;
	}
}

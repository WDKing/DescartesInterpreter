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
 * Test Class of the StmtNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class StmtNodeTest {

	/**
	 * Holds the test tree based upon rule 4 in the grammar
	 */
	ProgNode rule4Tree;
	/**
	 * Holds the test tree based upon rule 5 in the grammar
	 */
	ProgNode rule5Tree;
	/**
	 * Holds the test tree based upon rule 6 in the grammar
	 */
	ProgNode rule6Tree;
	/**
	 * Holds the test tree based upon rule 7 in the grammar
	 */
	ProgNode rule7Tree;
	/**
	 * Holds the test tree based upon rule 8 in the grammar
	 */
	ProgNode rule8Tree;
	/**
	 * Holds the test tree based upon rule 9 in the grammar
	 */
	ProgNode rule9Tree;

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

	/**
	 * Builds the Test Trees and creates testing objects.
	 */
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

	/**
	 * Test of the IF case of the populateChildren method, of class
	 * StmtNode.
	 */
	@Test
	public void testIfCase() {
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("IF", 2, -1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule4Tree));
	}


	/**
	 * Test of the LOOP case of the populateChildren method, of class
	 * StmtNode.
	 */
	@Test
	public void testLoopCase() {
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("LOOP", 6, -1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule5Tree));
	}

	/**
	 * Test of the ID case of the populateChildren method, of class
	 * StmtNode.
	 */
	@Test
	public void testIdCase() {
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("SomeID", 7, -1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule7Tree));
	}

	/**
	 * Test of the BREAK case of the populateChildren method, of class
	 * StmtNode.
	 */
	@Test
	public void testBreakCase() {
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("BREAK", 10, -1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule6Tree));
	}

	/**
	 * Test of the PRINT case of the populateChildren method, of class
	 * StmtNode.
	 */
	@Test
	public void testPrintCase() {
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("PRINT", 12, -1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule9Tree));
	}

	/**
	 * Test of the READ case of the populateChildren method, of class
	 * StmtNode.
	 */
	@Test
	public void testReadCase() {
		parent.addChild(32, -1);
		DescartesToken tok = new DescartesToken("READ", 13, -1);
		StmtNode stmt = (StmtNode) parent.getChildAt(0);
		stmt.populateChildren(tok);
		assertTrue(this.testTools.compareTrees(parent, rule8Tree));
	}

	/**
	 * Builds a test Tree based on rule 4 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 4 of the grammar.
	 */
	public ProgNode buildRule4Tree() {
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(34, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 5 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 5 of the grammar.
	 */
	public ProgNode buildRule5Tree() {
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(35, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 6 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 6 of the grammar.
	 */
	public ProgNode buildRule6Tree() {
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(36, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 7 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 7 of the grammar.
	 */
	public ProgNode buildRule7Tree() {
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(37, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 8 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 8 of the grammar.
	 */
	public ProgNode buildRule8Tree() {
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(38, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 9 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 9 of the grammar.
	 */
	public ProgNode buildRule9Tree() {
		ProgNode prog = new ProgNode();
		prog.addChild(32, -1);
		StmtNode stmt = (StmtNode) prog.getChildAt(0);
		stmt.addChild(39, -1);
		return prog;
	}
}

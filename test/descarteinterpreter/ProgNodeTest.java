/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descarteinterpreter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benjamin
 */
public class ProgNodeTest {
	TestingTools testTools;
	ProgNode prog;
	public ProgNodeTest() {
	}
	
	@Before
	public void setUp() {
		testTools = new TestingTools();
		 prog = new ProgNode();
	}


	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenPeriod() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken(".", 0,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree1(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenSemicolon() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken(";", 1,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree2(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenIf() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("IF", 2,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree3(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenLoop() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("LOOP", 6,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree4(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenId() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("SOMEIDENT", 7,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree5(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenBreak() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("BREAK", 10,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree6(), prog));
	}
	

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenPrint() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("PRINT", 12,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree7(), prog));
	}
	
	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenRead() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("READ", 13,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree8(), prog));
	}
	
	/**
	 * 
	 */
	public ProgNode buildTestTree1()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}
	
	/**
	 * 
	 * @return 
	 */
	public ProgNode buildTestTree2()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}


	/**
	 * 
	 */
	public ProgNode buildTestTree3()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree4()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree5()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree6()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree7()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree8()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

}

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
		 prog = new ProgNode(30);
	}


	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenPeriod() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair(".", 0);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree1(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenSemicolon() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair(";", 1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree2(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenIf() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair("IF", 2);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree3(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenLoop() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair("LOOP", 6);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree4(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenId() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair("SOMEIDENT", 7);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree5(), prog));
	}

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenBreak() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair("BREAK", 10);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree6(), prog));
	}
	

	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenPrint() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair("PRINT", 12);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree7(), prog));
	}
	
	/**
	 * Test of populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenRead() {
		System.out.println("populateChildren");
		TokenPair tok = new TokenPair("READ", 13);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree8(), prog));
	}
	
	/**
	 * 
	 */
	public ProgNode buildTestTree1()
	{
		new TokenPair(".", 0);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}
	
	/**
	 * 
	 * @return 
	 */
	public ProgNode buildTestTree2()
	{
		TokenPair tokenPair = new TokenPair(";", 1);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}


	/**
	 * 
	 */
	public ProgNode buildTestTree3()
	{
		new TokenPair("IF",2);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree4()
	{
		new TokenPair("LOOP", 6);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree5()
	{
		new TokenPair("SOMEINDENT",7);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree6()
	{
		new TokenPair("BREAK", 10);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree7()
	{
		new TokenPair("PRINT",12);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}

	/**
	 * 
	 */
	public ProgNode buildTestTree8()
	{
		new TokenPair("READ", 13);
		ProgNode prog = new ProgNode(30);
		prog.addChild(31);
		prog.addChild(0);
		return prog;
	}

}

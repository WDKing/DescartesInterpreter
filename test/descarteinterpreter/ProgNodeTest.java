package descarteinterpreter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of the ProgNode Class.
 *
 * @author Shelley King
 * @author William King
 * @author Benjamin Boudra
 */
public class ProgNodeTest {
	/**
	 * Holds the testing tools object
	 */
	TestingTools testTools;
	
	/**
	 * The object that will be tested.
	 */
	ProgNode prog;

	
	/**
	 * Creates the different objects used for testing.
	 */
	@Before
	public void setUp() {
		testTools = new TestingTools();
		 prog = new ProgNode();
	}


	/**
	 * Test of the period case of the populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenPeriod() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken(".", 0,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree1(), prog));
	}

	/**
	 * Test of the Semicolon case populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenSemicolon() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken(";", 1,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree2(), prog));
	}

	/**
	 * Test of the if case populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenIf() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("IF", 2,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree3(), prog));
	}

	/**
	 * Test of the LOOP case of the populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenLoop() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("LOOP", 6,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree4(), prog));
	}

	/**
	 * Test of the ID case of the populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenId() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("SOMEIDENT", 7,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree5(), prog));
	}

	/**
	 * Test of the BREAK case of the populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenBreak() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("BREAK", 10,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree6(), prog));
	}
	

	/**
	 * Test of the PRINT case of the populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenPrint() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("PRINT", 12,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree7(), prog));
	}
	
	/**
	 * Test of the READ case of the populateChildren method, of class ProgNode.
	 */
	@Test
	public void TestPopulateChildrenRead() {
		System.out.println("populateChildren");
		DescartesToken tok = new DescartesToken("READ", 13,-1);
		prog.populateChildren(tok);
		assertTrue(testTools.compareTrees(buildTestTree8(), prog));
	}
	
	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree1()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}
	
	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree2()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}


	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree3()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree4()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree5()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree6()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree7()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

	/**
	 * Builds a test Tree based on rule 1 of the grammar and returns it to
	 * the caller.
	 *
	 * @return the test Tree based on rule 1 of the grammar.
	 */
	public ProgNode buildTestTree8()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(31,-1);
		prog.addChild(0, -1);
		return prog;
	}

}

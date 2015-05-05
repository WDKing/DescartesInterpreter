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
 * @author Benjamin
 */
public class ElsePartNodeTest {
	ProgNode testTree12;
	ProgNode testTree13;
	ProgNode parent;
	TestingTools testTools;

	public ElsePartNodeTest() {
	}
	
	@Before
	public void setUp() {
		testTree12 = this.buildTestTree12();
		testTree13 = this.buildTestTree13();
		testTools = new TestingTools();
		parent = new ProgNode();
	}

	/**
	 * Test of populateChildren method, of class ElsePartNode.
	 */
	@Test
	public void testElseCase() {
		parent.addChild(41, -1);
		ElsePartNode elsePart = (ElsePartNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("ELSE",4,-1);
		elsePart.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, testTree12));
	}

	@Test
	public void testFiCase()
	{
		parent.addChild(41, -1);
		ElsePartNode elsePart=(ElsePartNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("FI",5,-1);
		elsePart.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, testTree13));
	}
	

	public ProgNode buildTestTree12()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(41, -1);
		ElsePartNode elsePart = (ElsePartNode) prog.getChildAt(0);
		elsePart.addChild(4, -1);
		elsePart.addChild(31, -1);
		elsePart.addChild(5, -1);
		return prog;
	}
	public ProgNode buildTestTree13()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(41, -1);
		ElsePartNode elsePart = (ElsePartNode) prog.getChildAt(0);
		elsePart.addChild(5, -1);
		return prog;
	}
}

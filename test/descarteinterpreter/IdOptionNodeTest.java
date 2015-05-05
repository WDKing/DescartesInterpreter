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
public class IdOptionNodeTest {
	
	ProgNode rule16Tree;
	ProgNode parent;
	TestingTools testTools;
	public IdOptionNodeTest() {
		rule16Tree = this.buildTestTree16();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	
	@Before
	public void setUp() {

	}

	/**
	 * Test of populateChildren method, of class IdOptionNode.
	 */
	@Test
	public void testIdCase() {
		parent.addChild(42, -1);
		IdOptionNode idOption = (IdOptionNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID",7,-1);
		idOption.addChild(7, -1);
		assertTrue(this.testTools.compareTrees(parent, rule16Tree));
	}
	
	public ProgNode buildTestTree16()
	{
		ProgNode prog = new ProgNode();
		prog.addChild(42, -1);
		IdOptionNode idOption = (IdOptionNode) prog.getChildAt(0);
		idOption.addChild(7, -1);
		return prog;
	}
}

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
public class ExprNodeTest {
	
	ProgNode rule23Tree;
	ProgNode parent;
	TestingTools testTools;
	public ExprNodeTest() {
	}
	
	@Before
	public void setUp() {
		rule23Tree = this.buildTestTree23();
		testTools = new TestingTools();
		parent = new ProgNode();
	}
	

	@Test
	public void testIDCase() {
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("SOMEID",7,-1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));
	}

	@Test
	public void testMinusCase()
	{
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("-",24,-1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));

	}
	
	@Test
	public void testOpenParenCase()
	{
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("(",27,-1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));
	}

	@Test
	public void testConstCase()
	{
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		DescartesToken dT = new DescartesToken("4",29,-1);
		expr.populateChildren(dT);
		assertTrue(this.testTools.compareTrees(parent, rule23Tree));
	}

	public ProgNode buildTestTree23()
	{
		ProgNode parent = new ProgNode();
		parent.addChild(40, -1);
		ExprNode expr = (ExprNode) parent.getChildAt(0);
		expr.addChild(44, -1);
		expr.addChild(45, -1);
		return parent;
	}
	
}

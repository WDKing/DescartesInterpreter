/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descarteinterpreter;

/**
 *
 * @author Benjamin
 */
public class TestingTools {
	

	
	public boolean compareTrees(ParseTreeNode one, ParseTreeNode two)
	{
		if(one.getClass() != two.getClass())
		{
			return false;
		}
		else if(one.getCode() != two.getCode())
		{
			return false;
		}
		else if(one.getChildCount() != two.getChildCount())
		{
			return false;
		}
		else if(one.hasChildren()== false)
		{
			return true;
		}
		else
		{
			boolean same;
			same = true;
			for(int i = 0; i < one.getChildCount(); i++)
			{
				if(!compareTrees(one.getChildAt(i),two.getChildAt(i)))
				{
					same = false;
				}
			}
			if(same)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
	}
}

/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for ParseTreeNode
 * @see java.util.Iterator
 */
public class ParseTreeIterator implements Iterator<ParseTreeNode>
{
    ParseTreeNode startNode;
    ParseTreeNode currNode;
    
    public ParseTreeIterator(ParseTreeNode start) {
        currNode = startNode = start;
    }
    
    @Override
    public boolean hasNext() {
        ParseTreeNode nextNode = currNode.getNextInTree();
        return (nextNode != null
            && nextNode.getParent() != startNode.getParent());
    }
    
    @Override
    public ParseTreeNode next() throws NoSuchElementException {
        ParseTreeNode result = currNode.getNextInTree();
        
        if(result == null || result.getParent() == startNode.getParent()) {
            throw new NoSuchElementException("No next element in tree.");
        }

        currNode = result;
        
        return result;
    }
}
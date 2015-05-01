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
    /** The node that the iterator starts at */
    ParseTreeNode startNode;
    /** The node that the iterator is at currently */
    ParseTreeNode currNode;
    
    public ParseTreeIterator(ParseTreeNode start) {
        currNode = startNode = start;
    }
    
    @Override
    public boolean hasNext() {
        ParseTreeNode nextNode = currNode.getNextInTree();
        return (nextNode != null
                && !nextNode.isSibling(startNode));
    }
    
    @Override
    public ParseTreeNode next() throws NoSuchElementException {
        ParseTreeNode result = currNode.getNextInTree();
        
        if(result == null
            || result.isSibling(startNode)) {
            throw new NoSuchElementException("No next element in tree.");
        }

        currNode = result;
        
        return result;
    }
}
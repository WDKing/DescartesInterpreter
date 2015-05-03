/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Main class for building and interpreting a parse tree from code written in
 * the Descartes-2 language.
 */
public class Interpreter
{   
    public static void main(String args[])
    {
        Tokenizer lexer;
        ParseTreeNode progTree = new ProgNode(30);
        ParseTreeIterator ptIter;
        InputStream fileIn;
        
        System.out.println("DESCARTES-2 INTERPRETER \n");
        
        fileIn = getFileFromUser();
        if(fileIn != null) {        
            lexer = new Tokenizer(fileIn);
            progTree.buildTree(lexer);
            ptIter = progTree.iterator();
            
            while(ptIter.hasNext()) {
                ParseTreeNode currNode = ptIter.next();
                if(currNode.isTerminal()) {
                    System.out.println(((TerminalNode) currNode).getTokenStr());
                } else {
                    System.out.print(currNode.getCode() + " ");
                }
            }
        }
        
        System.out.println("\nQuitting program.");
    }
    
    private static InputStream getFileFromUser() {
        boolean needFile = true;
        String fileName;
        InputStream codeFile = null;
        Scanner console = new Scanner(System.in);
        
        while(needFile) {
            System.out.println("\nEnter the filename, or enter nothing to use"
                    + " the default file (testprog.dat),"
                    + " \nor enter Q to quit.");
            System.out.print("Filename: ");
            fileName = console.nextLine().trim();

            if(!fileName.toUpperCase().equals("Q")){
                if(fileName.equals("")) {
                    fileName = "testprog.dat";
                    System.out.println("Using testprog.dat.");
                }
                try {
                    codeFile = new FileInputStream(fileName);
                    needFile = false;
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + fileName + ".");
                    System.out.println("Try again.");
                }
            } else {
                needFile = false;
            }
        }
        
        return codeFile;
    }
}

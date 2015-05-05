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
import java.util.Set;

/**
 * Main class for building and interpreting a parse tree from code written in
 * the Descartes-2 language.
 */
public class Interpreter
{   
    private static String theFileName;
    
    public static void main(String args[])
    {
        Tokenizer lexer;
        ProgNode progTree = new ProgNode();
        ParseTreeIterator ptIter;
        InputStream fileIn;
        ControlTag tag;
        
        System.out.println("DESCARTES-2 INTERPRETER");
        
        fileIn = getFileFromUser();
        if(fileIn != null) {
            System.out.println("\nParsing file " + theFileName + " ...");
            lexer = new Tokenizer(fileIn);
            progTree.buildTree(lexer);
            System.out.println("Executing file " + theFileName + " ...");
            System.out.println("\n********************");
            tag = progTree.execute();
            System.out.println("********************");
            
            if(tag.isBreak() || tag.isError()) {
                System.out.println("\nError in program.");
                System.out.println("Execution halted at line "
                        + tag.getLineNum());
            } else {
                System.out.println("\nExecution completed successfully.");
            }
            
            System.out.println("\nFinal symbol table:");
            Set<String> keys = progTree.getSymbolTable().keySet();
            for(String k : keys) {
                System.out.printf("%-16s %.2f", "\n" + k + ": ",
                        progTree.getSymbolTable().get(k));
            }
        }
        
        System.out.println("\n\nQuitting program.");
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
                }
                try {
                    codeFile = new FileInputStream(fileName);
                    theFileName = fileName;
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

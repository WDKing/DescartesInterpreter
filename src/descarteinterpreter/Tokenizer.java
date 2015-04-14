/**
 * 
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 * 
 * According to the specification, numbers must both start and end with digits,
 * and whitespace is required between a number and a period. Therefore, in
 * following two examples, the period will be discarded as garbage:
 * .5
 * 5.
 * 
 * Contiguous whitespace characters will be read as a single whitespace token,
 * and given token number 55.
 * 
 * There are no strings in this language.
 * 
 * To avoid ambiguity, a number cannot follow directly after a reserved word
 * or identifier without something separating them. But a number can directly
 * precede a reserved word or identifier without any separation. For instance,
 * this:
 * 23.4TEMP8
 * would be considered the number 23.4 and then the identifier TEMP8.
 * 
 * Identifiers and reserved words cannot follow each other directly with no
 * separation. So these:
 * $TEMPREAD
 * READ$TEMP
 * would both be considered just identifiers with no reserved word.
 * 
 * Lower-case alphabetic characters will be read and recorded as their
 * upper-case versions.
 * 
 * If getToken() is called when the stream has no tokens in it (the stream is
 * empty, or only has garbage in it) it will return null.
 * 
 * The encoding of the file will be assumed to be US_ASCII.
 */

package descarteinterpreter;

import java.io.PushbackReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.BufferOverflowException;
import java.nio.charset.Charset;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Tokenizer class for Descartes-2 Interpreter.
 */
public class Tokenizer {
    /** indicates that the period waiting in the stream is garbage */
    private boolean garbageFlag = false;
    /** the stream being parsed */
    private final PushbackReader fileIn;
    /** for building up the text of the token */
    private final StringBuilder tempChars = new StringBuilder(1024);
    
    /** stores the tokens found so far */
    private static final List<TokenPair> tokenList = new ArrayList<>(256);
    /** non-alphanumeric characters that can start a token */
    private static final char[] SPECIAL_STARTS =
            {'(', ')', '<', '>', '/', '*', '-', '+', '=', ';', ':', '.', ','};
    /** the reserved words and their numeric codes */
    private static final Map<String, Integer> RESERVED_WORDS = new HashMap<>(11);
    
    /**
     * Main method just for testing the class.
     * @param   args    not used
     */
    public static void main(String[] args) {
        TokenPair nextToken;
        Tokenizer testTokenizer;
        
        System.out.println("\nDisplaying the list of tokens: \n");

        try
        {
            testTokenizer = new Tokenizer(new FileInputStream("testprog.dat"));
            
            while((nextToken = testTokenizer.getToken()) != null)
            {
                System.out.println(nextToken);
            }

            System.out.println("\nThere were " + testTokenizer.countGarbage()
                + " occurrences of garbage in the file.");
            
            testTokenizer.close();
        }
        catch(FileNotFoundException e1) {
            System.out.println("\nError: File not found.");
            System.out.println(e1.getMessage());
        } catch(BufferOverflowException e2) {
            System.out.println("\nError: Buffer has overflowed.");
            System.out.println(e2.getMessage());
        } catch(IOException e3) {
            System.out.println("\nError: Unspecified IOException.");
            System.out.println(e3.getMessage());
        }
    }
    
    /**
     * Sole constructor.
     * @param   in  stream with the code to parse
     */
    public Tokenizer(InputStream in) {
        InputStreamReader tempRead;
        
        tempRead = new InputStreamReader(in, Charset.forName("US-ASCII"));
        this.fileIn = new PushbackReader(tempRead, 8);
        
        RESERVED_WORDS.put("IF", 2);
        RESERVED_WORDS.put("THEN", 3);
        RESERVED_WORDS.put("ELSE", 4);
        RESERVED_WORDS.put("FI", 5);
        RESERVED_WORDS.put("LOOP", 6);
        RESERVED_WORDS.put("REPEAT", 9);
        RESERVED_WORDS.put("BREAK", 10);
        RESERVED_WORDS.put("PRINT", 12);
        RESERVED_WORDS.put("READ", 13);
        RESERVED_WORDS.put("OR", 15);
        RESERVED_WORDS.put("AND", 16);
    }
    
    /**
     * The primary use of the Tokenizer class. Adds the next token in the stream
     * to its internal list, along with any intervening garbage blocks.
     * Whitespace is given the numeric code 55, and garbage is -1.
     * @return  the next token from the stream, or null if no tokens are left
     * @throws  IOException if it cannot read from fileIn
     * @throws  BufferOverflowException if pushback exceeds buffer
     */
    public TokenPair getToken() throws IOException, BufferOverflowException {
        int temp, tokenNum = -1;
        TokenPair result = null;
        
        while(tokenNum == -1 || tokenNum == 55) {
        // return only non-garbage or non-whitespace
            temp = fileIn.read();
            tempChars.delete(0, tempChars.length()); // clear buffer
            tempChars.append((char) temp); // add the first character

            if(temp >= 0 && temp <= 255) {
                if(Character.isLetter(tempChars.charAt(0))) {
                    tempChars.setCharAt(0,
                        Character.toUpperCase(tempChars.charAt(0)));
                    tokenNum = startsAlpha();
                } else if(Character.isDigit(tempChars.charAt(0))) {
                    tokenNum = startsDigit();
                } else if(Character.isWhitespace(tempChars.charAt(0))) {
                    tokenNum = startsWhiteSpace();
                } else {
                    switch(tempChars.charAt(0)) {
                        case '(':       tokenNum = 27;
                                        break;
                        case ')':       tokenNum = 28;
                                        break;
                        case '<':       tokenNum = startsLeftAngle();
                                        break;
                        case '>':       tokenNum = startsRightAngle();
                                        break;
                        case '/':       tokenNum = 26;
                                        break;
                        case '*':       tokenNum = 25;
                                        break;
                        case '-':       tokenNum = 24;
                                        break;
                        case '+':       tokenNum = 23;
                                        break;
                        case '=':       tokenNum = 19;
                                        break;
                        case ';':       tokenNum = 1;
                                        break;
                        case ',':       tokenNum = 14;
                                        break;
                        case ':':       tokenNum = startsColon();
                                        break;
                        case '.':       tokenNum = startsPeriod();
                                        break;
                        default:        tokenNum = startsGarbage();
                                        break;
                    }
                }
                result = new TokenPair(tempChars.toString(), tokenNum);
                tokenList.add(result);
            } else if(temp > 255) {
                tokenNum = startsGarbage();
                result = new TokenPair(tempChars.toString(), tokenNum);
                tokenList.add(result);
            } else { // if at EOF
                result = null; // return null
                tokenNum = -100; // end loop
            }
        }
        
        return result;
    }
    
    /**
     * Reads contiguous whitespace from the stream as a single token.
     * @return  the numeric code for the token, in this case always 55
     */
    private int startsWhiteSpace() throws IOException, BufferOverflowException {
        int temp = -1, tokenNum = 55, i;
        char tmp;
        boolean getAnother = true;
        
        tempChars.delete(0, tempChars.length()); // clear buffer
        tempChars.append("WHITESPACE");
        
        while(getAnother && (temp = fileIn.read()) >= 0) {
        // read in characters until EOF, or one is not whitespace
            tmp = (char) temp;
            if(!Character.isWhitespace(tmp)) {
                getAnother = false;
            }
        }
        if(temp >= 0) { // if we didn't end on EOF
            fileIn.unread(temp); // put ender back in the stream
        }
        
        return tokenNum;
    }
    
     /**
     * Continues reading a token from the stream which started with '<'.
     * @return  the numeric code for the token
     */
    private int startsLeftAngle() throws IOException, BufferOverflowException {
        int temp, tokenNum = 17;
        char tmp;
        
        temp = fileIn.read();
        if(temp >= 0) { // if not EOF right after the angle-bracket
            tmp = (char) temp;
            if(tmp == '>') { // ... then is it opposite bracket?
                tempChars.append(tmp); // if so, add it
                tokenNum = 22; // ... and adjust tokenNum
            } else if(tmp == '=') { // or is it equal-sign?
                tempChars.append(tmp); // if so, add it
                tokenNum = 18; // ... and adjust tokenNum
            } else { // if not either one of those
                fileIn.unread(temp); // put it back, leaving tokenNum as 17
            }
        }
        
        return tokenNum;
    }
    
    /**
     * Continues reading a token from the stream which started with '>'.
     * @return  the numeric code for the token
     */
    private int startsRightAngle() throws IOException, BufferOverflowException {
        int temp, tokenNum = 21;
        char tmp;
        
        temp = fileIn.read();
        if(temp >= 0) { // if not EOF right after the angle-bracket
            tmp = (char) temp;
            if(tmp == '=') { // ... then is it equal-sign?
                tempChars.append(tmp); // if so, add it
                tokenNum = 20; // ... and adjust tokenNum
            } else { // if not equal-sign
                fileIn.unread(temp); // put it back, leaving tokenNum as 21
            }
        }
        
        return tokenNum;
    }
    
    /**
     * Continues reading a token from the stream which started with ':'.
     * @return  the numeric code for the token
     */
    private int startsColon() throws IOException, BufferOverflowException {
        int temp, tokenNum = 8;
        char tmp;
        
        temp = fileIn.read();
        if(temp >= 0) { // if not EOF right after the colon
            tmp = (char) temp;
            if(tmp == '=') { // ... then is it equal-sign?
                tempChars.append(tmp); // if so, add it
                tokenNum = 11; // ... and adjust tokenNum
            } else { // if not equal-sign
                fileIn.unread(temp); // put it back, leaving tokenNum as 8
            }
        }
        
        return tokenNum;
    }
    
    /**
     * Continues reading a token from the stream which started with a letter.
     * @return  the numeric code for the token
     */
    private int startsAlpha() throws IOException, BufferOverflowException {
        int temp = -1, tokenNum = 7, i;
        char tmp;
        boolean getAnother = true;
        String checkStr;
        
        while(getAnother && (temp = fileIn.read()) >= 0) {
        // read in characters until EOF, or one is invalid for identifiers
            tmp = (char) temp;
            if(Character.isLetterOrDigit(tmp)) {
                tempChars.append(Character.toUpperCase(tmp));
            } else {
                getAnother = false;
            }
        }
        if(temp >= 0) { // if we didn't end on EOF
            fileIn.unread(temp); // put ender back in the stream
        }
        
        checkStr = tempChars.toString();
        if(RESERVED_WORDS.containsKey(checkStr)) {
            tokenNum = RESERVED_WORDS.get(checkStr);
        }
        
        return tokenNum;
    }
    
    /**
     * Continues reading a token from the stream which started with a digit.
     * @return  the numeric code for the token
     */
    private int startsDigit() throws IOException, BufferOverflowException {
        int temp = -1, tokenNum = 29, i;
        char tmp;
        boolean getAnother = true;
        
        while(getAnother && (temp = fileIn.read()) >= 0) {
        // read in more digits if there are any, until we get a non-digit
            tmp = (char) temp;
            if(Character.isDigit(tmp)) {
                tempChars.append(tmp);
            } else {
                getAnother = false;
            }
        }
        getAnother = true; // reset getAnother, so we can use it again
        
        if(temp == (int) '.') { // is the first non-digit a period?
            for(i = 0; getAnother && (temp = fileIn.read()) >= 0;) {
            // read in digits if there are any, until we get a non-digit
                tmp = (char) temp;
                if(Character.isDigit(tmp)) {
                    if(i == 0) {
                        tempChars.append('.'); // add the period first
                    }
                    tempChars.append(tmp);
                    i++; // count the digits
                } else {
                    getAnother = false;
                }
            }
            
            if(i == 0) { // if there was an immediate non-digit after the period
                if(temp >= 0) // if what's after the period is not EOF
                    fileIn.unread(temp); // ... put it back in the stream
                fileIn.unread('.'); // and then put back the period regardless
                garbageFlag = true; // ... and set the garbageFlag
                // The number token ends with only digits, and the following
                // period is marked as garbage
            } else { // if there was at least one digit after the period
                if(temp >= 0) { // we ended on something besides EOF?
                    fileIn.unread(temp); // if so, put it back
                }
                if(temp == (int) '.') { // was it another period?
                    garbageFlag = true; // ... if so, set the garbageFlag
                }
                // The number token ends having a decimal part, and if there's
                // a following period it's marked as garbage
            }
        } else { // if the first non-digit wasn't a period
            if(temp >= 0) // ... and also not EOF
                fileIn.unread(temp); // put it back in the stream
        } // the number token ends with only digits
        
        return tokenNum;
    }
    
    /**
     * Continues reading a token from the stream which started with '.'.
     * @return  the numeric code for the token
     */
    private int startsPeriod() throws IOException, BufferOverflowException {
        int temp, tokenNum = 0;
        char tmp;
        
        if(garbageFlag) { // if we previously flagged the period in the stream
            tokenNum = -1; // it's garbage
            garbageFlag = false; // reset the flag
        } else {
            temp = fileIn.read(); // read char after the period
            if(temp >= 0) {
                tmp = (char) temp;
                fileIn.unread(temp); // put following char back regardless

                if(Character.isDigit(tmp)) { // if a digit follows the period
                    tokenNum = -1; // it's garbage
                }
                // else leave tokenNum as 0
            }
        }
        
        return tokenNum;
    }
    
    /**
     * Continues reading a token from the stream which started with a character
     * with which tokens cannot start.
     * @return  the numeric code for the token
     */
    private int startsGarbage() throws IOException, BufferOverflowException {
        int temp = -1, tokenNum = -1;
        char tmp;
        boolean getAnother = true, foundMatch = false;
        
        while(getAnother && (temp = fileIn.read()) >= 0) {
        // read in characters until EOF
            tmp = (char) temp;
            if(Character.isLetterOrDigit(tmp) || Character.isWhitespace(tmp)) {
            // if alphanumeric start of token or whitespace
                getAnother = false; // stop looping
                fileIn.unread(temp); // put it back
            } else {
                for(int i = 0; !foundMatch && i < SPECIAL_STARTS.length; i++) {
                    if(tmp == SPECIAL_STARTS[i]) { // if valid start of token
                        getAnother = false; // stop outer loop
                        foundMatch = true; // stop inner loop
                        fileIn.unread(temp); // put it back
                    }
                }
                if(!foundMatch) { // if not valid start of token
                    tempChars.append(tmp); // add to garbage sequence
                }
            }
        }
        
        return tokenNum;
    }
    
    /**
     * Counts the number of instances of garbage read from the stream so far.
     * @return  the number of instances of garbage
     */
    public int countGarbage() {
        int result = 0;
        
        for(TokenPair token : tokenList) {
            if(token.getTokenNum() == -1) {
                result++;
            }
        }
        
        return result;
    }
    
    /**
     * Closes the stream belonging to the Tokenizer object.
     * @throws  IOException if cannot close fileIn
     */
    public void close() throws IOException {
        if(fileIn != null) {
            fileIn.close();
        }
    }
}
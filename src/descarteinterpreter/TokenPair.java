/**
 * CS3210: Descartes Interpreter assignment
 * @author Ben Boudra
 * @author Shelley King
 * @author William King
 */

package descarteinterpreter;

/**
 * Representation of a token in the language Descartes-2.
 */
public class TokenPair {    
    /** The text of the token as found in the file being parsed. */
    private final String tokenStr;
    /** The numeric code for the token. */
    private final int tokenNum;

    /**
     * Sole constructor.
     * @param   tokenStr    the text of the token as found in the file
     * @param   tokenNum    the numeric code for the token
     */
    public TokenPair(String tokenStr, int tokenNum) {
        this.tokenStr = tokenStr;
        this.tokenNum = tokenNum;
    }

    /**
     * @return              a string holding the text and numeric code of the
     *                      token
     */
    @Override
    public String toString() {
        return String.format("%-32s %2d", tokenStr, tokenNum);
    }
    
    /**
     * @return              accessor for the token's numeric code
     */
    public int getTokenNum() {
        return tokenNum;
    }
    
    /**
     * @return              accessor for the text of the token
     */
    public String getTokenString() {
        return tokenStr;
    }
}
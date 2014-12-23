package test.com.atslangplugin; 

import com.atslangplugin.ATSLexerAdapter;
import com.atslangplugin.ATSTokenTypes;
import com.intellij.psi.tree.IElementType;
import org.junit.Assert;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.io.StringReader;

/** 
* ATSLexerAdapter Tester. 
* 
* @author Brandon Elam Barker
* @since <pre>Dec 22, 2014</pre> 
* @version 1.0 
*/ 
public class ATSLexerAdapterTest {

String twoLinesATS = "/"+"/"+"This is a comment\n" + "int x =5;";
ATSLexerAdapter myLexerAdapter = null;

@Before
public void before() throws Exception {

    myLexerAdapter = new ATSLexerAdapter();
}

@After
public void after() throws Exception { 
}

/**
 *
 * @param charSeqATS
 *
 * An auxiliary method for scanning an entire
 * source code segment.
 *
 */
public void scanFile(CharSequence charSeqATS) {
    myLexerAdapter.start(charSeqATS);
    IElementType token;
    String tokenStr;
    int tokenCount = 0;
    while ((token = myLexerAdapter.getTokenType()) != ATSTokenTypes.EOF
            && tokenCount < 20)
    {
        tokenCount++;
        tokenStr = token.toString();
        Integer yyline = myLexerAdapter.getYyline();
        Integer yycol = myLexerAdapter.getYycolumn();
        System.out.println(tokenStr + " at " + yyline.toString() +
        ", " + yycol.toString());
        myLexerAdapter.advance();
    }
}

/**
 *
  * @throws Exception
 *
 * This is a simple test for correctness, making sure
 * several tokens are as expected.
 */
@Test
public void testAdvance() throws Exception {
    myLexerAdapter.start(twoLinesATS);

    IElementType token;
    String tokenStr;
    token = myLexerAdapter.getTokenType();
    //Assert.assertEquals(token, ATSTokenTypes.COMMENT);
    //
    myLexerAdapter.advance();
    token = myLexerAdapter.getTokenType();
    //Assert.assertEquals(token, ATSTokenTypes.INT);
    //


}

    /**
     *
     * @throws Exception
     *
     * Tests for completion of scanning several ATS2 files.
     *
     */
@Test
public void testAdvance2() throws Exception {
    scanFile(twoLinesATS);

}

} 

package test.com.atslangplugin; 

import com.atslangplugin.ATSLexerAdapter;
import com.atslangplugin.ATSTokenTypes;
import com.intellij.psi.tree.IElementType;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/** 
* ATSLexerAdapter Tester. 
* 
* @author Brandon Elam Barker
* @since <pre>Dec 22, 2014</pre> 
* @version 1.0 
*/ 
public class ATSLexerAdapterTest {

ATSLexerAdapter myLexerAdapter = null;
//
String twoLineATS_seq = "/"+"/"+"This is a comment\n" + "val x:int =5";
String coroutine_seq = "";

private static final String coroutinePath =
        "../../Resources/Coroutine/DATS/coroutine.dats";


@Before
public void before() throws Exception {

    myLexerAdapter = new ATSLexerAdapter();
    //
    coroutine_seq = readFile(getPath(coroutinePath), Charset.defaultCharset());

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
private void scanFile(CharSequence charSeqATS) {
    myLexerAdapter.start(charSeqATS);
    IElementType token;
    String tokenStr;
    int tokenCount = 0;
    while ((token = myLexerAdapter.getTokenType()) != ATSTokenTypes.EOF
            && tokenCount < 50000)
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

private static String readFile(String path, Charset encoding)
        throws IOException
{
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
}


private String getPath(String relPath) {
    String path = getClass().getResource(relPath).getPath();
    if (System.getProperty("os.name").startsWith("Windows")) {
        path = path.substring(1);
    }
    return path;
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
    myLexerAdapter.start(twoLineATS_seq);

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
    //scanFile(twoLineATS_seq);
    // How to reset the lexer here?
    scanFile(coroutine_seq);

}

} 

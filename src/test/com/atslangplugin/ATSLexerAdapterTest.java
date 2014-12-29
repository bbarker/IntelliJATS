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

String settingsPageDemo =
    "//\n" +
    "fun copyinto\n" +
    "  {n:nat} .<n>.\n" +
    "(\n" +
    "  xs: !list_vt (a, n), p: ptr\n" +
    ") :<!wrt> void = let\n" +
    "in\n" +
    "//\n" +
    "case+ xs of\n" +
    "| @list_vt_cons\n" +
    "    (x, xs1) => let\n" +
    "    val (\n" +
    "    ) = $UN.ptr0_set<a> (addr@(x), $UN.ptr0_get<a> (p))\n" +
    "    val () = copyinto (xs1, ptr0_succ<a> (p))\n" +
    "  in\n" +
    "    fold@ (xs)\n" +
    "  end // end of [list_vt_cons]\n" +
    "| list_vt_nil ((*void*)) => ()\n" +
    "//\n" +
    "end // end of [copyinto]\n" +
    "//\n" +
    "implement\n" +
    "array_quicksort$cmp<a>\n" +
    "  (x1, x2) = list_vt_quicksort$cmp<a> (x1, x2)\n" +
    "// end of [array_quicksort$cmp]\n" +
    "//\n" +
    "prval () = lemma_list_vt_param (xs)\n" +
    "//\n" +
    "val n = list_vt_length (xs)\n" +
    "//\n" +
    "val [l:addr]\n" +
    "  (pfat, pfgc | p0) = array_ptr_alloc<a> ((i2sz)n)\n" +
    "//\n" +
    "extern praxi\n" +
    "__out (pf: !array_v (a?, l, n) >> array_v (a, l, n)): void\n" +
    "extern praxi\n" +
    "__into (pf: !array_v (a, l, n) >> array_v (a?, l, n)): void\n" +
    "//\n" +
    "val () = copyout (xs, p0)\n" +
    "prval () = __out (pfat)\n" +
    "val () = array_quicksort<a> (!p0, (i2sz)n)\n" +
    "prval () = __into (pfat)\n" +
    "val () = copyinto (xs, p0)\n" +
    "//\n" +
    "val () = array_ptr_free {a} (pfat, pfgc | p0)\n" +
    "//\n" +
    "in\n" +
    "  xs\n" +
    "end // end of [list_vt_quicksort]\n" +
    "\n" +
    "(* ****** ****** *)\n";

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
    //scanFile(coroutine_seq);
    scanFile(settingsPageDemo);

}

} 

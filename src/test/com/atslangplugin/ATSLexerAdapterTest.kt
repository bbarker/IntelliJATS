package test.com.atslangplugin

import com.intellij.psi.tree.IElementType
import org.junit.Test
import org.junit.Before
import org.junit.After

import java.io.File
import java.io.FileReader
import java.io.IOException
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

import com.atslangplugin.ATSLexerAdapter
import com.atslangplugin.Utils.*
import kotlin.properties.Delegates

/**
 * ATSLexerAdapter Tester.

 * @author Brandon Elam Barker
* *
 * @since Dec 22, 2014
* *
 * @version 1.0
 */
public class ATSLexerAdapterTest {

    var myLexerAdapter: ATSLexerAdapter? = null
    //
    var twoLineATS_seq = "/" + "/" + "This is a comment\n" + "val x:int =5"

    var settingsPageDemo = getFileAsString<ATSLexerAdapterTest>(list_vt_quicksort_Path)

    var coroutine_seq = ""

    Before
    throws(javaClass<Exception>())
    public fun before() {

        myLexerAdapter = ATSLexerAdapter()
        //
        coroutine_seq = getFileAsString<ATSLexerAdapterTest>(coroutinePath)

    }

    After
    throws(javaClass<Exception>())
    public fun after() {
    }



    /**

     * @throws Exception
    * *
    * * This is a simple test for correctness, making sure
    * * several tokens are as expected.
     */
    Test
    throws(javaClass<Exception>())
    public fun testAdvance() {
        myLexerAdapter!!.start(twoLineATS_seq)

        var token: IElementType
        val tokenStr: String
        token = myLexerAdapter!!.getTokenType()
        //Assert.assertEquals(token, ATSTokenTypes.COMMENT);
        //
        myLexerAdapter!!.advance()
        token = myLexerAdapter!!.getTokenType()
        //Assert.assertEquals(token, ATSTokenTypes.INT);
        //


    }

    /**

     * @throws Exception
    * *
    * * Tests for completion of scanning several ATS2 files.
     */
    Test
    throws(javaClass<Exception>())
    public fun testAdvance2() {
        //scanFile(twoLineATS_seq);
        // How to reset the lexer here?
        //scanFile(coroutine_seq);
        scanFile(myLexerAdapter, settingsPageDemo)

    }

    companion object {

        val coroutinePath: String = "test/Resources/Coroutine/DATS/coroutine.dats"

        val list_vt_quicksort_Path: String = "test/Resources/list_vt_quicksort.dats"

    }

} 

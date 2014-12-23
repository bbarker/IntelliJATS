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

@Test
public void testAdvance() throws Exception {
    myLexerAdapter.start(twoLinesATS);

    IElementType token;
    String tokenStr;
    token = myLexerAdapter.getTokenType();
    //Assert.assertEquals(token, ATSTokenTypes.COMMENT);
    tokenStr = token.toString();
    System.out.println(tokenStr);
    //
    myLexerAdapter.advance();
    token = myLexerAdapter.getTokenType();
    //Assert.assertEquals(token, ATSTokenTypes.INT);
    tokenStr = token.toString();
    System.out.println(tokenStr);

}



} 

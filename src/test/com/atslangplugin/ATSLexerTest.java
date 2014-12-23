package test.com.atslangplugin;

// !!! This test is deprecated, see:
// https://devnet.jetbrains.com/message/5531516#5531516

import com.atslangplugin.ATSTokenTypes;
import com.intellij.psi.tree.IElementType;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

import com.atslangplugin.ATSLexer;

import java.io.File;

/** 
* ATSLexer Tester. 
* 
* @author Brandon Elam Barker
* @since <pre>Dec 21, 2014</pre> 
* @version 1.0 
*/

@Deprecated
public class ATSLexerTest { 

   private static final String coroutinePath =
           "../../Resources/Coroutine/DATS/coroutine.dats";
   private File coroutineFile;
   private java.io.Reader coroutineReader;
   private ATSLexer coroutineLexer;

@Before // Before each test
public void before() throws Exception {
//   coroutineFile = new File(getClass().getResource(coroutinePath).getFile());
//   coroutineReader = new java.io.FileReader(coroutineFile);
//   coroutineLexer = new ATSLexer(coroutineReader);
//

}

@After // After each test
public void after() throws Exception {
}

/** 
* 
* Method: getTokenStart() 
* 
*/ 
@Test
public void testGetTokenStart() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getTokenEnd() 
* 
*/ 
@Test
public void testGetTokenEnd() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: reset(CharSequence buffer, int start, int end, int initialState) 
* 
*/ 
@Test
public void testReset() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: yystate() 
* 
*/ 
@Test
public void testYystate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: yybegin(int newState) 
* 
*/ 
@Test
public void testYybegin() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: yytext() 
* 
*/ 
@Test
public void testYytext() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: yycharat(int pos) 
* 
*/ 
@Test
public void testYycharat() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: yylength() 
* 
*/ 
@Test
public void testYylength() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: yypushback(int number) 
* 
*/ 
@Test
public void testYypushback() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: advance() 
* 
*/ 
@Test
public void testAdvance() throws Exception {

   IElementType token;
   int i = 0;
   coroutineReader = new java.io.StringReader("/"+"/"+"This is a comment" +
           "int x =5;");
   coroutineLexer = new ATSLexer(coroutineReader);
   System.out.println(coroutineLexer.yylength());
   token = coroutineLexer.advance();
   /*
   while ((token = coroutineLexer.advance()) != ATSTypes.EOF) {
      i = i + 1;
      System.out.print(i);
      System.out.print(": ");
      System.out.println(token.toString());
      break;
   }
   */
   System.out.println(coroutineLexer.yylength());
   System.out.println(token.toString());

   // Temp test:
   char[] mycbuf = new char[100];
   coroutineReader.read(mycbuf,0,99);
   System.out.println(mycbuf);
} 


/** 
* 
* Method: zzUnpackAction() 
* 
*/ 
@Test
public void testZzUnpackAction() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackAction"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackAction(String packed, int offset, int [] result) 
* 
*/ 
@Test
public void testZzUnpackActionForPackedOffsetResult() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackAction", String.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackRowMap() 
* 
*/ 
@Test
public void testZzUnpackRowMap() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackRowMap"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackRowMap(String packed, int offset, int [] result) 
* 
*/ 
@Test
public void testZzUnpackRowMapForPackedOffsetResult() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackRowMap", String.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackTrans() 
* 
*/ 
@Test
public void testZzUnpackTrans() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackTrans"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackTrans(String packed, int offset, int [] result) 
* 
*/ 
@Test
public void testZzUnpackTransForPackedOffsetResult() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackTrans", String.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackAttribute() 
* 
*/ 
@Test
public void testZzUnpackAttribute() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackAttribute"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackAttribute(String packed, int offset, int [] result) 
* 
*/ 
@Test
public void testZzUnpackAttributeForPackedOffsetResult() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackAttribute", String.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzUnpackCMap(String packed) 
* 
*/ 
@Test
public void testZzUnpackCMap() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzUnpackCMap", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzRefill() 
* 
*/ 
@Test
public void testZzRefill() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzRefill"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzScanError(int errorCode) 
* 
*/ 
@Test
public void testZzScanError() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzScanError", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: zzDoEOF() 
* 
*/ 
@Test
public void testZzDoEOF() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ATSLexer.getClass().getMethod("zzDoEOF"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 

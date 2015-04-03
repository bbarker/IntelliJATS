package com.atslangplugin.Utils

import com.atslangplugin.ATSLexer
import com.atslangplugin.ATSLexerAdapter
import com.atslangplugin.ATSTokenTypes
import com.intellij.psi.tree.IElementType
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.net.URLEncoder
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Created by Brandon Elam Barker on 3/22/2015.
 */

/**

 * @param charSeqATS
* *
* * An auxiliary method for scanning an entire
* * source code segment.
 */
fun scanFile(myLexerAdapter: ATSLexerAdapter?, charSeqATS: CharSequence) {
    myLexerAdapter!!.start(charSeqATS)
    val token: IElementType
    val tokenStr: String
    var tokenCount = 0
    do {
        token = myLexerAdapter.getTokenType()
        tokenCount++
        tokenStr = token.toString()
        val yyline = myLexerAdapter.getYyline()
        val yycol = myLexerAdapter.getYycolumn()
        System.out.println(tokenStr + " at " + yyline.toString() + ", " + yycol.toString())
        myLexerAdapter.advance()
    } while (token != ATSTokenTypes.EOF && tokenCount < 50000 /* FIXME ?? */)
}

inline fun getFileAsString<reified T>(relPath: String): String {
    val fileStream = javaClass<T>().getClassLoader().getResourceAsStream(relPath)
    val fileReader: InputStreamReader? = fileStream.reader()
    val path: String? = javaClass<T>().getClassLoader().getResource(relPath)?.getPath()
    println(path ?: "File not found!" )
    return fileReader?.readText() ?: "// error: file not found or null"
}

throws(javaClass<IOException>())
fun readFile(path: String, encoding: Charset): String {
    val encoded = Files.readAllBytes(Paths.get(path))
    return String(encoded, encoding)
}
package com.atslangplugin


import com.atslangplugin.Utils.getFileAsString
import com.atslangplugin.Utils.readFile
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

import javax.swing.*
import java.awt.*
import java.io.Reader

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import java.nio.charset.Charset


/**
 * Created by Brandon Elam Barker on 12/21/2014.
 */

public class ATSColorSettingsPage : ColorSettingsPage {

    override fun getIcon(): Icon? {
        return ATSIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return ATSSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        val list_vt_quicksort_Path = "/com/resources/list_vt_quicksort.dats"
        val demoFileTxt = getFileAsString<ATSLexer>(list_vt_quicksort_Path)
        return demoFileTxt
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "ATS"
    }

    companion object {
        private val DESCRIPTORS = array(
                AttributesDescriptor("Block comments", ATSSyntaxHighlighter.ATS_BLOCK_COMMENT),
                AttributesDescriptor("Braces", ATSSyntaxHighlighter.ATS_BRACES),
                AttributesDescriptor("Brackets", ATSSyntaxHighlighter.ATS_BRACKETS),
                AttributesDescriptor("Commas", ATSSyntaxHighlighter.ATS_COMMA),
                AttributesDescriptor("Directives", ATSSyntaxHighlighter.ATS_DIRECTIVES), AttributesDescriptor("Identifiers", ATSSyntaxHighlighter.ATS_IDENTIFIER), AttributesDescriptor("Line comments", ATSSyntaxHighlighter.ATS_LINE_COMMENT), AttributesDescriptor("Keywords", ATSSyntaxHighlighter.ATS_KEYWORD), AttributesDescriptor("Local variables", ATSSyntaxHighlighter.ATS_LOCAL_VARIABLE), AttributesDescriptor("Numbers", ATSSyntaxHighlighter.ATS_NUMBER), AttributesDescriptor("Operators", ATSSyntaxHighlighter.ATS_OPERATION_SIGN), AttributesDescriptor("Parentheses", ATSSyntaxHighlighter.ATS_PARENTHESES), AttributesDescriptor("Semicolons", ATSSyntaxHighlighter.ATS_SEMICOLON), AttributesDescriptor("Strings", ATSSyntaxHighlighter.ATS_STRING), AttributesDescriptor("Type declarations", ATSSyntaxHighlighter.ATS_TYPE_DECLARATIONS),
                AttributesDescriptor("Val, Fun declarations", ATSSyntaxHighlighter.ATS_VAL_DECLARATIONS))
    }
}

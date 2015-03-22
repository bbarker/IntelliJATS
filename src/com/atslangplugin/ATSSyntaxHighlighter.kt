package com.atslangplugin

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

import java.io.Reader
import java.util.HashMap

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

/**
 * Created by Brandon Elam Barker on 12/21/2014.
 */
public class ATSSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return FlexAdapter(ATSLexer(null as? Reader))
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey>? {

        val tokenColor: Array<TextAttributesKey>? = tokenColorMap.get(tokenType)
        return tokenColor ?: EMPTY_KEYS
    }

    companion object {

        // Coloring BAD_CHARACTERs seems to cause a runtime error
        //
        private val EMPTY_KEYS = array<TextAttributesKey>()
        //

        //
        public val ATS_BLOCK_COMMENT: TextAttributesKey = createTextAttributesKey("BLOCK_COMMENT", BLOCK_COMMENT)
        private val ATS_BLOCK_COMMENT_KEYS = array<TextAttributesKey>(ATS_BLOCK_COMMENT)
        //
        public val ATS_BRACES: TextAttributesKey = createTextAttributesKey("BRACES", BRACES)
        private val ATS_BRACES_KEYS = array<TextAttributesKey>(ATS_BRACES)
        //
        public val ATS_BRACKETS: TextAttributesKey = createTextAttributesKey("BRACKETS", BRACKETS)
        private val ATS_BRACKETS_KEYS = array<TextAttributesKey>(ATS_BRACKETS)
        //
        public val ATS_COMMA: TextAttributesKey = createTextAttributesKey("COMMA", COMMA)
        private val ATS_COMMA_KEYS = array<TextAttributesKey>(ATS_COMMA)
        //
        public val ATS_DIRECTIVES: TextAttributesKey = createTextAttributesKey("DIRECTIVES", PREDEFINED_SYMBOL)
        private val ATS_DIRECTIVES_KEYS = array<TextAttributesKey>(ATS_DIRECTIVES)
        //
        public val ATS_FUNCTION_CALL: TextAttributesKey = createTextAttributesKey("FUNCTION_CALL", FUNCTION_CALL)
        private val ATS_FUNCTION_CALL_KEYS = array<TextAttributesKey>(ATS_FUNCTION_CALL)
        //
        public val ATS_IDENTIFIER: TextAttributesKey = createTextAttributesKey("IDENTIFIER", IDENTIFIER)
        private val ATS_IDENTIFIER_KEYS = array<TextAttributesKey>(ATS_IDENTIFIER)
        //
        public val ATS_LINE_COMMENT: TextAttributesKey = createTextAttributesKey("LINE_COMMENT", LINE_COMMENT)
        private val ATS_LINE_COMMENT_KEYS = array<TextAttributesKey>(ATS_LINE_COMMENT)
        //
        public val ATS_KEYWORD: TextAttributesKey = createTextAttributesKey("KEYWORD", KEYWORD)
        private val ATS_KEYWORD_KEYS = array<TextAttributesKey>(ATS_KEYWORD)
        //
        public val ATS_LOCAL_VARIABLE: TextAttributesKey = createTextAttributesKey("LOCAL_VARIABLE", LOCAL_VARIABLE)
        private val ATS_LOCAL_VARIABLE_KEYS = array<TextAttributesKey>(ATS_LOCAL_VARIABLE)
        //
        public val ATS_NUMBER: TextAttributesKey = createTextAttributesKey("NUMBER", NUMBER)
        private val ATS_NUMBER_KEYS = array<TextAttributesKey>(ATS_NUMBER)
        //
        public val ATS_OPERATION_SIGN: TextAttributesKey = createTextAttributesKey("OPERATION_SIGN", OPERATION_SIGN)
        private val ATS_OPERATION_SIGN_KEYS = array<TextAttributesKey>(ATS_OPERATION_SIGN)
        //
        public val ATS_PARENTHESES: TextAttributesKey = createTextAttributesKey("PARENTHESES", PARENTHESES)
        private val ATS_PARENTHESES_KEYS = array<TextAttributesKey>(ATS_PARENTHESES)
        //
        public val ATS_SEMICOLON: TextAttributesKey = createTextAttributesKey("SEMICOLON", SEMICOLON)
        private val ATS_SEMICOLON_KEYS = array<TextAttributesKey>(ATS_SEMICOLON)
        //
        public val ATS_STRING: TextAttributesKey = createTextAttributesKey("STRING", STRING)
        private val ATS_STRING_KEYS = array<TextAttributesKey>(ATS_STRING)
        //
        public val ATS_TYPE_DECLARATIONS: TextAttributesKey = createTextAttributesKey("TYPE_DECLARATIONS", FUNCTION_DECLARATION)
        private val ATS_TYPE_DECLARATIONS_KEYS = array<TextAttributesKey>(ATS_TYPE_DECLARATIONS)
        //
        public val ATS_VAL_DECLARATIONS: TextAttributesKey = createTextAttributesKey("VAL_DECLARATIONS", INSTANCE_FIELD)
        private val ATS_VAL_DECLARATIONS_KEYS = array<TextAttributesKey>(ATS_VAL_DECLARATIONS)
        //

        public val tokenColorMap: Map<IElementType, Array<TextAttributesKey>>

        init {
            val tmpMap = HashMap<IElementType, Array<TextAttributesKey>>()
            tmpMap.put(ATSTokenTypes.ABSTYPE, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.ADDRAT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.AND, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.AS, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.ASSUME, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.AT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.ATLBRACE, ATS_BRACES_KEYS)
            tmpMap.put(ATSTokenTypes.ATLPAREN, ATS_BRACES_KEYS)
            tmpMap.put(ATSTokenTypes.BACKSLASH, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.BANG, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.BAR, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.BEGIN, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.BQUOTE, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.CASE, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.CHAR, ATS_STRING_KEYS)
            tmpMap.put(ATSTokenTypes.CLASSDEC, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.COLON, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.COLONLT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.COMMA, ATS_COMMA_KEYS)
            tmpMap.put(ATSTokenTypes.COMMALPAREN, ATS_PARENTHESES_KEYS)
            tmpMap.put(ATSTokenTypes.COMMENT_BLOCK, ATS_BLOCK_COMMENT_KEYS)
            tmpMap.put(ATSTokenTypes.COMMENT_LINE, ATS_LINE_COMMENT_KEYS)
            tmpMap.put(ATSTokenTypes.COMMENT_REST, ATS_BLOCK_COMMENT_KEYS)
            // Do not want to color CRLF
            tmpMap.put(ATSTokenTypes.DATASORT, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.DLRARRPSZ, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.DLRBREAK, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRCONTINUE, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRDELAY, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLREFFMASK, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLREFFMASK_ARG, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.DLREXTERN, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLREXTFCALL, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLREXTVAL, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLREXTYPE, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLREXTYPE_STRUCT, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRLST, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRMYFILENAME, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRMYFILENAME, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRMYLOCATION, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRRAISE, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRREC, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRSHOWTYPE, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRTUP, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRTEMPENVER, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DLRVCOPYENV, ATS_FUNCTION_CALL_KEYS)
            tmpMap.put(ATSTokenTypes.DO, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.DOLLAR, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.DOT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.DOTDOT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.DOTDOTDOT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.DOTINT, ATS_OPERATION_SIGN_KEYS) // what is it?
            tmpMap.put(ATSTokenTypes.DOTLT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.DOTLTGTDOT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.DYNLOAD, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.ELSE, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.END, ATS_KEYWORD_KEYS)
            // don't color EOF
            tmpMap.put(ATSTokenTypes.EQ, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.EQGT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.EQGTGT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.EQLT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.EQLTGT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.EQSLASHEQGT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.EQSLASHEQGTGT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.EXCEPTION, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.EXTCODE, ATS_BRACES_KEYS)
            tmpMap.put(ATSTokenTypes.EXTERN, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.EXTVAR, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.FIX, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.FIXITY, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.FLOAT, ATS_NUMBER_KEYS)
            tmpMap.put(ATSTokenTypes.FOLDAT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.FORSTAR, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.FREEAT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.FUN, ATS_VAL_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.GT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.GTDOT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.GTLT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.HASH, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.HASHLBRACKETOLON, ATS_BRACKETS_KEYS)
            tmpMap.put(ATSTokenTypes.IDENTIFIER, ATS_IDENTIFIER_KEYS)
            tmpMap.put(ATSTokenTypes.IF, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.IMPLEMENT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.IMPORT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.IN, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.INT, ATS_NUMBER_KEYS)
            tmpMap.put(ATSTokenTypes.LAM, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.LBRACE, ATS_BRACES_KEYS)
            tmpMap.put(ATSTokenTypes.LBRACKET, ATS_BRACKETS_KEYS)
            tmpMap.put(ATSTokenTypes.LET, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.LOCAL, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.LPAREN, ATS_PARENTHESES_KEYS)
            tmpMap.put(ATSTokenTypes.LT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.MACDEF, ATS_VAL_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.MINUSGT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.MINUSLT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.MINUSLTGT, ATS_KEYWORD_KEYS)
            // NONE isn't used here
            tmpMap.put(ATSTokenTypes.NONFIX, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.OF, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.OP, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.OVERLOAD, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.PERCENT, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.PERCENTLPAREN, ATS_PARENTHESES_KEYS)
            tmpMap.put(ATSTokenTypes.QMARK, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.QUOTELBRACE, ATS_BRACES_KEYS)
            tmpMap.put(ATSTokenTypes.QUOTELBRACKET, ATS_BRACKETS_KEYS)
            tmpMap.put(ATSTokenTypes.QUOTELPAREN, ATS_PARENTHESES_KEYS)
            tmpMap.put(ATSTokenTypes.RBRACE, ATS_BRACES_KEYS)
            tmpMap.put(ATSTokenTypes.RBRACKET, ATS_BRACES_KEYS)
            tmpMap.put(ATSTokenTypes.REC, ATS_TYPE_DECLARATIONS_KEYS) // recursive
            tmpMap.put(ATSTokenTypes.REFAT, ATS_FUNCTION_CALL_KEYS) // CHECK_ME
            tmpMap.put(ATSTokenTypes.REF_IDENTIFIER, ATS_IDENTIFIER_KEYS)
            tmpMap.put(ATSTokenTypes.REQUIRE, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.RPAREN, ATS_PARENTHESES_KEYS)
            tmpMap.put(ATSTokenTypes.SCASE, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.SEMICOLON, ATS_SEMICOLON_KEYS)
            tmpMap.put(ATSTokenTypes.SIF, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.SORTDEF, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.SRPASSERT, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPDEFINE, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPELIF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPELIFDEF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPELIFNDEF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPELSE, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPENDIF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPERROR, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPIF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPIFDEF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPIFNDEF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPINCLUDE, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPPRINT, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPTHEN, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.SRPUNDEF, ATS_DIRECTIVES_KEYS)
            tmpMap.put(ATSTokenTypes.STACST, ATS_VAL_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.STADEF, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.STALOAD, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.STATIC, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.STRING, ATS_STRING_KEYS)
            tmpMap.put(ATSTokenTypes.SYMELIM, ATS_VAL_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.SYMINTR, ATS_VAL_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.THEN, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.TILDE, ATS_OPERATION_SIGN_KEYS)
            tmpMap.put(ATSTokenTypes.TKINDEF, ATS_VAL_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.TRY, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.TYPE, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.TYPEDEF, ATS_TYPE_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.VAL, ATS_VAL_DECLARATIONS_KEYS)
            tmpMap.put(ATSTokenTypes.VAL_IDENTIFIER, ATS_IDENTIFIER_KEYS)
            tmpMap.put(ATSTokenTypes.VIEWAT, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.WHEN, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.WHERE, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.WHILE, ATS_KEYWORD_KEYS)
            // do not color WHITESPACE
            tmpMap.put(ATSTokenTypes.WHILESTAR, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.WITH, ATS_KEYWORD_KEYS)
            tmpMap.put(ATSTokenTypes.WITHTYPE, ATS_KEYWORD_KEYS)

            tokenColorMap = tmpMap
        }
    }
}

package com.atslangplugin;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by Brandon Elam Barker on 12/21/2014.
 */
public class ATSSyntaxHighlighter extends SyntaxHighlighterBase {


    //
    public static final TextAttributesKey ATS_BLOCK_COMMENT =
            createTextAttributesKey("BLOCK_COMMENT", BLOCK_COMMENT);
    private static final TextAttributesKey[] ATS_BLOCK_COMMENT_KEYS =
            new TextAttributesKey[]{ATS_BLOCK_COMMENT};
    //
    public static final TextAttributesKey ATS_BRACES =
            createTextAttributesKey("BRACES", BRACES);
    private static final TextAttributesKey[] ATS_BRACES_KEYS =
            new TextAttributesKey[]{ATS_BRACES};
    //
    public static final TextAttributesKey ATS_IDENTIFIER =
            createTextAttributesKey("IDENTIFIER", IDENTIFIER);
    private static final TextAttributesKey[] ATS_IDENTIFIER_KEYS =
            new TextAttributesKey[]{ATS_IDENTIFIER};
    //
    public static final TextAttributesKey ATS_LINE_COMMENT =
            createTextAttributesKey("LINE_COMMENT", LINE_COMMENT);
    private static final TextAttributesKey[] ATS_LINE_COMMENT_KEYS =
            new TextAttributesKey[]{ATS_LINE_COMMENT};
    //
    public static final TextAttributesKey ATS_KEYWORD =
            createTextAttributesKey("KEYWORD", KEYWORD);
    private static final TextAttributesKey[] ATS_KEYWORD_KEYS =
            new TextAttributesKey[]{ATS_KEYWORD};
    //
    public static final TextAttributesKey ATS_LOCAL_VARIABLE =
            createTextAttributesKey("LOCAL_VARIABLE", LOCAL_VARIABLE);
    private static final TextAttributesKey[] ATS_LOCAL_VARIABLE_KEYS =
            new TextAttributesKey[]{ATS_LOCAL_VARIABLE};
    //
    public static final TextAttributesKey ATS_OPERATION_SIGN =
            createTextAttributesKey("OPERATION_SIGN", OPERATION_SIGN);
    private static final TextAttributesKey[] ATS_OPERATION_SIGN_KEYS =
            new TextAttributesKey[]{ATS_OPERATION_SIGN};
    //
    public static final TextAttributesKey ATS_PARENTHESES =
            createTextAttributesKey("PARENTHESES", PARENTHESES);
    private static final TextAttributesKey[] ATS_PARENTHESES_KEYS =
            new TextAttributesKey[]{ATS_PARENTHESES};
    //
    public static final TextAttributesKey ATS_TYPE_DECLARATIONS =
            createTextAttributesKey("TYPE_DECLARATIONS", LABEL);
    private static final TextAttributesKey[] ATS_TYPE_DECLARATIONS_KEYS =
            new TextAttributesKey[]{ATS_TYPE_DECLARATIONS};
    //

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new ATSLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ATSTokenTypes.ABSTYPE)) {
            return ATS_TYPE_DECLARATIONS_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.ADDRAT)) {
            return ATS_KEYWORD_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.AND)) {
            return ATS_OPERATION_SIGN_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.AS)) {
            return ATS_KEYWORD_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.ASSUME)) {
            return ATS_TYPE_DECLARATIONS_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.AT)) {
            return ATS_OPERATION_SIGN_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.ATLBRACE)) {
            return ATS_BRACES_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.ATLPAREN)) {
            return ATS_PARENTHESES_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.COMMENT_BLOCK)) {
            return ATS_BLOCK_COMMENT_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.COMMENT_LINE)) {
            return ATS_LINE_COMMENT_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.IDENTIFIER)) {
            return ATS_IDENTIFIER_KEYS;
        } else {
            return ATS_LOCAL_VARIABLE_KEYS;
        }
    }
}

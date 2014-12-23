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
    public static final TextAttributesKey ATS_IDENTIFIER =
            createTextAttributesKey("IDENTIFIER", IDENTIFIER);
    public static final TextAttributesKey ATS_BLOCK_COMMENT =
            createTextAttributesKey("BLOCK_COMMENT", BLOCK_COMMENT);
    public static final TextAttributesKey ATS_LOCAL_VARIABLE =
            createTextAttributesKey("LOCAL_VARIABLE", LOCAL_VARIABLE);

    /*
    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER",
            new TextAttributes(Color.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    */
    private static final TextAttributesKey[] ATS_IDENTIFIER_KEYS =
            new TextAttributesKey[]{ATS_IDENTIFIER};
    private static final TextAttributesKey[] ATS_BLOCK_COMMENT_KEYS =
            new TextAttributesKey[]{ATS_BLOCK_COMMENT};
    private static final TextAttributesKey[] ATS_LOCAL_VARIABLE_KEYS =
            new TextAttributesKey[]{ATS_LOCAL_VARIABLE};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new ATSLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ATSTokenTypes.IDENTIFIER)) {
            return ATS_IDENTIFIER_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.COMMENT_LINE)) {
            return ATS_BLOCK_COMMENT_KEYS;
        } else if (tokenType.equals(ATSTokenTypes.COMMENT)) {
            return ATS_BLOCK_COMMENT_KEYS;
        } else {
            return new TextAttributesKey[]{LOCAL_VARIABLE};
        }
    }
}

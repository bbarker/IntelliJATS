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
    public static final TextAttributesKey ATS_BLOCK_COMMENT =
            createTextAttributesKey("BLOCK_COMMENT", BLOCK_COMMENT);
    public static final TextAttributesKey ATS_LOCAL_VARIABLE =
            createTextAttributesKey("LOCAL_VARIABLE", LOCAL_VARIABLE);


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new ATSLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ATSTypes.COMMENT)) {
            return new TextAttributesKey[]{BLOCK_COMMENT};
        } else {
            return new TextAttributesKey[]{LOCAL_VARIABLE};
        }
    }
}

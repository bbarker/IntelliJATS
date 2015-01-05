package com.atslangplugin;


import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.Reader;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by Brandon Elam Barker on 12/21/2014.
 */

public class ATSColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Block comments", ATSSyntaxHighlighter.ATS_BLOCK_COMMENT),
            new AttributesDescriptor("Braces", ATSSyntaxHighlighter.ATS_BRACES),
            new AttributesDescriptor("Identifiers", ATSSyntaxHighlighter.ATS_IDENTIFIER),
            new AttributesDescriptor("Line comments", ATSSyntaxHighlighter.ATS_LINE_COMMENT),
            new AttributesDescriptor("Keywords", ATSSyntaxHighlighter.ATS_KEYWORD),
            new AttributesDescriptor("Local variables", ATSSyntaxHighlighter.ATS_LOCAL_VARIABLE),
            new AttributesDescriptor("Operator", ATSSyntaxHighlighter.ATS_OPERATION_SIGN),
            new AttributesDescriptor("Parentheses", ATSSyntaxHighlighter.ATS_PARENTHESES),
            new AttributesDescriptor("Type declarations", ATSSyntaxHighlighter.ATS_TYPE_DECLARATIONS)

    };

    @Nullable
    @Override
    public Icon getIcon() {
        return ATSIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new ATSSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "//\n" +
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
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "ATS";
    }
}

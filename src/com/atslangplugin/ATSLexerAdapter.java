package com.atslangplugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by Brandon Elam Barker on 12/20/2014.
 */
public class ATSLexerAdapter extends FlexAdapter {

    public ATSLexerAdapter() {
        super(new ATSLexer((Reader) null));
    }
}

package com.atslangplugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by Brandon Elam Barker on 12/20/2014.
 */
public class ATSLexerAdapter extends FlexAdapter {

    private ATSLexer myFlex = null;
    public ATSLexerAdapter() {
        super( new ATSLexer((Reader) null) );
        myFlex = (ATSLexer) this.getFlex();
    }

    public int getYyline() { return myFlex.getYyline(); }
    public int getYycolumn() { return myFlex.getYycolumn(); }
}

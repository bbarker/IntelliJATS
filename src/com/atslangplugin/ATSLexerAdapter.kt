package com.atslangplugin

import com.intellij.lexer.FlexAdapter

import java.io.Reader
import kotlin.properties.Delegates

/**
 * Created by Brandon Elam Barker on 12/20/2014.
 */
public class ATSLexerAdapter : FlexAdapter(ATSLexer(null:Reader?)) {

    private var myFlex: ATSLexer? = null

    {
        myFlex = this.getFlex() as ATSLexer
    }

    public fun getYyline(): Int {
        return myFlex!!.getYyline()
    }

    public fun getYycolumn(): Int {
        return myFlex!!.getYycolumn()
    }
}

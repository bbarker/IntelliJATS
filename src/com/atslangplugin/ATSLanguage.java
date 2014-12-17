package com.atslangplugin;


import com.intellij.lang.Language;


/**
 * Created by brandon on 12/16/14.
 */
public class ATSLanguage extends Language {
    public static final ATSLanguage INSTANCE = new
            ATSLanguage();

    private ATSLanguage() {
        super("ATS");
    }
}

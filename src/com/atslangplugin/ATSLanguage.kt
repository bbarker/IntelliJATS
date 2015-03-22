package com.atslangplugin


import com.intellij.lang.Language


/**
 * Created by brandon on 12/16/14.
 */
public class ATSLanguage private() : Language("ATS") {
    companion object {
        public val INSTANCE: ATSLanguage = ATSLanguage()
    }
}

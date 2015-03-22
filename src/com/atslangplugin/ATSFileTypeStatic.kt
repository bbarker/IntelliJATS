package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.*

/**
 * Created by brandon on 12/16/14.
 */
public class ATSFileTypeStatic private() : LanguageFileType(ATSLanguage.INSTANCE) {

    override fun getName(): String {
        return "sats file"
    }

    override fun getDescription(): String {
        return "Static Applied Type System (ATS) language file"
    }

    override fun getDefaultExtension(): String {
        return "sats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.FILE
    }

    companion object {
        public val INSTANCE: ATSFileTypeStatic = ATSFileTypeStatic()
    }
}

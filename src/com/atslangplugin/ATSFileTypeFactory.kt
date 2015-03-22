package com.atslangplugin

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileTypes.*

import java.util.ArrayList

/**
 * Created by brandon on 12/17/14.
 */
public class ATSFileTypeFactory : FileTypeFactory() {

    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        val matcherList = ArrayList<FileNameMatcher>()

        val ATSSourceExtensions = ArrayList<String>(3)
        ATSSourceExtensions.add(0, ATSFileTypeDynamic.INSTANCE.getDefaultExtension())
        ATSSourceExtensions.add(1, ATSFileTypeStatic.INSTANCE.getDefaultExtension())
        ATSSourceExtensions.add(2, ATSFileTypeInclude.INSTANCE.getDefaultExtension())

        for (s in ATSSourceExtensions) {
            matcherList.add(ExtensionFileNameMatcher(s))
        }

        fileTypeConsumer.consume(ATSFileTypeDynamic.INSTANCE, *matcherList.toArray<FileNameMatcher>(arrayOfNulls<FileNameMatcher>(matcherList.size())))
        matcherList.clear()
        // Could now include support for other file matching procedures,
        // like exact file names
    }
}

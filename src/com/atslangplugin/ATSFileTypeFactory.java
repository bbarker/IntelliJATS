package com.atslangplugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileTypes.*;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brandon on 12/17/14.
 */
public class ATSFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        List<FileNameMatcher> matcherList = new ArrayList<FileNameMatcher>();

        List<String> ATSSourceExtensions= new ArrayList<String>(3);
        ATSSourceExtensions.add(0, ATSFileTypeDynamic.INSTANCE.getDefaultExtension());
        ATSSourceExtensions.add(1, ATSFileTypeStatic.INSTANCE.getDefaultExtension());
        ATSSourceExtensions.add(2, ATSFileTypeInclude.INSTANCE.getDefaultExtension());

        for (String s: ATSSourceExtensions) {
            matcherList.add(new ExtensionFileNameMatcher(s));
        }

        fileTypeConsumer.consume(ATSFileTypeDynamic.INSTANCE,
                matcherList.toArray(new FileNameMatcher[matcherList.size()]));
        matcherList.clear();
        // Could now include support for other file matching procedures,
        // like exact file names
    }
}

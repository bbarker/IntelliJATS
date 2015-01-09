package com.atslangplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by brandon on 12/16/14.
 */
public class ATSFileTypeDynamic extends LanguageFileType {
    public static final ATSFileTypeDynamic INSTANCE = new
            ATSFileTypeDynamic();

    private ATSFileTypeDynamic() {
        super(ATSLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "dats file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Dynamic Applied Type System (ATS) language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "dats";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ATSIcons.FILE;
    }
}

package com.atslangplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by brandon on 12/16/14.
 */
public class ATSFileTypeStatic extends LanguageFileType {
    public static final ATSFileTypeStatic INSTANCE = new
            ATSFileTypeStatic();

    private ATSFileTypeStatic() {
        super(ATSLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "sats file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Static Applied Type System (ATS) language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "sats";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ATSIcons.FILE;
    }
}

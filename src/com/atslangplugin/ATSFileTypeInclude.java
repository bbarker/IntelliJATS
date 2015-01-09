package com.atslangplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by brandon on 12/16/14.
 */
public class ATSFileTypeInclude extends LanguageFileType {
    public static final ATSFileTypeInclude INSTANCE = new
            ATSFileTypeInclude();

    private ATSFileTypeInclude() {
        super(ATSLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "hats file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Included (\"header\") Applied Type System (ATS) language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "hats";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ATSIcons.FILE;
    }
}

package com.atslangplugin.psi;

import com.atslangplugin.ATSLanguage;
import com.intellij.psi.tree.IElementType;
import com.atslangplugin.ATSLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Brandon Barker on 12/18/2014.
 */
public class ATSTokenType extends IElementType {
    public ATSTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ATSLanguage.INSTANCE);
    }
    @Override
    public String toString() {
        return "ATSTokenType." + super.toString();
    }
}

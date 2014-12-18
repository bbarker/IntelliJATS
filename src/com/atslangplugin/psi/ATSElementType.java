package com.atslangplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.atslangplugin.ATSLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


/**
 * Created by Brandon Barker on 12/18/2014.
 */
public class ATSElementType extends IElementType {
    public ATSElementType(@NotNull @NonNls String debugName){
        super (debugName, ATSLanguage.INSTANCE);
    }

}

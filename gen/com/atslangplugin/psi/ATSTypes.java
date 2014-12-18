// This is a generated file. Not intended for manual editing.
package com.atslangplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.atslangplugin.psi.impl.*;

public interface ATSTypes {

  IElementType PROPERTY = new ATSElementType("PROPERTY");

  IElementType COMMENT = new ATSTokenType("COMMENT");
  IElementType CRLF = new ATSTokenType("CRLF");
  IElementType KEY = new ATSTokenType("KEY");
  IElementType SEPARATOR = new ATSTokenType("SEPARATOR");
  IElementType VALUE = new ATSTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new ATSPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

// This was a generated file, created from ATS.bnf.
// But since we don't currently want to use the PSI
// parser generator, we leave it alone for now.

package com.atslangplugin;

import com.atslangplugin.psi.ATSElementType;
import com.atslangplugin.psi.ATSTokenType;
//import com.atslangplugin.psi.impl.ATSKeyImpl;
//import com.atslangplugin.psi.impl.ATSPropertyImpl;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface ATSTokenTypes {

  IElementType KEY = new ATSElementType("KEY");
  IElementType PROPERTY = new ATSElementType("PROPERTY");

  IElementType ABSTYPE = new ATSTokenType("ABSTYPE");
  IElementType ADDRAT = new ATSTokenType("ADDRAT");
  IElementType AND = new ATSTokenType("AND");
  IElementType AS = new ATSTokenType("AS");
  IElementType ASSUME = new ATSTokenType("ASSUME");
  IElementType AT = new ATSTokenType("AT");
  IElementType ATLBRACE = new ATSTokenType("ATLBRACE");
  IElementType ATLBRACKET = new ATSTokenType("ATLBRACKET");
  IElementType ATLPAREN = new ATSTokenType("ATLPAREN");
  IElementType BACKSLASH = new ATSTokenType("BACKSLASH");
  IElementType BANG = new ATSTokenType("BANG");
  IElementType BAR = new ATSTokenType("BAR");
  IElementType BEGIN = new ATSTokenType("BEGIN");
  IElementType BQUOTE = new ATSTokenType("BQUOTE");
  IElementType BQUOTELPAREN = new ATSTokenType("BQUOTELPAREN");
  IElementType CASE = new ATSTokenType("CASE");
  IElementType CDATA = new ATSTokenType("CDATA");
  IElementType CHAR = new ATSTokenType("CHAR");
  IElementType CLASSDEC = new ATSTokenType("CLASSDEC");
  IElementType COLON = new ATSTokenType("COLON");
  IElementType COLONLT = new ATSTokenType("COLONLT");
  IElementType COMMA = new ATSTokenType("COMMA");
  IElementType COMMALPAREN = new ATSTokenType("COMMALPAREN");
  IElementType COMMENT = new ATSTokenType("COMMENT");
  IElementType COMMENT_BLOCK = new ATSTokenType("COMMENT_BLOCK");
  IElementType COMMENT_LINE = new ATSTokenType("COMMENT_LINE");
  IElementType COMMENT_REST = new ATSTokenType("COMMENT_REST");
  IElementType CRLF = new ATSTokenType("CRLF");
  IElementType DATASORT = new ATSTokenType("DATASORT");
  IElementType DATATYPE = new ATSTokenType("DATATYPE");
  IElementType DLRARRPSZ = new ATSTokenType("DLRARRPSZ");
  IElementType DLRBREAK = new ATSTokenType("DLRBREAK");
  IElementType DLRCONTINUE = new ATSTokenType("DLRCONTINUE");
  IElementType DLRDELAY = new ATSTokenType("DLRDELAY");
  IElementType DLREFFMASK = new ATSTokenType("DLREFFMASK");
  IElementType DLREFFMASK_ARG = new ATSTokenType("DLREFFMASK_ARG");
  IElementType DLREXTERN = new ATSTokenType("DLREXTERN");
  IElementType DLREXTFCALL = new ATSTokenType("DLREXTFCALL");
  IElementType DLREXTKIND = new ATSTokenType("DLREXTKIND");
  IElementType DLREXTMCALL = new ATSTokenType("DLREXTMCALL");
  IElementType DLREXTVAL = new ATSTokenType("DLREXTVAL");
  IElementType DLREXTYPE = new ATSTokenType("DLREXTYPE");
  IElementType DLREXTYPE_STRUCT = new ATSTokenType("DLREXTYPE_STRUCT");
  IElementType DLRLST = new ATSTokenType("DLRLST");
  IElementType DLRMYFILENAME = new ATSTokenType("DLRMYFILENAME");
  IElementType DLRMYFUNCTION = new ATSTokenType("DLRMYFUNCTION");
  IElementType DLRMYLOCATION = new ATSTokenType("DLRMYLOCATION");
  IElementType DLRRAISE = new ATSTokenType("DLRRAISE");
  IElementType DLRREC = new ATSTokenType("DLRREC");
  IElementType DLRSHOWTYPE = new ATSTokenType("DLRSHOWTYPE");
  IElementType DLRTUP = new ATSTokenType("DLRTUP");
  IElementType DLRVCOPYENV = new ATSTokenType("DLRVCOPYENV");
  IElementType DO = new ATSTokenType("DO");
  IElementType DOLLAR = new ATSTokenType("DOLLAR");
  IElementType DOT = new ATSTokenType("DOT");
  IElementType DOTDOT = new ATSTokenType("DOTDOT");
  IElementType DOTDOTDOT = new ATSTokenType("DOTDOTDOT");
  IElementType DOTINT = new ATSTokenType("DOTINT");
  IElementType DOTLT = new ATSTokenType("DOTLT");
  IElementType DOTLTGTDOT = new ATSTokenType("DOTLTGTDOT");
  IElementType DYNLOAD = new ATSTokenType("DYNLOAD");
  IElementType ELSE = new ATSTokenType("ELSE");
  IElementType END = new ATSTokenType("END");
  IElementType EOF = new ATSTokenType("EOF");
  IElementType EQ = new ATSTokenType("EQ");
  IElementType EQGT = new ATSTokenType("EQGT");
  IElementType EQGTGT = new ATSTokenType("EQGTGT");
  IElementType EQLT = new ATSTokenType("EQLT");
  IElementType EQLTGT = new ATSTokenType("EQLTGT");
  IElementType EQSLASHEQGT = new ATSTokenType("EQSLASHEQGT");
  IElementType EQSLASHEQGTGT = new ATSTokenType("EQSLASHEQGTGT");
  IElementType EXCEPTION = new ATSTokenType("EXCEPTION");
  IElementType EXTCODE = new ATSTokenType("EXTCODE");
  IElementType EXTERN = new ATSTokenType("EXTERN");
  IElementType EXTVAR = new ATSTokenType("EXTVAR");
  IElementType EXTYPE = new ATSTokenType("EXTYPE");
  IElementType FIX = new ATSTokenType("FIX");
  IElementType FIXITY = new ATSTokenType("FIXITY");
  IElementType FLOAT = new ATSTokenType("FLOAT");
  IElementType FOLDAT = new ATSTokenType("FOLDAT");
  IElementType FORSTAR = new ATSTokenType("FORSTAR");
  IElementType FREEAT = new ATSTokenType("FREEAT");
  IElementType FUN = new ATSTokenType("FUN");
  IElementType GT = new ATSTokenType("GT");
  IElementType GTDOT = new ATSTokenType("GTDOT");
  IElementType GTLT = new ATSTokenType("GTLT");
  IElementType HASH = new ATSTokenType("HASH");
  IElementType HASHLBRACKETOLON = new ATSTokenType("HASHLBRACKETOLON");
  IElementType IDENTIFIER = new ATSTokenType("IDENTIFIER"); // Not exactly in ATS (CHECK_ME)
  IElementType IF = new ATSTokenType("IF");
  IElementType IMPLEMENT = new ATSTokenType("IMPLEMENT");
  IElementType IMPORT = new ATSTokenType("IMPORT");
  IElementType IN = new ATSTokenType("IN");
  IElementType INT = new ATSTokenType("INT");
  IElementType LAM = new ATSTokenType("LAM");
  IElementType LBRACE = new ATSTokenType("LBRACE");
  IElementType LBRACKET = new ATSTokenType("LBRACKET");
  IElementType LET = new ATSTokenType("LET");
  IElementType LOCAL = new ATSTokenType("LOCAL");
  IElementType LPAREN = new ATSTokenType("LPAREN");
  IElementType LT = new ATSTokenType("LT");
  IElementType MACDEF = new ATSTokenType("MACDEF");
  IElementType MINUSGT = new ATSTokenType("MINUSGT");
  IElementType MINUSLT = new ATSTokenType("MINUSLT");
  IElementType MINUSLTGT = new ATSTokenType("MINUSLTGT");
  IElementType NONE = new ATSTokenType("NONE");
  IElementType NONFIX = new ATSTokenType("NONFIX");
  IElementType OF = new ATSTokenType("OF");
  IElementType OP = new ATSTokenType("OP");
  IElementType OVERLOAD = new ATSTokenType("OVERLOAD");
  IElementType PERCENT = new ATSTokenType("PERCENT");
  IElementType PERCENTLPAREN = new ATSTokenType("PERCENTLPAREN");
  IElementType QMARK = new ATSTokenType("QMARK");
  IElementType QUOTELBRACE = new ATSTokenType("QUOTELBRACE");
  IElementType QUOTELBRACKET = new ATSTokenType("QUOTELBRACKET");
  IElementType QUOTELPAREN = new ATSTokenType("QUOTELPAREN");
  IElementType RBRACE = new ATSTokenType("RBRACE");
  IElementType RBRACKET = new ATSTokenType("RBRACKET");
  IElementType REC = new ATSTokenType("REC");
  IElementType REFAT = new ATSTokenType("REFAT");
  IElementType REF_IDENTIFIER = new ATSTokenType("REF_IDENTIFIER"); // (CHECK_ME)
  IElementType REQUIRE = new ATSTokenType("REQUIRE");
  IElementType RPAREN = new ATSTokenType("RPAREN");
  IElementType SCASE = new ATSTokenType("SCASE");
  IElementType SEMICOLON = new ATSTokenType("SEMICOLON");
  IElementType SEPARATOR = new ATSTokenType("SEPARATOR");
  IElementType SIF = new ATSTokenType("SIF");
  IElementType SORTDEF = new ATSTokenType("SORTDEF");
  IElementType SRPASSERT = new ATSTokenType("SRPASSERT");
  IElementType SRPDEFINE = new ATSTokenType("SRPDEFINE");
  IElementType SRPELIF = new ATSTokenType("SRPELIF");
  IElementType SRPELIFDEF = new ATSTokenType("SRPELIFDEF");
  IElementType SRPELIFNDEF = new ATSTokenType("SRPELIFNDEF");
  IElementType SRPELSE = new ATSTokenType("SRPELSE");
  IElementType SRPENDIF = new ATSTokenType("SRPENDIF");
  IElementType SRPERROR = new ATSTokenType("SRPERROR");
  IElementType SRPIF = new ATSTokenType("SRPIF");
  IElementType SRPIFDEF = new ATSTokenType("SRPIFDEF");
  IElementType SRPIFNDEF = new ATSTokenType("SRPIFNDEF");
  IElementType SRPINCLUDE = new ATSTokenType("SRPINCLUDE");
  IElementType SRPPRINT = new ATSTokenType("SRPPRINT");
  IElementType SRPTHEN = new ATSTokenType("SRPTHEN");
  IElementType SRPUNDEF = new ATSTokenType("SRPUNDEF");
  IElementType STACST = new ATSTokenType("STACST");
  IElementType STADEF = new ATSTokenType("STADEF");
  IElementType STALOAD = new ATSTokenType("STALOAD");
  IElementType STATIC = new ATSTokenType("STATIC");
  IElementType STRING = new ATSTokenType("STRING");
  IElementType SYMELIM = new ATSTokenType("SYMELIM");
  IElementType SYMINTR = new ATSTokenType("SYMINTR");
  IElementType THEN = new ATSTokenType("THEN");
  IElementType TILDE = new ATSTokenType("TILDE");
  IElementType TKINDEF = new ATSTokenType("TKINDEF");
  IElementType TRY = new ATSTokenType("TRY");
  IElementType TYPE = new ATSTokenType("TYPE");
  IElementType TYPEDEF = new ATSTokenType("TYPEDEF");
  IElementType VAL = new ATSTokenType("VAL");
  IElementType VAL_IDENTIFIER = new ATSTokenType("VAL_IDENTIFIER"); // (CHECK_ME)
  IElementType VALUE = new ATSTokenType("VALUE");
  IElementType VAR = new ATSTokenType("VAR");
  IElementType VIEWAT = new ATSTokenType("VIEWAT");
  IElementType WHEN = new ATSTokenType("WHEN");
  IElementType WHERE = new ATSTokenType("WHERE");
  IElementType WHILE = new ATSTokenType("WHILE");
  IElementType WHITE_SPACE = new ATSTokenType("WHITE_SPACE"); // Not exactly in ATS (CHECK_ME)
  IElementType WHILESTAR = new ATSTokenType("WHILESTAR");
  IElementType WITH = new ATSTokenType("WITH");
  IElementType WITHTYPE = new ATSTokenType("WITHTYPE");

  /*
  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == KEY) {
        return new ATSKeyImpl(node);
      }
      else if (type == PROPERTY) {
        return new ATSPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
  */
}

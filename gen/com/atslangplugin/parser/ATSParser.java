// This is a generated file. Not intended for manual editing.
package com.atslangplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.atslangplugin.psi.ATSTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ATSParser implements PsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == KEY) {
      r = KEY(b, 0);
    }
    else if (t == PROPERTY) {
      r = property(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return ATSFile(b, l + 1);
  }

  /* ********************************************************** */
  // item_*
  static boolean ATSFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ATSFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ATSFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // NONE |
  // AT |
  // BACKSLASH |
  // BANG |
  // BQUOTE |
  // COLON |
  // COLONLT |
  // DOLLAR |
  // DOT |
  // DOTDOT |
  // DOTDOTDOT |
  // DOTINT |
  // EQ |
  // EQGT |
  // EQLT |
  // EQLTGT |
  // EQSLASHEQGT |
  // EQGTGT |
  // EQSLASHEQGTGT |
  // HASH |
  // LT |
  // GT |
  // GTLT |
  // DOTLT |
  // GTDOT |
  // DOTLTGTDOT |
  // MINUSGT |
  // MINUSLT |
  // MINUSLTGT |
  // TILDE |
  // ABSTYPE |
  // AND |
  // AS |
  // ASSUME |
  // BEGIN |
  // CASE |
  // CLASSDEC |
  // DATASORT |
  // DATATYPE |
  // DO |
  // DYNLOAD |
  // ELSE |
  // END |
  // EXCEPTION |
  // EXTERN |
  // EXTYPE |
  // EXTVAR |
  // FIX |
  // FIXITY |
  // FORSTAR |
  // FUN |
  // IF |
  // IMPLEMENT |
  // IMPORT |
  // IN |
  // LAM |
  // LET |
  // LOCAL |
  // MACDEF |
  // NONFIX |
  // OVERLOAD |
  // OF |
  // OP |
  // REC |
  // REFAT |
  // REQUIRE |
  // SCASE |
  // SIF |
  // SORTDEF |
  // STACST |
  // STADEF |
  // STALOAD |
  // STATIC |
  // SYMELIM |
  // SYMINTR |
  // THEN |
  // TKINDEF |
  // TRY |
  // TYPE |
  // TYPEDEF |
  // VAL |
  // VAR |
  // WHEN |
  // WHERE |
  // WHILE |
  // WHILESTAR |
  // WITH |
  // WITHTYPE |
  // ADDRAT |
  // FOLDAT |
  // FREEAT |
  // VIEWAT |
  // DLRARRPSZ |
  // DLRDELAY |
  // DLREFFMASK |
  // DLREFFMASK_ARG |
  // DLREXTERN |
  // DLREXTKIND |
  // DLREXTYPE |
  // DLREXTYPE_STRUCT |
  // DLREXTVAL |
  // DLREXTFCALL |
  // DLREXTMCALL |
  // DLRBREAK |
  // DLRCONTINUE |
  // DLRRAISE |
  // DLRLST |
  // DLRREC |
  // DLRTUP |
  // DLRMYFILENAME |
  // DLRMYLOCATION |
  // DLRMYFUNCTION |
  // DLRSHOWTYPE |
  // DLRVCOPYENV |
  // SRPASSERT |
  // SRPDEFINE |
  // SRPELIF |
  // SRPELIFDEF |
  // SRPELIFNDEF |
  // SRPELSE |
  // SRPENDIF |
  // SRPERROR |
  // SRPIF |
  // SRPIFDEF |
  // SRPIFNDEF |
  // SRPINCLUDE |
  // SRPPRINT |
  // SRPTHEN |
  // SRPUNDEF |
  // INT |
  // CHAR |
  // FLOAT |
  // CDATA |
  // STRING |
  // COMMA |
  // SEMICOLON |
  // LPAREN |
  // RPAREN |
  // LBRACKET |
  // RBRACKET |
  // LBRACE |
  // RBRACE |
  // ATLPAREN |
  // QUOTELPAREN |
  // ATLBRACKET |
  // QUOTELBRACKET |
  // HASHLBRACKETOLON |
  // ATLBRACE |
  // QUOTELBRACE |
  // BQUOTELPAREN |
  // COMMALPAREN |
  // PERCENTLPAREN |
  // EXTCODE |
  // COMMENT_LINE |
  // COMMENT_BLOCK |
  // COMMENT_REST |
  // PERCENT |
  // QMARK |
  // EOF
  public static boolean KEY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEY")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key>");
    r = consumeToken(b, NONE);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, BQUOTE);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, COLONLT);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, DOTDOT);
    if (!r) r = consumeToken(b, DOTDOTDOT);
    if (!r) r = consumeToken(b, DOTINT);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, EQGT);
    if (!r) r = consumeToken(b, EQLT);
    if (!r) r = consumeToken(b, EQLTGT);
    if (!r) r = consumeToken(b, EQSLASHEQGT);
    if (!r) r = consumeToken(b, EQGTGT);
    if (!r) r = consumeToken(b, EQSLASHEQGTGT);
    if (!r) r = consumeToken(b, HASH);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GTLT);
    if (!r) r = consumeToken(b, DOTLT);
    if (!r) r = consumeToken(b, GTDOT);
    if (!r) r = consumeToken(b, DOTLTGTDOT);
    if (!r) r = consumeToken(b, MINUSGT);
    if (!r) r = consumeToken(b, MINUSLT);
    if (!r) r = consumeToken(b, MINUSLTGT);
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, ABSTYPE);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, AS);
    if (!r) r = consumeToken(b, ASSUME);
    if (!r) r = consumeToken(b, BEGIN);
    if (!r) r = consumeToken(b, CASE);
    if (!r) r = consumeToken(b, CLASSDEC);
    if (!r) r = consumeToken(b, DATASORT);
    if (!r) r = consumeToken(b, DATATYPE);
    if (!r) r = consumeToken(b, DO);
    if (!r) r = consumeToken(b, DYNLOAD);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, END);
    if (!r) r = consumeToken(b, EXCEPTION);
    if (!r) r = consumeToken(b, EXTERN);
    if (!r) r = consumeToken(b, EXTYPE);
    if (!r) r = consumeToken(b, EXTVAR);
    if (!r) r = consumeToken(b, FIX);
    if (!r) r = consumeToken(b, FIXITY);
    if (!r) r = consumeToken(b, FORSTAR);
    if (!r) r = consumeToken(b, FUN);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, IMPLEMENT);
    if (!r) r = consumeToken(b, IMPORT);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, LAM);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, LOCAL);
    if (!r) r = consumeToken(b, MACDEF);
    if (!r) r = consumeToken(b, NONFIX);
    if (!r) r = consumeToken(b, OVERLOAD);
    if (!r) r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, OP);
    if (!r) r = consumeToken(b, REC);
    if (!r) r = consumeToken(b, REFAT);
    if (!r) r = consumeToken(b, REQUIRE);
    if (!r) r = consumeToken(b, SCASE);
    if (!r) r = consumeToken(b, SIF);
    if (!r) r = consumeToken(b, SORTDEF);
    if (!r) r = consumeToken(b, STACST);
    if (!r) r = consumeToken(b, STADEF);
    if (!r) r = consumeToken(b, STALOAD);
    if (!r) r = consumeToken(b, STATIC);
    if (!r) r = consumeToken(b, SYMELIM);
    if (!r) r = consumeToken(b, SYMINTR);
    if (!r) r = consumeToken(b, THEN);
    if (!r) r = consumeToken(b, TKINDEF);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, TYPEDEF);
    if (!r) r = consumeToken(b, VAL);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, WHEN);
    if (!r) r = consumeToken(b, WHERE);
    if (!r) r = consumeToken(b, WHILE);
    if (!r) r = consumeToken(b, WHILESTAR);
    if (!r) r = consumeToken(b, WITH);
    if (!r) r = consumeToken(b, WITHTYPE);
    if (!r) r = consumeToken(b, ADDRAT);
    if (!r) r = consumeToken(b, FOLDAT);
    if (!r) r = consumeToken(b, FREEAT);
    if (!r) r = consumeToken(b, VIEWAT);
    if (!r) r = consumeToken(b, DLRARRPSZ);
    if (!r) r = consumeToken(b, DLRDELAY);
    if (!r) r = consumeToken(b, DLREFFMASK);
    if (!r) r = consumeToken(b, DLREFFMASK_ARG);
    if (!r) r = consumeToken(b, DLREXTERN);
    if (!r) r = consumeToken(b, DLREXTKIND);
    if (!r) r = consumeToken(b, DLREXTYPE);
    if (!r) r = consumeToken(b, DLREXTYPE_STRUCT);
    if (!r) r = consumeToken(b, DLREXTVAL);
    if (!r) r = consumeToken(b, DLREXTFCALL);
    if (!r) r = consumeToken(b, DLREXTMCALL);
    if (!r) r = consumeToken(b, DLRBREAK);
    if (!r) r = consumeToken(b, DLRCONTINUE);
    if (!r) r = consumeToken(b, DLRRAISE);
    if (!r) r = consumeToken(b, DLRLST);
    if (!r) r = consumeToken(b, DLRREC);
    if (!r) r = consumeToken(b, DLRTUP);
    if (!r) r = consumeToken(b, DLRMYFILENAME);
    if (!r) r = consumeToken(b, DLRMYLOCATION);
    if (!r) r = consumeToken(b, DLRMYFUNCTION);
    if (!r) r = consumeToken(b, DLRSHOWTYPE);
    if (!r) r = consumeToken(b, DLRVCOPYENV);
    if (!r) r = consumeToken(b, SRPASSERT);
    if (!r) r = consumeToken(b, SRPDEFINE);
    if (!r) r = consumeToken(b, SRPELIF);
    if (!r) r = consumeToken(b, SRPELIFDEF);
    if (!r) r = consumeToken(b, SRPELIFNDEF);
    if (!r) r = consumeToken(b, SRPELSE);
    if (!r) r = consumeToken(b, SRPENDIF);
    if (!r) r = consumeToken(b, SRPERROR);
    if (!r) r = consumeToken(b, SRPIF);
    if (!r) r = consumeToken(b, SRPIFDEF);
    if (!r) r = consumeToken(b, SRPIFNDEF);
    if (!r) r = consumeToken(b, SRPINCLUDE);
    if (!r) r = consumeToken(b, SRPPRINT);
    if (!r) r = consumeToken(b, SRPTHEN);
    if (!r) r = consumeToken(b, SRPUNDEF);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, CDATA);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, ATLPAREN);
    if (!r) r = consumeToken(b, QUOTELPAREN);
    if (!r) r = consumeToken(b, ATLBRACKET);
    if (!r) r = consumeToken(b, QUOTELBRACKET);
    if (!r) r = consumeToken(b, HASHLBRACKETOLON);
    if (!r) r = consumeToken(b, ATLBRACE);
    if (!r) r = consumeToken(b, QUOTELBRACE);
    if (!r) r = consumeToken(b, BQUOTELPAREN);
    if (!r) r = consumeToken(b, COMMALPAREN);
    if (!r) r = consumeToken(b, PERCENTLPAREN);
    if (!r) r = consumeToken(b, EXTCODE);
    if (!r) r = consumeToken(b, COMMENT_LINE);
    if (!r) r = consumeToken(b, COMMENT_BLOCK);
    if (!r) r = consumeToken(b, COMMENT_REST);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, QMARK);
    if (!r) r = consumeToken(b, EOF);
    exit_section_(b, l, m, KEY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // property|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<property>");
    r = property_0(b, l + 1);
    if (!r) r = KEY(b, l + 1);
    exit_section_(b, l, m, PROPERTY, r, false, null);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && property_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_0")) return false;
    KEY(b, l + 1);
    return true;
  }

  // VALUE?
  private static boolean property_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

}

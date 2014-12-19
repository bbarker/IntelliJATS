package com.atsplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.atsplugin.psi.ATSTypes;
import com.intellij.psi.TokenType;

%%

%class ATSLexer
%implements FlexLexer
%unicode
%function advance
%type IElement
%line
%column
%eof{ return;
%eof}

%{
  // Not sure if needed:
  StringBuffer string = new StringBuffer();

%}

CRLF = \n|\r|\r\n
WHITE_SPACE = {CRLF} | [\ \t\f]
FIRST_VALUE_CHARACTER = [^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER = [^ \n\r\f\\] | "\\"{CRLF} | "\\".

/* Should VALUE_CHARACTER include or exclude comments? */

/* Should we be using ATS datatypes names? */
/* comments */
COMMENT = {TRADITIONAL_COMMENT} | {END_OF_LINE_COMMENT} | {DOCUMENTATION_COMMENT} | {COMMENT_CONTENT}
END_OF_LINE_COMMENT = "//" {VALUE_CHARACTER}* {CRLF}?
DOCUMENTATION_COMMENT = "(*" (\*+\ +{CRLF}?)* {COMMENT_CONTENT} (\*+\ +{CRLF}?)* "*)"
COMMENT_CONTENT = ( [^*] | \*+ [^)*] ) // should we delimit the ')' ?
TRADITIONAL_COMMENT = "(*" [^*] ~"*)"

DEC_INT_LITERAL = 0 | [1-9][0-9]* // CHECK_ME

%state STRING

%%

/* for more information, see the following */
/* in the ATS-Postiats source repository:  */
/* src/pats_lexing.sats                    */
/* src/pats_lexing_token.dats              */

/*  *** *** keywords and symbols  *** ***  */

<YYINITIAL> ""          { return symbol(sym.NONE); } // CHECK_ME
//
<YYINITIAL> "@"         { return symbol(sym.AT); }
//
<YYINITIAL> "\\"        { return symbol(sym.BACKSLASH); }
<YYINITIAL> "!"         { return symbol(sym.BANG); }
<YYINITIAL> "`"         { return symbol(sym.BQUOTE); }
//
<YYINITIAL> ":"         { return symbol(sym.COLON); }
<YYINITIAL> ":<"        { return symbol(sym.COLONLT); }
/*
  | T_COLONLTGT of () // :<> // HX: impossible
*/
//
<YYINITIAL> "$"                         { return symbol(sym.DOLLAR); }
//
<YYINITIAL> "."                         { return symbol(sym.DOT); }
<YYINITIAL> ".."                        { return symbol(sym.DOTDOT); }
<YYINITIAL> "..."                       { return symbol(sym.DOTDOTDOT); }
//
<YYINITIAL> "."{DEC_INT_LITERAL}        { return symbol(sym.DOTINT); }
//
<YYINITIAL> "="                         { return symbol(sym.EQ); }
<YYINITIAL> "=>"                        { return symbol(sym.EQGT); }
<YYINITIAL> "=<"                        { return symbol(sym.EQLT); }
<YYINITIAL> "=<>"                       { return symbol(sym.EQLTGT); }
<YYINITIAL> "=/=>"                      { return symbol(sym.EQSLASHEQGT); }
<YYINITIAL> "=>>"                       { return symbol(sym.EQGTGT); }
<YYINITIAL> "=/=>>"                     { return symbol(sym.EQSLASHEQGTGT); }
//
<YYINITIAL> "#"                         { return symbol(sym.HASH); }
//
<YYINITIAL> "<"                         { return symbol(sym.LT); } // for opening a tmparg
<YYINITIAL> ">"                         { return symbol(sym.GT); } // for closing a tmparg
//
<YYINITIAL> "<>"                        { return symbol(sym.GTLT); }
<YYINITIAL> ".<"                        { return symbol(sym.DOTLT); } // opening termetric
<YYINITIAL> ">."                        { return symbol(sym.GTDOT); } // closing termetric
<YYINITIAL> ".<>."                      { return symbol(sym.DOTLTGTDOT); } // empty termetric
//
<YYINITIAL> "->"                        { return symbol(sym.MINUSGT); }
<YYINITIAL> "-<"                        { return symbol(sym.MINUSLT); }
<YYINITIAL> "-<>"                       { return symbol(sym.MINUSLTGT); }
//
<YYINITIAL> "~"                         { return symbol(sym.TILDE); }
//
<YYINITIAL> "absview"|"absviewtype"|"absviewt@ype"  { return symbol(sym.ABSTYPE); }
//
<YYINITIAL> "and"                        { return symbol(sym.AND); }
<YYINITIAL> "as"                         { return symbol(sym.AND); }
<YYINITIAL> "assume"                     { return symbol(sym.ASSUME); }
<YYINITIAL> "begin"                      { return symbol(sym.BEGIN); }
<YYINITIAL> "begin"                      { return symbol(sym.BEGIN); }
<YYINITIAL> "case"|"case-"|"case+"|"prcase" { return symbol(sym.CASE); }
<YYINITIAL> "classdec"                   { return symbol(sym.CLASSDEC); }
<YYINITIAL> "datasort"                   { return symbol(sym.DATASORT); }
// BB: surprising to me these all generate the same token:
<YYINITIAL> "datatype"|"dataprop"|"dataview"|"dataviewtype"
                                         { return symbol(sym.DATATYPE); }
<YYINITIAL> "do"                         { return symbol(sym.DO); }
<YYINITIAL> "dynload"                    { return symbol(sym.DYNLOAD); }
<YYINITIAL> "else"                       { return symbol(sym.ELSE); }
<YYINITIAL> "end"                        { return symbol(sym.END); }
<YYINITIAL> "exception"                  { return symbol(sym.EXCEPTION); }
//


















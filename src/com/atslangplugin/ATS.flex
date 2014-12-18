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
<YYINITIAL> "`"         { return symbol.BQUOTE); }
//
<YYINITIAL> ":"         { return symbol.COLON); }
<YYINITIAL> ":<"        { return symbol.COLONLT); }
/*
  | T_COLONLTGT of () // :<> // HX: impossible
*/
//
<YYINITIAL> "$"                         { return symbol.DOLLAR); }
//
<YYINITIAL> "."                         { return symbol.DOT); }
<YYINITIAL> ".."                        { return symbol.DOTDOT); }
<YYINITIAL> "..."                       { return symbol.DOTDOTDOT); }
//
<YYINITIAL> "."{DEC_INT_LITERAL}        { return symbol.DOTINT); }
//
<YYINITIAL> "="                         { return symbol.EQ); }
<YYINITIAL> "=>"                        { return symbol.EQGT); }
<YYINITIAL> "=<"                        { return symbol.EQLT); }
<YYINITIAL> "=<>"                       { return symbol.EQLTGT); }
<YYINITIAL> "=/=>"                      { return symbol.EQSLASHEQGT); }
<YYINITIAL> "=>>"                       { return symbol.EQGTGT); }
<YYINITIAL> "=/=>>"                     { return symbol.EQSLASHEQGTGT); }
//
<YYINITIAL> "#"                         { return symbol.HASH); }
//
<YYINITIAL> "<"                         { return symbol.LT); } // for opening a tmparg
<YYINITIAL> ">"                         { return symbol.GT); } // for closing a tmparg
//
<YYINITIAL> "<>"                        { return symbol.GTLT); }
<YYINITIAL> ".<"                        { return symbol.DOTLT); } // opening termetric
<YYINITIAL> ">."                        { return symbol.GTDOT); } // closing termetric
<YYINITIAL> ".<>."                         { return symbol.DOTLTGTDOT); } // empty termetric
//


















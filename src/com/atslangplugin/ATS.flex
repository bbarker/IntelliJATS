package com.atslangplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.atslangplugin.ATSTypes;
import com.intellij.psi.TokenType;

%%

%class ATSLexer
%public
%implements FlexLexer
%unicode
%function advance
%type IElementType
%line
%column
%eof{ return;
%eof}

%{
  // Not sure if needed:
  StringBuffer string = new StringBuffer();

  // Placeholders for line and column information:
  private int yyline;
  private int yycolumn;
%}

DIGIT=[0-9]
OCTAL_DIGIT=[0-7]
HEX_DIGIT=[0-9A-Fa-f]
SIMPLE_SPACE_CHAR=[\ \t\f]
NEWLINE_SPACE_CHAR=(\n | \r | \r\n)
WHITE_SPACE_CHAR=[\ \n\r\t\f]

IDENTIFIER= ([:letter:]|_) ([:letter:]|{DIGIT}|_ )*

C_STYLE_COMMENT=("/*"[^"*"]{COMMENT_TAIL})|"/*"

COMMENT_TAIL=([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
DOC_COMMENT="/*""*"+("/"|([^"/""*"]{COMMENT_TAIL}))?
END_OF_LINE_COMMENT="/""/"([^\r\n]|(\\\r?\n))*

INTEGER_LITERAL={DECIMAL_INTEGER_LITERAL}|{HEX_INTEGER_LITERAL}
DECIMAL_INTEGER_LITERAL=(0|([1-9]({DIGIT})*))
HEX_INTEGER_LITERAL=0[Xx]({HEX_DIGIT})*

FLOAT_LITERAL=({FLOATING_POINT_LITERAL1})|({FLOATING_POINT_LITERAL2})|({FLOATING_POINT_LITERAL3})|({FLOATING_POINT_LITERAL4})
FLOATING_POINT_LITERAL1=({DIGIT})+"."({DIGIT})*({EXPONENT_PART})?
FLOATING_POINT_LITERAL2="."({DIGIT})+({EXPONENT_PART})?
FLOATING_POINT_LITERAL3=({DIGIT})+({EXPONENT_PART})
FLOATING_POINT_LITERAL4=({DIGIT})+
EXPONENT_PART=[Ee]["+""-"]?({DIGIT})*

QUOTED_LITERAL="'"([^\\\'\r\n]|{ESCAPE_SEQUENCE})*("'"|\\)?
DOUBLE_QUOTED_LITERAL=\"([^\\\"\r\n]|{ESCAPE_SEQUENCE})*(\"|\\)?
ESCAPE_SEQUENCE=\\[^\r\n]
SIMPLE_PRE_KEYWORD=(include|ifdef|endif|undef|ifndef|error|defined)

// Old patterns:

CRLF = \n|\r|\r\n
WHITE_SPACE = {CRLF} | [\ \t\f]
FIRST_VALUE_CHARACTER = [^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER = [^ \n\r\f\\] | "\\"{CRLF} | "\\".

/* Should VALUE_CHARACTER include or exclude comments? */

/* Should we be using ATS datatypes names? */
/* comments */
COMMENT = {TRADITIONAL_COMMENT} | {END_OF_LINE_COMMENT} | {END_OF_FILE_COMMENT} | {DOCUMENTATION_COMMENT} | {COMMENT_CONTENT}
END_OF_LINE_COMMENT = "//" .* {CRLF}?
END_OF_FILE_COMMENT = "////" (.* {CRLF}?)* // CHECK_ME
DOCUMENTATION_COMMENT = "(*" (\*+\ +{CRLF}?)* {COMMENT_CONTENT} (\*+\ +{CRLF}?)* "*)"
COMMENT_CONTENT = ( [^*] | \*+ [^)*] ) // should we delimit the ')' ?
TRADITIONAL_COMMENT = "(*" [^*] ~"*)"

OCT_INT_LITERAL = 0 | [1-9][0-9]* // FIX_ME
DEC_INT_LITERAL = 0 | [1-9][0-9]* // CHECK_ME
HEX_INT_LITERAL = 0 | [1-9][0-9]* // FIX_ME


%state STRING
%state PRE
%state PRAGMA
%state DEFINE
%state DEFINE_CONTINUATION
%state CONTINUATION

%%

/* for more information, see the following */
/* in the ATS-Postiats source repository:  */
/* src/pats_lexing.sats                    */
/* src/pats_lexing_token.dats              */

/*  *** *** keywords and symbols  *** ***  */

<YYINITIAL> {
""          { return ATSTypes.NONE; } // CHECK_ME
//
"@"         { return ATSTypes.AT; }
//
"\\"        { return ATSTypes.BACKSLASH; }
"!"         { return ATSTypes.BANG; }
"`"         { return ATSTypes.BQUOTE; }
//
":"         { return ATSTypes.COLON; }
":<"        { return ATSTypes.COLONLT; }
/*
  | T_COLONLTGT of () // :<> // HX: impossible
*/
//
"$"                         { return ATSTypes.DOLLAR; }
//
"."                         { return ATSTypes.DOT; }
".."                        { return ATSTypes.DOTDOT; }
"..."                       { return ATSTypes.DOTDOTDOT; }
//
"."{DEC_INT_LITERAL}        { return ATSTypes.DOTINT; }
//
"="                         { return ATSTypes.EQ; }
"=>"                        { return ATSTypes.EQGT; }
"=<"                        { return ATSTypes.EQLT; }
"=<>"                       { return ATSTypes.EQLTGT; }
"=/=>"                      { return ATSTypes.EQSLASHEQGT; }
"=>>"                       { return ATSTypes.EQGTGT; }
"=/=>>"                     { return ATSTypes.EQSLASHEQGTGT; }
//
"#"                         { return ATSTypes.HASH; }
//
"<"                         { return ATSTypes.LT; } // for opening a tmparg
">"                         { return ATSTypes.GT; } // for closing a tmparg
//
"<>"                        { return ATSTypes.GTLT; }
".<"                        { return ATSTypes.DOTLT; } // opening termetric
">."                        { return ATSTypes.GTDOT; } // closing termetric
".<>."                      { return ATSTypes.DOTLTGTDOT; } // empty termetric
//
"->"                        { return ATSTypes.MINUSGT; }
"-<"                        { return ATSTypes.MINUSLT; }
"-<>"                       { return ATSTypes.MINUSLTGT; }
//
"~"                         { return ATSTypes.TILDE; }
//
"abstype"|"abst0ype"|"absprop"|"absview"|
            "absviewtype"|"absvtype"|"absviewt@ype"|"absvt0ype"|"absviewt0ype"
                                        { return ATSTypes.ABSTYPE; }
//
"and"                       { return ATSTypes.AND; }
"as"                        { return ATSTypes.AS; }
"assume"                    { return ATSTypes.ASSUME; }
"begin"                     { return ATSTypes.BEGIN; }
"case"|"case-"|"case+"|"prcase"
                                        { return ATSTypes.CASE; }
"classdec"                  { return ATSTypes.CLASSDEC; }
"datasort"                  { return ATSTypes.DATASORT; }
// BB: surprising to me these all generate the same token:
// (but maybe not exactly, see ./src/pats_lexing_token.dats)
"datatype"|"dataprop"|"dataview"|"dataviewtype"|"datavtype"
                                        { return ATSTypes.DATATYPE; }
"do"                        { return ATSTypes.DO; }
"dynload"                   { return ATSTypes.DYNLOAD; }
"else"                      { return ATSTypes.ELSE; }
"end"                       { return ATSTypes.END; }
"exception"                 { return ATSTypes.EXCEPTION; }
//
"extern"                    { return ATSTypes.EXTERN; }
"extype"                    { return ATSTypes.EXTYPE; }
"extvar"                    { return ATSTypes.EXTVAR; }
//
"fix"|"fix@"                { return ATSTypes.FIX; }
"infix"|"infixl"|"infixr"|"prefix"|"postfix"
                                        { return ATSTypes.FIXITY; }
"for*"                      { return ATSTypes.FORSTAR; }
"fn"|"fnx"|"fun"|"prfn"|"prfun"|"praxi"|"castfn"
                                        { return ATSTypes.FUN; }
"if"                        { return ATSTypes.IF; } // dynamic
"implement"|"primplement"   { return ATSTypes.IMPLEMENT; }
"import"                    { return ATSTypes.IMPORT; }
"in"                        { return ATSTypes.IN; }
"lam"|"llam"|"lam@"         { return ATSTypes.LAM; }
"let"                       { return ATSTypes.LET; }
"local"                     { return ATSTypes.LOCAL; }
"macdef"|"macrodef"         { return ATSTypes.MACDEF; }
"nonfix"                    { return ATSTypes.NONFIX; }
"overload"                  { return ATSTypes.OVERLOAD; }
"of"                        { return ATSTypes.OF; }
"op"                        { return ATSTypes.OP; }
"rec"                       { return ATSTypes.REC; }
"ref@"                      { return ATSTypes.REFAT; }
"require"                   { return ATSTypes.REQUIRE; }
"scase"                     { return ATSTypes.SCASE; }
"sif"                       { return ATSTypes.SIF; } // static
"sortdef"                   { return ATSTypes.SORTDEF; }
"stacst"                    { return ATSTypes.STACST; }
"stadef"                    { return ATSTypes.STADEF; }
"staload"                   { return ATSTypes.STALOAD; }
"static"                    { return ATSTypes.STATIC; }
/*
  | T_STAVAR of () // stavar // HX: a suspended hack
*/
"symelim"                   { return ATSTypes.SYMELIM; }
"symintr"                   { return ATSTypes.SYMINTR; }
"then"                      { return ATSTypes.THEN; }
"tkindef"                   { return ATSTypes.TKINDEF; }
"try"                       { return ATSTypes.TRY; }
"type"|"type+"|"type-"      { return ATSTypes.TYPE; }
"typedef"|"propdef"|"viewdef"|"viewtypedef" // CHECK_ME: aliases?
                                        { return ATSTypes.TYPEDEF; }
"val"|"val+"|"val-"|"prval" { return ATSTypes.VAL; }
"var"|"prvar"               { return ATSTypes.VAR; }
"when"                      { return ATSTypes.WHEN; }
"where"                     { return ATSTypes.WHERE; }
"while"                     { return ATSTypes.WHILE; }
"while*"                    { return ATSTypes.WHILESTAR; }
"with"                      { return ATSTypes.WITH; }
"withtype"|"withprop"|"withview"|"withviewtype"
                                        { return ATSTypes.WITHTYPE; }
//
"addr@"                     { return ATSTypes.ADDRAT; }
"fold@"                     { return ATSTypes.FOLDAT; }
"free@"                     { return ATSTypes.FREEAT; }
"view@"                     { return ATSTypes.VIEWAT; }
//
"$arrpsz"|"$arrptrsize"     { return ATSTypes.DLRARRPSZ; }
//
"$delay"|"$ldelay"          { return ATSTypes.DLRDELAY; }
//
"$effmask"                  { return ATSTypes.DLREFFMASK; }
"ntm"|"exn"|"ref"|"wrt"|"all"
                                        { return ATSTypes.DLREFFMASK_ARG; }
"$extern"                   { return ATSTypes.DLREXTERN; }
"$extkind"                  { return ATSTypes.DLREXTKIND; }
"$extype"                   { return ATSTypes.DLREXTYPE; }
"$extype_struct"            { return ATSTypes.DLREXTYPE_STRUCT; }
//
"$extval"                   { return ATSTypes.DLREXTVAL; }
"$extfcall"                 { return ATSTypes.DLREXTFCALL; }
"$extmcall"                 { return ATSTypes.DLREXTMCALL; }
//
"$break"                    { return ATSTypes.DLRBREAK; }
"$continue"                 { return ATSTypes.DLRCONTINUE; }
"$raise"                    { return ATSTypes.DLRRAISE; }
//
"$lst"|"$list"|"$lst_t"|"$list_t"|"$lst_vt"|"$list_vt"
                                        { return ATSTypes.DLRLST; }
"$rec"|"$record"|"$rec_t"|"$record_t"|"$rec_vt"|"$record_vt"
                                        { return ATSTypes.DLRREC; }
"$tup"|"$tup_t"|"$tup_vt"|"$tuple"|"$tuple_t"|"$tuple_vt"
                                        { return ATSTypes.DLRTUP; }
//
"$myfilename"               { return ATSTypes.DLRMYFILENAME; }
"$mylocation"               { return ATSTypes.DLRMYLOCATION; }
"$myfunction"               { return ATSTypes.DLRMYFUNCTION; }
//
"$showtype"                 { return ATSTypes.DLRSHOWTYPE; }
//
"$vcopyenv_v"|"$vcopyenv_vt(vt)"
                                        { return ATSTypes.DLRVCOPYENV; }
//
"#assert"                   { return ATSTypes.SRPASSERT; }
"#define"                   { return ATSTypes.SRPDEFINE; }
"#elif"                     { return ATSTypes.SRPELIF; }
"#elifdef"                  { return ATSTypes.SRPELIFDEF; }
"#elifndef"                 { return ATSTypes.SRPELIFNDEF; }
"#else"                     { return ATSTypes.SRPELSE; }
"#endif"                    { return ATSTypes.SRPENDIF; }
"#error"                    { return ATSTypes.SRPERROR; }
"#if"                       { return ATSTypes.SRPIF; }
"#ifdef"                    { return ATSTypes.SRPIFDEF; }
"#ifndef"                   { return ATSTypes.SRPIFNDEF; }
"#include"                  { return ATSTypes.SRPINCLUDE; }
"#print"                    { return ATSTypes.SRPPRINT; }
"#then"                     { return ATSTypes.SRPTHEN; }
"#undef"                    { return ATSTypes.SRPUNDEF; }
//
// The internal lexing of views + types seems to be a bit complicated
// For now I try to simplify it a bit; currently not handled: (FIX_ME)
// T_IDENT_alp
//
""                          { return ATSTypes.INT; }  // FIX_ME
""                          { return ATSTypes.CHAR; }  // FIX_ME
""                          { return ATSTypes.FLOAT; }  // FIX_ME
""                          { return ATSTypes.CDATA; }  // FIX_ME
""                          { return ATSTypes.STRING; }  // FIX_ME
//
/*
  | T_LABEL of (int(*knd*), string) // HX-2013-01: should it be supported?
*/
//
","                         { return ATSTypes.COMMA; }
";"                         { return ATSTypes.SEMICOLON; }
//
"("                         { return ATSTypes.LPAREN; }
")"                         { return ATSTypes.RPAREN; }
"["                         { return ATSTypes.LBRACKET; }
"]"                         { return ATSTypes.RBRACKET; }
"{"                         { return ATSTypes.LBRACE; }
"}"                         { return ATSTypes.RBRACE; }
//
"@("                        { return ATSTypes.ATLPAREN; }
"'("                        { return ATSTypes.QUOTELPAREN; }
"@["                        { return ATSTypes.ATLBRACKET; }
"'["                        { return ATSTypes.QUOTELBRACKET; }
"#["                        { return ATSTypes.HASHLBRACKETOLON; }
"@{"                        { return ATSTypes.ATLBRACE; }
"'{"                        { return ATSTypes.QUOTELBRACE; }
//
// For macros:
//
"`("                        { return ATSTypes.BQUOTELPAREN; }
",("                        { return ATSTypes.COMMALPAREN; }
"%("                        { return ATSTypes.PERCENTLPAREN; }
//
""                          { return ATSTypes.EXTCODE; } //FIX_ME
//
{END_OF_LINE_COMMENT}       { return ATSTypes.COMMENT_LINE; }
{TRADITIONAL_COMMENT}       { return ATSTypes.COMMENT_BLOCK; }
{END_OF_FILE_COMMENT}       { return ATSTypes.COMMENT_REST; }
{COMMENT}                   { return ATSTypes.COMMENT; }
// FIX_ME for the next two ("can never be matched")
"%"                         { return ATSTypes.PERCENT; }
"?"                         { return ATSTypes.QMARK; }
} // End of <YYINITIAL>

<STRING> {
\" { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString()); }
[^\n\r\"\\]+ { string.append( yytext() ); }
\\t { string.append('\t'); }
\\n { string.append('\n'); }
\\r { string.append('\r'); }
\\\" { string.append('\"'); }
\\ { string.append('\\'); }
} // End of <STRING>

//
<<EOF>>                                 { return ATSTypes.EOF; }
//
// Match anything not picked up and throw an error:
//
[^]         {throw new Error("Illegal character <"+yytext()+">"); }
//





























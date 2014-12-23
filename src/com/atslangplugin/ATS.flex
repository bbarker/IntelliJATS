package com.atslangplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.atslangplugin.ATSTokenTypes;
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



// Old patterns:
IDENTIFIER= ([:letter:]|_) ([:letter:]|{DIGIT}|_ )*

ESCAPE_SEQUENCE=\\[^\r\n]
CRLF=(\n | \r | \r\n)

DIGIT=[0-9]
OCTAL_DIGIT=[0-7]
HEX_DIGIT=[0-9A-Fa-f]

INTEGER_LITERAL={DECIMAL_INTEGER_LITERAL}|{OCTAL_INTEGER_LITERAL}|{HEX_INTEGER_LITERAL}
DECIMAL_INTEGER_LITERAL=(0|([1-9]({DIGIT})*))
HEX_INTEGER_LITERAL=0[Xx]({HEX_DIGIT})*
OCTAL_INTEGER_LITERAL=0({OCTAL_DIGIT})*

// for DEFINE:
SIMPLE_SPACE_CHAR=[\ \t\f]
SIMPLE_PRE_KEYWORD=(include|ifdef|endif|undef|ifndef|error|defined)

WHITE_SPACE=[\ \n\r\t\f]

/* comments */
END_OF_LINE_COMMENT="/""/"([^\r\n]|(\\\r?\n))*
COMMENT_TAIL=([^"*"]*("*"+[^"*"")"])?)*("*"+")")?
TRADITIONAL_COMMENT=("(*"[^"*"]{COMMENT_TAIL})|"*)"
END_OF_FILE_COMMENT = "////" (.* {CRLF}?)* // CHECK_ME
DOCUMENTATION_COMMENT="(*""*"+("("|([^"(""*"]{COMMENT_TAIL}))?
//DOCUMENTATION_COMMENT = "(*" (\*+\ +{CRLF}?)* {COMMENT_CONTENT} (\*+\ +{CRLF}?)* "*)"
//COMMENT_CONTENT = ( [^*] | \*+ [^)*] ) // should we delimit the ')' ?
COMMENT = {TRADITIONAL_COMMENT} | {END_OF_LINE_COMMENT} | {END_OF_FILE_COMMENT} | {DOCUMENTATION_COMMENT}

FLOAT_LITERAL=({FLOATING_POINT_LITERAL1})|({FLOATING_POINT_LITERAL2})|({FLOATING_POINT_LITERAL3})|({FLOATING_POINT_LITERAL4})
FLOATING_POINT_LITERAL1=({DIGIT})+"."({DIGIT})*({EXPONENT_PART})?
FLOATING_POINT_LITERAL2="."({DIGIT})+({EXPONENT_PART})?
FLOATING_POINT_LITERAL3=({DIGIT})+({EXPONENT_PART})
FLOATING_POINT_LITERAL4=({DIGIT})+
EXPONENT_PART=[Ee]["+""-"]?({DIGIT})*

CHAR_SINGLEQ_BASE=[^\\\'\r\n]|{ESCAPE_SEQUENCE}
CHAR_DOUBLEQ_BASE=[^\\\"\r\n]|{ESCAPE_SEQUENCE}
QUOTED_LITERAL="'"({CHAR_SINGLEQ_BASE})*("'"|\\)?
DOUBLE_QUOTED_LITERAL=\"({CHAR_DOUBLEQ_BASE})*(\"|\\)?
CHAR_LITERAL="'"({CHAR_SINGLEQ_BASE})("'"|\\)? | \"({CHAR_DOUBLEQ_BASE})*(\"|\\)?

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
"'("                        { return ATSTokenTypes.QUOTELPAREN; }
"["                         { return ATSTokenTypes.LBRACKET; }
"{"                         { return ATSTokenTypes.LBRACE; }
"'["                        { return ATSTokenTypes.QUOTELBRACKET; }
"'{"                        { return ATSTokenTypes.QUOTELBRACE; }
//
"@"                         { return ATSTokenTypes.AT; }
//
"\\"                        { return ATSTokenTypes.BACKSLASH; }
"!"                         { return ATSTokenTypes.BANG; }
"`"                         { return ATSTokenTypes.BQUOTE; }
//
":"                         { return ATSTokenTypes.COLON; }
":<"                        { return ATSTokenTypes.COLONLT; }
/*
  | T_COLONLTGT of () // :<> // HX: impossible
*/
//
"$"                         { return ATSTokenTypes.DOLLAR; }
//
"."                         { return ATSTokenTypes.DOT; }
".."                        { return ATSTokenTypes.DOTDOT; }
"..."                       { return ATSTokenTypes.DOTDOTDOT; }
//
"."({DIGIT}+)               { return ATSTokenTypes.DOTINT; }
//
"="                         { return ATSTokenTypes.EQ; }
"=>"                        { return ATSTokenTypes.EQGT; }
"=<"                        { return ATSTokenTypes.EQLT; }
"=<>"                       { return ATSTokenTypes.EQLTGT; }
"=/=>"                      { return ATSTokenTypes.EQSLASHEQGT; }
"=>>"                       { return ATSTokenTypes.EQGTGT; }
"=/=>>"                     { return ATSTokenTypes.EQSLASHEQGTGT; }
//
"#"                         { return ATSTokenTypes.HASH; }
//
"<"                         { return ATSTokenTypes.LT; } // for opening a tmparg
">"                         { return ATSTokenTypes.GT; } // for closing a tmparg
//
"<>"                        { return ATSTokenTypes.GTLT; }
".<"                        { return ATSTokenTypes.DOTLT; } // opening termetric
">."                        { return ATSTokenTypes.GTDOT; } // closing termetric
".<>."                      { return ATSTokenTypes.DOTLTGTDOT; } // empty termetric
//
"->"                        { return ATSTokenTypes.MINUSGT; }
"-<"                        { return ATSTokenTypes.MINUSLT; }
"-<>"                       { return ATSTokenTypes.MINUSLTGT; }
//
"~"                         { return ATSTokenTypes.TILDE; }
//
"abstype"|"abst0ype"|"absprop"|"absview"| "absviewtype"|
"absvtype"|"absviewt@ype"|"absvt0ype"|"absviewt0ype"
                            { return ATSTokenTypes.ABSTYPE; }
//
"and"                       { return ATSTokenTypes.AND; }
"as"                        { return ATSTokenTypes.AS; }
"assume"                    { return ATSTokenTypes.ASSUME; }
"begin"                     { return ATSTokenTypes.BEGIN; }
"case"|"case-"|"case+"|"prcase"
                            { return ATSTokenTypes.CASE; }
"classdec"                  { return ATSTokenTypes.CLASSDEC; }
"datasort"                  { return ATSTokenTypes.DATASORT; }
// BB: surprising to me these all generate the same token:
// (but maybe not exactly, see ./src/pats_lexing_token.dats)
"datatype"|"dataprop"|"dataview"|"dataviewtype"|"datavtype"
                            { return ATSTokenTypes.DATATYPE; }
"do"                        { return ATSTokenTypes.DO; }
"dynload"                   { return ATSTokenTypes.DYNLOAD; }
"else"                      { return ATSTokenTypes.ELSE; }
"end"                       { return ATSTokenTypes.END; }
"exception"                 { return ATSTokenTypes.EXCEPTION; }
//
"extern"                    { return ATSTokenTypes.EXTERN; }
"extype"                    { return ATSTokenTypes.EXTYPE; }
"extvar"                    { return ATSTokenTypes.EXTVAR; }
//
"fix"|"fix@"                { return ATSTokenTypes.FIX; }
"infix"|"infixl"|"infixr"|"prefix"|"postfix"
                            { return ATSTokenTypes.FIXITY; }
"for*"                      { return ATSTokenTypes.FORSTAR; }
"fn"|"fnx"|"fun"|"prfn"|"prfun"|"praxi"|"castfn"
                            { return ATSTokenTypes.FUN; }
"if"                        { return ATSTokenTypes.IF; } // dynamic
"implement"|"primplement"   { return ATSTokenTypes.IMPLEMENT; }
"import"                    { return ATSTokenTypes.IMPORT; }
"in"                        { return ATSTokenTypes.IN; }
"lam"|"llam"|"lam@"         { return ATSTokenTypes.LAM; }
"let"                       { return ATSTokenTypes.LET; }
"local"                     { return ATSTokenTypes.LOCAL; }
"macdef"|"macrodef"         { return ATSTokenTypes.MACDEF; }
"nonfix"                    { return ATSTokenTypes.NONFIX; }
"overload"                  { return ATSTokenTypes.OVERLOAD; }
"of"                        { return ATSTokenTypes.OF; }
"op"                        { return ATSTokenTypes.OP; }
"rec"                       { return ATSTokenTypes.REC; }
"ref@"                      { return ATSTokenTypes.REFAT; }
"require"                   { return ATSTokenTypes.REQUIRE; }
"scase"                     { return ATSTokenTypes.SCASE; }
"sif"                       { return ATSTokenTypes.SIF; } // static
"sortdef"                   { return ATSTokenTypes.SORTDEF; }
"stacst"                    { return ATSTokenTypes.STACST; }
"stadef"                    { return ATSTokenTypes.STADEF; }
"staload"                   { return ATSTokenTypes.STALOAD; }
"static"                    { return ATSTokenTypes.STATIC; }
/*
  | T_STAVAR of () // stavar // HX: a suspended hack
*/
"symelim"                   { return ATSTokenTypes.SYMELIM; }
"symintr"                   { return ATSTokenTypes.SYMINTR; }
"then"                      { return ATSTokenTypes.THEN; }
"tkindef"                   { return ATSTokenTypes.TKINDEF; }
"try"                       { return ATSTokenTypes.TRY; }
"type"|"type+"|"type-"      { return ATSTokenTypes.TYPE; }
"typedef"|"propdef"|"viewdef"|"viewtypedef" // CHECK_ME: aliases?
                            { return ATSTokenTypes.TYPEDEF; }
"val"|"val+"|"val-"|"prval" { return ATSTokenTypes.VAL; }
"var"|"prvar"               { return ATSTokenTypes.VAR; }
"when"                      { return ATSTokenTypes.WHEN; }
"where"                     { return ATSTokenTypes.WHERE; }
"while"                     { return ATSTokenTypes.WHILE; }
"while*"                    { return ATSTokenTypes.WHILESTAR; }
"with"                      { return ATSTokenTypes.WITH; }
"withtype"|"withprop"|"withview"|"withviewtype"
                            { return ATSTokenTypes.WITHTYPE; }
//
"addr@"                     { return ATSTokenTypes.ADDRAT; }
"fold@"                     { return ATSTokenTypes.FOLDAT; }
"free@"                     { return ATSTokenTypes.FREEAT; }
"view@"                     { return ATSTokenTypes.VIEWAT; }
//
"$arrpsz"|"$arrptrsize"     { return ATSTokenTypes.DLRARRPSZ; }
//
"$delay"|"$ldelay"          { return ATSTokenTypes.DLRDELAY; }
//
"$effmask"                  { return ATSTokenTypes.DLREFFMASK; }
"ntm"|"exn"|"ref"|"wrt"|"all"
                            { return ATSTokenTypes.DLREFFMASK_ARG; }
"$extern"                   { return ATSTokenTypes.DLREXTERN; }
"$extkind"                  { return ATSTokenTypes.DLREXTKIND; }
"$extype"                   { return ATSTokenTypes.DLREXTYPE; }
"$extype_struct"            { return ATSTokenTypes.DLREXTYPE_STRUCT; }
//
"$extval"                   { return ATSTokenTypes.DLREXTVAL; }
"$extfcall"                 { return ATSTokenTypes.DLREXTFCALL; }
"$extmcall"                 { return ATSTokenTypes.DLREXTMCALL; }
//
"$break"                    { return ATSTokenTypes.DLRBREAK; }
"$continue"                 { return ATSTokenTypes.DLRCONTINUE; }
"$raise"                    { return ATSTokenTypes.DLRRAISE; }
//
"$lst"|"$list"|"$lst_t"|"$list_t"|"$lst_vt"|"$list_vt"
                            { return ATSTokenTypes.DLRLST; }
"$rec"|"$record"|"$rec_t"|"$record_t"|"$rec_vt"|"$record_vt"
                            { return ATSTokenTypes.DLRREC; }
"$tup"|"$tup_t"|"$tup_vt"|"$tuple"|"$tuple_t"|"$tuple_vt"
                            { return ATSTokenTypes.DLRTUP; }
//
"$myfilename"               { return ATSTokenTypes.DLRMYFILENAME; }
"$mylocation"               { return ATSTokenTypes.DLRMYLOCATION; }
"$myfunction"               { return ATSTokenTypes.DLRMYFUNCTION; }
//
"$showtype"                 { return ATSTokenTypes.DLRSHOWTYPE; }
//
"$vcopyenv_v"|"$vcopyenv_vt(vt)"
                            { return ATSTokenTypes.DLRVCOPYENV; }
//
"#assert"                   { return ATSTokenTypes.SRPASSERT; }
"#define"                   { return ATSTokenTypes.SRPDEFINE; }
"#elif"                     { return ATSTokenTypes.SRPELIF; }
"#elifdef"                  { return ATSTokenTypes.SRPELIFDEF; }
"#elifndef"                 { return ATSTokenTypes.SRPELIFNDEF; }
"#else"                     { return ATSTokenTypes.SRPELSE; }
"#endif"                    { return ATSTokenTypes.SRPENDIF; }
"#error"                    { return ATSTokenTypes.SRPERROR; }
"#if"                       { return ATSTokenTypes.SRPIF; }
"#ifdef"                    { return ATSTokenTypes.SRPIFDEF; }
"#ifndef"                   { return ATSTokenTypes.SRPIFNDEF; }
"#include"                  { return ATSTokenTypes.SRPINCLUDE; }
"#print"                    { return ATSTokenTypes.SRPPRINT; }
"#then"                     { return ATSTokenTypes.SRPTHEN; }
"#undef"                    { return ATSTokenTypes.SRPUNDEF; }
//
// The internal lexing of views + types seems to be a bit complicated
// For now I try to simplify it a bit; currently not handled: (FIX_ME)
// T_IDENT_alp
//
{INTEGER_LITERAL}           { return ATSTokenTypes.INT; }  // CHECK_ME
{CHAR_LITERAL}              { return ATSTokenTypes.CHAR; }  // CHECK_ME
{FLOAT_LITERAL}             { return ATSTokenTypes.FLOAT; }
//""                          { return ATSTokenTypes.CDATA; }  // FIX_ME
{QUOTED_LITERAL}|{DOUBLE_QUOTED_LITERAL}
                            { return ATSTokenTypes.STRING; }  // CHECK_ME
//
/*
  | T_LABEL of (int(*knd*), string) // HX-2013-01: should it be supported?
*/
//
","                         { return ATSTokenTypes.COMMA; }
";"                         { return ATSTokenTypes.SEMICOLON; }
//
"("                         { return ATSTokenTypes.LPAREN; }
")"                         { return ATSTokenTypes.RPAREN; }
"]"                         { return ATSTokenTypes.RBRACKET; }
"}"                         { return ATSTokenTypes.RBRACE; }
//
"@("                        { return ATSTokenTypes.ATLPAREN; }
"@["                        { return ATSTokenTypes.ATLBRACKET; }
"#["                        { return ATSTokenTypes.HASHLBRACKETOLON; }
"@{"                        { return ATSTokenTypes.ATLBRACE; }
//
// For macros:
//
"`("                        { return ATSTokenTypes.BQUOTELPAREN; }
",("                        { return ATSTokenTypes.COMMALPAREN; }
"%("                        { return ATSTokenTypes.PERCENTLPAREN; }
//
""                          { return ATSTokenTypes.EXTCODE; } //FIX_ME
//
{END_OF_LINE_COMMENT}       { return ATSTokenTypes.COMMENT_LINE; }
{TRADITIONAL_COMMENT}       { return ATSTokenTypes.COMMENT_BLOCK; }
{END_OF_FILE_COMMENT}       { return ATSTokenTypes.COMMENT_REST; }
{COMMENT}                   { return ATSTokenTypes.COMMENT; }
// FIX_ME for the next two ("can never be matched")
"%"                         { return ATSTokenTypes.PERCENT; }
"?"                         { return ATSTokenTypes.QMARK; }

//Not ATS tokens, precisely:
{WHITE_SPACE}               { return ATSTokenTypes.WHITE_SPACE; }
{IDENTIFIER}                { return ATSTokenTypes.IDENTIFIER; }

} // End of <YYINITIAL>

/* Not using for now
<STRING> {
\" { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString()); }
[^\n\r\"\\]+ { string.append( yytext() ); }
\\t { string.append('\t'); }
\\n { string.append('\n'); }
\\r { string.append('\r'); }
\\\" { string.append('\"'); }
\\ { string.append('\\'); }
} // End of <STRING>
*/
//
<<EOF>>                     { return ATSTokenTypes.EOF; }
//
// Match anything not picked up and throw an error:
//
[^]         { throw new Error("Illegal character <"+yytext()+">"); }
""          { return ATSTokenTypes.NONE; } // CHECK_ME
//





























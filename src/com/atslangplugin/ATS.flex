package com.atslangplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.atslangplugin.psi.ATSTypes;
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
COMMENT = {TRADITIONAL_COMMENT} | {END_OF_LINE_COMMENT} | {END_OF_FILE_COMMENT}
        | {DOCUMENTATION_COMMENT} | {COMMENT_CONTENT}
END_OF_LINE_COMMENT = "//" {VALUE_CHARACTER}* {CRLF}?
END_OF_FILE_COMMENT = "////" (.* {CRLF}?)* // CHECK_ME
DOCUMENTATION_COMMENT = "(*" (\*+\ +{CRLF}?)* {COMMENT_CONTENT} (\*+\ +{CRLF}?)* "*)"
COMMENT_CONTENT = ( [^*] | \*+ [^)*] ) // should we delimit the ')' ?
TRADITIONAL_COMMENT = "(*" [^*] ~"*)"

OCT_INT_LITERAL = 0 | [1-9][0-9]* // FIX_ME
DEC_INT_LITERAL = 0 | [1-9][0-9]* // CHECK_ME
HEX_INT_LITERAL = 0 | [1-9][0-9]* // FIX_ME


%state STRING

%%

/* for more information, see the following */
/* in the ATS-Postiats source repository:  */
/* src/pats_lexing.sats                    */
/* src/pats_lexing_token.dats              */

/*  *** *** keywords and symbols  *** ***  */

<YYINITIAL> ""          { return ATSTypes.NONE; } // CHECK_ME
//
<YYINITIAL> "@"         { return ATSTypes.AT; }
//
<YYINITIAL> "\\"        { return ATSTypes.BACKSLASH; }
<YYINITIAL> "!"         { return ATSTypes.BANG; }
<YYINITIAL> "`"         { return ATSTypes.BQUOTE; }
//
<YYINITIAL> ":"         { return ATSTypes.COLON; }
<YYINITIAL> ":<"        { return ATSTypes.COLONLT; }
/*
  | T_COLONLTGT of () // :<> // HX: impossible
*/
//
<YYINITIAL> "$"                         { return ATSTypes.DOLLAR; }
//
<YYINITIAL> "."                         { return ATSTypes.DOT; }
<YYINITIAL> ".."                        { return ATSTypes.DOTDOT; }
<YYINITIAL> "..."                       { return ATSTypes.DOTDOTDOT; }
//
<YYINITIAL> "."{DEC_INT_LITERAL}        { return ATSTypes.DOTINT; }
//
<YYINITIAL> "="                         { return ATSTypes.EQ; }
<YYINITIAL> "=>"                        { return ATSTypes.EQGT; }
<YYINITIAL> "=<"                        { return ATSTypes.EQLT; }
<YYINITIAL> "=<>"                       { return ATSTypes.EQLTGT; }
<YYINITIAL> "=/=>"                      { return ATSTypes.EQSLASHEQGT; }
<YYINITIAL> "=>>"                       { return ATSTypes.EQGTGT; }
<YYINITIAL> "=/=>>"                     { return ATSTypes.EQSLASHEQGTGT; }
//
<YYINITIAL> "#"                         { return ATSTypes.HASH; }
//
<YYINITIAL> "<"                         { return ATSTypes.LT; } // for opening a tmparg
<YYINITIAL> ">"                         { return ATSTypes.GT; } // for closing a tmparg
//
<YYINITIAL> "<>"                        { return ATSTypes.GTLT; }
<YYINITIAL> ".<"                        { return ATSTypes.DOTLT; } // opening termetric
<YYINITIAL> ">."                        { return ATSTypes.GTDOT; } // closing termetric
<YYINITIAL> ".<>."                      { return ATSTypes.DOTLTGTDOT; } // empty termetric
//
<YYINITIAL> "->"                        { return ATSTypes.MINUSGT; }
<YYINITIAL> "-<"                        { return ATSTypes.MINUSLT; }
<YYINITIAL> "-<>"                       { return ATSTypes.MINUSLTGT; }
//
<YYINITIAL> "~"                         { return ATSTypes.TILDE; }
//
<YYINITIAL> "abstype"|"abst0ype"|"absprop"|"absview"|
            "absviewtype"|"absvtype"|"absviewt@ype"|"absvt0ype"|"absviewt0ype"
                                        { return ATSTypes.ABSTYPE; }
//
<YYINITIAL> "and"                       { return ATSTypes.AND; }
<YYINITIAL> "as"                        { return ATSTypes.AS; }
<YYINITIAL> "assume"                    { return ATSTypes.ASSUME; }
<YYINITIAL> "begin"                     { return ATSTypes.BEGIN; }
<YYINITIAL> "begin"                     { return ATSTypes.BEGIN; }
<YYINITIAL> "case"|"case-"|"case+"|"prcase"
                                        { return ATSTypes.CASE; }
<YYINITIAL> "classdec"                  { return ATSTypes.CLASSDEC; }
<YYINITIAL> "datasort"                  { return ATSTypes.DATASORT; }
// BB: surprising to me these all generate the same token:
// (but maybe not exactly, see ./src/pats_lexing_token.dats)
<YYINITIAL> "datatype"|"dataprop"|"dataview"|"dataviewtype"|"datavtype"
                                        { return ATSTypes.DATATYPE; }
<YYINITIAL> "do"                        { return ATSTypes.DO; }
<YYINITIAL> "dynload"                   { return ATSTypes.DYNLOAD; }
<YYINITIAL> "else"                      { return ATSTypes.ELSE; }
<YYINITIAL> "end"                       { return ATSTypes.END; }
<YYINITIAL> "exception"                 { return ATSTypes.EXCEPTION; }
//
<YYINITIAL> "extern"                    { return ATSTypes.EXTERN; }
<YYINITIAL> "extype"                    { return ATSTypes.EXTYPE; }
<YYINITIAL> "extvar"                    { return ATSTypes.EXTVAR; }
//
<YYINITIAL> "fix"|"fix@"                { return ATSTypes.FIX; }
<YYINITIAL> "infix"|"infixl"|"infixr"|"prefix"|"postfix"
                                        { return ATSTypes.FIXITY; }
<YYINITIAL> "for*"                      { return ATSTypes.FORSTAR; }
<YYINITIAL> "fn"|"fnx"|"fun"|"prfn"|"prfun"|"praxi"|"castfn"
                                        { return ATSTypes.FUN; }
<YYINITIAL> "if"                        { return ATSTypes.IF; } // dynamic
<YYINITIAL> "implement"|"primplement"   { return ATSTypes.IMPLEMENT; }
<YYINITIAL> "import"                    { return ATSTypes.IMPORT; }
<YYINITIAL> "in"                        { return ATSTypes.IN; }
<YYINITIAL> "lam"|"llam"|"lam@"         { return ATSTypes.LAM; }
<YYINITIAL> "let"                       { return ATSTypes.LET; }
<YYINITIAL> "local"                     { return ATSTypes.LOCAL; }
<YYINITIAL> "macdef"|"macrodef"         { return ATSTypes.MACDEF; }
<YYINITIAL> "nonfix"                    { return ATSTypes.NONFIX; }
<YYINITIAL> "overload"                  { return ATSTypes.OVERLOAD; }
<YYINITIAL> "of"                        { return ATSTypes.OF; }
<YYINITIAL> "op"                        { return ATSTypes.OP; }
<YYINITIAL> "rec"                       { return ATSTypes.REC; }
<YYINITIAL> "ref@"                      { return ATSTypes.REFAT; }
<YYINITIAL> "require"                   { return ATSTypes.REQUIRE; }
<YYINITIAL> "scase"                     { return ATSTypes.SCASE; }
<YYINITIAL> "sif"                       { return ATSTypes.SIF; } // static
<YYINITIAL> "sortdef"                   { return ATSTypes.SORTDEF; }
<YYINITIAL> "stacst"                    { return ATSTypes.STACST; }
<YYINITIAL> "stadef"                    { return ATSTypes.STADEF; }
<YYINITIAL> "staload"                   { return ATSTypes.STALOAD; }
<YYINITIAL> "static"                    { return ATSTypes.STATIC; }
/*
  | T_STAVAR of () // stavar // HX: a suspended hack
*/
<YYINITIAL> "symelim"                   { return ATSTypes.SYMELIM; }
<YYINITIAL> "symintr"                   { return ATSTypes.SYMINTR; }
<YYINITIAL> "then"                      { return ATSTypes.THEN; }
<YYINITIAL> "tkindef"                   { return ATSTypes.TKINDEF; }
<YYINITIAL> "try"                       { return ATSTypes.TRY; }
<YYINITIAL> "type"|"type+"|"type-"      { return ATSTypes.TYPE; }
<YYINITIAL> "typedef"|"propdef"|"viewdef"|"viewtypedef" // CHECK_ME: aliases?
                                        { return ATSTypes.TYPEDEF; }
<YYINITIAL> "val"|"val+"|"val-"|"prval" { return ATSTypes.VAL; }
<YYINITIAL> "var"|"prvar"               { return ATSTypes.VAR; }
<YYINITIAL> "when"                      { return ATSTypes.WHEN; }
<YYINITIAL> "where"                     { return ATSTypes.WHERE; }
<YYINITIAL> "while"                     { return ATSTypes.WHILE; }
<YYINITIAL> "while*"                    { return ATSTypes.WHILESTAR; }
<YYINITIAL> "with"                      { return ATSTypes.WITH; }
<YYINITIAL> "withtype"|"withprop"|"withview"|"withviewtype"
                                        { return ATSTypes.WITHTYPE; }
//
<YYINITIAL> "addr@"                     { return ATSTypes.ADDRAT; }
<YYINITIAL> "fold@"                     { return ATSTypes.FOLDAT; }
<YYINITIAL> "free@"                     { return ATSTypes.FREEAT; }
<YYINITIAL> "view@"                     { return ATSTypes.VIEWAT; }
//
<YYINITIAL> "$arrpsz"|"$arrptrsize"     { return ATSTypes.DLRARRPSZ; }
//
<YYINITIAL> "$delay"|"$ldelay"          { return ATSTypes.DLRDELAY; }
//
<YYINITIAL> "$effmask"                  { return ATSTypes.DLREFFMASK; }
<YYINITIAL> "ntm"|"exn"|"ref"|"wrt"|"all"
                                        { return ATSTypes.DLREFFMASK_ARG; }
<YYINITIAL> "$extern"                   { return ATSTypes.DLREXTERN; }
<YYINITIAL> "$extkind"                  { return ATSTypes.DLREXTKIND; }
<YYINITIAL> "$extype"                   { return ATSTypes.DLREXTYPE; }
<YYINITIAL> "$extype_struct"            { return ATSTypes.DLREXTYPE_STRUCT; }
//
<YYINITIAL> "$extval"                   { return ATSTypes.DLREXTVAL; }
<YYINITIAL> "$extfcall"                 { return ATSTypes.DLREXTFCALL; }
<YYINITIAL> "$extmcall"                 { return ATSTypes.DLREXTMCALL; }
//
<YYINITIAL> "$break"                    { return ATSTypes.DLRBREAK; }
<YYINITIAL> "$continue"                 { return ATSTypes.DLRCONTINUE; }
<YYINITIAL> "$raise"                    { return ATSTypes.DLRRAISE; }
//
<YYINITIAL> "$lst"|"$list"|"$lst_t"|"$list_t"|"$lst_vt"|"$list_vt"
                                        { return ATSTypes.DLRLST; }
<YYINITIAL> "$rec"|"$record"|"$rec_t"|"$record_t"|"$rec_vt"|"$record_vt"
                                        { return ATSTypes.DLRREC; }
<YYINITIAL> "$tup"|"$tup_t"|"$tup_vt"|"$tuple"|"$tuple_t"|"$tuple_vt"
                                        { return ATSTypes.DLRTUP; }
//
<YYINITIAL> "$myfilename"               { return ATSTypes.DLRMYFILENAME; }
<YYINITIAL> "$mylocation"               { return ATSTypes.DLRMYLOCATION; }
<YYINITIAL> "$myfunction"               { return ATSTypes.DLRMYFUNCTION; }
//
<YYINITIAL> "$showtype"                 { return ATSTypes.DLRSHOWTYPE; }
//
<YYINITIAL> "$vcopyenv_v"|"$vcopyenv_vt(vt)"
                                        { return ATSTypes.DLRVCOPYENV; }
//
<YYINITIAL> "#assert"                   { return ATSTypes.SRPASSERT; }
<YYINITIAL> "#define"                   { return ATSTypes.SRPDEFINE; }
<YYINITIAL> "#elif"                     { return ATSTypes.SRPELIF; }
<YYINITIAL> "#elifdef"                  { return ATSTypes.SRPELIFDEF; }
<YYINITIAL> "#elifndef"                 { return ATSTypes.SRPELIFNDEF; }
<YYINITIAL> "#else"                     { return ATSTypes.SRPELSE; }
<YYINITIAL> "#endif"                    { return ATSTypes.SRPENDIF; }
<YYINITIAL> "#error"                    { return ATSTypes.SRPERROR; }
<YYINITIAL> "#if"                       { return ATSTypes.SRPIF; }
<YYINITIAL> "#ifdef"                    { return ATSTypes.SRPIFDEF; }
<YYINITIAL> "#ifndef"                   { return ATSTypes.SRPIFNDEF; }
<YYINITIAL> "#include"                  { return ATSTypes.SRPINCLUDE; }
<YYINITIAL> "#print"                    { return ATSTypes.SRPPRINT; }
<YYINITIAL> "#then"                     { return ATSTypes.SRPTHEN; }
<YYINITIAL> "#undef"                    { return ATSTypes.SRPUNDEF; }
//
// The internal lexing of views + types seems to be a bit complicated
// For now I try to simplify it a bit; currently not handled: (FIX_ME)
// T_IDENT_alp
//
<YYINITIAL> ""                          { return ATSTypes.INT; }  // FIX_ME
<YYINITIAL> ""                          { return ATSTypes.CHAR; }  // FIX_ME
<YYINITIAL> ""                          { return ATSTypes.FLOAT; }  // FIX_ME
<YYINITIAL> ""                          { return ATSTypes.CDATA; }  // FIX_ME
<YYINITIAL> ""                          { return ATSTypes.STRING; }  // FIX_ME
//
/*
  | T_LABEL of (int(*knd*), string) // HX-2013-01: should it be supported?
*/
//
<YYINITIAL> ","                         { return ATSTypes.COMMA; }
<YYINITIAL> ";"                         { return ATSTypes.SEMICOLON; }
//
<YYINITIAL> "("                         { return ATSTypes.LPAREN; }
<YYINITIAL> ")"                         { return ATSTypes.RPAREN; }
<YYINITIAL> "["                         { return ATSTypes.LBRACKET; }
<YYINITIAL> "]"                         { return ATSTypes.RBRACKET; }
<YYINITIAL> "{"                         { return ATSTypes.LBRACE; }
<YYINITIAL> "}"                         { return ATSTypes.RBRACE; }
//
<YYINITIAL> "@("                        { return ATSTypes.ATLPAREN; }
<YYINITIAL> "'("                        { return ATSTypes.QUOTELPAREN; }
<YYINITIAL> "@["                        { return ATSTypes.ATLBRACKET; }
<YYINITIAL> "'["                        { return ATSTypes.QUOTELBRACKET; }
<YYINITIAL> "#["                        { return ATSTypes.HASHLBRACKETOLON; }
<YYINITIAL> "@{"                        { return ATSTypes.ATLBRACE; }
<YYINITIAL> "'{"                        { return ATSTypes.QUOTELBRACE; }
//
// For macros:
//
<YYINITIAL> "`("                        { return ATSTypes.BQUOTELPAREN; }
<YYINITIAL> ",("                        { return ATSTypes.COMMALPAREN; }
<YYINITIAL> "%("                        { return ATSTypes.LPAREN; }
//
<YYINITIAL> ""                          { return ATSTypes.EXTCODE; } //FIX_ME
//
<YYINITIAL> {END_OF_LINE_COMMENT}       { return ATSTypes.COMMENT_line; }
<YYINITIAL> {TRADITIONAL_COMMENT}       { return ATSTypes.COMMENT_block; }
<YYINITIAL> {END_OF_FILE_COMMENT}       { return ATSTypes.COMMENT_rest; }
//
<YYINITIAL> "%"                         { return ATSTypes.PERCENT; }
<YYINITIAL> "?"                         { return ATSTypes.QMARK; }
//
<<EOF>>                                 { return ATSTypes.EOF; }
[^]         {throw new Error("Illegal character <"+yytext()+">"); }
//





























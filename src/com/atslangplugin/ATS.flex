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
<YYINITIAL> "absview"|"absviewtype"|"absviewt@ype"
                                        { return symbol(sym.ABSTYPE); }
//
<YYINITIAL> "and"                       { return symbol(sym.AND); }
<YYINITIAL> "as"                        { return symbol(sym.AS); }
<YYINITIAL> "assume"                    { return symbol(sym.ASSUME); }
<YYINITIAL> "begin"                     { return symbol(sym.BEGIN); }
<YYINITIAL> "begin"                     { return symbol(sym.BEGIN); }
<YYINITIAL> "case"|"case-"|"case+"|"prcase"
                                        { return symbol(sym.CASE); }
<YYINITIAL> "classdec"                  { return symbol(sym.CLASSDEC); }
<YYINITIAL> "datasort"                  { return symbol(sym.DATASORT); }
// BB: surprising to me these all generate the same token:
<YYINITIAL> "datatype"|"dataprop"|"dataview"|"dataviewtype"
                                        { return symbol(sym.DATATYPE); }
<YYINITIAL> "do"                        { return symbol(sym.DO); }
<YYINITIAL> "dynload"                   { return symbol(sym.DYNLOAD); }
<YYINITIAL> "else"                      { return symbol(sym.ELSE); }
<YYINITIAL> "end"                       { return symbol(sym.END); }
<YYINITIAL> "exception"                 { return symbol(sym.EXCEPTION); }
//
<YYINITIAL> "extern"                    { return symbol(sym.EXTERN); }
<YYINITIAL> "extype"                    { return symbol(sym.EXTYPE); }
<YYINITIAL> "extvar"                    { return symbol(sym.EXTVAR); }
//
<YYINITIAL> "fix"|"fix@"                { return symbol(sym.FIX); }
<YYINITIAL> "infix"|"infixl"|"infixr"|"prefix"|"postfix"
                                        { return symbol(sym.FIXITY); }
<YYINITIAL> "for*"                      { return symbol(sym.FORSTAR); }
<YYINITIAL> "fn"|"fnx"|"fun"|"prfn"|"prfun"
                                        { return symbol(sym.FUN); }
<YYINITIAL> "if"                        { return symbol(sym.IF); } // dynamic
<YYINITIAL> "implement"|"primplement"   { return symbol(sym.IMPLEMENT); }
<YYINITIAL> "import"                    { return symbol(sym.IMPORT); }
<YYINITIAL> "in"                        { return symbol(sym.IN); }
<YYINITIAL> "lam"|"llam"|"lam@"         { return symbol(sym.LAM); }
<YYINITIAL> "let"                       { return symbol(sym.LET); }
<YYINITIAL> "local"                     { return symbol(sym.LOCAL); }
<YYINITIAL> "macdef"|"macrodef"         { return symbol(sym.MACDEF); }
<YYINITIAL> "nonfix"                    { return symbol(sym.NONFIX); }
<YYINITIAL> "overload"                  { return symbol(sym.OVERLOAD); }
<YYINITIAL> "of"                        { return symbol(sym.OF); }
<YYINITIAL> "op"                        { return symbol(sym.OP); }
<YYINITIAL> "rec"                       { return symbol(sym.REC); }
<YYINITIAL> "ref@"                      { return symbol(sym.REFAT); }
<YYINITIAL> "require"                   { return symbol(sym.REQUIRE); }
<YYINITIAL> "scase"                     { return symbol(sym.SCASE); }
<YYINITIAL> "sif"                       { return symbol(sym.SIF); } // static
<YYINITIAL> "sortdef"                   { return symbol(sym.SORTDEF); }
<YYINITIAL> "stacst"                    { return symbol(sym.STACST); }
<YYINITIAL> "stadef"                    { return symbol(sym.STADEF); }
<YYINITIAL> "staload"                   { return symbol(sym.STALOAD); }
<YYINITIAL> "static"                    { return symbol(sym.STATIC); }
/*
  | T_STAVAR of () // stavar // HX: a suspended hack
*/
<YYINITIAL> "symelim"                   { return symbol(sym.SYMELIM); }
<YYINITIAL> "symintr"                   { return symbol(sym.SYMINTR); }
<YYINITIAL> "then"                      { return symbol(sym.THEN); }
<YYINITIAL> "tkindef"                   { return symbol(sym.TKINDEF); }
<YYINITIAL> "try"                       { return symbol(sym.TRY); }
<YYINITIAL> "type"|"type+"|"type-"      { return symbol(sym.TYPE); }
<YYINITIAL> "typedef"|"propdef"|"viewdef"|"viewtypedef" // CHECK_ME: aliases?
                                        { return symbol(sym.TYPEDEF); }
<YYINITIAL> "val"|"val+"|"val-"|"prval" { return symbol(sym.VAL); }
<YYINITIAL> "var"|"prvar"               { return symbol(sym.VAR); }
<YYINITIAL> "when"                      { return symbol(sym.WHEN); }
<YYINITIAL> "where"                     { return symbol(sym.WHERE); }
<YYINITIAL> "while"                     { return symbol(sym.WHILE); }
<YYINITIAL> "while*"                    { return symbol(sym.WHILESTAR); }
<YYINITIAL> "with"                      { return symbol(sym.WITH); }
<YYINITIAL> "withtype"|"withprop"|"withview"|"withviewtype"
                                        { return symbol(sym.WITHTYPE); }
//
<YYINITIAL> "addr@"                     { return symbol(sym.ADDRAT); }
<YYINITIAL> "fold@"                     { return symbol(sym.FOLDAT); }
<YYINITIAL> "free@"                     { return symbol(sym.FREEAT); }
<YYINITIAL> "view@"                     { return symbol(sym.VIEWAT); }
//
<YYINITIAL> "$arrpsz"|"$arrptrsize"     { return symbol(sym.DLRARRPSZ); }
//
<YYINITIAL> "$delay"|"$ldelay"          { return symbol(sym.DLRDELAY); }
//
<YYINITIAL> "$effmask"                  { return symbol(sym.DLREFFMASK); }
<YYINITIAL> "ntm"|"exn"|"ref"|"wrt"|"all"
                                        { return symbol(sym.DLREFFMASK_ARG); }
<YYINITIAL> "$extern"                   { return symbol(sym.DLREXTERN); }
<YYINITIAL> "$extkind"                  { return symbol(sym.DLREXTKIND); }
<YYINITIAL> "$extype"                   { return symbol(sym.DLREXTYPE); }
<YYINITIAL> "$extype_struct"            { return symbol(sym.DLREXTYPE_STRUCT); }
//
<YYINITIAL> "$extval"                   { return symbol(sym.DLREXTVAL); }
<YYINITIAL> "$extfcall"                 { return symbol(sym.DLREXTFCALL); }
<YYINITIAL> "$extmcall"                 { return symbol(sym.DLREXTMCALL); }
//
<YYINITIAL> "$break"                    { return symbol(sym.DLRBREAK); }
<YYINITIAL> "$continue"                 { return symbol(sym.DLRCONTINUE); }
<YYINITIAL> "$raise"                    { return symbol(sym.DLRRAISE); }
//
<YYINITIAL> "$lst"|"$list"|"$lst_t"|"$list_t"|"$lst_vt"|"$list_vt"
                                        { return symbol(sym.DLRLST); }
<YYINITIAL> "$rec"|"$record"|"$rec_t"|"$record_t"|"$rec_vt"|"$record_vt"
                                        { return symbol(sym.DLRREC); }
<YYINITIAL> "$tup"|"$tup_t"|"$tup_vt"|"$tuple"|"$tuple_t"|"$tuple_vt"
                                        { return symbol(sym.DLRTUP); }
//
<YYINITIAL> "$myfilename"               { return symbol(sym.DLRMYFILENAME); }
<YYINITIAL> "$mylocation"               { return symbol(sym.DLRMYLOCATION); }
<YYINITIAL> "$myfunction"               { return symbol(sym.DLRMYFUNCTION); }
//
<YYINITIAL> "$showtype"                 { return symbol(sym.DLRSHOWTYPE); }
//
<YYINITIAL> "$vcopyenv_v"|"$vcopyenv_vt(vt)"
                                        { return symbol(sym.DLRVCOPYENV); }
//
<YYINITIAL> "#assert"                   { return symbol(sym.SRPASSERT); }
<YYINITIAL> "#define"                   { return symbol(sym.SRPDEFINE); }
<YYINITIAL> "#elif"                     { return symbol(sym.SRPELIF); }
<YYINITIAL> "#elifdef"                  { return symbol(sym.SRPELIFDEF); }
<YYINITIAL> "#elifndef"                 { return symbol(sym.SRPELIFNDEF); }
<YYINITIAL> "#else"                     { return symbol(sym.SRPELSE); }
<YYINITIAL> "#endif"                    { return symbol(sym.SRPENDIF); }
<YYINITIAL> "#error"                    { return symbol(sym.SRPERROR); }
<YYINITIAL> "#if"                       { return symbol(sym.SRPIF); }
<YYINITIAL> "#ifdef"                    { return symbol(sym.SRPIFDEF); }
<YYINITIAL> "#ifndef"                   { return symbol(sym.SRPIFNDEF); }
<YYINITIAL> "#include"                  { return symbol(sym.SRPINCLUDE); }
<YYINITIAL> "#print"                    { return symbol(sym.SRPPRINT); }
<YYINITIAL> "#then"                     { return symbol(sym.SRPTHEN); }
<YYINITIAL> "#undef"                    { return symbol(sym.SRPUNDEF); }
//




















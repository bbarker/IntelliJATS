package com.atslangplugin;

import com.atslangplugin.parser.ATSParser;
import com.atslangplugin.psi.ATSTypes;
import com.atslangplugin.psi.ATSFile;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.sun.javafx.fxml.expression.Expression;
import groovy.util.IFileNameFinder;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

/**
 * Created by Brandon Elam Barker on 12/20/2014.
 */
public class ATSParserDefinition implements ParserDefinition{
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(ATSTypes.COMMENT);

    public static final IFileElementType FILE = new IFileElementType(
            Language.<ATSLanguage>findInstance(ATSLanguage.class)
    );

    @NotNull
    @Override
    public Lexer createLexer(Project project){
        return new FlexAdapter(new ATSLexer((Reader) null));
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new ATSParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ATSFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(
            ASTNode Left,  ASTNode Right
    ) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return ATSTypes.Factory.createElement(node);
    }


}

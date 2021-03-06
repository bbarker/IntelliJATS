IntelliJATS
===========

An ATS Plugin for IntelliJ IDEA.

![Image of IntelliJATS](http://i.imgur.com/sfqAJcG.png)

## Current Features
* Complete JFlex lexer based on the ATS2 lexer definition
* Customizable syntax highlighting
* Building ATS programs (indirectly; use a [makefile wrapper](https://gist.github.com/bbarker/c73ecf257bca966c1efd))
* An icon for the various ATS files

## Important Notes for Development

Before working with this project, you'll want to follow
the prerequisites found in the [IntelliJ Documentation]
(https://confluence.jetbrains.com/display/IntelliJIDEA/Prerequisites).

If you plan to try using the PSI parser or possibly other
parts of the PSI toolkit, you'll need to mark the `gen` folder as a
"Sources Root" in IntelliJ.

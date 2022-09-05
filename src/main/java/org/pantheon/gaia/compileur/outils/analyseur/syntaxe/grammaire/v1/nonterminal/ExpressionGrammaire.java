package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.NonTerminalGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.*;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Grammaire pour une expression.
 */
public class ExpressionGrammaire extends NonTerminalGrammaire {
    /**
     * Initialise une nouvelle instance de la classe {@link ExpressionGrammaire}.
     */
    public ExpressionGrammaire() {
        super(ETypeSymbole.EXPRESSION);
    }

    @Override
    protected void initialiser() {
        this.ajouterSymboleDirecteur(new CaractereGrammaire());
        this.ajouterSymboleDirecteur(new BooleenGrammaire());
        this.ajouterSymboleDirecteur(new ChaineGrammaire());
        this.ajouterSymboleDirecteur(new ReelGrammaire());
        this.ajouterSymboleDirecteur(new EntierGrammaire());
    }

}

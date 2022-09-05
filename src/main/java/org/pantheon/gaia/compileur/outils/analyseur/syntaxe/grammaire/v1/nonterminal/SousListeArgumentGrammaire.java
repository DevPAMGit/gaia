package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.NonTerminalGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.VirguleGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Grammaire pour une sous-liste.
 */
public class SousListeArgumentGrammaire extends NonTerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link NonTerminalGrammaire}.
     */
    public SousListeArgumentGrammaire() {
        super(ETypeSymbole.SOUS_LISTE_ARGUMENTS);
    }

    @Override
    protected void initialiser() {
        this.ajouterSymboleDirecteur(new VideGrammaire());
        this.ajouterSymboleDirecteur(new VirguleGrammaire());

        this.ajouterSequence(ETypeSymbole.VIRGULE, new ExpressionGrammaire());
        this.ajouterSequence(ETypeSymbole.VIRGULE, this);
    }
}

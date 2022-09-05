package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.NonTerminalGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.ParentheseFermanteGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Classe d'état pour un symbole de type vide.
 */
public class VideGrammaire extends NonTerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link VideGrammaire}.
     */
    public VideGrammaire() {
        super(ETypeSymbole.VIDE);
    }

    @Override
    protected void initialiser() {
        this.ajouterSymboleDirecteur(new ParentheseFermanteGrammaire());
    }
}

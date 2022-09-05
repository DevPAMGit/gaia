package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.Grammaire;

/**
 * Grammaire pour une parenthèse fermante.
 */
public class ParentheseFermanteGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link Grammaire}.
     */
    public ParentheseFermanteGrammaire() {
        super(ETypeSymbole.PARENTHESE_FERMANTE);
    }

    @Override
    protected void initialiser() {
    }
}

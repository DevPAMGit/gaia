package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Grammaire désignant la fin.
 */
public class FinGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link FinGrammaire}.
     */
    public FinGrammaire() {
        super(ETypeSymbole.FIN);
    }

    @Override
    protected void initialiser() {

    }
}

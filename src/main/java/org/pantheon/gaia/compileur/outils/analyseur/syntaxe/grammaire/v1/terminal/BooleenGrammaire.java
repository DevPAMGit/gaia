package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.Grammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

public class BooleenGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link Grammaire}.
     */
    public BooleenGrammaire() {
        super(ETypeSymbole.BOOLEEN);
    }

    @Override
    protected void initialiser() {

    }
}

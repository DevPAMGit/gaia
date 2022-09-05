package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Grammaire pour un identifiant.
 */
public class IdentifiantGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link IdentifiantGrammaire}.
     */
    public IdentifiantGrammaire() {
        super(ETypeSymbole.IDENTIFIANT);
    }

    @Override
    protected void initialiser() {

    }
}

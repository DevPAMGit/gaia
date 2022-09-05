package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.Grammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Classe d'état pour un symbole de type virgule.
 */
public class VirguleGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link Grammaire}.
     */
    public VirguleGrammaire() {
        super(ETypeSymbole.VIRGULE);
    }

    @Override
    protected void initialiser() {

    }
}

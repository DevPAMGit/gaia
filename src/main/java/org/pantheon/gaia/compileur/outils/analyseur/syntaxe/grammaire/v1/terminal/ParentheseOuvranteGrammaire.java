package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Grammaire pour une parenthèse ouvrante.
 */
public class ParentheseOuvranteGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link ParentheseOuvranteGrammaire}.
     */
    public ParentheseOuvranteGrammaire() {
        super(ETypeSymbole.PARENTHESE_OUVRANTE);
    }

    @Override
    protected void initialiser() {
    }
}

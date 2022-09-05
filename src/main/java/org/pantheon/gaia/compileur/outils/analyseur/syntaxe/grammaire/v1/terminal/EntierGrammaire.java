package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Classe d'état pour un symbole de type chaîne de caractères.
 */
public class EntierGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link EntierGrammaire}.
     */
    public EntierGrammaire() {
        super(ETypeSymbole.ENTIER);
    }

    @Override
    protected void initialiser() {

    }
}

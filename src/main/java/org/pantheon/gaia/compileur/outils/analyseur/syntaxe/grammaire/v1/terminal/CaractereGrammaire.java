package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.TerminalGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Classe d'état pour un symbole de type caractère.
 */
public class CaractereGrammaire extends TerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link CaractereGrammaire}.
     */
    public CaractereGrammaire() {
        super(ETypeSymbole.CARACTERE);
    }

    @Override
    protected void initialiser() {

    }
}

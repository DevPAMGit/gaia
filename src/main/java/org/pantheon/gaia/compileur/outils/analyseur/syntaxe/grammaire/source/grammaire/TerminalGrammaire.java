package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Etat terminal d'une grammaire.
 */
public abstract class TerminalGrammaire extends Grammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link TerminalGrammaire}.
     * @param symbole Le symbole de la grammaire.
     */
    public TerminalGrammaire(ETypeSymbole symbole) {
        super(true, symbole);
    }

    @Override
    public boolean analyser(TexteSource texteSource)  {
        try {
            if(texteSource.obtenirSymbole() != this.symbole) return false;
            texteSource.avancer();
        }catch (Exception e) { return false; }
        return true;
    }
}

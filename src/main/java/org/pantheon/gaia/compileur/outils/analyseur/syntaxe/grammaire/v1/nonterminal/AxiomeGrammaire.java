package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.NonTerminalGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.FinGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.IdentifiantGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.ParentheseOuvranteGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.IdentifiantSymbole;

/**
 * Grammaire pour l'axiome de la grammaire.
 */
public class AxiomeGrammaire extends NonTerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link AxiomeGrammaire}.
     */
    public AxiomeGrammaire() {
        super(ETypeSymbole.APPEL_SERVICE);
    }

    @Override
    protected void initialiser() {
        this.ajouterSymboleDirecteur(ETypeSymbole.IDENTIFIANT, new AppelServiceGrammaire());
    }
}

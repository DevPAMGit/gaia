package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.NonTerminalGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.IdentifiantGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Classe d'état pour un symbole de type service.
 */
public class ServiceGrammaire extends NonTerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link ServiceGrammaire}.
     */
    public ServiceGrammaire() {
        super(ETypeSymbole.SERVICE);
    }

    @Override
    protected void initialiser() {
        this.ajouterSymboleDirecteur(new IdentifiantGrammaire());
    }
}

package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.NonTerminalGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.FinGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.IdentifiantGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.ParentheseOuvranteGrammaire;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

public class AppelServiceGrammaire extends NonTerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link NonTerminalGrammaire}..
     */
    public AppelServiceGrammaire() {
        super(ETypeSymbole.APPEL_SERVICE);
    }

    @Override
    protected void initialiser() {
        this.ajouterSymboleDirecteur(new IdentifiantGrammaire());

        this.ajouterSequence(ETypeSymbole.IDENTIFIANT, new ParentheseOuvranteGrammaire());
        this.ajouterSequence(ETypeSymbole.IDENTIFIANT, new ListeArgumentsGrammaire());
        this.ajouterSequence(ETypeSymbole.IDENTIFIANT, new FinGrammaire());
    }
}

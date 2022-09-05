package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire.NonTerminalGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.*;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * Grammaire pour une liste d'arguments.
 */
public class ListeArgumentsGrammaire extends NonTerminalGrammaire {

    /**
     * Initialise une nouvelle instance de la classe {@link NonTerminalGrammaire}.
     */
    public ListeArgumentsGrammaire() {
        super(ETypeSymbole.LISTE_ARGUMENTS);
    }

    @Override
    protected void initialiser() {
        this.ajouterSymboleDirecteur(new VideGrammaire());
        this.ajouterSymboleDirecteur(new CaractereGrammaire());
        this.ajouterSymboleDirecteur(new BooleenGrammaire());
        this.ajouterSymboleDirecteur(new ChaineGrammaire());
        this.ajouterSymboleDirecteur(new EntierGrammaire());
        this.ajouterSymboleDirecteur(new EntierGrammaire());

        this.ajouterSequence(ETypeSymbole.CARACTERE, new SousListeArgumentGrammaire());
        this.ajouterSequence(ETypeSymbole.BOOLEEN, new SousListeArgumentGrammaire());
        this.ajouterSequence(ETypeSymbole.CHAINE, new SousListeArgumentGrammaire());
        this.ajouterSequence(ETypeSymbole.ENTIER, new SousListeArgumentGrammaire());
        this.ajouterSequence(ETypeSymbole.REEL, new SousListeArgumentGrammaire());

    }
}

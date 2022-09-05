package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.AnalyseSyntaxiqueException;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Grammaire pour un état terminal.
 */
public abstract class NonTerminalGrammaire extends Grammaire {

    /** Liste des symboles directeurs */
    private ArrayList<ETypeSymbole> symbolesDirecteurs;

    /**
     * Les alternatives dirigées par les symboles directeurs.
     */
    private HashMap<ETypeSymbole, Grammaire> alternatives;

    /**
     * La séquence de symboles attendus.
     */
    private HashMap<ETypeSymbole, ArrayList<Grammaire>> sequence;

    /**
     * Initialise une nouvelle instance de la classe {@link NonTerminalGrammaire}.
     * @param symbole Le symbole que représente cette grammaire.
     */
    public NonTerminalGrammaire(ETypeSymbole symbole) {
        super(false, symbole);
    }


    /**
     * Ajoute un symbole directeur à l'état.
     * @param grammaire L'état de correspondance au symbole.
     */
    protected void ajouterSymboleDirecteur(Grammaire grammaire) {
        if(this.symbolesDirecteurs == null) this.symbolesDirecteurs = new ArrayList<>();
        if(this.alternatives == null) this.alternatives = new HashMap<>();
        this.symbolesDirecteurs.add(grammaire.symbole);
        this.alternatives.put(grammaire.symbole, grammaire);
    }

    /**
     * Ajoute un symbole directeur à l'état.
     * @param symbole Le symbole directeur de la grammaire.
     * @param grammaire L'état de correspondance au symbole.
     */
    protected void ajouterSymboleDirecteur(ETypeSymbole symbole, Grammaire grammaire) {
        if(this.symbolesDirecteurs == null) this.symbolesDirecteurs = new ArrayList<>();
        if(this.alternatives == null) this.alternatives = new HashMap<>();
        this.symbolesDirecteurs.add(symbole);
        this.alternatives.put(symbole, grammaire);
    }

    /**
     * Ajoute une grammaire à une séquence.
     * @param grammaire La grammaire à ajouter à la séquence.
     */
    protected void ajouterSequence(ETypeSymbole symbole, Grammaire grammaire) {
        if(this.sequence == null) this.sequence = new HashMap<>();

        if(!this.sequence.containsKey(symbole)) this.sequence.put(symbole, new ArrayList<>());
        this.sequence.get(symbole).add(grammaire);
    }

    /**
     * Développe l'état non terminal.
     * @param texteSource Le texte source à analyser.
     * @return <c>true</c> si le développement est valide. Sinon <c>false</c>.
     * @throws AnalyseSyntaxiqueException Si une erreur syntaxique à lieu.
     */
    private ETypeSymbole developper(TexteSource texteSource)  {
        int index = 0;
        int max = this.symbolesDirecteurs.size();
        while(index < max && !this.alternatives.get(this.symbolesDirecteurs.get(index)).analyser(texteSource))
            index++;

        if(index == max) return null;
        return this.alternatives.get(this.symbolesDirecteurs.get(index)).symbole;
    }

    @Override
    public boolean analyser(TexteSource texteSource) {
        ETypeSymbole symbole = this.developper(texteSource);
        if(symbole == null) return false;

        if(this.sequence == null || !this.sequence.containsKey(symbole)) return true;

        int index = 0;
        int max = this.sequence.get(symbole).size();
        ArrayList<Grammaire> sequence = this.sequence.get(symbole);

        while(index < max && sequence.get(index).analyser(texteSource))
            index++;
        return (index == max );
    }
}

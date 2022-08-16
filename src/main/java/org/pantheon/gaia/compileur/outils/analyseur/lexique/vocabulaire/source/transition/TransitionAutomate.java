package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.IEtatAutomate;

/** Transition entre deux nœuds. */
public class TransitionAutomate {

    /**
     * Le nœud de destination.
     */
    private final IEtatAutomate destination;

    /**
     * La valeur de passage de la transition.
     */
    private final String valeur;

    /**
     * Initialise une nouvelle instance de la classe {@link TransitionAutomate}.
     * @param destination L'état de destination de la transition.
     * @param valeur La valeur de passage de la transition.
     */
    public TransitionAutomate(IEtatAutomate destination, String valeur) {
        this.destination = destination;
        this.valeur = valeur;
    }

    /**
     * Méthode permettant de transiter à l'état suivant si la condition le permet.
     * @param caractere Le caractère permettant de passer à l'état suivant.
     * @return L'état suivant si la condition est rempli sinon null.
     */
    public IEtatAutomate transiter(String caractere) {
        if(caractere == null) return null;
        if( caractere.matches(this.valeur) ) return this.destination;
        return null;
    }
}

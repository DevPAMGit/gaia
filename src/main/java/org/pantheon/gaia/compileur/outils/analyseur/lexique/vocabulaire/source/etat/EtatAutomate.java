package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

import java.util.ArrayList;

/**
 * Classe définissant l'état d'un automate d'un vocabulaire.
 */
public class EtatAutomate implements IEtatAutomate {
    /**
     * Indique si l'état est satisfaisant.
     */
    private final boolean estSatisfaisant;

    /**
     * Liste des transitions de l'état d'automate.
     */
    private final ArrayList<TransitionAutomate> transitions;

    /**
     * Initialise une nouvelle instance de la classe {@link EtatAutomate}.
     * @param estSatisfaisant Indique si l'état est satisfaisant.
     */
    public EtatAutomate(boolean estSatisfaisant) {
        this.transitions = new ArrayList<>();
        this.estSatisfaisant = estSatisfaisant;
    }

    /**
     * Ajoute une transition à l'état.
     * @param transition La transition à ajouter.
     */
    public void ajouterTransition(TransitionAutomate transition) {
        this.transitions.add(transition);
    }

    @Override
    public boolean estSatisfaisant() {
        return this.estSatisfaisant;
    }

    @Override
    public IEtatAutomate transiter(String caractere) {
        int index = 0, max = this.transitions.size();
        IEtatAutomate prochain_etat = null;

        while (prochain_etat == null && index < max) {
            prochain_etat = transitions.get(index).transiter(caractere);
            index++;
        }

        return prochain_etat;
    }
}

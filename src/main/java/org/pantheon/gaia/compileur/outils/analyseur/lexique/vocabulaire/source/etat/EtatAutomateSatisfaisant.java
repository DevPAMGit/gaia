package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe définissant un automate satisfaisant.
 */
public class EtatAutomateSatisfaisant extends EtatAutomate {
    /**
     * Initialise une nouvelle instance de la classe {@link EtatAutomateSatisfaisant}.
     */
    public EtatAutomateSatisfaisant() {
        super(true);
    }

    @Override
    public void ajtTransition(TransitionAutomate transition) {
        // étant un état satisfaisant (donc final), cet état ne peut avoir de transitions suivantes.
        return;
    }
}

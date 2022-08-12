package org.pantheon.gaia.compileur.outils.vocabulaire.source.etat;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe définissant un automate non satisfaisant.
 */
public class EtatAutomateNonSatisfaisant extends EtatAutomate {
    /**
     * Initialise une nouvelle instance de la classe {@link EtatAutomateNonSatisfaisant}.
     */
    public EtatAutomateNonSatisfaisant() {
        super(false);
    }

}

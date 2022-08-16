package org.pantheon.gaia.compileur.outils.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.Automate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 *
 */
public class Virgule extends Automate {
    /**
     * Initialise une nouvelle instance de la classe {@link Virgule}.
     */
    public Virgule(){
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        etat1.ajtTransition(new TransitionAutomate(etat2, ","));

        this.source = etat1;
    }
}

package org.pantheon.gaia.compileur.outils.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.Automate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Automate pour le vocabulaire de type booléen.
 */
public class Booleen extends Automate {
    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat2 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat3 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat4 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat5 = new EtatAutomateSatisfaisant();

        EtatAutomateNonSatisfaisant etat6 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat7 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat8 = new EtatAutomateNonSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "[tT]");
        TransitionAutomate transition2 = new TransitionAutomate(etat3, "r");
        TransitionAutomate transition3 = new TransitionAutomate(etat4, "u");
        TransitionAutomate transition4 = new TransitionAutomate(etat5, "e");

        TransitionAutomate transition5 = new TransitionAutomate(etat6, "[fF]");
        TransitionAutomate transition6 = new TransitionAutomate(etat7, "a");
        TransitionAutomate transition7 = new TransitionAutomate(etat8, "l");
        TransitionAutomate transition8 = new TransitionAutomate(etat4, "s");

        etat1.ajtTransition(transition1);
        etat1.ajtTransition(transition5);

        etat2.ajtTransition(transition2);
        etat3.ajtTransition(transition3);
        etat4.ajtTransition(transition4);

        etat6.ajtTransition(transition6);
        etat7.ajtTransition(transition7);
        etat8.ajtTransition(transition8);

        this.source = etat1;
    }
}

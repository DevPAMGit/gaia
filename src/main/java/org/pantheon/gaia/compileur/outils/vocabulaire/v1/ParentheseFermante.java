package org.pantheon.gaia.compileur.outils.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.Automate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe personnalisée pour l'extraction du caractère de parenthèse fermante.
 */
public class ParentheseFermante extends Automate {

    /**
     * Initialise une nouvelle instance de la classe {@link ParentheseFermante}.
     */
    public ParentheseFermante() {
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition = new TransitionAutomate(etat2, "\\)");

        etat1.ajtTransition(transition);
        this.source = etat1;
    }
}

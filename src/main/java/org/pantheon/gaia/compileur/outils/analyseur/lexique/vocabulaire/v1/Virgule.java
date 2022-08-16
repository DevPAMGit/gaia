package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;

/**
 *
 */
public class Virgule extends Lexique {
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

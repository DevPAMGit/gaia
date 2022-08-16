package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe personnalisée pour l'extraction du caractère de fin d'instruction.
 */
public class Fin extends Lexique {

    /**
     * Initialise une nouvelle instance de la classe {@link Fin}.
     */
    public Fin(){ }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, ";");

        etat1.ajtTransition(transition1);
        this.source = etat1;
    }
}

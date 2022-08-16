package org.pantheon.gaia.compileur.outils.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.Automate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Automate pour un vocabulaire d'entier.
 */
public class Entier extends Automate {

    /**
     * Initialise une nouvelle instance de la classe {@link Entier}.
     */
    public Entier(){
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "\\d");

        etat1.ajtTransition(transition1);

        this.source = etat1;
    }

    @Override
    public String extraireUniteLexicale(String commande, int curseur) {
        String unite = super.extraireUniteLexicale(commande, curseur);
        if(unite == null) return null;

        curseur++;
        String buffer = super.extraireUniteLexicale(commande, curseur);

        while((buffer != null)) {
            unite += buffer;
            curseur++;
            buffer = super.extraireUniteLexicale(commande, curseur);
        }

        return unite;
    }
}

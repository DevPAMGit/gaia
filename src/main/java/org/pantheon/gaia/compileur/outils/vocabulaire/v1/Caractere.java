package org.pantheon.gaia.compileur.outils.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.Automate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

public class Caractere  extends Automate {

    /**
     * Initialise une nouvelle instance de la classe {@link Caractere}.
     */
    public Caractere(){
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat2 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat3 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat4 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "'");
        TransitionAutomate transition2 = new TransitionAutomate(etat3, "[a-zA-Z\\s]");
        TransitionAutomate transition3 = new TransitionAutomate(etat4, "'");
        TransitionAutomate transition4 = new TransitionAutomate(etat4, "'");

        etat1.ajtTransition(transition1);
        etat2.ajtTransition(transition2);
        etat3.ajtTransition(transition3);
        etat3.ajtTransition(transition4);

        etat2.ajtTransition(transition4);

        this.source = etat1;
    }

    @Override
    public String extraireUniteLexicale(String commande, int curseur) {
        String unite = super.extraireUniteLexicale(commande, curseur);
        if(unite == null) return null;
        return unite.substring(1, unite.length()-1);
    }
}

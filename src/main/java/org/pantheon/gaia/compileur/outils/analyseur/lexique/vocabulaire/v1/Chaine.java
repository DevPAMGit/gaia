package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe personnalisée pour l'extraction de chaînes de caractères.
 */
public class Chaine  extends Lexique {

    /**
     * Initialise une nouvelle instance de la classe {@link Chaine}.
     */
    public Chaine() {
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateNonSatisfaisant etat2 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat3 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "\"");
        TransitionAutomate transition2 = new TransitionAutomate(etat2, "[^\"]");
        TransitionAutomate transition4 = new TransitionAutomate(etat3, "^\"$");

        etat1.ajtTransition(transition1);
        etat2.ajtTransition(transition2);
        etat2.ajtTransition(transition4);

        // \s+(?=([^"]*"[^"]*")*[^"]*$)

        this.source = etat1;
    }

    @Override
    public String extraireUniteLexicale(String commande, int curseur) {
        String resultat = super.extraireUniteLexicale(commande, curseur);
        if(resultat == null) return null;
        return resultat.substring(1,resultat.length()-1);
    }
}

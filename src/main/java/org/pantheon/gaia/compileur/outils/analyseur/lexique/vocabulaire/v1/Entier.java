package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;

/**
 * Classe personnalisée pour l'extraction d'entiers.
 */
public class Entier extends Lexique {

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

package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Champ lexical pour les types chaînes de caractères.
 */
public class ChaineLexique extends Lexique {

    /**
     * Initialise une nouvelle instance de la classe {@link ChaineLexique}.
     */
    public ChaineLexique() {
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

        this.source = etat1;
    }

    @Override
    public Symbole extraireSymbole(String instruction, int curseur) {
        return null;
    }

    @Override
    public String extraireUniteLexicale(String instruction, int curseur) {
        String resultat = super.extraireUniteLexicale(instruction, curseur);
        if(resultat == null) return null;
        return resultat.substring(1,resultat.length()-1);
    }
}

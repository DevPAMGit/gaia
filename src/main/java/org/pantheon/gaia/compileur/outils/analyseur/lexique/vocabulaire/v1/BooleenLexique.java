package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;

/**
 * Champ lexical pour les types booléens.
 */
public class BooleenLexique extends Lexique {

    /**
     * Initialise une nouvelle instance de la classe {@link BooleenLexique}.
     */
    public BooleenLexique() {
        super();
    }

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

    @Override
    public Symbole extraireSymbole(String instruction, int curseur) {
        String unite = this.extraireUniteLexicale(instruction, curseur);
        if (unite == null) return null;
        return new BooleenSymbole(unite);
    }
}

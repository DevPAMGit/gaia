package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.CaractereSymbole;

/**
 * Champ lexical pour les types caractères.
 */
public class CaractereLexique extends Lexique {

    /**
     * Initialise une nouvelle instance de la classe {@link CaractereLexique}.
     */
    public CaractereLexique(){
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

        etat1.ajouterTransition(transition1);
        etat2.ajouterTransition(transition2);
        etat3.ajouterTransition(transition3);
        etat3.ajouterTransition(transition4);

        etat2.ajouterTransition(transition4);

        this.source = etat1;
    }

    @Override
    public Symbole extraireSymbole(String instruction, int curseur) {
        String unite = this.extraireUniteLexicale(instruction, curseur);
        if(unite == null) return null;
        return new CaractereSymbole(unite);
    }

    @Override
    protected String extraireUniteLexicale(String instruction, int curseur) {
        String unite = super.extraireUniteLexicale(instruction, curseur);
        if(unite == null) return null;
        return unite.substring(1, unite.length()-1);
    }
}

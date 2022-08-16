package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.VirguleSymbole;

/**
 * Champ lexical pour les types virgules.
 */
public class VirguleLexique extends Lexique {
    /**
     * Initialise une nouvelle instance de la classe {@link VirguleLexique}.
     */
    public VirguleLexique(){
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        etat1.ajtTransition(new TransitionAutomate(etat2, ","));

        this.source = etat1;
    }

    @Override
    public Symbole extraireSymbole(String instruction, int curseur) {
        String unite = this.extraireUniteLexicale(instruction, curseur);
        if(unite == null) return null;
        return new VirguleSymbole(unite);
    }
}

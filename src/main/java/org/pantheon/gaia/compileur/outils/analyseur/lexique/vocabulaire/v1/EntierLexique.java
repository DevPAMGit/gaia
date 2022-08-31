package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.EntierSymbole;

/**
 * Champ lexical pour les types entiers.
 */
public class EntierLexique extends Lexique {

    /**
     * Initialise une nouvelle instance de la classe {@link EntierLexique}.
     */
    public EntierLexique(){
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "\\d");

        etat1.ajouterTransition(transition1);

        this.source = etat1;
    }

    @Override
    public Symbole extraireSymbole(String instruction, int curseur) {
        String unite = this.extraireUniteLexicale(instruction, curseur);
        if(unite == null) return null;
        return new EntierSymbole(unite);
    }

    @Override
    protected String extraireUniteLexicale(String instruction, int curseur) {
        String unite = super.extraireUniteLexicale(instruction, curseur);
        if(unite == null) return null;

        curseur++;
        String buffer = super.extraireUniteLexicale(instruction, curseur);

        while((buffer != null)) {
            unite += buffer;
            curseur++;
            buffer = super.extraireUniteLexicale(instruction, curseur);
        }

        return unite;
    }
}

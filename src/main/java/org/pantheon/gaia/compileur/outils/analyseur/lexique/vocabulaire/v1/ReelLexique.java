package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ReelSymbole;

/**
 * Champ lexical pour les types réels.
 */
public class ReelLexique extends EntierLexique {

    private EtatAutomateNonSatisfaisant source2;

    /**
     * Initialise une nouvelle instance de la classe {@link ReelLexique} class.
     */
    public ReelLexique(){
        super();
    }

    @Override
    protected void initialiser() {
        super.initialiser();

        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "\\.");
        etat1.ajtTransition(transition1);

        this.source2 = etat1;
    }

    @Override
    protected String extraireUniteLexicale(String instruction, int curseur) {
        String unite = super.extraireUniteLexicale(instruction, curseur);

        curseur = (unite == null) ? 0 : curseur + unite.length();
        String buffer = this.extraireSousUniteLexicale(instruction, curseur);

        if(buffer == null) return null;

        if (unite != null) unite += buffer;
        else unite = buffer;

        if(unite == null) return null;

        curseur += 1;

        buffer = super.extraireUniteLexicale(instruction, curseur);
        if(buffer == null) return null;
        unite += buffer;

        return unite;
    }

    /**
     * Sous extracteur d'unité lexicale.
     * @param commande la commande à parser.
     * @param curseur La position de départ pour du parseur.
     * @return  La sous-unité lexicale extraite ou null.
     */
    protected String extraireSousUniteLexicale(String commande, int curseur) {
        String unite = "";
        int max = commande.length();
        IEtatAutomate etat = this.source2;

        while( etat != null && !etat.estSatisfaisant() && curseur < max ) {
            String caractere = String.valueOf(commande.charAt(curseur));
            unite = String.format("%s%s", unite, caractere);
            etat = etat.transiter(caractere);
            curseur++;
        }

        if(etat == null || !etat.estSatisfaisant()) return null;
        return unite;
    }

    @Override
    public Symbole extraireSymbole(String instruction, int curseur) {
        String unite = this.extraireUniteLexicale(instruction, curseur);
        if(unite == null) return null;
        return new ReelSymbole(unite);
    }
}

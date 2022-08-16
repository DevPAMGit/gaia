package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de vocabulaire pour un Réel.
 */
public class Reel extends Entier {

    private EtatAutomateNonSatisfaisant source2;

    /**
     * Initialise une nouvelle instance de la classe {@link Reel} class.
     */
    public Reel(){
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
    public String extraireUniteLexicale(String commande, int curseur) {
        String unite = super.extraireUniteLexicale(commande, curseur);

        curseur = (unite == null) ? 0 : unite.length();
        if (unite == null) unite = this.extraireSousUniteLexicale(commande, curseur);
        else unite += this.extraireSousUniteLexicale(commande, curseur);

        if(unite == null) return null;

        curseur = unite.length();

        String buffer = super.extraireUniteLexicale(commande, curseur);
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
    public String extraireSousUniteLexicale(String commande, int curseur) {
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
}

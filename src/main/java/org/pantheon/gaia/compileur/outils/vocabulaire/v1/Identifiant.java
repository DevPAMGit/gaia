package org.pantheon.gaia.compileur.outils.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.Automate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe représentant le vocabulaire pour un identifiant.
 */
public class Identifiant extends Automate {

    /**
     * Le second état source.
     */
    private EtatAutomateNonSatisfaisant source2;


    /**
     * Initialise une nouvelle instance de la classe {@link Identifiant}.
     */
    public Identifiant() {
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "[a-zA-Z]");
        TransitionAutomate transition2 = new TransitionAutomate(etat2, "[a-zA-Z0-9]");

        etat1.ajtTransition(transition1);
        etat2.ajtTransition(transition2);

        EtatAutomateNonSatisfaisant etat3 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat4 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition3 = new TransitionAutomate(etat4, "[a-zA-Z0-9]");

        etat3.ajtTransition(transition3);

        this.source = etat1;
        this.source2 = etat3;
    }

    @Override
    public String extraireUniteLexicale(String commande, int curseur) {
        String extraction = super.extraireUniteLexicale(commande, curseur);
        if(extraction == null) return null;

        StringBuilder unite = new StringBuilder(extraction);
        curseur++;
        String buffer = this.extraireSousUniteLexicale(commande, curseur);


        while((buffer != null)) {
            unite.append(buffer);
            curseur++;
            buffer = this.extraireSousUniteLexicale(commande, curseur);
        }

        return unite.toString();
    }

    /**
     * Sous extracteur d'unité lexicale.
     * @param commande la commande à parser.
     * @param curseur La position de départ pour du parseur.
     * @return L'unité lexicale extraite ou null.
     */
    private String extraireSousUniteLexicale(String commande, int curseur) {
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

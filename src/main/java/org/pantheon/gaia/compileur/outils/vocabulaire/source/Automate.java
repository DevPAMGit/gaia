package org.pantheon.gaia.compileur.outils.vocabulaire.source;

import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.IEtatAutomate;

/**
 * Classe pour un automate.
 */
public abstract class Automate {

    /**
     * Etat source de l'automate.
     */
    protected EtatAutomateNonSatisfaisant source;

    /**
     * Initialise une nouvelle instance de la classe {@link Automate}.
     */
    public Automate() {
        this.source = null;
        this.initialiser();
    }

    /**
     * Méthode permettant d'extraire une unité lexicale.
     * @param commande La commande d'où l'on extrait l'unité.
     * @param curseur La position de démarrage de l'unité
     * @return L'unité lexicale extraite ou null.
     */
    public String extraireUniteLexicale(String commande, int curseur) {
        String unite = "";
        int max = commande.length();
        IEtatAutomate etat = this.source;

        while( etat != null && !etat.estSatisfaisant() && curseur < max ) {
            String caractere = String.valueOf(commande.charAt(curseur));
            unite = String.format("%s%s", unite, caractere);
            etat = etat.transiter(caractere);
            curseur++;
        }

        if(etat == null || !etat.estSatisfaisant()) return null;
        return unite;
    }

    /**
     * Initialise les états de l'automate.
     */
    protected abstract void initialiser();
}

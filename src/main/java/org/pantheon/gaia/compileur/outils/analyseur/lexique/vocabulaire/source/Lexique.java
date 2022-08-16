package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Classe pour un automate.
 */
public abstract class Lexique {

    /**
     * Etat source de l'automate.
     */
    protected EtatAutomateNonSatisfaisant source;

    /**
     * Initialise une nouvelle instance de la classe {@link Lexique}.
     */
    public Lexique() {
        this.source = null;
        this.initialiser();
    }

    /**
     * Méthode permettant d'extraire une unité lexicale.
     * @param instruction La commande d'où l'on extrait l'unité.
     * @param curseur La position de démarrage de l'unité
     * @return L'unité lexicale extraite ou null.
     */
    protected String extraireUniteLexicale(String instruction, int curseur) {
        String unite = "";
        int max = instruction.length();
        IEtatAutomate etat = this.source;

        while( etat != null && !etat.estSatisfaisant() && curseur < max ) {
            String caractere = String.valueOf(instruction.charAt(curseur));
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

    /**
     * Méthode permettant d'extraire un symbole.
     * @param instruction La commande à interpréter.
     * @param curseur La position pour débuter l'extraction.
     * @return Le symbole
     */
    public abstract Symbole extraireSymbole(String instruction, int curseur);
}

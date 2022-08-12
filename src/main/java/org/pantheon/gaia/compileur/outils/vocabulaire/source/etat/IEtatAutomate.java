package org.pantheon.gaia.compileur.outils.vocabulaire.source.etat;

/**
 * Interface contractualisant les opérations nécessaires pour un etat d'automate.
 */
public interface IEtatAutomate {
    /**
     * Indique si l'automate est satisfaisant.
     * @return <c>true</c> si l'automate est satisfaisant, sinon <c>false</c>.
     */
    boolean estSatisfaisant();

    /**
     * Permet de "transiter" au prochain nœud.
     * @param caractere Le caractère de transition.
     * @return Une instance de l'interface {@link IEtatAutomate};
     */
    IEtatAutomate transiter(String caractere);
}

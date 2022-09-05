package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;

/**
 * L'état d'une grammaire.
 */
public abstract class Grammaire implements IGrammaire {

    /**
     * Le type de symbole représentant cet état.
     */
    protected final ETypeSymbole symbole;

    /**
     * Indique si l'état est satisfaisant.
     */
    protected final boolean estSatisfaisant;

    /**
     * Initialise une nouvelle instance de la classe {@link Grammaire}.
     * @param symbole Le symbole de l'état.
     * @param estSatisfaisant Indique si l'état du nœud est satisfaisant.
     */
    public Grammaire(boolean estSatisfaisant, ETypeSymbole symbole) {
        this.estSatisfaisant = estSatisfaisant;
        this.symbole = symbole;
        this.initialiser();
    }

    /**
     * Initialise l'état.
     */
    protected abstract void initialiser();
}

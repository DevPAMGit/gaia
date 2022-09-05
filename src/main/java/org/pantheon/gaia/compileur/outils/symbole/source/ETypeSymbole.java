package org.pantheon.gaia.compileur.outils.symbole.source;

/**
 * Enumération pour les types de symboles.
 */
public enum ETypeSymbole {
    /**
     * Symbole représentant un booléen.
     * */
    BOOLEEN,

    /**
     * Symbole représentant un carctère.
     * */
    CARACTERE,

    /**
     * Symbole représentant une chaîne de caractères.
     * */
    CHAINE,

    /**
     * Symbole représentant un entier.
     */
    ENTIER,

    /**
     * Symbole représentant la fin d'une instruction.
     */
    FIN,

    /**
     * Symbole représentant un identifiant.
     */
    IDENTIFIANT,

    /**
     * Symbole représentant une parenthèse ouvrante.
     */
    PARENTHESE_OUVRANTE,

    /**
     * Symbole représentant une parenthèse fermante.
     */
    PARENTHESE_FERMANTE,

    /**
     * Symbole représentant un réel.
     */
    REEL,

    /**
     * Symbole représentant une virgule.
     */
    VIRGULE,

    /**
     * Symbole non terminal de grammaire instruction.
     */
    INSTRUCTION,

    /**
     * Symbole non terminal de la grammaire "appel service".
     */
    APPEL_SERVICE,

    /**
     * Symbole non terminal de la grammaire "liste d'arguments".
     */
    LISTE_ARGUMENTS,

    /**
     * Symbole non terminal de la grammaire "sous-liste d'arguments".
     */
    SOUS_LISTE_ARGUMENTS,

    /**
     * Symbole terminal de la grammaire "vide".
     */
    VIDE,

    SERVICE,
    /**
     * Symbole non terminal de la grammaire "expression".
     */
    EXPRESSION

}

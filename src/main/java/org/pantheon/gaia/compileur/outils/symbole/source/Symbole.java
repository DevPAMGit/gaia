package org.pantheon.gaia.compileur.outils.symbole.source;

/**
 * Classe représentant un symbole.
 */
public abstract class Symbole {

    /**
     * Le type du symbole.
     */
    private final ETypeSymbole type;

    /**
     * Le jeton d'identification du symbole.
     */
    private final String jeton;

    /** Initialise une nouvelle instance de la classe {@link Symbole}.
     * @param type Le type du {@link Symbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}. */
    public Symbole(ETypeSymbole type, String jeton) {
        this.type = type;
        this.jeton = jeton;
    }

    /**
     * Méthode permettant d'obtenir le type du symbole.
     * @return Le type du symbole.
     */
    public ETypeSymbole obtType() {
        return this.type;
    }

    /**
     * Méthode permettant de récupérer le jeton du symbole.
     * @return Le jeton du symbole.
     */
    public String obtJeton() {
        return this.jeton;
    }
}

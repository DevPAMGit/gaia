package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Symbole pour une chaîne de caractères.
 */
public class ChaineSymbole extends Symbole {
    /**
     * Initialise une nouvelle instance de la classe {@link ChaineSymbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public ChaineSymbole(String jeton) {
        super(ETypeSymbole.CHAINE, jeton);
    }
}

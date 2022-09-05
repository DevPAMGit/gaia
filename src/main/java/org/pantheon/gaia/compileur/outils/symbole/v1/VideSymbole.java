package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Symbole de type symbole.
 */
public class VideSymbole extends Symbole {

    /**
     * Initialise une nouvelle instance de la classe {@link Symbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public VideSymbole(String jeton) {
        super(ETypeSymbole.VIDE, jeton);
    }
}

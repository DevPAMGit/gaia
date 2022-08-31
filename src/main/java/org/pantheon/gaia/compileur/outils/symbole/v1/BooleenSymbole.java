package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Symbole de type booléen.
 */
public class BooleenSymbole extends Symbole {
    /**
     * Initialise une nouvelle instance de la classe {@link Symbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public BooleenSymbole(String jeton) {
        super(ETypeSymbole.BOOLEEN, jeton);
    }
}

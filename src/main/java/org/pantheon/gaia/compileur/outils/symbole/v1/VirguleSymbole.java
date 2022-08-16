package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Symbole de type virgule.
 */
public class VirguleSymbole extends Symbole {

    /**
     * Initialise une nouvelle instance de la classe {@link Symbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public VirguleSymbole(String jeton) {
        super(ETypeSymbol.VIRGULE, jeton);
    }
}

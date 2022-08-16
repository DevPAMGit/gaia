package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Symbole de type entier.
 */
public class EntierSymbole extends Symbole {
    /**
     * Initialise une nouvelle instance de la classe {@link Symbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public EntierSymbole(String jeton) {
        super(ETypeSymbol.ENTIER, jeton);
    }
}

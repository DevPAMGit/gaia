package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Symbole de type parenthèse ouvrante.
 */
public class ParentheseOuvranteSymbole extends Symbole {

    /**
     * Initialise une nouvelle instance de la classe {@link Symbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public ParentheseOuvranteSymbole(String jeton) {
        super(ETypeSymbole.PARENTHESE_OUVRANTE, jeton);
    }
}

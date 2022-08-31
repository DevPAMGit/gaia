package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Symbole indiquant la fin d'une instruction.
 */
public class FinSymbole extends Symbole {
    /**
     * Initialise une nouvelle instance de la classe {@link Symbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public FinSymbole(String jeton) {
        super(ETypeSymbole.FIN, jeton);
    }
}

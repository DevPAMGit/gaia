package org.pantheon.gaia.compileur.outils.symbole.v1;

import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

/**
 * Classe représentant un {@link Symbole} de type identifiant.
 */
public class IdentifiantSymbole extends Symbole {
    /**
     * Initialise une nouvelle instance de la classe {@link IdentifiantSymbole}.
     * @param jeton Le jeton reconnu du {@link Symbole}.
     */
    public IdentifiantSymbole(String jeton) {
        super(ETypeSymbole.IDENTIFIANT, jeton);
    }
}

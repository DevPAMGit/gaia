package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.IdentifiantSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class IdentifiantSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final IdentifiantSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link IdentifiantSymboleTest}.
     */
    public IdentifiantSymboleTest() {
        this.symbole = new IdentifiantSymbole("1methode");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertSame(this.symbole.obtType(), ETypeSymbol.IDENTIFIANT);
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(),
                "1methode");
    }
}

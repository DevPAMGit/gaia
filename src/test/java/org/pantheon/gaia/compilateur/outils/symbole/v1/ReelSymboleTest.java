package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ReelSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class ReelSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final ReelSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link ReelSymboleTest}.
     */
    public ReelSymboleTest() {
        this.symbole = new ReelSymbole("10.10");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertSame(this.symbole.obtType(), ETypeSymbole.REEL);
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(),
                "10.10");
    }
}

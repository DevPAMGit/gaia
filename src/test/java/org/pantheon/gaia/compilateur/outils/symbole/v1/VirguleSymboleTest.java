package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.VirguleSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class VirguleSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final VirguleSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link VirguleSymboleTest}.
     */
    public VirguleSymboleTest() {
        this.symbole = new VirguleSymbole(",");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertSame(this.symbole.obtType(), ETypeSymbol.VIRGULE);
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(),
                ",");
    }
}

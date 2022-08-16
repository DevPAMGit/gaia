package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class BooleenSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final BooleenSymbole symbole1;

    /**
     * Le second symbole à tester.
     */
    private final BooleenSymbole symbole2;

    /**
     * Initialise une nouvelle instance de la classe {@link BooleenSymboleTest}.
     */
    public BooleenSymboleTest() {
        this.symbole1 = new BooleenSymbole("true");
        this.symbole2 = new BooleenSymbole("false");
    }

    @Test
    public void testType() {
        Assert.assertTrue( this.symbole1.obtType() == ETypeSymbol.BOOLEEN );
        Assert.assertTrue( this.symbole2.obtType() == ETypeSymbol.BOOLEEN );
    }

    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole1.obtJeton(), "true");
        Assert.assertEquals(this.symbole2.obtJeton(), "false");
    }
}

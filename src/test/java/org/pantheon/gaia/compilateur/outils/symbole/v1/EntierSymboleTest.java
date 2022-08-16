package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.EntierSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class EntierSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final EntierSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link EntierSymboleTest}.
     */
    public EntierSymboleTest() {
        this.symbole = new EntierSymbole("10");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertSame(this.symbole.obtType(), ETypeSymbol.ENTIER);
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(),
                "10");
    }
}

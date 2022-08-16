package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ChaineSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class ChaineSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final ChaineSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link ChaineSymboleTest}.
     */
    public ChaineSymboleTest() {
        this.symbole = new ChaineSymbole(
                "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertSame(this.symbole.obtType(), ETypeSymbol.CHAINE);
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(),
                "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit");
    }
}

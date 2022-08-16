package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbol;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ParentheseOuvranteSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ReelSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class ParentheseOuvranteSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final ParentheseOuvranteSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link ParentheseOuvranteSymboleTest}.
     */
    public ParentheseOuvranteSymboleTest() {
        this.symbole = new ParentheseOuvranteSymbole("(");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertSame(this.symbole.obtType(), ETypeSymbol.PARENTHESE_OUVRANTE);
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(),
                "(");
    }
}

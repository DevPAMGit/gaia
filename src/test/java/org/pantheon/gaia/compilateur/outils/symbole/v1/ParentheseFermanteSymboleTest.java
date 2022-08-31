package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ParentheseFermanteSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class ParentheseFermanteSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final ParentheseFermanteSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link ParentheseFermanteSymboleTest}.
     */
    public ParentheseFermanteSymboleTest() {
        this.symbole = new ParentheseFermanteSymbole(")");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertSame(this.symbole.obtType(), ETypeSymbole.PARENTHESE_FERMANTE);
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(),
                ")");
    }
}

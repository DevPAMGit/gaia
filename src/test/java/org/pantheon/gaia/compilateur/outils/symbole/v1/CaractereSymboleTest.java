package org.pantheon.gaia.compilateur.outils.symbole.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.CaractereSymbole;

/**
 * Classe de test pour un {@link BooleenSymbole}
 */
public class CaractereSymboleTest {

    /**
     * Le premier symbole à tester.
     */
    private final CaractereSymbole symbole;

    /**
     * Initialise une nouvelle instance de la classe {@link CaractereSymboleTest}.
     */
    public CaractereSymboleTest() {
        this.symbole = new CaractereSymbole("a");
    }

    /**
     * Teste le type du symbole.
     */
    @Test
    public void testType() {
        Assert.assertTrue( this.symbole.obtType() == ETypeSymbole.CARACTERE );
    }

    /**
     * Teste le jeton du symbole.
     */
    @Test
    public void testJeton() {
        Assert.assertEquals(this.symbole.obtJeton(), "a");
    }
}

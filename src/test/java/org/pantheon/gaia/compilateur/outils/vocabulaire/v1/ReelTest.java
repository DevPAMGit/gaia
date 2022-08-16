package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.v1.Reel;

public class ReelTest {
    /**
     * Vocabulaire à tester.
     */
    private final Reel vocabulaire;

    /**
     * Initialise une nouvelle instance de classe {@link ReelTest}.
     */
    public ReelTest(){
        this.vocabulaire = new Reel();
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = "10.23";
        String chaineVide2 = ".10";
        Assert.assertEquals("10.23", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals(".10", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = ".";
        String chaineVide2 = "123.";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }


}

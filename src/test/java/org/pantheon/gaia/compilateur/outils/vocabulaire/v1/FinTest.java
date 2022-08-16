package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.v1.Fin;

public class FinTest {
    /**
     * Le vocabulaire à tester.
     */
    private final Fin vocabulaire;

    /** Initialise une nouvelle instance de la classe {@link FinTest}. */
    public FinTest() {
        this.vocabulaire = new Fin();
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = ";";
        String chaineVide2 = "; ";
        Assert.assertEquals(";", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals(";", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = " ;";
        String chaineVide2 = "'; ";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }
}

package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.Entier;

public class EntierTest {
    /**
     * Le vocabulaire à tester.
     */
    private final Entier vocabulaire;

    /** Initialise une nouvelle instance de la classe {@link EntierTest}. */
    public EntierTest() {
        this.vocabulaire = new Entier();
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = "10)";
        String chaineVide2 = "10,";
        Assert.assertEquals("10", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals("10", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = "\"Neque porro quisquam est qui ";
        String chaineVide2 = " ";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

}

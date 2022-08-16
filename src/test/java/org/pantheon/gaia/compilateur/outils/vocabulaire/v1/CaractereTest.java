package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.Caractere;

public class CaractereTest {
    /**
     * Le vocabulaire à tester.
     */
    private Caractere vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link CaractereTest}.
     */
    public CaractereTest(){
        this.vocabulaire = new Caractere();
    }

    @Test
    public void extraireUniteLexicaleVideTest() {
        String chaineVide1 = "''";
        String chaineVide2 = "' '";
        Assert.assertEquals("", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals(" ", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = "'N'";
        String chaineVide2 = "'d'";
        Assert.assertEquals("N", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals("d", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = "'Neque porro quisquam est qui ";
        String chaineVide2 = "10'";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }
}

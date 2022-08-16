package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.ParentheseFermante;

public class ParentheseFermanteTest {
    /**
     * Vocabulaire à tester.
     */
    private final ParentheseFermante vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link ParentheseFermanteTest}.
     */
    public ParentheseFermanteTest(){
        this.vocabulaire = new ParentheseFermante();
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = ")";
        String chaineVide2 = ") ";
        Assert.assertEquals(")", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals(")", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = " )";
        String chaineVide2 = "') ";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }
}

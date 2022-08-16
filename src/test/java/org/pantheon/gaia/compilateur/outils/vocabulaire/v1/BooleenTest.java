package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.Booleen;

public class BooleenTest {

    /**
     * Vocabulaire du test.
     */
    private final Booleen vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link BooleenTest}.
     */
    public BooleenTest() {
        this.vocabulaire = new Booleen();
    }

    @Test
    public void extraireUniteLexicaleVideTest() {
        String chaineVide1 = "\"\"";
        String chaineVide2 = "\" \"";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chainePleine1 = "True";
        String chainePleine2 = "true ";

        String chainePleine3 = "False";
        String chainePleine4 = "false";

        Assert.assertEquals("True", this.vocabulaire.extraireUniteLexicale(chainePleine1, 0));
        Assert.assertEquals("true", this.vocabulaire.extraireUniteLexicale(chainePleine2, 0));

        Assert.assertEquals("False", this.vocabulaire.extraireUniteLexicale(chainePleine3, 0));
        Assert.assertEquals("false", this.vocabulaire.extraireUniteLexicale(chainePleine4, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chainePleine1 = "Fals ";
        String chainePleine2 = "Tru";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chainePleine1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chainePleine2, 0));
    }

}

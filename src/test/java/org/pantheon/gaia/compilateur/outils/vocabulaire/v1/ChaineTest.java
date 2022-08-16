package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.Chaine;

/**
 * Classe de test pour les classes de type {@link ChaineTest}.
 */
public class ChaineTest {

    /**
     * Vocabulaire de test.
     */
    private final Chaine vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link ChaineTest}.
     */
    public ChaineTest() {
        this.vocabulaire = new Chaine();
    }

    @Test
    public void extraireUniteLexicaleVideTest() {
        String chaineVide1 = "\"\"";
        String chaineVide2 = "\" \"";
        Assert.assertEquals("", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals(" ", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = "\"Neque porro quisquam est qui\"";
        String chaineVide2 = "\"  dolorem ipsum quia dolor sit amet, consectetur \" ";
        Assert.assertEquals("Neque porro quisquam est qui", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals("  dolorem ipsum quia dolor sit amet, consectetur ",
                this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = "\"Neque porro quisquam est qui ";
        String chaineVide2 = "10";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

}

package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.ChaineLexique;

/**
 * Classe de test pour les classes de type {@link ChaineLexicaleTest}.
 */
public class ChaineLexicaleTest {

    /**
     * Vocabulaire de test.
     */
    private final ChaineLexique vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link ChaineLexicaleTest}.
     */
    public ChaineLexicaleTest() {
        this.vocabulaire = new ChaineLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes vides.
     */
    @Test
    public void extraireSymboleVideTest() {
        String chaineVide1 = "\"\"";
        String chaineVide2 = "\" \"";
        Assert.assertEquals("", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals(" ", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValideTest() {
        String chaineVide1 = "\"Neque porro quisquam est qui\"";
        String chaineVide2 = "\"  dolorem ipsum quia dolor sit amet, consectetur \" ";
        Assert.assertEquals("Neque porro quisquam est qui", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals("  dolorem ipsum quia dolor sit amet, consectetur ",
                this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreurTest() {
        String chaineVide1 = "\"Neque porro quisquam est qui ";
        String chaineVide2 = "10";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

}
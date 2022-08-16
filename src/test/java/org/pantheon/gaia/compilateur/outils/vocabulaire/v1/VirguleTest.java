package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.Virgule;

/**
 * Classe de test pour le vocabulaire de type virgule.
 */
public class VirguleTest {
    /**
     * Le vocabulaire à tester.
     */
    private final Virgule vocabulaire;

    /** Initialise une nouvelle instance de la classe {@link VirguleTest}. */
    public VirguleTest() {
        this.vocabulaire = new Virgule();
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = ",";
        String chaineVide2 = ", ";
        Assert.assertEquals(",", this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertEquals(",", this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = " ,";
        String chaineVide2 = "', ";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }
}

package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.v1.Identifiant;

/**
 * Classe de test pour le vocabulaire de type Identifiant.
 */
public class IdentifiantTest {

    /**
     * Le vocabulaire à tester.
     */
    private final Identifiant vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link IdentifiantTest}.
     */
    public IdentifiantTest() {
        this.vocabulaire = new Identifiant();
    }

    @Test
    public void extraireUniteLexicaleVideTest() {
        String chaineVide1 = "";
        String chaineVide2 = " ";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaineVide2, 0));
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaine1 = "methode1";
        String chaine2 = "m";
        Assert.assertEquals("methode1", this.vocabulaire.extraireUniteLexicale(chaine1, 0));
        Assert.assertEquals("m", this.vocabulaire.extraireUniteLexicale(chaine2, 0));
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaine1 = "1fsfds";
        String chaine2 = "1.0";
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaine1, 0));
        Assert.assertNull(this.vocabulaire.extraireUniteLexicale(chaine2, 0));
    }

}

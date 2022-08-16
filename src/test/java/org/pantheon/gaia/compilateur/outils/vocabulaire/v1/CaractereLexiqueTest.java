package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.CaractereLexique;

public class CaractereLexiqueTest {
    /**
     * Le vocabulaire à tester.
     */
    private final CaractereLexique vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link CaractereLexiqueTest}.
     */
    public CaractereLexiqueTest(){
        this.vocabulaire = new CaractereLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes vides.
     */
    @Test
    public void extraireSymboleVideTest() {
        String chaineVide1 = "''";
        String chaineVide2 = "' '";
        Assert.assertEquals("", this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertEquals(" ", this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValideTest() {
        String chaineVide1 = "'N'";
        String chaineVide2 = "'d'";
        Assert.assertEquals("N", this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertEquals("d", this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreurTest() {
        String chaineVide1 = "'Neque porro quisquam est qui ";
        String chaineVide2 = "10'";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0));
    }
}

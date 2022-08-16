package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.ParentheseOuvranteLexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.ReelLexique;

/**
 * Classe de test pour le vocabulaire de type {@link ReelLexique}.
 */
public class ReelLexiqueTest {
    /**
     * Vocabulaire à tester.
     */
    private final ReelLexique vocabulaire;

    /**
     * Initialise une nouvelle instance de classe {@link ReelLexiqueTest}.
     */
    public ReelLexiqueTest(){
        this.vocabulaire = new ReelLexique();
    }

    /**
     * Test le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValideTest() {
        String chaineVide1 = "10.23";
        String chaineVide2 = ".10";
        Assert.assertEquals("10.23", this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertEquals(".10", this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreurTest() {
        String chaineVide1 = ".";
        String chaineVide2 = "123.";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0));
    }


}

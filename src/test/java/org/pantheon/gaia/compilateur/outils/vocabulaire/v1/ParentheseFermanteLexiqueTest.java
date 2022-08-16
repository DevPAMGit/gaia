package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.ParentheseFermanteLexique;

/**
 * Classe de test pour le vocabulaire de type {@link ParentheseFermanteLexique}.
 */
public class ParentheseFermanteLexiqueTest {
    /**
     * Vocabulaire à tester.
     */
    private final ParentheseFermanteLexique vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link ParentheseFermanteLexiqueTest}.
     */
    public ParentheseFermanteLexiqueTest(){
        this.vocabulaire = new ParentheseFermanteLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValideTest() {
        String chaineVide1 = ")";
        String chaineVide2 = ") ";
        Assert.assertEquals(")", this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertEquals(")", this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreurTest() {
        String chaineVide1 = " )";
        String chaineVide2 = "') ";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0));
    }
}

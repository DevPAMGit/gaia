package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.IdentifiantLexique;

/**
 * Classe de test pour le vocabulaire de type {@link IdentifiantLexique}.
 */
public class IdentifiantLexiqueTest {

    /**
     * Le vocabulaire à tester.
     */
    private final IdentifiantLexique vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link IdentifiantLexiqueTest}.
     */
    public IdentifiantLexiqueTest() {
        this.vocabulaire = new IdentifiantLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes vides.
     */
    @Test
    public void extraireSymboleVideTest() {
        String chaineVide1 = "";
        String chaineVide2 = " ";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValideTest() {
        String chaine1 = "methode1";
        String chaine2 = "m";
        Assert.assertEquals("methode1", this.vocabulaire.extraireSymbole(chaine1, 0).obtJeton());
        Assert.assertEquals("m", this.vocabulaire.extraireSymbole(chaine2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreurTest() {
        String chaine1 = "1Lorem";
        String chaine2 = "1.0";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaine1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaine2, 0));
    }

}

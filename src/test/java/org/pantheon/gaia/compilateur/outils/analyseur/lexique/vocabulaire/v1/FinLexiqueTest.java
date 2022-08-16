package org.pantheon.gaia.compilateur.outils.analyseur.lexique.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.FinLexique;

/**
 * Classe de test pour la classe {@link FinLexique}.
 */
public class FinLexiqueTest {
    /**
     * Le vocabulaire à tester.
     */
    private final FinLexique vocabulaire;

    /** Initialise une nouvelle instance de la classe {@link FinLexiqueTest}. */
    public FinLexiqueTest() {
        this.vocabulaire = new FinLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValide() {
        String chaineVide1 = ";";
        String chaineVide2 = "; ";
        Assert.assertEquals(";", this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertEquals(";", this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreur() {
        String chaineVide1 = " ;";
        String chaineVide2 = "'; ";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0));
    }
}

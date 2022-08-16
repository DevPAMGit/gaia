package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.EntierLexique;

/**
 * Classe de test pour la classe {@link EntierLexique}.
 */
public class EntierLexiqueTest {
    /**
     * Le vocabulaire à tester.
     */
    private final EntierLexique vocabulaire;

    /** Initialise une nouvelle instance de la classe {@link EntierLexiqueTest}. */
    public EntierLexiqueTest() {
        this.vocabulaire = new EntierLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValide() {
        String chaine1 = "10)";
        String chaine2 = "10,";
        Assert.assertEquals("10", this.vocabulaire.extraireSymbole(chaine1, 0).obtJeton());
        Assert.assertEquals("10", this.vocabulaire.extraireSymbole(chaine2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreur() {
        String chaineVide1 = "\"Neque porro quisquam est qui ";
        String chaineVide2 = " ";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0));
    }

}

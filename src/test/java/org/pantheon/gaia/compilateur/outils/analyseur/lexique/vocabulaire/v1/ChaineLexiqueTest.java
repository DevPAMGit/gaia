package org.pantheon.gaia.compilateur.outils.analyseur.lexique.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.ChaineLexique;

/**
 * Classe de test pour les classes de type {@link ChaineLexiqueTest}.
 */
public class ChaineLexiqueTest {

    /**
     * Vocabulaire de test.
     */
    private final ChaineLexique vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link ChaineLexiqueTest}.
     */
    public ChaineLexiqueTest() {
        this.vocabulaire = new ChaineLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes vides.
     */
    @Test
    public void extraireSymboleVideTest() {
        String chaineVide1 = "\"\"";
        String chaineVide2 = "\" \"";
        Assert.assertEquals("", this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertEquals(" ", this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValideTest() {
        String chaineVide1 = "\"Neque porro quisquam est qui\"";
        String chaineVide2 = "\"  dolorem ipsum quia dolor sit amet, consectetur \" ";
        Assert.assertEquals("Neque porro quisquam est qui", this.vocabulaire.extraireSymbole(chaineVide1,
                0).obtJeton());
        Assert.assertEquals("  dolorem ipsum quia dolor sit amet, consectetur ",
                this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreurTest() {
        String chaineVide1 = "\"Neque porro quisquam est qui ";
        String chaineVide2 = "10";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0));
    }

}

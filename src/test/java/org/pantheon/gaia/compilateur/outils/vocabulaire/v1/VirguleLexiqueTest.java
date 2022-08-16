package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.VirguleLexique;

/**
 * Classe de test pour le vocabulaire de type {@link VirguleLexique}.
 */
public class VirguleLexiqueTest {

    /**
     * Le vocabulaire à tester.
     */
    private final VirguleLexique vocabulaire;

    /** Initialise une nouvelle instance de la classe {@link VirguleLexiqueTest}. */
    public VirguleLexiqueTest() {
        this.vocabulaire = new VirguleLexique();
    }

    @Test
    public void extraireUniteLexicalePleineTest() {
        String chaineVide1 = ",";
        String chaineVide2 = ", ";
        Assert.assertEquals(",", this.vocabulaire.extraireSymbole(chaineVide1, 0).obtJeton());
        Assert.assertEquals(",", this.vocabulaire.extraireSymbole(chaineVide2, 0).obtJeton());
    }

    @Test
    public void extraireUniteLexicaleErreur() {
        String chaineVide1 = " ,";
        String chaineVide2 = "', ";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaineVide2, 0));
    }
}

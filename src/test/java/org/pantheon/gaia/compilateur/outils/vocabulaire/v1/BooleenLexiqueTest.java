package org.pantheon.gaia.compilateur.outils.vocabulaire.v1;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.BooleenLexique;

/**
 * Classe de test pour la classe {@link BooleenLexique}.
 */
public class BooleenLexiqueTest {

    /**
     * Vocabulaire du test.
     */
    private final BooleenLexique vocabulaire;

    /**
     * Initialise une nouvelle instance de la classe {@link BooleenLexiqueTest}.
     */
    public BooleenLexiqueTest() {
        this.vocabulaire = new BooleenLexique();
    }

    /**
     * Teste le champ lexical avec des chaînes vides.
     */
    @Test
    public void extraireSymboleVideTest() {
        String chaine1 = "\"\"";
        String chaine2 = "\" \"";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaine1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaine2, 0));
    }

    /**
     * Teste le champ lexical avec des chaînes valides.
     */
    @Test
    public void extraireSymboleValideTest() {
        String chaine1 = "True";
        String chaine2 = "true ";

        String chaine3 = "False";
        String chaine4 = "false";

        Assert.assertEquals("True", this.vocabulaire.extraireSymbole(chaine1, 0).obtJeton());
        Assert.assertEquals("true", this.vocabulaire.extraireSymbole(chaine2, 0).obtJeton());

        Assert.assertEquals("False", this.vocabulaire.extraireSymbole(chaine3, 0).obtJeton());
        Assert.assertEquals("false", this.vocabulaire.extraireSymbole(chaine4, 0).obtJeton());
    }

    /**
     * Teste le champ lexical avec des chaînes non valides.
     */
    @Test
    public void extraireSymboleErreurTest() {
        String chaine1 = "Fails ";
        String chaine2 = "Tru";
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaine1, 0));
        Assert.assertNull(this.vocabulaire.extraireSymbole(chaine2, 0));
    }

}

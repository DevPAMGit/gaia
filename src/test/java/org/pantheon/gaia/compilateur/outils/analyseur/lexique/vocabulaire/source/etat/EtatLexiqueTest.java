package org.pantheon.gaia.compilateur.outils.analyseur.lexique.vocabulaire.source.etat;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour les instances {@link EtatAutomate}
 */
public class EtatLexiqueTest {

    /**
     * Etat de satisfaction à tester.
     */
    private final EtatAutomate etatSatisfaisant;

    /**
     * Etat de non-satisfaction à tester.
     */
    private final EtatAutomate etatNonSatisfaisant;

    /**
     * Initialise une nouvelle instance de la classe {@link EtatLexiqueTest}.
     */
    public EtatLexiqueTest() {
        this.etatSatisfaisant = new EtatAutomate(true);
        this.etatNonSatisfaisant = new EtatAutomate(false);

        this.etatSatisfaisant.ajtTransition(new TransitionAutomate(this.etatNonSatisfaisant, "[a-zA-Z]"));
    }

    @Test
    public void testSatisfaction() {
        Assert.assertTrue(this.etatSatisfaisant.estSatisfaisant());
        Assert.assertFalse(this.etatNonSatisfaisant.estSatisfaisant());
    }

    @Test
    public void testTransition() {
        Assert.assertNull(this.etatSatisfaisant.transiter("10"));
        Assert.assertNotNull(this.etatSatisfaisant.transiter("c"));
        Assert.assertNull(this.etatNonSatisfaisant.transiter("c"));
    }


}


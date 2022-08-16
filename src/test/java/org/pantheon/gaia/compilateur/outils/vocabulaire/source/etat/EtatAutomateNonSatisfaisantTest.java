package org.pantheon.gaia.compilateur.outils.vocabulaire.source.etat;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour la classe EtatAutomateNonSatisfaisantTest.
 */
public class EtatAutomateNonSatisfaisantTest {

    /**
     * Etat de non-satisfaction à tester.
     */
    private final EtatAutomateNonSatisfaisant etatNonSatisfaisant;

    /**
     * Initialise une nouvelle instance de la classe {@link EtatAutomateNonSatisfaisantTest}.
     */
    public EtatAutomateNonSatisfaisantTest() {
        EtatAutomate etatSatisfaisant = new EtatAutomate(true);
        this.etatNonSatisfaisant = new EtatAutomateNonSatisfaisant();

        this.etatNonSatisfaisant.ajtTransition(new TransitionAutomate(etatSatisfaisant, "[a-zA-Z]"));
    }

    @Test
    public void testSatisfaction() {
        Assert.assertFalse(this.etatNonSatisfaisant.estSatisfaisant());
    }

    @Test
    public void testTransition() {
        Assert.assertNull(this.etatNonSatisfaisant.transiter("10"));
        Assert.assertNotNull(this.etatNonSatisfaisant.transiter("c"));
    }
}

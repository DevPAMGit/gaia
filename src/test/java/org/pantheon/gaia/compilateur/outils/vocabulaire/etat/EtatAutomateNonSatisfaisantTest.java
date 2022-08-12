package org.pantheon.gaia.compilateur.outils.vocabulaire.etat;

import junit.framework.TestCase;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour la classe EtatAutomateNonSatisfaisantTest.
 */
public class EtatAutomateNonSatisfaisantTest extends TestCase {

    /**
     * Etat de non-satisfaction à tester.
     */
    private EtatAutomateNonSatisfaisant etatNonSatisfaisant;

    /**
     * Etat de satisfaction à tester.
     */
    private EtatAutomate etatSatisfaisant;

    /**
     * Initialise une nouvelle instance de la classe {@link EtatAutomateNonSatisfaisantTest}.
     */
    public EtatAutomateNonSatisfaisantTest() {
        this.etatSatisfaisant = new EtatAutomate(true);
        this.etatNonSatisfaisant = new EtatAutomateNonSatisfaisant();

        this.etatNonSatisfaisant.ajtTransition(new TransitionAutomate(this.etatSatisfaisant, "[a-zA-Z]"));
    }

    @Test
    public void testSatisfaction() {
        assertFalse(this.etatNonSatisfaisant.estSatisfaisant());
    }

    @Test
    public void testTransition() {
        assertNull(this.etatNonSatisfaisant.transiter("10"));
        assertNotNull(this.etatNonSatisfaisant.transiter("c"));
    }
}

package org.pantheon.gaia.compilateur.symbole.v1;

import junit.framework.TestCase;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour les instances {@link EtatAutomate}
 */
public class EtatAutomateTest extends TestCase {

    /**
     * Etat de satisfaction à tester.
     */
    private EtatAutomate etatSatisfaisant = new EtatAutomate(true);

    /**
     * Etat de non-satisfaction à tester.
     */
    private EtatAutomate etatNonSatisfaisant = new EtatAutomate(false);

    /**
     * Initialise une nouvelle instance de la classe {@link EtatAutomateTest}.
     */
    public EtatAutomateTest() {
        this.etatSatisfaisant = new EtatAutomate(true);
        this.etatNonSatisfaisant = new EtatAutomate(false);

        this.etatSatisfaisant.ajtTransition(new TransitionAutomate(this.etatNonSatisfaisant, "[a-zA-Z]"));
    }

    @Test
    public void testInitialisation() {
        assertTrue(this.etatSatisfaisant.estSatisfaisant());
        assertFalse(this.etatNonSatisfaisant.estSatisfaisant());
    }

    public void testTransition() {
        assertNull(this.etatSatisfaisant.transiter("10"));
        assertNotNull(this.etatSatisfaisant.transiter("c"));
        assertNull(this.etatNonSatisfaisant.transiter("c"));
    }


}


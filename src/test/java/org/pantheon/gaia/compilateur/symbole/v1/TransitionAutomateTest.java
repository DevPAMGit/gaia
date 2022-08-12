package org.pantheon.gaia.compilateur.symbole.v1;

import org.junit.Test;
import junit.framework.TestCase;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour la classe TransitionAutomate.
 */
public class TransitionAutomateTest extends TestCase {
    /**
     * L'instance à tester dans cette classe.
     */
    private TransitionAutomate transition;

    /**
     * Initialise une nouvelle instance de la classe {@link TransitionAutomateTest}.s
     */
    public TransitionAutomateTest() {
        EtatAutomate etat = new EtatAutomate(true);
        this.transition = new TransitionAutomate(etat, "[a-zA-Z]");

    }

    @Test
    public void testTransitionOk() {
        IEtatAutomate destination = this.transition.transiter("a");
        assertNotNull(destination);
        assertTrue(destination.estSatisfaisant());
    }

    @Test
    public void testTransitionNonOk() {
        IEtatAutomate destination = this.transition.transiter("1");
        assertNull(destination);
    }

}

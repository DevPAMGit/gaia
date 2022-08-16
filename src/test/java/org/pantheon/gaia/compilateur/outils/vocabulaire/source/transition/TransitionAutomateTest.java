package org.pantheon.gaia.compilateur.outils.vocabulaire.source.transition;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour la classe TransitionAutomate.
 */
public class TransitionAutomateTest {
    /**
     * L'instance à tester dans cette classe.
     */
    private final TransitionAutomate transition;

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
        Assert.assertNotNull(destination);
        Assert.assertTrue(destination.estSatisfaisant());
    }

    @Test
    public void testTransitionNonOk() {
        IEtatAutomate destination = this.transition.transiter("1");
        Assert.assertNull(destination);
    }

}

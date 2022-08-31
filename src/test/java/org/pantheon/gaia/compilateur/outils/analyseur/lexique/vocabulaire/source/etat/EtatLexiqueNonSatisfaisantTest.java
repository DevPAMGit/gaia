package org.pantheon.gaia.compilateur.outils.analyseur.lexique.vocabulaire.source.etat;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour la classe EtatAutomateNonSatisfaisantTest.
 */
public class EtatLexiqueNonSatisfaisantTest {

    /**
     * Etat de non-satisfaction à tester.
     */
    private final EtatAutomateNonSatisfaisant etatNonSatisfaisant;

    /**
     * Initialise une nouvelle instance de la classe {@link EtatLexiqueNonSatisfaisantTest}.
     */
    public EtatLexiqueNonSatisfaisantTest() {
        EtatAutomate etatSatisfaisant = new EtatAutomate(true);
        this.etatNonSatisfaisant = new EtatAutomateNonSatisfaisant();

        this.etatNonSatisfaisant.ajouterTransition(new TransitionAutomate(etatSatisfaisant, "[a-zA-Z]"));
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

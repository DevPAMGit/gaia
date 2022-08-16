package org.pantheon.gaia.compilateur.outils.analyseur.lexique.vocabulaire.source.etat;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour la classe EtatAutomateSatisfaisant.
 */
public class EtatLexiqueSatisfaisantTest {

    /**
     * Etat de satisfaction à tester.
     */
    private final EtatAutomateSatisfaisant etatSatisfaisant;

    /**
     * Etat de non-satisfaction à tester.
     */
    private final EtatAutomate etatNonSatisfaisant = new EtatAutomate(false);

    /**
     * Initialise une nouvelle instance de la classe {@link EtatLexiqueSatisfaisantTest}.
     */
    public EtatLexiqueSatisfaisantTest() {
        this.etatSatisfaisant = new EtatAutomateSatisfaisant();
    }

    /**
     * Test de vérification vérifiant si l'état est satisfaisant.
     */
    @Test
    public void testSatisfaction() {
        Assert.assertTrue(this.etatSatisfaisant.estSatisfaisant());
    }

    /**
     * Test sur la transition d'un état satisfaisant.
     */
    @Test
    public void testTransition() {
        // Cette commande n'est pas supposée ajouter la transition.
        this.etatSatisfaisant.ajtTransition(new TransitionAutomate(this.etatNonSatisfaisant, "[a-zA-Z]"));
        // En conséquence même si la transition devrait être ok, celle-ci doit être null.
        Assert.assertNull(this.etatSatisfaisant.transiter("a"));
    }

}

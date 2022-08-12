package org.pantheon.gaia.compilateur.outils.vocabulaire.etat;

import junit.framework.TestCase;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomate;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.vocabulaire.source.transition.TransitionAutomate;

/**
 * Classe de test pour la classe EtatAutomateSatisfaisant.
 */
public class EtatAutomateSatisfaisantTest extends TestCase {

    /**
     * Etat de satisfaction à tester.
     */
    private EtatAutomateSatisfaisant etatSatisfaisant;

    /**
     * Etat de non-satisfaction à tester.
     */
    private EtatAutomate etatNonSatisfaisant = new EtatAutomate(false);

    /**
     * Initialise une nouvelle instance de la classe {@link EtatAutomateSatisfaisantTest}.
     */
    public EtatAutomateSatisfaisantTest() {
        this.etatSatisfaisant = new EtatAutomateSatisfaisant();
    }

    /**
     * Test de vérification vérifiant si l'état est satisfaisant.
     */
    @Test
    public void testSatisfaction() {
        assertTrue(this.etatSatisfaisant.estSatisfaisant());
    }

    /**
     * Test sur la transition d'un état satisfaisant.
     */
    @Test
    public void testTransition() {
        // Cette commande n'est pas supposée ajouter la transition.
        this.etatSatisfaisant.ajtTransition(new TransitionAutomate(this.etatNonSatisfaisant, "[a-zA-Z]"));
        // En conséquence même si la transition devrait être ok, celle-ci doit être null.
        assertNull(this.etatSatisfaisant.transiter("a"));
    }

}

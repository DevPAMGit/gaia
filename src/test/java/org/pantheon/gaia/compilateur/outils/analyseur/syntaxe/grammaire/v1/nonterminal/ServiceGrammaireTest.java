package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal.ServiceGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.CaractereSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.IdentifiantSymbole;

import java.util.ArrayList;

/**
 * Test unitaire pour la grammaire "service".
 */
public class ServiceGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static ServiceGrammaire GRAMMAIRE = new ServiceGrammaire();

    /**
     * Teste la grammaire avec un symbole "identifiant".
     */
    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new IdentifiantSymbole("identifiant"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test la grammaire avec un symbole autre qu'un symbole valide.
     */
    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new CaractereSymbole("c"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test la grammaire une liste d'unités lexicales vides.
     */
    @Test
    public void testerAnalyseVide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }

}

package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal.VideGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.CaractereSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ParentheseFermanteSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire Vide.
 */
public class VideGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static VideGrammaire VIDE_GRAMMAIRE = new VideGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(VIDE_GRAMMAIRE.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new CaractereSymbole("c"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(VIDE_GRAMMAIRE.analyser(texteSource));
    }

}

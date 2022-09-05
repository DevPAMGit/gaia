package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.ParentheseFermanteGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ParentheseFermanteSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire fin.
 */
public class ParentheseFermanteGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static ParentheseFermanteGrammaire PARENTHESE_FERMANTE_GRAMMAIRE = new ParentheseFermanteGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(PARENTHESE_FERMANTE_GRAMMAIRE.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();

        unitesLexicales.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(PARENTHESE_FERMANTE_GRAMMAIRE.analyser(texteSource));
    }

}

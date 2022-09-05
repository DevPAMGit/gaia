package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.ParentheseOuvranteGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ParentheseOuvranteSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire fin.
 */
public class ParentheseOuvranteGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static ParentheseOuvranteGrammaire PARENTHESE_OUVRANTE_GRAMMAIRE = new ParentheseOuvranteGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new ParentheseOuvranteSymbole("("));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(PARENTHESE_OUVRANTE_GRAMMAIRE.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(PARENTHESE_OUVRANTE_GRAMMAIRE.analyser(texteSource));
    }

}

package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.BooleenGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.CaractereSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire booléen.
 */
public class BooleenGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static BooleenGrammaire GRAMMAIRE_BOOLEEN = new BooleenGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE_BOOLEEN.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new CaractereSymbole("c"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(GRAMMAIRE_BOOLEEN.analyser(texteSource));
    }

}

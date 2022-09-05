package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.VirguleGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.VirguleSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire virgule.
 */
public class VirguleGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static VirguleGrammaire VIRGULE_GRAMMAIRE = new VirguleGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new VirguleSymbole(","));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(VIRGULE_GRAMMAIRE.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(VIRGULE_GRAMMAIRE.analyser(texteSource));
    }

}

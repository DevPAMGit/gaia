package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.ReelGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.EntierSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ReelSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire réel.
 */
public class ReelGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static ReelGrammaire GRAMMAIRE_REEL = new ReelGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new ReelSymbole("10.10"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE_REEL.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(GRAMMAIRE_REEL.analyser(texteSource));
    }

}

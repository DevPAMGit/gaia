package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.IdentifiantGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.IdentifiantSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire fin.
 */
public class IdentifiantGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static IdentifiantGrammaire IDENTIFIANT_FIN = new IdentifiantGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new IdentifiantSymbole("identifiant"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(IDENTIFIANT_FIN.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(IDENTIFIANT_FIN.analyser(texteSource));
    }

}

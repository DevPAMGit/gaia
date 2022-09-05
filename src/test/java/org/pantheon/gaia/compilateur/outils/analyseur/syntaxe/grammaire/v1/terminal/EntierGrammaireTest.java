package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.terminal;

import org.junit.Test;
import org.junit.Assert;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.terminal.EntierGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.BooleenSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.EntierSymbole;

import java.util.ArrayList;

/**
 * Test pour la grammaire entier.
 */
public class EntierGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static EntierGrammaire GRAMMAIRE_ENTIER = new EntierGrammaire();

    @Test
    public void testerAnalyseValide()  {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new EntierSymbole("10"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE_ENTIER.analyser(texteSource));
    }


    @Test
    public void testerAnalyseNonValide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

         Assert.assertFalse(GRAMMAIRE_ENTIER.analyser(texteSource));
    }

}

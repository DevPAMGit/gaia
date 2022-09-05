package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal.SousListeArgumentGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.*;

import java.util.ArrayList;

public class SousListeArgumentTest {

    /**
     * La grammaire à tester.
     */
    private final static SousListeArgumentGrammaire GRAMMAIRE = new SousListeArgumentGrammaire();

    @Test
    public void testValidePlein() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new EntierSymbole("12"));
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new ChaineSymbole("chaine"));
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new ReelSymbole("1.2"));
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));

        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    @Test
    public void testValideVide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    @Test
    public void testInvalide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new EntierSymbole("12"));
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new ChaineSymbole("chaine"));
        unitesLexicales.add(new VirguleSymbole(","));

        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }


}

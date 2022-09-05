package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal.AppelServiceGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.*;

import java.util.ArrayList;

/**
 * Classe de tests unitaire pour la grammaire "appel de service".
 */
public class AppelServiceTest {

    /**
     * La grammaire à tester.
     */
    private final static AppelServiceGrammaire GRAMMAIRE = new AppelServiceGrammaire();

    /**
     * Test la grammaire avec arguments lors de l'appel.
     */
    @Test
    public void testValidePlein() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new IdentifiantSymbole("service"));
        unitesLexicales.add(new ParentheseOuvranteSymbole("("));
        unitesLexicales.add(new EntierSymbole("12"));
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new ChaineSymbole("chaine"));
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new ReelSymbole("1.2"));
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        unitesLexicales.add(new FinSymbole(";"));

        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test la grammaire sans argument lors de l'appel.
     */
    @Test
    public void testValideVide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new IdentifiantSymbole("service"));
        unitesLexicales.add(new ParentheseOuvranteSymbole("("));
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        unitesLexicales.add(new FinSymbole(";"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test avec une liste d'unités lexicales invalides.
     */
    @Test
    public void testInvalideArguments() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new IdentifiantSymbole("service"));
        unitesLexicales.add(new ParentheseOuvranteSymbole("("));
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new EntierSymbole("12"));
        unitesLexicales.add(new VirguleSymbole(","));
        unitesLexicales.add(new ChaineSymbole("chaine"));
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        unitesLexicales.add(new FinSymbole(";"));

        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test invalide : le symbole de fin (';') manquant.
     */
    @Test
    public void testInvalideFinManquantes() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new IdentifiantSymbole("service"));
        unitesLexicales.add(new ParentheseOuvranteSymbole("("));
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test de la grammaire avec une liste d'unité lexical vide.
     */
    @Test
    public void testInvalideVide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }


}

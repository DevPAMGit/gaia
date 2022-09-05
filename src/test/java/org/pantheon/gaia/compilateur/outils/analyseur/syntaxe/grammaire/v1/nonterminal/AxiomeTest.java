package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal.AxiomeGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.*;

import java.util.ArrayList;

/**
 * Classe de tests unitaires pour la grammaire "axiome".
 */
public class AxiomeTest {

    /**
     * La grammaire à tester.
     */
    private final static AxiomeGrammaire GRAMMAIRE = new AxiomeGrammaire();

    /**
     * Test l'appel de service avec une liste d'unités lexicales valides, avec arguments.
     */
    @Test
    public void testAppelServiceUnitesLexicalesValidesAvecArgs() {
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
     * Test l'appel de service avec une liste d'unités lexicales valides, sans arguments.
     */
    @Test
    public void testAppelServiceUnitesLexicalesValidesSansArgs() {
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
    public void testAppelServiceUnitesLexicalesNonValidesAvecArgs() {
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
    public void testInvalideFinManquante() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        unitesLexicales.add(new IdentifiantSymbole("service"));
        unitesLexicales.add(new ParentheseOuvranteSymbole("("));
        unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test de la grammaire avec une liste d'unités lexicales vides.
     */
    @Test
    public void testListeUnitesLexicalesVide() {
        ArrayList<Symbole> unitesLexicales = new ArrayList<>();
        TexteSource texteSource = new TexteSource(unitesLexicales);

        Assert.assertFalse(GRAMMAIRE.analyser(texteSource));
    }


}

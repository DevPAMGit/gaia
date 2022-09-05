package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.grammaire.v1.nonterminal;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.v1.nonterminal.ExpressionGrammaire;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.*;

import java.util.ArrayList;

/**
 * Test pour la grammaire "expression".
 */
public class ExpressionGrammaireTest {

    /**
     * La grammaire à tester.
     */
    private final static ExpressionGrammaire GRAMMAIRE = new ExpressionGrammaire();

    /**
     * Test la validité d'un entier.
     */
    @Test
    public void validerEntier() {
        ArrayList<Symbole> uniteLexicale = new ArrayList<>();
        uniteLexicale.add(new EntierSymbole("12"));
        TexteSource texteSource = new TexteSource(uniteLexicale);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test la validité d'un réel.
     */
    @Test
    public void validerReel() {
        ArrayList<Symbole> uniteLexicale = new ArrayList<>();
        uniteLexicale.add(new ReelSymbole("12.12"));
        TexteSource texteSource = new TexteSource(uniteLexicale);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test la validité d'une chaîne de caractères.
     */
    @Test
    public void validerChaine() {
        ArrayList<Symbole> uniteLexicale = new ArrayList<>();
        uniteLexicale.add(new ChaineSymbole("Chaine de caractère"));
        TexteSource texteSource = new TexteSource(uniteLexicale);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test la validité d'un symbole booléen
     */
    @Test
    public void validerBooleen() {
        ArrayList<Symbole> uniteLexicale = new ArrayList<>();
        uniteLexicale.add(new BooleenSymbole("true"));
        TexteSource texteSource = new TexteSource(uniteLexicale);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }

    /**
     * Test la validité d'un symbole caractère
     */
    @Test
    public void validerCaractere() {
        ArrayList<Symbole> uniteLexicale = new ArrayList<>();
        uniteLexicale.add(new CaractereSymbole("c"));
        TexteSource texteSource = new TexteSource(uniteLexicale);

        Assert.assertTrue(GRAMMAIRE.analyser(texteSource));
    }
}

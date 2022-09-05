package org.pantheon.gaia.compilateur.outils.analyseur.syntaxe.unite;

import org.junit.Assert;
import org.junit.Test;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.AnalyseSyntaxiqueException;
import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.FinSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.IdentifiantSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ParentheseFermanteSymbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.ParentheseOuvranteSymbole;

import java.util.ArrayList;

/**
 * Classe de test pour la classe {@link TexteSource}
 */
public class TexteSourceTest {
    /**
     * L'instance à tester.
     */
    private final TexteSource texteSource;

    /**
     * Liste des symboles.
     */
    private final ArrayList<Symbole> unitesLexicales;

    /**
     * Initialise une nouvelle instance de la classe {@link TexteSource}.
     */
    public TexteSourceTest() {
        this.unitesLexicales = new ArrayList<>();
        this.unitesLexicales.add(new IdentifiantSymbole("service"));
        this.unitesLexicales.add(new ParentheseOuvranteSymbole("("));
        this.unitesLexicales.add(new ParentheseFermanteSymbole(")"));
        this.unitesLexicales.add(new FinSymbole(";"));

        this.texteSource = new TexteSource(this.unitesLexicales);
    }

    @Test
    public void avancerEtSymboleValide() throws AnalyseSyntaxiqueException {
        int max = this.unitesLexicales.size();
        int index = 0;
        while(index < max) {
            Assert.assertEquals(unitesLexicales.get(index).obtType(), this.texteSource.obtenirSymbole());
            this.texteSource.avancer();
            index++;
        }
    }

    @Test
    public void avancerValideNonValide() throws AnalyseSyntaxiqueException {
        int max = this.unitesLexicales.size();
        for(int i=0; i<max; i++) this.texteSource.avancer();
        Assert.assertThrows(AnalyseSyntaxiqueException.class, texteSource::avancer);
    }


    @Test
    public void verifierFinValide() throws AnalyseSyntaxiqueException {
        int max = this.unitesLexicales.size();
        for(int i=0; i<max; i++) this.texteSource.avancer();
        Assert.assertTrue(this.texteSource.estFini());
    }

    @Test
    public void verifierFinNonValide() throws AnalyseSyntaxiqueException {
        int max = this.unitesLexicales.size() - 3;
        for(int i=0; i<max; i++) this.texteSource.avancer();
        Assert.assertFalse(this.texteSource.estFini());
    }


}

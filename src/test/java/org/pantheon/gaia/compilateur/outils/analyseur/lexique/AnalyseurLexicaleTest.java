package org.pantheon.gaia.compilateur.outils.analyseur.lexique;

import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.AnalyseLexicalException;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.AnalyseurLexical;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de test pour la classe {@link AnalyseurLexical}.
 */
public class AnalyseurLexicaleTest {

    /**
     * L'analyseur lexical à tester.
     */
    private final AnalyseurLexical analyseur;

    /**
     * Le resultat attendu la méthode "analyseValide".
     */
    private final ArrayList<Symbole> RESULTATS;

    /**
     * Initialise une nouvelle instance de la classe {@link AnalyseurLexicaleTest}.
     */
    public AnalyseurLexicaleTest() {
        this.analyseur = new AnalyseurLexical();
        this.RESULTATS = new ArrayList<>();

        this.RESULTATS.add(new IdentifiantSymbole("service"));
        this.RESULTATS.add(new ParentheseOuvranteSymbole("("));
        this.RESULTATS.add(new ChaineSymbole("chaine"));
        this.RESULTATS.add(new VirguleSymbole(","));
        this.RESULTATS.add(new CaractereSymbole("c"));
        this.RESULTATS.add(new VirguleSymbole(","));
        this.RESULTATS.add(new EntierSymbole("10"));
        this.RESULTATS.add(new VirguleSymbole(","));
        this.RESULTATS.add(new ReelSymbole("10.5"));
        this.RESULTATS.add(new ParentheseFermanteSymbole(")"));
        this.RESULTATS.add(new FinSymbole(";"));
    }

    /**
     * Test l'analyseur avec une instruction valide.
     */
    @Test
    public void analyseValide() throws AnalyseLexicalException {
        String instruction = "service ( \"chaine\", 'c', 10, 10.5);";
        List<Symbole> symboles = analyseur.analyser(instruction);

        Assert.assertEquals(symboles.size(), this.RESULTATS.size());
        for(int i=0; i< symboles.size(); i++) {
            Assert.assertEquals(symboles.get(i).obtJeton(), this.RESULTATS.get(i).obtJeton());
            Assert.assertEquals(symboles.get(i).obtType(), this.RESULTATS.get(i).obtType());
        }
    }

    /**
     * Test l'analyseur avec une instruction non valide.
     */
    @Test
    public void analyseNonValide() throws AnalyseLexicalException {
        String instruction = "service ( \"chaine\", c', 10, 10.5);";
        Assert.assertThrows(AnalyseLexicalException.class, () -> { this.analyseur.analyser(instruction); });
    }
}

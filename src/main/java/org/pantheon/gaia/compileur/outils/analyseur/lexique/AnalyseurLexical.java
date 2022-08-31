package org.pantheon.gaia.compileur.outils.analyseur.lexique;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1.*;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant d'analyser lexicalement une instruction.
 */
public class AnalyseurLexical {

    /**
     * Lexique de l'analyseur lexical.
     */
    private final ArrayList<Lexique> lexiques;

    /**
     * Initialise une nouvelle instance de la classe {@link AnalyseurLexical}.
     */
    public AnalyseurLexical() {
        this.lexiques = new ArrayList<>();
        this.initialiserLexique();
    }

    /**
     * Analyse des instruction.
     * @param instruction La chaîne de caractères des instructions.
     * @return La liste des symboles correspondants à l'instruction.
     * @throws AnalyseLexicalException Si une erreur lexicale survient.
     */
    public List<Symbole> analyser(String instruction) throws AnalyseLexicalException {
        instruction = instruction.replaceAll(
                "\\s+(?=((\\\\[\\\\\"]|[^\\\\\"])*\"(\\\\[\\\\\"]|[^\\\\\"])*\")*(\\\\[\\\\\"]|[^\\\\\"])*$)",
                "");

        int curseur = 0;
        Symbole symbole;
        int max = instruction.length();
        ArrayList<Symbole> symboles = new ArrayList<>();

        while(curseur < max) {
            symbole = this.obtSymbole(instruction, curseur);
            curseur += symbole.obtJeton().length();

            if(symbole.obtType() == ETypeSymbole.CARACTERE || symbole.obtType() == ETypeSymbole.CHAINE)
                curseur +=2;

            symboles.add(symbole);
        }

        return symboles;
    }

    /**
     * Méthode permettant d'obtenir un {@link Symbole}.
     * @param instruction l'instruction à éxecuter.
     * @param curseur La position de départ de récupération de l'analyse lexicale.
     * @return L'unité lexicale récupérée.
     * @throws AnalyseLexicalException Si aucune unité lexicale n'a pété récupérée.
     */
    private Symbole obtSymbole(String instruction, int curseur) throws AnalyseLexicalException {
        int index = 0;
        int max = this.lexiques.size();
        Symbole symbole = null;

        while(symbole == null && index < max) {
            symbole = this.lexiques.get(index).extraireSymbole(instruction, curseur);
            index++;
        }

        if(symbole == null) throw new AnalyseLexicalException(instruction, curseur);
        // System.out.println(symbole.obtJeton());
        return symbole;
    }

    /**
     * Initialise le lexique de l'analyseur.
     */
    private void initialiserLexique() {
        this.lexiques.add(new FinLexique());
        this.lexiques.add(new ReelLexique());
        this.lexiques.add(new EntierLexique());
        this.lexiques.add(new ChaineLexique());
        this.lexiques.add(new VirguleLexique());
        this.lexiques.add(new BooleenLexique());
        this.lexiques.add(new CaractereLexique());
        this.lexiques.add(new IdentifiantLexique());
        this.lexiques.add(new ParentheseOuvranteLexique());
        this.lexiques.add(new ParentheseFermanteLexique());
    }
}



package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.AnalyseSyntaxiqueException;
import org.pantheon.gaia.compileur.outils.symbole.source.ETypeSymbole;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;

import java.util.List;

/**
 * Le texte source à analyser.
 */
public class TexteSource {

    /**
     * Les symboles de l'unité lexicale.
     */
    private final List<Symbole> symboles;

    /**
     * Le curseur de consultation.
     */
    private int curseur;

    /**
     * Initialise une nouvelle instance de la classe {@link TexteSource}.
     * @param symboles Les symboles à analyser.
     */
    public TexteSource(List<Symbole> symboles) {
        this.symboles = symboles;
        this.curseur = 0;
    }

    /**
     * Modifier la position du curseur.
     * @param curseur La nouvelle valeur du paramètre curseur.
     * @throws AnalyseSyntaxiqueException Si la nouvelle valeur est invalide.
     */
    private void majCurseur(int curseur) throws AnalyseSyntaxiqueException {
        if(curseur < 0 || this.estFini())
            throw new AnalyseSyntaxiqueException(String.format("Aucun symbole à l'index %d du texte source.", this.curseur));
        this.curseur = curseur;
    }

    /**
     * Fait avancer le curseur dans le texte source.
     * @throws AnalyseSyntaxiqueException Si la nouvelle valeur est invalide.
     */
    public void avancer() throws AnalyseSyntaxiqueException {
        this.majCurseur(this.curseur+1);
    }

    /**
     * Vérifie si le curseur peut encore avancer.
     * @return <c>true</c> si le curseur est arrivé au bout du texte cible ; sinon <c>false</c>.
     */
    public boolean estFini() {
        return this.curseur == this.symboles.size();
    }

    /**
     * Permet d'obtenir le symbole à la position actuelle.
     * @return Le symbole à la position actuelle.
     * @throws AnalyseSyntaxiqueException S'il n'y a pas de valeur attendue à la position du curseur.
     */
    public ETypeSymbole obtenirSymbole() throws AnalyseSyntaxiqueException {
        if(this.estFini())
            throw new AnalyseSyntaxiqueException(String.format("Aucun symbole à l'index %d du texte source.", this.curseur));

        return this.symboles.get(this.curseur).obtType();
    }
}

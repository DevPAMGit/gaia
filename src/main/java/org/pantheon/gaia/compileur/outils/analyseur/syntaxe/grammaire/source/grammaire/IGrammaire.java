package org.pantheon.gaia.compileur.outils.analyseur.syntaxe.grammaire.source.grammaire;

import org.pantheon.gaia.compileur.outils.analyseur.syntaxe.unite.TexteSource;

/**
 * Interface de contractuelle pour un etat de la grammaire.
 */
public interface IGrammaire {
    /**
     * Analyse la liste des symboles de l'analyse lexicale.
     * @param texteSource le texte source à analyser.
     * @return <c>true</c> si la suite lexicale est valide ; sinon <c>false</c>.
     */
    boolean analyser(TexteSource texteSource);

}

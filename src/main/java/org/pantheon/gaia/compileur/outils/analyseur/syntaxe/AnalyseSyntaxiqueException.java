package org.pantheon.gaia.compileur.outils.analyseur.syntaxe;

import org.pantheon.gaia.compileur.outils.exception.CompilateurException;

/**
 * Classe d'exception pour une erreur syntaxique.
 */
public class AnalyseSyntaxiqueException extends CompilateurException {

    /**
     * Initialise une nouvelle instance de la classe {@link AnalyseSyntaxiqueException}.
     * @param message Le message d'erreur de l'exception.
     */
    public AnalyseSyntaxiqueException(String message) {
        super(message);
    }
}

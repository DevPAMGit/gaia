package org.pantheon.gaia.compileur.outils.exception;

/**
 * Exception personnalisée lancée lorsqu'une erreur de compilation survient.
 */
public class CompilateurException extends Exception {

    /**
     * Initialise une nouvelle instance de la classe {@link CompilateurException}.
     * @param message Le message lié à l'exception.
     */
    public CompilateurException(String message) {
        super(message);
    }

}

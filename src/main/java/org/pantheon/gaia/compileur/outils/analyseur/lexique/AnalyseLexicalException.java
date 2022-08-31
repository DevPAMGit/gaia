package org.pantheon.gaia.compileur.outils.analyseur.lexique;

import org.pantheon.gaia.compileur.outils.exception.CompilateurException;

/**
 * Classe d'exception lancée lorsque
 */
public class AnalyseLexicalException extends CompilateurException {

    /**
     * L'instruction ayant causé l'erreur.
     */
    private final String instruction;

    /**
     * Le curseur de l'erreur.
     */
    private final int curseur;

    /**
     * Initialise une nouvelle instance de la classe {@link AnalyseLexicalException}.
     * @param instruction L'instruction ayant causé l'exception.
     * @param curseur Curseur sur le début de l'erreur.
     */
    public AnalyseLexicalException(String instruction, int curseur) {
        super(null);
        this.instruction = instruction;
        this.curseur = curseur;
    }

    @Override
    public String getMessage() {
        return String.format("\n%s\n", this.instruction) + " ".repeat(Math.max(0, this.curseur)) +
                "^\nVotre commandes est lexicalement incorrect à cet endroit.";
    }
}

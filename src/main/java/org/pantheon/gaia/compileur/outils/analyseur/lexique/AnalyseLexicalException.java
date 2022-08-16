package org.pantheon.gaia.compileur.outils.analyseur.lexique;

/**
 * Classe d'exception lancée lorsque
 */
public class AnalyseLexicalException extends Exception {

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
        super();
        this.instruction = instruction;
        this.curseur = curseur;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder(String.format("\n%s\n", this.instruction));
        for(int i=0; i<this.curseur; i++)
            message.append(" ");
        message.append("^\nL'unité lexicale n'a pas été reconnue.");
        return message.toString();
    }
}

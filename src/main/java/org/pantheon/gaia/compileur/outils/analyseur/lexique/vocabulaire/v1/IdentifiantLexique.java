package org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.v1;

import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.IEtatAutomate;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.Lexique;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.etat.EtatAutomateNonSatisfaisant;
import org.pantheon.gaia.compileur.outils.analyseur.lexique.vocabulaire.source.transition.TransitionAutomate;
import org.pantheon.gaia.compileur.outils.symbole.source.Symbole;
import org.pantheon.gaia.compileur.outils.symbole.v1.IdentifiantSymbole;

/**
 * Champ lexical pour les types identifiants.
 */
public class IdentifiantLexique extends Lexique {

    /**
     * Le second état source.
     */
    private EtatAutomateNonSatisfaisant source2;


    /**
     * Initialise une nouvelle instance de la classe {@link IdentifiantLexique}.
     */
    public IdentifiantLexique() {
        super();
    }

    @Override
    protected void initialiser() {
        EtatAutomateNonSatisfaisant etat1 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat2 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition1 = new TransitionAutomate(etat2, "[a-zA-Z]");
        TransitionAutomate transition2 = new TransitionAutomate(etat2, "[a-zA-Z0-9]");

        etat1.ajouterTransition(transition1);
        etat2.ajouterTransition(transition2);

        EtatAutomateNonSatisfaisant etat3 = new EtatAutomateNonSatisfaisant();
        EtatAutomateSatisfaisant etat4 = new EtatAutomateSatisfaisant();

        TransitionAutomate transition3 = new TransitionAutomate(etat4, "[a-zA-Z0-9]");

        etat3.ajouterTransition(transition3);

        this.source = etat1;
        this.source2 = etat3;
    }

    @Override
    public Symbole extraireSymbole(String instruction, int curseur) {
        String unite = this.extraireUniteLexicale(instruction, curseur);
        if(unite == null) return null;
        return new IdentifiantSymbole(unite);
    }

    @Override
    protected String extraireUniteLexicale(String instruction, int curseur) {
        String extraction = super.extraireUniteLexicale(instruction, curseur);
        if(extraction == null) return null;

        StringBuilder unite = new StringBuilder(extraction);
        curseur++;
        String buffer = this.extraireSousUniteLexicale(instruction, curseur);

        while((buffer != null)) {
            unite.append(buffer);
            curseur++;
            buffer = this.extraireSousUniteLexicale(instruction, curseur);
        }

        return unite.toString();
    }

    /**
     * Sous extracteur d'unité lexicale.
     * @param commande la commande à parser.
     * @param curseur La position de départ pour du parseur.
     * @return L'unité lexicale extraite ou null.
     */
    private String extraireSousUniteLexicale(String commande, int curseur) {
        String unite = "";
        int max = commande.length();
        IEtatAutomate etat = this.source2;

        while( etat != null && !etat.estSatisfaisant() && curseur < max ) {
            String caractere = String.valueOf(commande.charAt(curseur));
            unite = String.format("%s%s", unite, caractere);
            etat = etat.transiter(caractere);
            curseur++;
        }

        if(etat == null || !etat.estSatisfaisant()) return null;
        return unite;
    }
}

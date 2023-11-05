package src;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Professeur extends Personne {
    private final String abreviation;
    private Lecon[] lecons;

    public Professeur(String nom, String prenom, String abreviation) {
        super(nom, prenom);
        if (abreviation == null || abreviation.isEmpty()) {
            throw new RuntimeException("L'abréviation ne peut pas être vide");
        }
        this.abreviation = abreviation;
    }

    public String abreviation() {
        return abreviation;
    }

    public String horaire() {
        return String.format("\n-- Horaire %s\n\n%s", this, Lecon.horaire(lecons));
    }

    public String toString() {
        return String.format("Prof. %s (%s)", super.toString(), abreviation);
    }

    public void definirLecons(Lecon[] lecons) {
        this.lecons = lecons;
    }
}
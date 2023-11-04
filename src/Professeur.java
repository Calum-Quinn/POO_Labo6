package src;

public class Professeur extends Personne {
    private final String abreviation;
    private Lecon[] lecons;

    public Professeur(String nom, String prenom, String abreviation) {
        super(nom, prenom);
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
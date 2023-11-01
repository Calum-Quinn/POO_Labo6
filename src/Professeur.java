package src;

public class Professeur extends Personne {
    private final String abreviation;
    private Lecon[] lecons;

    public Professeur(String nom, String prenom, String abreviation) {
        super(nom, prenom);
        this.abreviation = abreviation;
    }

    public String abreviation() {
        return this.abreviation;
    }

    public String horaire() {
        return "";
    }

    public String toString() {
        //return "Prof. " + super.toString() + " " + "(" + this.abreviation + ")";
        return String.format("Prof. %s (%s)",super.toString(),this.abreviation);
    }
}
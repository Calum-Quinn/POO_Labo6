public class Professeur extends Personne {
    private String abreviation;
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
        return super.toString() + " " + this.abreviation;
    }
}

public class Etudiant extends Personne {
    private String matricule;
    private Groupe groupe;

    public Etudiant(String nom, String prenom, String matricule) {
        super(nom, prenom);
        this.matricule = matricule;
    }

    public String toString() {
        return super.toString() + " " + this.matricule;
    }
}
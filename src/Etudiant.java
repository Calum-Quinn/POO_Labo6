public class Etudiant extends Personne {
    private int matricule;
    private Groupe groupe;

    public Etudiant(String nom, String prenom, int matricule) {
        super(nom, prenom);
        this.matricule = matricule;
    }

    public String toString() {
        return "Etud. " + super.toString() + " " + "(" + this.matricule + ")" + " - " + this.groupe.nom();
    }
}
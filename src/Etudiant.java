package src;

public class Etudiant extends Personne {
    private final int matricule;
    private Groupe groupe;

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Etudiant(String nom, String prenom, int matricule) {
        super(nom, prenom);
        this.matricule = matricule;
    }

    public String toString() {
        //return "Etud. " + super.toString() + " " + "(" + this.matricule + ")" + " - " + this.groupe.nom();
        return String.format("Etud. %s (%s) - %s",super.toString(),this.matricule,this.groupe.nom());
    }
}
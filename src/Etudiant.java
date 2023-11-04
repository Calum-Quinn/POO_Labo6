package src;

public class Etudiant extends Personne {
    private final int matricule;
    private Groupe groupe;

    public Etudiant(String nom, String prenom, int matricule) {
        super(nom, prenom);
        if (matricule < 0) {
            throw new RuntimeException("Le numéro de matricule doit être positif");
        }
        this.matricule = matricule;
    }

    public String toString() {
        return String.format("Etud. %s (%s) - %s", super.toString(), matricule, groupe.nom());
    }

    public void definirGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
}
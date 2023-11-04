package src;

public abstract class Personne {
    private final String nom;
    private final String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String toString() {
        return String.format("%s %s", prenom, nom);
    }
}
package src;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public abstract class Personne {
    private final String nom;
    private final String prenom;

    public Personne(String nom, String prenom) {
        if (nom == null || prenom == null || nom.isEmpty() || prenom.isEmpty()) {
            throw new RuntimeException("Le nom et le prénom ne peuvent pas être vides");
        }
        this.nom = nom;
        this.prenom = prenom;
    }

    public String toString() {
        return String.format("%s %s", prenom, nom);
    }
}
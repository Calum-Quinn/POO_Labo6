public class Groupe {
    private int numero;
    private int trimestre;
    private String orientation;
    private Etudiant[] etudiants;
    private Lecon[] lecons;

    public Groupe(int numero, int trimestre, String orientation, Etudiant[] etudiants) {
        if (etudiants == null) {
            throw new RuntimeException("Il faut au moins 1 étudiant dans un groupe");
        }
        this.numero = numero;
        this.trimestre = trimestre;
        this.orientation = orientation;
    }

    public String horaire() {
        return "";
    }

    public String nom() {
        return "";
    }

    public int nombreEtudiants() {
        return 0;
    }
    
    public void definirLecons(Lecon[] lecons) {
        this.lecons = lecons;
    }
}
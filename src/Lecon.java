package src;

public class Lecon {
    private final String matiere;
    private final int jourSemaine;
    private final int periodeDebut;
    private final int duree;
    private final String salle;
    private final Professeur professeur;

    public String getMatiere() {
        return matiere;
    }

    public int getJourSemaine() {
        return jourSemaine;
    }

    public int getPeriodeDebut() {
        return periodeDebut;
    }

    public int getDuree() {
        return duree;
    }

    public String getSalle() {
        return salle;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public Lecon(String matiere, int jourSemaine, int periodeDebut, int duree, String salle, Professeur professeur) {
        this.matiere = matiere;
        this.jourSemaine = jourSemaine;
        this.periodeDebut = periodeDebut;
        this.duree = duree;
        this.salle = salle;
        this.professeur = professeur;
    }

    public static String horaire() {
        return "";
    }
}
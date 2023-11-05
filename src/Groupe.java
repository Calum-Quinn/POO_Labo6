package src;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Groupe {
    private final int numero;
    private final int trimestre;
    private final String orientation;
    private final Etudiant[] etudiants;
    private Lecon[] lecons;

    public Groupe(int numero, int trimestre, String orientation, Etudiant[] etudiants) {
        if (etudiants == null) {
            throw new RuntimeException("Il faut au moins 1 étudiant dans un groupe");
        }
        if(numero < 0 || trimestre < 0 || orientation == null || orientation.isEmpty()) {
            throw new RuntimeException("Le numéro et le trimestre doivent être positifs et l'orientation ne peut pas être vide");
        }
        this.numero = numero;
        this.trimestre = trimestre;
        this.orientation = orientation;
        this.etudiants = etudiants;
        // Assign a group to each student
        for (Etudiant etudiant : etudiants) {
            etudiant.definirGroupe(this);
        }
    }

    public String horaire() {
        return String.format("\n-- Horaire du groupe %s (%s étudiants)\n\n%s", nom(), nombreEtudiants(), Lecon.horaire(lecons));
    }

    public String nom() {
        return String.format("%s%d-%d", orientation, trimestre, numero);
    }

    public int nombreEtudiants() {
        return etudiants.length;
    }

    public void definirLecons(Lecon[] lecons) {
        this.lecons = lecons;
    }
}
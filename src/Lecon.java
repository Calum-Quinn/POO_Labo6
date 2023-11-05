package src;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Lecon {
    private final String matiere;
    private final int jourSemaine;
    private final int periodeDebut;
    private final int duree;
    private final String salle;
    private final Professeur professeur;
    private static final char caractereColonne = '|';
    private static final int largeurCellule = 13;

    public Lecon(String matiere, int jourSemaine, int periodeDebut, int duree, String salle, Professeur professeur) {
        if (matiere == null || matiere.isEmpty()) {
            throw new RuntimeException("La matière ne peut pas être vide");
        }
        if (jourSemaine < 1 || jourSemaine > 5) {
            throw new RuntimeException("Le jour de la semaine doit être entre 1 et 5");
        }
        if (periodeDebut < 1 || periodeDebut > 11) {
            throw new RuntimeException("La période de début doit être entre 1 et 11");
        }
        if (duree % 45 != 0 || duree > 495) {
            throw new RuntimeException("La durée doit être un multiple de 45 et inférieure à 495");
        }
        if (salle == null || salle.isEmpty()) {
            throw new RuntimeException("La salle ne peut pas être vide");
        }
        this.matiere = matiere;
        this.jourSemaine = jourSemaine;
        this.periodeDebut = periodeDebut;
        this.duree = duree;
        this.salle = salle;
        this.professeur = professeur;
    }

    public static String horaire(Lecon[] lecons) {
        // Create a 2D array to store the schedule
        final int nbLignes = 24, nbColonnes = 6;
        String[][] grille = new String[nbLignes][nbColonnes];

        // Create the left and top headers
        creerEntetes(grille);

        // Fill the schedule column by column to simplify the code for multiple lessons in the same day
        for (int i = 1; i < nbColonnes; ++i) {
            int nbSeparationsVides = 0;

            for (int j = 2; j < nbLignes; ++j) {
                // If the row is even, it's a lesson else it's a separation
                if (j % 2 == 0) {
                    boolean leconTrouvee = false;
                    // Create a lesson cell if a lesson was found for the current day and period
                    for (Lecon lecon : lecons) {
                        if (lecon.jourSemaine == i && lecon.periodeDebut == j / 2) {
                            String professeurAbreviation = lecon.professeur != null ? lecon.professeur.abreviation() : " ";
                            grille[j][i] = cellule(lecon.matiere, lecon.salle, professeurAbreviation);
                            // Calculate the number of empty separations needed for the lesson
                            nbSeparationsVides = lecon.duree / 45 - 1;
                            leconTrouvee = true;
                            break;
                        }
                    }
                    // If no lesson was found, we create an empty cell
                    if (!leconTrouvee) {
                        grille[j][i] = cellule(null, null, null);
                    }
                } else {
                    // Create an empty separation cell or a cell with a separation character
                    if (nbSeparationsVides > 0) {
                        grille[j][i] = celluleSeparation(true);
                        --nbSeparationsVides;
                    } else {
                        grille[j][i] = celluleSeparation(false);
                    }
                }
            }
        }
        // Create the schedule string by concatenating the columns
        StringBuilder horaire = new StringBuilder();

        for (int i = 0; i < nbLignes; ++i) {
            for (int j = 0; j < nbColonnes; ++j) {
                horaire.append(grille[i][j]);
            }
            horaire.append("\n");
        }

        return horaire.toString();
    }

    private static void creerEntetes(String[][] grille) {
        // Top header
        final String[] jours = {"Lun", "Mar", "Mer", "Jeu", "Ven"};
        for (int i = 1; i < grille[0].length; ++i) {
            // We need to decrease the width by 1 because of the first space
            grille[0][i] = String.format(" %-" + (largeurCellule - 1) + "s%s", jours[i - 1], caractereColonne);
            grille[1][i] = celluleSeparation(false);
        }

        // Left header
        final String[] heures = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15", "14:00", "14:55", "15:45",
                "16:35", "17:20"};
        grille[0][0] = celluleHeure(null);
        grille[1][0] = celluleHeure(null);
        for (int i = 2; i < grille.length; ++i) {
            if (i % 2 == 0) {
                grille[i][0] = celluleHeure(heures[i / 2 - 1]);
            } else {
                grille[i][0] = celluleHeure(null);
            }
        }
    }

    private static String celluleHeure(String heure) {
        final int largeur = 5;
        heure = heure != null ? heure : " ";

        return String.format("%" + largeur + "s%s", heure, caractereColonne);
    }

    private static String cellule(String matiere, String salle, String professeur) {
        matiere = matiere != null ? matiere : "";
        salle = salle != null ? salle : "";
        String professeurAbreviation = professeur != null ? professeur : "";
        String texteCellule = String.format("%s%3s%s %s", matiere, " ", salle, professeurAbreviation);

        return String.format("%-" + largeurCellule + "s%s", texteCellule, caractereColonne);
    }

    private static String celluleSeparation(boolean estVide) {
        char caractereSeparation = estVide ? ' ' : '-';

        return String.format("%" + largeurCellule + "s", " ").replace(' ', caractereSeparation) + caractereColonne;
    }
}
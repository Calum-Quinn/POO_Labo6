package src;

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
        this.matiere = matiere;
        this.jourSemaine = jourSemaine;
        this.periodeDebut = periodeDebut;
        this.duree = duree;
        this.salle = salle;
        this.professeur = professeur;
    }

    public static String horaire(Lecon[] lecons) {
        final int nbLignes = 24, nbColonnes = 6;

        String[][] grille = new String[nbLignes][nbColonnes];

        creerEntetes(grille);

        for (int i = 1; i < nbColonnes; ++i) {
            int nbSeparationsVides = 0;

            for (int j = 2; j < nbLignes; ++j) {
                if (j % 2 == 0) {
                    boolean leconTrouvee = false;

                    for (Lecon lecon : lecons) {
                        if (lecon.jourSemaine == i && lecon.periodeDebut == j / 2) {
                            String professeurAbreviation = lecon.professeur != null ? lecon.professeur.abreviation() : " ";
                            grille[j][i] = cellule(lecon.matiere, lecon.salle, professeurAbreviation);
                            nbSeparationsVides = lecon.duree / 45 - 1;
                            leconTrouvee = true;
                            break;
                        }
                    }

                    if (!leconTrouvee) {
                        grille[j][i] = cellule(null, null, null);
                    }
                } else {
                    if (nbSeparationsVides > 0) {
                        grille[j][i] = celluleSeparation(true);
                        --nbSeparationsVides;
                    } else {
                        grille[j][i] = celluleSeparation(false);
                    }
                }
            }
        }

        StringBuilder horaire = new StringBuilder();

        for (int i = 0; i < nbLignes; ++i) {
            for (int j = 0; j < nbColonnes; ++j) {
                horaire.append(grille[i][j]);
            }
            horaire.append("\n");
        }


        return horaire.toString();
    }

    private static String celluleHeure(String heure) {
        final int largeur = 5;
        heure = heure != null ? heure : " ";

        return String.format("%" + largeur + "s%s", heure, caractereColonne);
    }

    private static String celluleJour(String jour) {
        // We need to decrease the width by 1 because of the first space
        return String.format(" %-" + (largeurCellule - 1) + "s%s", jour, caractereColonne);
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

    private static void creerEntetes(String[][] grille) {
        final String[] heures = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15", "14:00", "14:55", "15:45",
                "16:35", "17:20"};
        final String[] jours = {"Lun", "Mar", "Mer", "Jeu", "Ven"};

        // Left header
        grille[0][0] = celluleHeure(null);
        grille[1][0] = celluleHeure(null);
        for (int i = 2; i < grille.length; ++i) {
            if (i % 2 == 0) {
                grille[i][0] = celluleHeure(heures[i / 2 - 1]);
            } else {
                grille[i][0] = celluleHeure(null);
            }
        }

        // Top header
        for (int i = 1; i < grille[0].length; ++i) {
            grille[0][i] = celluleJour(jours[i - 1]);
            grille[1][i] = celluleSeparation(false);
        }
    }
}
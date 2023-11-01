package src;

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
        this.numero = numero;
        this.trimestre = trimestre;
        this.orientation = orientation;
        this.etudiants = etudiants;
        // Assign group to each student
        for (Etudiant etudiant : etudiants) {
            etudiant.setGroupe(this);
        }
    }

    public String horaire() {

        // IL FAUDRAIT SUREMENT FAIRE UNE CLASSE HORAIRE

        // Print header
        String[] jours = {"Lun","Mar","Mer","Jeu","Ven"};
        String[] heures = {"8:30","9:15","10:25","12:00","13:15","14:00","14:55","15:45","16:35","17:20"};
        System.out.print("     |");
        for (String jour : jours) {
            System.out.print(" " + jour + "         |");
        }
        System.out.println();

        // Print line under header
        System.out.print("     |");
        for (int i = 0; i < jours.length; ++i) {
            System.out.print("-------------|");
        }
        System.out.println();

        // Print lines with time and lessons
        for (int j = 0; j < heures.length; ++j) {
            // Table to show whether a certain day has a double period at a specific time
            boolean[] doublePeriode = {false,false,false,false,false};
            System.out.printf("%5s|",heures[j]);
            for (int k = 0; k < jours.length; ++k) {
                String print = "";
                // If there is a class during this period
                for (Lecon lecon : lecons) {
                    if (lecon.getPeriodeDebut() == j + 1 && lecon.getJourSemaine() == k + 1) {

                        // LECON N'A PAS DE METHODE toString(), JE PENSE QUE CA SERAIT BIEN D'EN FAIRE UNE
                        //print = lecon.toString();
                        print = lecon.getMatiere() + "   " + lecon.getSalle() + " ";
                        if (lecon.getProfesseur() != null) {
                            print += lecon.getProfesseur().abreviation();
                        }
                        else {
                            print += "   ";
                        }

                        // If there is a double period we need to specify which line not to draw on the next row
                        if (lecon.getDuree() == 90) {
                            doublePeriode[k] = true;
//                            doublePeriode = k + 1;
                        }

                        break;
                    }
                }
                System.out.printf("%13s|",print);
            }
            System.out.println();

            System.out.print("     |");

            for (int l = 0; l < jours.length; ++l) {
                if (doublePeriode[l]) {
                    System.out.print("             |");
                    continue;
                }
                System.out.print("-------------|");
            }

            System.out.println();
        }

        return "";
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
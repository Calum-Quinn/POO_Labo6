package src;

public class Professeur extends Personne {
    private final String abreviation;
    private Lecon[] lecons;

    public void setLecons(Lecon[] lecons) {
        this.lecons = lecons;
    }

    public Professeur(String nom, String prenom, String abreviation) {
        super(nom, prenom);
        this.abreviation = abreviation;
    }

    public String abreviation() {
        return this.abreviation;
    }

    public String horaire() {
        // IL FAUDRAIT SUREMENT FAIRE UNE CLASSE HORAIRE

        StringBuilder horaire = new StringBuilder();

        // Print header
        String[] jours = {"Lun","Mar","Mer","Jeu","Ven"};
        String[] heures = {"8:30","9:15","10:25","11:15","12:00","13:15","14:00","14:55","15:45","16:35","17:20"};
        horaire.append("     |");
        for (String jour : jours) {
            horaire.append(" ").append(jour).append("         |");
        }
        horaire.append('\n');

        // Print line under header
        horaire.append("     |");
        horaire.append("-------------|".repeat(jours.length));
        horaire.append('\n');

        // Print lines with time and lessons
        for (int j = 0; j < heures.length; ++j) {
            // Table to show whether a certain day has a double period at a specific time
            boolean[] doublePeriode = {false,false,false,false,false};
            horaire.append(String.format("%5s|", heures[j]));
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
                        }

                        break;
                    }
                }
                horaire.append(String.format("%13s|",print));
            }
            horaire.append('\n');

            // Print row with lines between periods
            horaire.append("     |");
            for (int l = 0; l < jours.length; ++l) {
                // No line if double period
                if (doublePeriode[l]) {
                    horaire.append("             |");
                    continue;
                }
                horaire.append("-------------|");
            }
            horaire.append('\n');
        }

        return horaire.toString();
    }

    public String toString() {
        //return "Prof. " + super.toString() + " " + "(" + this.abreviation + ")";
        return String.format("Prof. %s (%s)",super.toString(),this.abreviation);
    }
}
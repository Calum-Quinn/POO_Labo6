package src;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Professeur[] professeurs = new Professeur[]{
                new Professeur("Rossier", "Daniel", "DRE"),
                new Professeur("Donini", "Pierre", "PDO")
        };

        Lecon[] lecons = new Lecon[]{
                new Lecon("POO", 3, 6, 90, "H02", professeurs[1]),
                new Lecon("POO", 4, 6, 90, "H02", professeurs[1]),
                new Lecon("POO", 4, 8, 90, "H02", professeurs[1]),
                new Lecon("SYE", 1, 1, 90, "G01", professeurs[0]),
                new Lecon("SYE", 4, 3, 90, "A09", professeurs[0]),
                new Lecon("TIC", 2, 10, 45, "F06", null)
        };

        Etudiant[] etudiants = new Etudiant[]{
                new Etudiant("Lennon", "John", 1234),
                new Etudiant("Mc Cartney", "Paul", 2341),
                new Etudiant("Starr", "Ringo", 3241),
                new Etudiant("Harrison", "George", 4321),
                new Etudiant("Waters", "Roger", 1324),
                new Etudiant("Gilmour", "David", 4312),
        };

        // ON DOIT UTILISER SOUVENT LES GROUPES ET LEURS METHODES DONC ON PEUT PEUT-ETRE DEFINIR DES VARIABLES
        // E.G.
        /*
        Groupe IL6_1 = new Groupe(1, 6, "IL", Arrays.copyOfRange(etudiants, 0, 4));
        Groupe SI6_1 = new Groupe(1, 6, "SI", Arrays.copyOfRange(etudiants, etudiants.length - 2, etudiants.length));
         */

        Groupe[] groupes = new Groupe[]{
                new Groupe(1, 6, "IL", Arrays.copyOfRange(etudiants, 0, 4)),
                new Groupe(1, 6, "SI", Arrays.copyOfRange(etudiants, etudiants.length - 2, etudiants.length))
        };

        // Define each group's lessons
        groupes[0].definirLecons(lecons);
        groupes[1].definirLecons(Arrays.copyOfRange(lecons, 0, 3));

        // Count each professor's lessons
        int[] leconsParProf = new int[professeurs.length];
        for (Lecon lecon : lecons) {
            for (int i = 0; i < professeurs.length; ++i) {
                if (lecon.getProfesseur() == professeurs[i]) {
                    ++leconsParProf[i];
                }
            }
        }

        // Define each professor's lessons
        Lecon[][] leconsProf = new Lecon[][] {
                new Lecon[leconsParProf[0]],
                new Lecon[leconsParProf[1]]
        };
        // Index per professor for inserting lessons
        int index0 = 0;
        int index1 = 0;
        // Insert each lesson in the correct professor's list
        for (Lecon lecon : lecons) {
            if (lecon.getProfesseur() == professeurs[0]) {
                leconsProf[0][index0++] = lecon;
                continue;
            }
            if(lecon.getProfesseur() == professeurs[1]) {
                leconsProf[1][index1++] = lecon;
            }
        }
        // Set the professor's list of lessons
        professeurs[0].setLecons(leconsProf[0]);
        professeurs[1].setLecons(leconsProf[1]);

        // Output the members of the school
        System.out.println("-- Membres de l'ecole\n");
        Personne[] personnes = new Personne[professeurs.length + etudiants.length];
        System.arraycopy(professeurs, 0, personnes, 0, professeurs.length);
        System.arraycopy(etudiants, 0, personnes, professeurs.length, etudiants.length);
        for (Personne personne : personnes) {
            System.out.println(personne);
        }
        System.out.println();

        // Output the information pertaining to IL6-1
        System.out.println("-- Horaire du groupe " + groupes[0].nom() + " (" + groupes[0].nombreEtudiants() + " etudiants)");
        System.out.println();
        System.out.println(groupes[0].horaire());
        System.out.println();

        // Output the information pertaining prof. PDO
        System.out.println("-- Horaire " + professeurs[1]);
        System.out.println();
        System.out.println(professeurs[1].horaire());
        System.out.println();
    }
}
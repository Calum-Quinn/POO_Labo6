package src;

import java.util.Arrays;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Main {
    public static void main(String[] args) {
        Professeur[] professeurs = new Professeur[]{
                new Professeur("Rossier", "Daniel", "DRE"),
                new Professeur("Donini", "Pier", "PDO")
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

        Groupe[] groupes = new Groupe[]{
                new Groupe(1, 6, "IL", Arrays.copyOfRange(etudiants, 0, 4)),
                new Groupe(1, 6, "SI", Arrays.copyOfRange(etudiants, etudiants.length - 2, etudiants.length))
        };

        // Display school's members
        System.out.println("-- Membres de l'ecole\n");
        Personne[] personnes = new Personne[professeurs.length + etudiants.length];
        System.arraycopy(professeurs, 0, personnes, 0, professeurs.length);
        System.arraycopy(etudiants, 0, personnes, professeurs.length, etudiants.length);
        for (Personne personne : personnes) {
            System.out.println(personne);
        }

        // Define lessons for the group IL6-1
        groupes[0].definirLecons(lecons);
        // Define lessons for the teacher PDO
        professeurs[1].definirLecons(Arrays.copyOfRange(lecons, 0, 3));

        System.out.println(groupes[0].horaire());
        System.out.println(professeurs[1].horaire());
    }
}
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Professeur[] professeurs = new Professeur[]{
                new Professeur("Rossier", "Daniel", "DRE"),
                new Professeur("Donini", "Pierre", "PDO")
        };

        Lecon[] lecons = new Lecon[]{
                new Lecon("Programmation orientee objet", 3, 6, 90, "H02", professeurs[1]),
                new Lecon("Programmation orientee objet", 4, 6, 90, "H02", professeurs[1]),
                new Lecon("Programmation orientee objet", 4, 8, 90, "H02", professeurs[1]),
                new Lecon("Systeme d'exploitations", 1, 1, 90, "G01", professeurs[0]),
                new Lecon("Systeme d'exploitations", 4, 3, 90, "A09", professeurs[0]),
                new Lecon("Technique de l'information et de la communication", 2, 10, 45, "F06", null)
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

        groupes[0].definirLecons(lecons);
        groupes[1].definirLecons(Arrays.copyOfRange(lecons, 0, 3));

        System.out.println("-- Membres de l'ecole\n");
        Personne[] personnes = new Personne[professeurs.length + etudiants.length];
        System.arraycopy(professeurs, 0, personnes, 0, professeurs.length);
        System.arraycopy(etudiants, 0, personnes, professeurs.length, etudiants.length);
        for (Personne personne : personnes) {
            System.out.println(personne);
        }
    }
}

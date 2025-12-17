/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off;

/**
 *
 * @author Macéo
 */
public class Statistiques {
     public int nbPartiesJouees;
    public int nbPartiesGagnees;
    public int nbPartiesPerdues;
    public int meilleurScore;
    public int totalCoupsJoues;

    public Statistiques() {
        nbPartiesJouees = 0;
        nbPartiesGagnees = 0;
        nbPartiesPerdues = 0;
        meilleurScore = 0;
        totalCoupsJoues = 0;
    }

    /**
     * Met à jour les statistiques en fin de partie.
     *
     * @param victoire true si la partie est gagnée
     * @param score score obtenu sur cette partie
     * @param nbCoups nombre de coups joués sur cette partie
     */
    public void enregistrerPartie(boolean victoire, int score, int nbCoups) {
        nbPartiesJouees++;
        totalCoupsJoues += nbCoups;

        if (victoire) {
            nbPartiesGagnees++;
        } else {
            nbPartiesPerdues++;
        }

        if (score > meilleurScore) {
            meilleurScore = score;
        }
    }

    /**
     * Renvoie le nombre moyen de coups par partie.
     *
     * @return moyenne des coups, ou 0 si aucune partie
     */
    public double getMoyenneCoups() {
        if (nbPartiesJouees == 0) {
            return 0.0;
        }
        return (double) totalCoupsJoues / nbPartiesJouees;
    }

    @Override
    public String toString() {
        return "Statistiques de la session :\n"
                + "Parties jouées : " + nbPartiesJouees + "\n"
                + "Parties gagnées : " + nbPartiesGagnees + "\n"
                + "Parties perdues : " + nbPartiesPerdues + "\n"
                + "Meilleur score : " + meilleurScore + "\n"
                + "Nombre moyen de coups : " + getMoyenneCoups();
    }
    
}

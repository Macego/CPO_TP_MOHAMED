/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off;

/**
 *
 * @author Macéo
 */
import java.util.Scanner;
public class Partie {
     public GrilledeJeu grille;
    public int nbCoups;
    public int nbCoupsMax;
    public int difficulte;
    
    public Partie() {
        nbCoups = 0;
    }

    public void initialiserPartie() {
        Scanner sc = new Scanner(System.in);
        int taille;
        
        while (true) {
            System.out.println("Taille de la grille (entre 3 et 10) ?");
            String saisie = sc.nextLine();
            try {
                taille = Integer.parseInt(saisie);
                if (taille >= 3 && taille <= 10) {
                    break;
                } else {
                    System.out.println("Veuillez entrer un nombre entre 3 et 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, tape un entier.");
            }
        }
        
     int nbToursMelange;
        while (true) {
            System.out.println("Niveau de difficulté :");
            System.out.println("1 = facile, 2 = moyen, 3 = difficile");
            String saisie = sc.nextLine();
            if (saisie.equals("1")) {
                difficulte = 1;
                nbToursMelange = 5;
                nbCoupsMax = 20;
                break;
            } else if (saisie.equals("2")) {
                difficulte = 2;
                nbToursMelange = 10;
                nbCoupsMax = 15;
                break;
            } else if (saisie.equals("3")) {
                difficulte = 3;
                nbToursMelange = 20;
                nbCoupsMax = 12;
                break;
            } else {
                System.out.println("Choix invalide, réponds par 1, 2 ou 3.");
            }
        }

        grille = new GrilledeJeu(taille, taille);
        grille.melangerMatriceAleatoirement(nbToursMelange);
        System.out.println("Tu as au maximum " + nbCoupsMax + " coups pour gagner.");
    }

    // Demande un coup au joueur et applique l'effet
    private void jouerUnCoup() {
        Scanner sc = new Scanner(System.in);
        int ligne = -1;
        int colonne = -1;

        while (true) {
            try {
                System.out.println("Numéro de ligne (0 à " + (grille.nbLignes - 1) + ") :");
                String sLigne = sc.nextLine();
                ligne = Integer.parseInt(sLigne);

                System.out.println("Numéro de colonne (0 à " + (grille.nbColonnes - 1) + ") :");
                String sCol = sc.nextLine();
                colonne = Integer.parseInt(sCol);

                if (ligne < 0 || ligne >= grille.nbLignes ||
                    colonne < 0 || colonne >= grille.nbColonnes) {
                    System.out.println("Coordonnées hors de la grille, recommence.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, tape des entiers.");
            }
        }

        grille.activerCelluleEtVoisins(ligne, colonne);
        nbCoups++;
    }

    public void lancerPartie() {
        initialiserPartie();
        System.out.println("Grille initiale :");
        System.out.println(grille);

        while (!grille.cellulesToutesEteintes()) {
            System.out.println("Coup numéro " + (nbCoups + 1));
            jouerUnCoup();
            System.out.println("État de la grille :");
            System.out.println(grille);
        }

        System.out.println("Bravo, toutes les cellules sont éteintes !");
        System.out.println("Nombre de coups joués : " + nbCoups);
    }
}

    


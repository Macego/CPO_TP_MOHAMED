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
                nbToursMelange = 5;
                break;
            } else if (saisie.equals("2")) {
                nbToursMelange = 10;
                break;
            } else if (saisie.equals("3")) {
                nbToursMelange = 20;
                break;
            } else {
                System.out.println("Choix invalide, réponds par 1, 2 ou 3.");
            }
        }

        grille = new GrilledeJeu(taille, taille);
        grille.melangerMatriceAleatoirement(nbToursMelange);
    }

    // Demande un coup au joueur et applique l'effet
    private void jouerUnCoup() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tapez L pour ligne, C pour colonne, D pour diagonale descendante, M pour diagonale montante :");
        String choix = sc.next().toUpperCase();

        if (choix.equals("L")) {
            System.out.println("Numéro de ligne ?");
            int l = sc.nextInt();
            grille.activerLigneDeCellules(l);
        } else if (choix.equals("C")) {
            System.out.println("Numéro de colonne ?");
            int c = sc.nextInt();
            grille.activerColonneDeCellules(c);
        } else if (choix.equals("D")) {
            grille.activerDiagonaleDescendante();
        } else if (choix.equals("M")) {
            grille.activerDiagonaleMontante();
        } else {
            System.out.println("Choix invalide, aucun coup joué.");
            return;
        }

        nbCoups++;
    }

    // Boucle principale de jeu
    public void lancerPartie() {
        initialiserPartie();
        System.out.println("Grille initiale :");
        System.out.println(grille);

        Scanner sc = new Scanner(System.in);

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

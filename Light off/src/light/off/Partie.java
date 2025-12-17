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
        grille = new GrilledeJeu(5, 5); // 5x5 comme demandé
        nbCoups = 0;
    }

    public void initialiserPartie() {
        grille.melangerMatriceAleatoirement(10);
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

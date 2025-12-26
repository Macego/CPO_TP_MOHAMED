/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off2;
import java.util.Scanner;

/**
 *
 * @author Macéo
 */
public class Partie {

    private GrilleDeJeu grille;
    private int nbCoups;

    public Partie(int nbLignes, int nbColonnes) {
        grille = new GrilleDeJeu(nbLignes, nbColonnes);
        nbCoups = 0;
    }

    public void initialiserPartie() {
        grille.eteindreToutesLesCellules();
        grille.melangerMatriceAleatoirement(10);
        nbCoups = 0;
    }

    private void jouerUnCoup(Scanner sc) {
        System.out.println("Que veux-tu activer ?");
        System.out.println("1 - Ligne");
        System.out.println("2 - Colonne");
        System.out.println("3 - Diagonale descendante");
        System.out.println("4 - Diagonale montante");
        int choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.print("Numéro de ligne (0 à " + (grille.nbLignes - 1) + ") : ");
                int lig = sc.nextInt();
                grille.activerLigneDeCellules(lig);
                nbCoups++;
                break;
            case 2:
                System.out.print("Numéro de colonne (0 à " + (grille.nbColonnes - 1) + ") : ");
                int col = sc.nextInt();
                grille.activerColonneDeCellules(col);
                nbCoups++;
                break;
            case 3:
                grille.activerDiagonaleDescendante();
                nbCoups++;
                break;
            case 4:
                grille.activerDiagonaleMontante();
                nbCoups++;
                break;
            default:
                System.out.println("Choix invalide, coup ignoré.");
        }
    }

    public void lancerPartie() {
        Scanner sc = new Scanner(System.in);
        initialiserPartie();

        System.out.println("=== Début de la partie LightOff (console) ===");
        while (!grille.cellulesToutesEteintes()) {
            System.out.println("Grille actuelle :");
            System.out.println(grille);
            System.out.println("Nombre de coups joués : " + nbCoups);
            jouerUnCoup(sc);
        }

        System.out.println("Bravo, toutes les lumières sont éteintes !");
        System.out.println("Partie terminée en " + nbCoups + " coups.");
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off;

/**
 *
 * @author Macéo
 */
import java.util.Random;

public class GrilledeJeu {
    
    public void activerCelluleEtVoisins(int ligne, int colonne) {
    if (ligne < 0 || ligne >= nbLignes || colonne < 0 || colonne >= nbColonnes) {
        return; // coordonnées invalides
    }

    // cellule elle‑même
    matriceCellules[ligne][colonne].activerCellule();

    // voisin du haut
    if (ligne > 0) {
        matriceCellules[ligne - 1][colonne].activerCellule();
    }
    // voisin du bas
    if (ligne < nbLignes - 1) {
        matriceCellules[ligne + 1][colonne].activerCellule();
    }
    // voisin de gauche
    if (colonne > 0) {
        matriceCellules[ligne][colonne - 1].activerCellule();
    }
    // voisin de droite
    if (colonne < nbColonnes - 1) {
        matriceCellules[ligne][colonne + 1].activerCellule();
    }
} 
    
    public CelulleLumineuse[][] matriceCellules;
    public int nbLignes;
    public int nbColonnes;

    public GrilledeJeu(int pNbLignes, int pNbColonnes) {
        nbLignes = pNbLignes;
        nbColonnes = pNbColonnes;

        matriceCellules = new CelulleLumineuse[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelulleLumineuse();
            }
        }
    }

    // Met toutes les cellules à l'état éteint
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    // Active toutes les cellules d'une ligne
    public void activerLigneDeCellules(int idLigne) {
        if (idLigne < 0 || idLigne >= nbLignes) {
            return;
        }
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

    // Active toutes les cellules d'une colonne
    public void activerColonneDeCellules(int idColonne) {
        if (idColonne < 0 || idColonne >= nbColonnes) {
            return;
        }
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }

    // Active la diagonale descendante (i == j)
    public void activerDiagonaleDescendante() {
        int n = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < n; i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    // Active la diagonale montante (i + j == n-1)
    public void activerDiagonaleMontante() {
        int n = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            matriceCellules[i][j].activerCellule();
        }
    }

    // Choisit aléatoirement ligne, colonne ou diagonale et l'active
    public void activerLigneColonneOuDiagonaleAleatoire() {
        Random generateur = new Random();
        int type = generateur.nextInt(4); // 0 = ligne, 1 = colonne, 2 = diag desc, 3 = diag mont

        if (type == 0) {
            int idLigne = generateur.nextInt(nbLignes);
            activerLigneDeCellules(idLigne);
        } else if (type == 1) {
            int idColonne = generateur.nextInt(nbColonnes);
            activerColonneDeCellules(idColonne);
        } else if (type == 2) {
            activerDiagonaleDescendante();
        } else {
            activerDiagonaleMontante();
        }
    }

    // Mélange la grille avec nbTours activations aléatoires
    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCellules();
        for (int i = 0; i < nbTours; i++) {
            activerLigneColonneOuDiagonaleAleatoire();
        }
    }

    // Vrai si toutes les cellules sont éteintes
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String resultat = "   ";
        for (int j = 0; j < nbColonnes; j++) {
            resultat += j + " ";
        }
        resultat += "\n";

        resultat += "  ";
        for (int j = 0; j < nbColonnes; j++) {
            resultat += "--";
        }
        resultat += "-\n";

        for (int i = 0; i < nbLignes; i++) {
            resultat += i + " |";
            for (int j = 0; j < nbColonnes; j++) {
                resultat += matriceCellules[i][j].toString() + " ";
            }
            resultat += "\n";
        }
        return resultat;
    }
}

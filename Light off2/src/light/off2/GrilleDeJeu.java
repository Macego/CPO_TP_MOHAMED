/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off2;
import java.util.Random;

/**
 *
 * @author Macéo
 */
public class GrilleDeJeu {

    public CelluleLumineuse[][] matriceCellules;
    public int nbLignes;
    public int nbColonnes;

    public GrilleDeJeu(int pNbLignes, int pNbColonnes) {
        nbLignes = pNbLignes;
        nbColonnes = pNbColonnes;
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    public void activerLigneDeCellules(int idLigne) {
        if (idLigne < 0 || idLigne >= nbLignes) return;
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

    public void activerColonneDeCellules(int idColonne) {
        if (idColonne < 0 || idColonne >= nbColonnes) return;
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }

    public void activerDiagonaleDescendante() {
        int n = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < n; i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    public void activerDiagonaleMontante() {
        int n = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < n; i++) {
            int j = nbColonnes - 1 - i;
            if (j >= 0 && j < nbColonnes) {
                matriceCellules[i][j].activerCellule();
            }
        }
    }

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

    public void activerLigneColonneOuDiagonaleAleatoire() {
        Random rand = new Random();
        int choix = rand.nextInt(4); // 0..3

        switch (choix) {
            case 0:
                activerLigneDeCellules(rand.nextInt(nbLignes));
                break;
            case 1:
                activerColonneDeCellules(rand.nextInt(nbColonnes));
                break;
            case 2:
                activerDiagonaleDescendante();
                break;
            case 3:
                activerDiagonaleMontante();
                break;
        }
    }

    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCellules();
        for (int i = 0; i < nbTours; i++) {
            activerLigneColonneOuDiagonaleAleatoire();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("   ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(j).append(" ");
        }
        sb.append("\n");

        sb.append("   ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append("--");
        }
        sb.append("\n");

        for (int i = 0; i < nbLignes; i++) {
            sb.append(i).append(" |");
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Macéo
 */
import java.util.Random;

/**
 * Classe métier : gère tout le jeu sans interface graphique.
 */
public class Cadenas {
    private int[] codeSecret;      // 4 chiffres à deviner
    private int nbTentatives;      // tentatives déjà faites
    private int maxTentatives;

    public Cadenas() {
        genererCodeSecret();
        nbTentatives = 0;
    }

    private void genererCodeSecret() {
        Random r = new Random();
        codeSecret = new int[4];
        for (int i = 0; i < 4; i++) {
            codeSecret[i] = r.nextInt(10); // 0..9
        }
    }

    /**
     * @param proposition tableau de 4 chiffres
     * @return int[3] = {exacts, tropHauts, tropBas}
     */
    public int[] testerProposition(int[] proposition) {
        int exacts = 0;
        int tropHauts = 0;
        int tropBas = 0;

        for (int i = 0; i < 4; i++) {
            if (proposition[i] == codeSecret[i]) {
                exacts++;
            } else if (proposition[i] > codeSecret[i]) {
                tropHauts++;
            } else {
                tropBas++;
            }
        }

        nbTentatives++;
        return new int[]{exacts, tropHauts, tropBas};
    }

    public boolean estGagne(int[] resultat) {
        return resultat[0] == 4;
    }

    public boolean estFini(int[] resultat) {
        return estGagne(resultat) || nbTentatives >= maxTentatives;
    }

    public int getNbTentatives() {
        return nbTentatives;
    }

    public int getMaxTentatives() {
        return maxTentatives;
    }
}

    


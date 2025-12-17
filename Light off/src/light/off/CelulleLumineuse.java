/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off;

/**
 *
 * @author Macéo
 */
public class CelulleLumineuse {
    private boolean etat;  // true = allumée, false = éteinte

    // Constructeur par défaut : cellule éteinte
    public CelulleLumineuse() {
        etat = false;
    }

    // Inverse l'état de la cellule
    public void activerCellule() {
        etat = !etat;
    }

    // Met la cellule à l'état éteint
    public void eteindreCellule() {
        etat = false;
    }

    // Renvoie true si la cellule est éteinte
    public boolean estEteint() {
        return !etat;
    }

    // Renvoie l'état brut (true = allumée, false = éteinte)
    public boolean getEtat() {
        return etat;
    }

    // Représentation texte : X = allumée, O = éteinte
    @Override
    public String toString() {
        if (etat) {
            return "X";
        } else {
            return "O";
        }
    }
}



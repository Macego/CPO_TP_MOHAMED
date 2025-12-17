/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off;

/**
 *
 * @author Macéo
 */

/**
 * Représente une cellule lumineuse qui peut être allumée ou éteinte.
 */
public class CelulleLumineuse {
    private boolean etat;  // true = allumée, false = éteinte


    /**
     * Crée une nouvelle cellule initialement éteinte.
     */
    public CelulleLumineuse() {
        etat = false;
    }

     /**
     * Inverse l'état de la cellule.
     * Si elle est allumée, elle s'éteint, et inversement.
     */
    public void activerCellule() {
        etat = !etat;
    }

     /**
     * Éteint la cellule (etat = false).
     */
    public void eteindreCellule() {
        etat = false;
    }

    /**
     * Indique si la cellule est éteinte.
     *
     * @return true si la cellule est éteinte, false sinon
     */
    public boolean estEteint() {
        return !etat;
    }

    /**
     * Renvoie l'état brut de la cellule.
     *
     * @return true si la cellule est allumée, false sinon
     */
    public boolean getEtat() {
        return etat;
    }

    /**
     * Renvoie "X" si la cellule est allumée, "O" sinon.
     *
     * @return représentation texte de la cellule
     */
    @Override
    public String toString() {
        if (etat) {
            return "X";
        } else {
            return "O";
        }
    }
}



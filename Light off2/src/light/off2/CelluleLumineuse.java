/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off2;

/**
 *
 * @author Macéo
 */
public class CelluleLumineuse {
    private boolean etat; // true = allumé, false = éteint

    public CelluleLumineuse() {
        etat = false; // éteint par défaut
    }

    public void activerCellule() {
        etat = !etat;
    }

    public void eteindreCellule() {
        etat = false;
    }

    public boolean estEteint() {
        return !etat;
    }

    public boolean getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        if (etat) {
            return "X"; // allumé
        } else {
            return "O"; // éteint
        }
    }
    
}

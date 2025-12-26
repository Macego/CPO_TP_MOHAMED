/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off2;
import javax.swing.JButton;

/**
 *
 * @author Macéo
 */
public class CelluleGraphique {
    int largeur;
    int hauteur;
    CelluleLumineuse celluleLumineuseAssociee;

    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l, int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        this.setText(celluleLumineuseAssociee.toString());
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        this.setText(celluleLumineuseAssociee.toString());
    }
    
}

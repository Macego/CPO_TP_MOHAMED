/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off;

/**
 *
 * @author Macéo
 */
import javax.swing.JButton;
import java.awt.Graphics;

public class CelluleGraphique extends JButton {
    
    int largeur;
    int hauteur;
    CelulleLumineuse celluleLumineuseAssociee;
    FenetrePrincipale fenetre;
    int ligne;
    int colonne;

    public CelluleGraphique(CelulleLumineuse celluleLumineuseAssociee,
                            int l, int h,
                            FenetrePrincipale fenetre,
                            int lig, int col) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        this.fenetre = fenetre;
        this.ligne = lig;
        this.colonne = col;

        // Quand on clique sur le bouton : appliquer la règle cellule + voisines
        this.addActionListener(e -> {
            fenetre.jouerCoupGraphique(ligne, colonne);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setText(celluleLumineuseAssociee.toString());
    }
    
}

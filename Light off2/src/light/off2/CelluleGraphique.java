/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off2;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CelluleGraphique extends JButton {

    int largeur;
    int hauteur;
    CelluleLumineuse celluleLumineuseAssociee;

    private GrilleDeJeu grille;
    private int ligne;
    private int colonne;

    public CelluleGraphique(GrilleDeJeu grille, int ligne, int colonne,
                            CelluleLumineuse celluleLumineuseAssociee,
                            int l, int h) {
        super();
        this.grille = grille;
        this.ligne = ligne;
        this.colonne = colonne;
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;

        this.setText(celluleLumineuseAssociee.toString());

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerCelluleEtVoisins(ligne, colonne);
                // le modèle a changé, on met à jour notre affichage
                setText(celluleLumineuseAssociee.toString());
                // demander aussi à la fenêtre de tout repeindre
                getParent().repaint();
            }
        });
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        this.setText(celluleLumineuseAssociee.toString());
    }
}

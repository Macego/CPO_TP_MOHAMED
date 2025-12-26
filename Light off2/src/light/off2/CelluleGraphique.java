/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package light.off2;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;

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
                this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerCelluleEtVoisins(ligne, colonne);
                repaint();
                getParent().repaint();
            }
        });
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();

        if (celluleLumineuseAssociee.getEtat()) {
            g.setColor(Color.YELLOW);      // allumé
        } else {
            g.setColor(new Color(0, 100, 0)); // vert foncé éteint
        }

        g.fillOval(2, 2, w - 4, h - 4);
    }
}

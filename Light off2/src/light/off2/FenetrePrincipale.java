/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package light.off2;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *
 * @author Macéo
 */
public class FenetrePrincipale extends javax.swing.JFrame {
    private GrilleDeJeu grille;
private int nbCoups;
private int nbLignes = 5;
private int nbColonnes = 5;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName());

    /**
     * Creates new form FenetrePrincipale
     */
    public FenetrePrincipale() {
        initComponents();
      nbLignes = 5;
    nbColonnes = 5;
    grille = new GrilleDeJeu(nbLignes, nbColonnes);
    nbCoups = 0;
    labelScore.setText("Score : 0");
    PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
PanneauBoutonsVerticaux.setLayout(new GridLayout(nbLignes, 1));
PanneauBoutonsHorizontaux.setLayout(new GridLayout(1, nbColonnes));

initialiserPartie();
initialiserGrilleGraphique();
initialiserBoutonsLignes();
initialiserBoutonsColonnes();
    }

    public void initialiserPartie() {
    grille.eteindreToutesLesCellules();
    grille.melangerMatriceAleatoirement(10); // tu peux changer le 10
    nbCoups = 0;
    labelScore.setText("Score : 0");
}

private void initialiserGrilleGraphique() {
    PanneauGrille.removeAll();

    for (int i = 0; i < nbLignes; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            CelluleGraphique boutonCellule =
                new CelluleGraphique(this,            
                                     grille,          
                                     i,               
                                     j,               
                                     grille.matriceCellules[i][j],
                                     40,              
                                     40);             
            PanneauGrille.add(boutonCellule);
        }
    }

    PanneauGrille.revalidate();
    PanneauGrille.repaint();
}

    private void initialiserBoutonsLignes() {
    PanneauBoutonsVerticaux.removeAll();

    for (int i = 0; i < nbLignes; i++) {
        JButton boutonLigne = new JButton("L" + i);

        final int j = i; // index de ligne capturé pour l'action
        ActionListener ecouteurClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerLigneDeCellules(j);
                nbCoups++;
                PanneauGrille.repaint();

                if (grille.cellulesToutesEteintes()) {
                    javax.swing.JOptionPane.showMessageDialog(
                        FenetrePrincipale.this,
                        "Bravo, grille éteinte en " + nbCoups + " coups !");
                }
            }
        };

        boutonLigne.addActionListener(ecouteurClick);
        PanneauBoutonsVerticaux.add(boutonLigne);
    }

    PanneauBoutonsVerticaux.revalidate();
    PanneauBoutonsVerticaux.repaint();
}
    
    private void initialiserBoutonsColonnes() {
    PanneauBoutonsHorizontaux.removeAll();

    for (int j = 0; j < nbColonnes; j++) {
        JButton boutonColonne = new JButton("C" + j);

        final int k = j; // index de colonne
        ActionListener ecouteurClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerColonneDeCellules(k);
                nbCoups++;
                PanneauGrille.repaint();

                if (grille.cellulesToutesEteintes()) {
                    javax.swing.JOptionPane.showMessageDialog(
                        FenetrePrincipale.this,
                        "Bravo, grille éteinte en " + nbCoups + " coups !");
                }
            }
        };

        boutonColonne.addActionListener(ecouteurClick);
        PanneauBoutonsHorizontaux.add(boutonColonne);
    }

    PanneauBoutonsHorizontaux.revalidate();
    PanneauBoutonsHorizontaux.repaint();
}
    
    public void jouerUnCoupSurCellule(int ligne, int colonne) {
    grille.activerCelluleEtVoisins(ligne, colonne);
    nbCoups++;
    labelScore.setText("Score : " + nbCoups);
    PanneauGrille.repaint();

    // test de victoire
    if (grille.cellulesToutesEteintes()) {
        int choix = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Bravo ! Tu as éteint toutes les lumières en " + nbCoups + " coups.\n"
            + "Veux-tu recommencer une partie ?",
            "Victoire",
            javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (choix == javax.swing.JOptionPane.YES_OPTION) {
            initialiserPartie();      
            PanneauGrille.repaint();
        } else {
           
        }
    }
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        PanneauBoutonsVerticaux = new javax.swing.JPanel();
        PanneauBoutonsHorizontaux = new javax.swing.JPanel();
        labelScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanneauGrille.setBackground(new java.awt.Color(0, 153, 51));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout PanneauBoutonsVerticauxLayout = new javax.swing.GroupLayout(PanneauBoutonsVerticaux);
        PanneauBoutonsVerticaux.setLayout(PanneauBoutonsVerticauxLayout);
        PanneauBoutonsVerticauxLayout.setHorizontalGroup(
            PanneauBoutonsVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PanneauBoutonsVerticauxLayout.setVerticalGroup(
            PanneauBoutonsVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanneauBoutonsHorizontauxLayout = new javax.swing.GroupLayout(PanneauBoutonsHorizontaux);
        PanneauBoutonsHorizontaux.setLayout(PanneauBoutonsHorizontauxLayout);
        PanneauBoutonsHorizontauxLayout.setHorizontalGroup(
            PanneauBoutonsHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PanneauBoutonsHorizontauxLayout.setVerticalGroup(
            PanneauBoutonsHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauGrilleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanneauBoutonsVerticaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneauGrilleLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(PanneauBoutonsHorizontaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneauGrilleLayout.createSequentialGroup()
                .addComponent(PanneauBoutonsVerticaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(PanneauBoutonsHorizontaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelScore.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(labelScore)
                .addGap(18, 18, 18)
                .addComponent(PanneauGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FenetrePrincipale().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauBoutonsHorizontaux;
    private javax.swing.JPanel PanneauBoutonsVerticaux;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables
}

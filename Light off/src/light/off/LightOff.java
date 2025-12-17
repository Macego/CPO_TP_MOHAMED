/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package light.off;

/**
 *
 * @author Macéo
 */
public class LightOff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    CelulleLumineuse c1 = new CelulleLumineuse();
    System.out.println(c1);  // O
    c1.activerCellule();
    System.out.println(c1);  // X

    GrilledeJeu g = new GrilledeJeu(5, 5);
    g.melangerMatriceAleatoirement(10);
    System.out.println(g);

}
        // TODO code application logic here
    }
    


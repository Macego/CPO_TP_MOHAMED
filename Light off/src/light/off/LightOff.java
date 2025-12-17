/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package light.off;
import java.util.Scanner; 
/**
 *
 * @author Macéo
 */
public class LightOff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Statistiques stats = new Statistiques();

        boolean continuer = true;
        while (continuer) {
            Partie partie = new Partie(stats);
            partie.lancerPartie();

            System.out.println();
            System.out.println(stats);

            System.out.println();
            System.out.println("Voulez-vous rejouer ? (O/N)");
            String reponse = sc.nextLine().trim().toUpperCase();
            if (!reponse.equals("O")) {
                continuer = false;
            }
        }

        System.out.println("Merci d'avoir joué !");
        
    CelulleLumineuse c1 = new CelulleLumineuse();
    System.out.println(c1);  // O
    c1.activerCellule();
    System.out.println(c1);  // X

    GrilledeJeu g = new GrilledeJeu(5, 5);
    g.melangerMatriceAleatoirement(10);
    System.out.println(g);
    
    Partie partie = new Partie();
        partie.lancerPartie();    

}
        // TODO code application logic here
    }
    


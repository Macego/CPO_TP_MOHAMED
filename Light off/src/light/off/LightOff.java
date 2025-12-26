package light.off;

import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * @author Macéo
 */
public class LightOff {

    /**
     * Lancement en mode CONSOLE (ancien main).
     */
    public static void mainConsole(String[] args) {
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
    }

    /**
     * Lancement en mode GRAPHIQUE.
     */
    public static void main(String[] args) {
        // si tes statistiques sont utilisées dans Partie, adapte le constructeur
        Statistiques stats = new Statistiques();
        Partie partie = new Partie(stats);

        SwingUtilities.invokeLater(() -> {
            FenetreJeu f = new FenetreJeu(partie); // ta JFrame
            f.setVisible(true);
        });
    }
}


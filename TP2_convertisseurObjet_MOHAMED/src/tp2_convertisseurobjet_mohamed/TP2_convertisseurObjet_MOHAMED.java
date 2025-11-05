/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_convertisseurobjet_mohamed;

/**
 *
 * @author Macéo
 */
public class TP2_convertisseurObjet_MOHAMED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Convertisseur conv1 = new Convertisseur();
        System.out.println("20°C = " + conv1.CelciusVersFahrenheit(20) + "°F");
        System.out.println("50°F = " + conv1.FahrenheitVersCelcius(50) + "°C");
        System.out.println(conv1); // Affiche le nombre de conversions

        Convertisseur conv2 = new Convertisseur();
        System.out.println("350K = " + conv2.KelvinVersCelcius(350) + "°C");
        System.out.println(conv2);

        // TODO code application logic here
    }
    
}

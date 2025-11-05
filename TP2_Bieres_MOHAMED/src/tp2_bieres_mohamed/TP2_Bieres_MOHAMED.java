/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_bieres_mohamed;

/**
 *
 * @author Macéo
 */
public class TP2_Bieres_MOHAMED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BouteilleBiere uneBiere = new BouteilleBiere("Leffe", 6.6, "Abbaye de Leffe") ;
        uneBiere.nom = "Cuvée des trolls";
        uneBiere.degreAlcool = 7.0 ;
        uneBiere.brasserie = "Dubuisson";
        uneBiere.lireEtiquette();

        BouteilleBiere autreBiere = new BouteilleBiere("Leffe", 6.6, "Abbaye de Leffe");
        autreBiere.nom = "Leffe";
        autreBiere.degreAlcool = 6.6;
        autreBiere.brasserie = "Abbaye de Leffe";
        autreBiere.lireEtiquette();
        
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls",
7.0 ,"Dubuisson") ;
        
        System.out.println(uneBiere) ;
        uneBiere.decapsuler();
        System.out.println(uneBiere);
        

           // TODO code application logic here
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_heroic_fantasy_mohamed;

/**
 *
 * @author Macéo
 */
public class Epee extends Arme {
    int finesse;
    public Epee (String Nom, int niveauAttaque, int finesse){
     super(Nom, niveauAttaque);
    
        if (finesse > 100) {
       finesse = 100;
    }
    else if (finesse < 0){
        finesse = 0;
    }
    else {
    this.finesse = finesse;
}
    }
public String toString() {
    return super.toString() + ", finesse :" + finesse;
}
}




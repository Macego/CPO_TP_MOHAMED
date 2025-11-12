/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_heroic_fantasy_mohamed;

/**
 *
 * @author Macéo
 */
public abstract class Arme {
    String Nom;
    int niveauAttaque;
    public Arme(String nom, int niveauAttaque){ 
    this.Nom = Nom;
    if (niveauAttaque > 100){
       niveauAttaque = 100;
}   else if (niveauAttaque < 0){
       niveauAttaque = 0;
}    else {
       this.niveauAttaque = niveauAttaque;
            }
    
}

public String toString() {
    return "Arme :" + Nom + ", Niveau d'attaque" + niveauAttaque;
}
 
}



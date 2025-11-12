/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_heroic_fantasy_mohamed;

/**
 *
 * @author Macéo
 */
public class Baton extends Arme{
        int age;
    public Baton (String Nom, int niveauAttaque, int age){
     super(Nom, niveauAttaque);
    
        if (age > 100) {
       age = 100;
    }
    else if (age < 0){
        age = 0;
    }
    else {
    this.age = age;
}
    }
public String toString() {
    return super.toString() + ", âge :" + age;
}
}
    


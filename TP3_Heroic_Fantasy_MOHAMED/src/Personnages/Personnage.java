package Personnages;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Macéo
 */
import Armes.Arme;
import java.util.ArrayList;

public abstract class Personnage {
    private String nom;
    private int niveauVie;
    private ArrayList<Arme> inventaire = new ArrayList<>();
    private Arme armeEnMain = null;

    public Personnage(String nom, int niveauVie) {
        this.nom = nom;
        this.niveauVie = niveauVie;
    }

    public String getNom() {
        return nom;
    }

    public int getNiveauVie() {
        return niveauVie;
    }

    // Getter pour l'inventaire (pour les sous-classes)
    public ArrayList<Arme> getInventaire() {
        return inventaire;
    }

    // Ajouter une arme à l'inventaire (max 5 armes) avec message personnalisé
    public void ajouterArme(Arme a) {
        if (inventaire.size() < 5) {
            inventaire.add(a);
            System.out.println(nom + " a ajouté l'arme " + a.getNom() + " à son inventaire.");
        } else {
            System.out.println(nom + " : inventaire plein, impossible d’ajouter une nouvelle arme.");
        }
    }

    // Retourne l'arme en main
    public Arme getArmeEnMain() {
        return armeEnMain;
    }

    // Choisir une arme à équiper par son nom
    public void choisirArme(String nomArme) {
        for (Arme a : inventaire) {
            if (a.getNom().equals(nomArme)) {
                armeEnMain = a;
                System.out.println(nom + " s'équipe de " + a.getNom() + ".");
                return;
            }
        }
        System.out.println(nom + " ne possède pas cette arme dans son inventaire.");
    }

    // METHODE ABSTRAITE pour attaquer (à redéfinir dans Magicien/Guerrier)
    public abstract void attaquer(Personnage cible);

    // Fait perdre des points de vie au personnage
    public void estAttaque(int points) {
        niveauVie -= points;
        if (niveauVie < 0) { niveauVie = 0; }
        System.out.println(nom + " subit " + points + " points de dégâts. Vie restante : " + niveauVie);
    }

    // Pour savoir si le perso est toujours en vie
    public boolean estVivant() {
        return niveauVie > 0;
    }

    @Override
    public String toString() {
        String res = nom + " (Vie : " + niveauVie + ")";
        if (armeEnMain != null) {
            res += " - Arme en main : " + armeEnMain;
        }
        return res;
    }
}

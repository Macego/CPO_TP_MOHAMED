/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Macéo
 */
public class Question {
    private String intitule;
    private String proposition1;
    private String proposition2;
    private String proposition3;
    private String proposition4;
    private int indexBonneReponse; // Valeur entre 1 et 4

    // Constructeur
    public Question(String intitule, String p1, String p2, String p3, String p4, int indexBonneReponse) {
        this.intitule = intitule;
        this.proposition1 = p1;
        this.proposition2 = p2;
        this.proposition3 = p3;
        this.proposition4 = p4;
        this.indexBonneReponse = indexBonneReponse;
    }

    // Accesseurs (getter) pour chaque attribut
    public String getIntitule() {
        return intitule;
    }

    public String getProposition1() {
        return proposition1;
    }

    public String getProposition2() {
        return proposition2;
    }

    public String getProposition3() {
        return proposition3;
    }

    public String getProposition4() {
        return proposition4;
    }

    public int getIndexBonneReponse() {
        return indexBonneReponse;
    }
}

    

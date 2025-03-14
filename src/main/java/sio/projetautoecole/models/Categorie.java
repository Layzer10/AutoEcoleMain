package sio.projetautoecole.models;

public class Categorie {
    private int IdCategorie;
    private String Libelle;
    private double prix;

    public Categorie(int idCategorie, String libelle, double prix) {
        IdCategorie = idCategorie;
        Libelle = libelle;
        this.prix = prix;
    }
    public Categorie(String libelle){
        Libelle = libelle;
    }

    public Categorie() {

    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        IdCategorie = idCategorie;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

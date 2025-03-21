package sio.projetautoecole.models;

public class Responsable {
    private int IdResponsable;
    private String Mail;
    private String Nom;
    private int NumCompte;

    public Responsable(int idResponsable, String mail, String nom, int numCompte) {
        IdResponsable = idResponsable;
        Mail = mail;
        Nom = nom;
        NumCompte = numCompte;
    }

    public Responsable() {

    }

    public int getIdResponsable() {
        return IdResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        IdResponsable = idResponsable;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public int getNumCompte() {
        return NumCompte;
    }

    public void setNumCompte(int numCompte) {
        NumCompte = numCompte;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
